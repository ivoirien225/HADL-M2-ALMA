package hadl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import hadl.interfaces.meta.model.PortProvided;

public class Logger {

	public static String loggerReader() throws IOException{
		FileReader reader = new FileReader(new File("Repository/log.txt"));
		@SuppressWarnings("resource")
		BufferedReader buf = new BufferedReader(reader);
		String content;
		StringBuilder res = new StringBuilder();
		while((content = buf.readLine()) !=  null){
			res.append(content+"\n");
		}
		return res.toString();
	}

	public static void loggerWritter(Object ob, String methodName,  Message message) throws IOException {
		System.out.println("[INFOS] -- Element name: " + ob.getClass().getSimpleName() + " Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS] -- Element name: " + ob.getClass().getSimpleName() + " Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
	
	public static void loggerExceptionWritter(Object ob, String methodName,  Message message) throws IOException {
		System.out.println("[INFOS]**[EXCEPTION] -- Element name: " + ob.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS]**[EXCEPTION] -- Element name: " + ob.getClass().getSimpleName() + " Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		loggerExceptionWritter(new PortProvided("yannis"), "test cyrille", new Message("arafet", null, true, null, null));
	}
	
}
