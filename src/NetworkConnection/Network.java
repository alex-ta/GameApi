package NetworkConnection;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;

public class Network {
	/**
	 * Alex's
	 * 
	 *checks all connected clients and spreads all received Objects to the Listeners
	 *
	 */
	protected static ArrayList<Client> clients = new ArrayList<Client>();
	protected static ArrayList<NetListener>listener = new ArrayList<NetListener>();
	private static Server server;
	public static int sleeptime = 200;

	public static void registerListener(NetListener l){
		/**registeres a Listener class*/
		listener.add(l);
	}
	public static void unregisterListener(NetListener l){
		/**unregisteres a Listener class*/
		listener.remove(l);
	}
	
	public static int createServer(SocketAddress ip, int port){
		/**closes the connection if exists and creats a new server*/
		close();
		server = new Server(ip, port);
		server.start();
		return server.getServerId();
	}
	
	public static int createClient(SocketAddress ip){
		/**creates a client with a ip*/
		clients.add(new Client().createClient(ip));
		return 0;
	}
	
	public static void send(int id,Object o){
		/**sends an object to an id server*/
		for(Client c : clients){
			if(c.getServerId() != id)
				continue;
			try {
			c.write(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	public static void sendAll(int delay,Object o){
		/**sends an object to all connected servers/clients with delay*/
		synchronized(o){
			try {
				o.wait(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sendAll(o);
	}
	
	public static void sendAll(Object o){
		/**sends an object to all connected servers/clients*/
		for(Client c : clients){
			try {
			c.write(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void add(Client c){
		/**adds a serverside client to the list of connected ones*/
		clients.add(c);
	}
	
	public static void close(){
		/**closes all clients*/
		for(Client c : clients)
			c.close();
		sleep(500);
		if(server != null)
			server.close();
		
	}
	
	public static void sleep(int timeout){
		/**waits a specific time*/
		synchronized(clients){
			try {
				clients.wait(timeout);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

