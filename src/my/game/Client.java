/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.game;

/**
 *
 * @author NADUN
 */
import java.net.*;
import java.io.*;

public class Client{

   	public String start(String s1) throws IOException{

		Socket socket = null;
		PrintWriter output = null;
		BufferedReader input = null;
		BufferedReader stdIn = new BufferedReader (new InputStreamReader(System.in));
		String ip;
		String port;
		try{
			System.out.print("Enter IP: ");
			ip = stdIn.readLine();
			System.out.print("\nEnter Port: ");
			port = stdIn.readLine();
			socket = new Socket(ip,Integer.valueOf(port));
			output = new PrintWriter(socket.getOutputStream(),true);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(UnknownHostException e){
			System.out.println("Error h");
			System.exit(1);
		}catch(IOException ie){
			System.out.println("Error port");
			System.exit(1);
		}catch(Exception ex){}
		//BufferedReader stdIn = new BufferedReader (new InputStreamReader(System.in));

		
                String s2;
//		while(true){
//			System.out.print("Client: ");
//			il = stdIn.readLine();
//			output.println(il);
//			il = input.readLine();
//			System.out.print("Server: " +il+ "\n");
//			if(il.equals("Bye")){
//					break;
//			}
//		}
                //s1 = stdIn.readLine(); //out
                output.println(s1); // going
                s2 = input.readLine();  //in
                
                
		output.close();
		input.close();
		stdIn.close();
		socket.close();
                
                return s2;
	}

}