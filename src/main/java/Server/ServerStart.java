/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

import Controller.JogadorController;
import Controller.MessageHandler;
import Controller.TecnicoController;
import Controller.TimeFutebolController;
import Interface.View.Login;
import Model.Jogador;
import Model.Message;
import Model.Tecnico;
/**
 *
 * @author andreellias18
 */
public class ServerStart {

    /**
     * @param args the command line arguments
     * @param login
     * @throws java.io.IOException
     */
    public static void main(String[] args, Login login) throws IOException{
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);
        
        Login tela = login;
        Gson gson = new Gson();
        
    	Socket conn = null;
        tela.FecharTela();
        
        while (true){

            try {
                System.out.println("Servidor iniciado. Aguardando conexão...");
                conn = server.accept();
                System.out.println("Conexão recebida.");
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String msgRecebida = in.readLine();

                Message mensagem = gson.fromJson(msgRecebida, Message.class);

                MessageHandler messageHandler = processarEntrada(mensagem, conn);
                messageHandler.processar();

            } catch (Exception e) {
                System.out.println("Deu exception");
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    conn.close();
                    System.out.println("Socket encerrado.");
                }
//                server.close();
//                scan.close();
//                System.out.println("ServerSocket encerrado.");
            }
        }
    }
    
    
    public static MessageHandler processarEntrada(Message mensagem, Socket conexao) throws IOException {
    	MessageHandler messageHandler;
    	if(mensagem.isExistsTime()) {
    		messageHandler = new TimeFutebolController(mensagem, conexao, mensagem.getTime());
    	} else if(mensagem.isExistsTecnico()) {
    		messageHandler = new TecnicoController(mensagem, conexao, (Tecnico) mensagem.getPessoa());
    	} else {
    		messageHandler = new JogadorController(mensagem, conexao, mensagem.getJogador());
    	}
    	return messageHandler;
    }
}