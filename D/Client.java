import java.net.*;
import java.io.*;

public class Client{

   	public static void main(String[] args) throws IOException{

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

		String il;
		while(true){
			System.out.print("Client: ");
			il = stdIn.readLine();
			output.println(il);
			il = input.readLine();
			System.out.print("Server: "+il+"\n");
			if(il.equals("Bye")){
					break;
			}
		}
		output.close();
		input.close();
		stdIn.close();
		socket.close();
	}

}