package launcher;

import java.io.IOException;
import java.util.Scanner;

import connection.Server;

public class Main {

	public static void main(String[] args) throws IOException {
		Server server = new Server(5123);
		Scanner in = new Scanner(System.in);
		
		while(true) {
			server.connect();
			
			while(!server.connectionIsClosed()) {
				try {
					System.out.print("> ");
					server.send(in.nextLine());
				}catch(IOException e){
					server.end();
					System.out.println("Connection interrupted :/");
				}
			}
		}
	}
}
