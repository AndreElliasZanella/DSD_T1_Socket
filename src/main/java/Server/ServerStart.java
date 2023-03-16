/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
        
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);
        
        while (true) {
            System.out.println("Aguardando conexao...");
            try (Socket conn = server.accept();) {
                System.out.println("Conectado com: " + conn.getInetAddress().getHostAddress());
                
                //leitura do comando do usuário
                InputStream in = conn.getInputStream();
                byte[] dadosBrutos = new byte[1024];
                int qtdBytesLidos = in.read(dadosBrutos);
                String JSONRecebido = "";
                while (qtdBytesLidos >= 0 && in.available() >= 0) {
                    String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                    JSONRecebido += dadosStr;
                    qtdBytesLidos = in.read(dadosBrutos);
                }
                
                String JSONRetorno;
                OutputStream out = conn.getOutputStream();
                
                //processa a operaçao e retorna pro usuário
                JSONRetorno = processarEntrada(JSONRecebido);
                out.write(JSONRetorno.getBytes());
            }
        }
    }
    
    public static String processarEntrada(String entrada) {
        //processamento dos comandos
        return "inserido";
    }
}


// vamos usar o json.org pra formatar os dados em JSON e ser mais fácil de manipular
// https://www.javatpoint.com/java-json-example
// podemos trabalhar com map no envio e recebimento de dados, o mais trabalhoso só vai ser tratar esses dados.



/*

exemplo entrada:

{
"operacao":"INSERT",
"cpf":"12345678910",
"nome":"admin",
"endereco":"rua x",
"contato":"47 999999999",
"idade":"25"
}

*/