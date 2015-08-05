import java.net.*;
import java.io.*;

public class Sever{

   	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(10007);
		}catch(IOException ie){
			System.out.println("Error port");
			System.exit(1);
		}
		Socket cs = null;
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
		String il;
		//while((li = input.readLine())!=null){

		while(true){
			//System.out.println("S:"+il);

			il = input.readLine();
			if(il.equals("Bye")){
				break;
			}
			System.out.println("Cliet: " +il);
			System.out.print("Server: ");
			il = get.readLine();
			output.println(il);

		}
		output.close();
		input.close();
		cs.close();
		serverSocket.close();
	}

}