package hadl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import hadl.component.meta.model.Component;
import hadl.interfaces.meta.model.Interface;

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
	
	public static void loggerExceptionWritter(Component component, String methodName,  Message message) throws IOException {
		System.out.println("[INFOS]**[EXCEPTION] -- Element name: " + component.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS] -- Element name: " + component.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
	
	public static void loggerExceptionWritter(Interface interfaceCom, String methodName, Message message) throws IOException {
		System.out.println("[INFOS]**[EXCEPTION] -- Element name: " + interfaceCom.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS] -- Element name: " + interfaceCom.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
	
	public static void loggerWritter(Interface interfaceCom, String methodName, Message message) throws IOException {
		System.out.println("[INFOS] -- Element name: " + interfaceCom.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS] -- Element name: " + interfaceCom.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
		
	
	public static void loggerWritter(Component component, String methodName,  Message message) throws IOException {
		System.out.println("[INFOS] -- Element name: " + component.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response);
		String chaine = loggerReader();
		FileWriter writer = new FileWriter(new File("Repository/log.txt"));
		if(!(chaine.equals(null))){
			chaine = chaine + "[INFOS] -- Element name: " + component.getClass().getSimpleName() + "Method called: "+ methodName + " " + " Message type: " + message.getName() + " "+ "Message result: " + message.response; 
		}
		writer.write(chaine);
		writer.close();
	}
}
