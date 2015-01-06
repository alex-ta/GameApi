package MAIN_EXAMPLE_SERVER;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import NetworkConnection.Network;

public class Main {
	/**Server example -> Server*/
	public static void main(String[] args) {
		SocketAddress ip = new InetSocketAddress("127.0.0.1",2000);
		Network.createServer(ip, 2000);
		
		int i =0;
		while (i<4){
		Network.sendAll(5000,"Message vom Server");
		i++;
		}	
		Network.close();
	}	
	
}
