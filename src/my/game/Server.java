/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NADUN
 */

package my.game;

import java.net.*;
import java.io.*;

public class Server{

   	public String start(String s) throws IOException{
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(10007);
		}catch(IOException ie){
			System.out.println("Error port");
			System.exit(1);
		}
		Socket cs = null;
                serverSocket.getInetAddress().getAddress();
		System.out.println("L.....");
		try{
			cs = serverSocket.accept();
		}catch(IOException e){
			System.out.println("Ac fail");
			System.exit(1);
		}
		System.out.println("Connction S");
		System.out.println("L....");
		PrintWriter output = new PrintWriter(cs.getOutputStream(),true);
		BufferedReader input = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		BufferedReader get = new BufferedReader(new InputStreamReader(System.in));
		String s1;
                String s2;
                String il;
		//while((li = input.readLine())!=null){

//		while(true){
//			//System.out.println("S:"+il);
//
//			il = input.readLine();
//			if(il.equals("Bye")){
//				break;
//			}
//			System.out.println("Client: " +il);
//			System.out.print("Server: ");
//			il = get.readLine();
//			output.println(il);
//
//		}
                s1 = input.readLine();
                s2 = get.readLine();
                output.println(s2);
                
		output.close();
		input.close();
		cs.close();
		serverSocket.close();
                return s2;
	}

}