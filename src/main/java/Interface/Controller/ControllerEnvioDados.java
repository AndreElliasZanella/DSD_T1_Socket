/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Controller;

import Model.Message;

/**
 *
 * @author andreellias18
 */
public class ControllerEnvioDados {
    
    Message message = new Message();
    
    public ControllerEnvioDados() {
    }
    
    public String getDados(String json){
        return json;
    }
}
