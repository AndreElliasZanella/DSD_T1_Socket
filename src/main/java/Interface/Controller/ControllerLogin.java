/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controller;

import Client.ClientStart;
import Interface.View.EnvioDados;
import Server.ServerStart;
import java.io.IOException;

/**
 *
 * @author andreellias18
 */
public class ControllerLogin {

    public ControllerLogin() {
    }
    
    public void isServidor(String[] args) throws IOException{
        ServerStart.main(args);
    }
    
    public void isCliente(String[] args) throws IOException{
        EnvioDados envio = new EnvioDados(args);
    }
}
