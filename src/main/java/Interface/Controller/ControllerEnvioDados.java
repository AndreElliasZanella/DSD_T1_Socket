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
    
    String message = "";
    
    public ControllerEnvioDados() {
    }
    
    public void setMessage(String json){
        message = json;
    }
    
    public String getDados(){
        return this.message;
    }
    
}
