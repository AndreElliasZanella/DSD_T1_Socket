/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Model.Message;
import Model.TimeFutebol;
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
public class Client {
    
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n"); // rodar via NetBeans precisa disso para identificar o <enter>

        Socket conn = null;
        Gson gson = new Gson();
        
        try {
            conn = new Socket("127.0.0.1", 65000);
            System.out.println("Conexão estabelecida.");
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true); // true para autoflush
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while (true) {
                // ler sentença do usuário e enviar
                Message message = new Message();
                System.out.print("metodo:");
                String msgEnviar = scan.nextLine();
                if (msgEnviar.equals("exit")) {
                    break;
                }else{
                    message.setMetodo(msgEnviar);
                    System.out.print("Nome Time:");
                    String nome = scan.nextLine();
                    System.out.print("Categoria Time:");
                    int categoria = scan.nextInt();
                    System.out.print("Estadio:");
                    String estadio = scan.nextLine();
                    TimeFutebol timeFutebol = new TimeFutebol(nome,categoria,estadio);
                    
                    message.setTime(timeFutebol);
                }
                
                out.write(gson.toJson(message,Message.class));
                
                // ler sentença recebida
                System.out.println("Aguardando mensagem...");
                String msgRecebida = in.readLine();
                if (msgRecebida == null){
                    // se a outra máquina fechar a conexão (digitar exit) 
                    // então será recebido 'null' e podemos encerrar o chat.
                    System.out.println("Chat encerrado pelo Servidor.");
                    break;
                }
                System.out.println("Retorno: " + msgRecebida);
            }
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