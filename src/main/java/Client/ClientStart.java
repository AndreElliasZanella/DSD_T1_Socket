/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Interface.Controller.ControllerEnvioDados;
import Interface.View.EnvioDados;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author andreellias18
 */
public class ClientStart {
    
    public static void main(String[] args, String dados) throws IOException {
        
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n"); // rodar via NetBeans precisa disso para identificar o <enter>
        
        Socket conn = null;
        Gson gson = new Gson();
        
        //Fazer para se conectar a cada comando
        //Para isso vai ter que ativar a conexão ao clicr no botão enviar da tela
        
        try {
            conn = new Socket("localhost", 80);
            System.out.println("Conexão estabelecida.");
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            //enviar
            String msgEnviar = dados;
            out.println(msgEnviar);

            // ler sentença recebida
            System.out.println("Aguardando mensagem...");
            String msgRecebida = in.readLine();
            if (msgRecebida == null){
                System.out.println("Error.");
            }
            System.out.println("Retorno: " + msgRecebida);
                
        } catch (IOException e) {
            System.out.println("Deu exception");
        } finally {
            if (conn != null) {
                conn.close();
                System.out.println("Socket encerrado.");
            }
        }
    }
}