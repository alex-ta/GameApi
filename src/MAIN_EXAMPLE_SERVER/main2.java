package MAIN_EXAMPLE_SERVER;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import NetworkConnection.*;

public class main2 {
	
	public static void main(String [] args){
		/**Server example -> client*/
		SocketAddress ip = new InetSocketAddress("127.0.0.1",2000);
		Network.createClient(ip);
		Network.registerListener(new Connection("client "));
		
	
	}

}
