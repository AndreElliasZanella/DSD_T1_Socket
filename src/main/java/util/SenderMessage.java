package util;

import com.google.gson.Gson;

import Model.Message;

public class SenderMessage {
	private static Gson gson;
	
	public static String converteMessage(String mensagem) {
		gson = new Gson();
		return gson.toJson(new Message(mensagem), Message.class);
	}
}
