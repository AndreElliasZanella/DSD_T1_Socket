/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author andreellias18
 */
public class ServerStart {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(65000);
        server.setReuseAddress(true);
        
        Scanner scan = new Scanner(System.in);
        
    	Socket conn = null;

        try {
            System.out.println("Servidor iniciado. Aguardando conexão...");
            conn = server.accept();
            System.out.println("Conexão recebida.");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true); // true para autoflush;

            System.out.println("Digite mensagem para enviar: ");
            String msgEnviar = scan.next();
            while (!msgEnviar.equals("exit")) {
                // enviar a sentença digitada pelo usuário
                out.println(msgEnviar);

                // ler sentença recebida
                System.out.println("Aguardando mensagem...");
                String msgRecebida = in.readLine();
                if (msgRecebida == null){
                    // se a outra máquina fechar a conexão (digitar exit) 
                    // então será recebido 'null' e podemos encerrar o chat.
                    System.out.println("Chat encerrado pelo outro usuário.");
                    break;
                }
                System.out.println("Mensagem recebida " + msgRecebida);
                System.out.println("Digite mensagem para enviar ('exit' para sair): ");
                msgEnviar = scan.next();
            }
        } catch (Exception e) {
            System.out.println("Deu exception");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
                System.out.println("Socket encerrado.");
            }
            server.close();
            scan.close();
            System.out.println("ServerSocket encerrado.");
        }
    }
    
    public static String processarEntrada(String entrada) {
        //processamento dos comandos
        return "inserido";
    }
}