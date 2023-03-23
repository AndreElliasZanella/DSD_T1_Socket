/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controller;

import Client.ClientStart;
import Interface.View.EnvioDados;
import Interface.View.Login;
import Interface.View.ServidorDados;
import Server.ServerStart;
import java.io.IOException;

/**
 *
 * @author andreellias18
 */
public class ControllerLogin {

    public ControllerLogin() {
    }
    
    public void isServidor(String[] args, Login tela) throws IOException{
        ServerStart.main(args, tela);
    }
    
    public void isCliente(String[] args, Login tela, String ip) throws IOException{
        EnvioDados envio = new EnvioDados(args, tela, ip);
    }
}
