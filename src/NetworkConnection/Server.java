package NetworkConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server extends Thread{
	
	/**
	 * Alex's
	 * -*Game Libary*______*~~~~~____~~~~~~~~~~~~~_______~~~~~~~~___++++++___~~~~
	 * ~~~~~~~~~~~~##____~____~~~____~~~~~~~~~~~~____*____~~~~~~~~___~~~~___~~~~~
	 *~~~~~~~~~~~~~~~____+____~~~____~~~~~~~~~~~____***____~~~~~~~~________~~~~~~
	 * ~~~~~~~~~~~~~~_______~~~~~____~~~~~~~~~~_____________~~~~~~~~~____~~~~~~~~
	 * ~~~~~~~~~~~~~~____~~~~~~~~____~~~~~~~~~_______________~~~~~~~~____~~~~~~~~
	 * ~~~~~~~~~~~~~~____~~~~~~~~_________~~~____*********____~~~~~~~____~~~~~~~~
	 * ~~~~~~~~~~~~~~____~~~~~~~~_________~~____***********____~~~~~~____~~~~~~~~
	 *
	 *Server class all servers hat a binded port an id and wait till a client is connecting,
	 *then they make a connection an create a serverclient	 
	 */
	private static int serverid = 1;
	private int id;
	private boolean running = true;
	SocketAddress ip;
	private int port;
	private ServerSocket s;
	private boolean exit;
	

	protected Server(SocketAddress ip, int port){
		this.ip = ip;
		this.port = port;
		this.s = null;
		this.exit = false;
		this.id = serverid++;
		System.out.println("Server created");
	}
	
	@Override
	public void run(){
		/**Server Lifecycle*/
		System.out.println("Server started");
		try {
			s = new ServerSocket();
			s.bind(ip, port);
			System.out.println("Serversocket bound");	
		} catch (Exception e) {
			running = false;
		}
			System.out.println("Server is running");
		
		while(running){
			try {
				Socket c = s.accept();
				Network.add(new Client().createServerClient(c,id));
				System.out.println("Client connected"+c);
			} catch (IOException e) {
				try {
					s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
			this.exit = true;
			System.out.println("Server closed");
	}
	
	protected boolean isexited(){
		/**returns if the server is finished*/
		return exit;
	}
	
	protected boolean isrunning(){
		/**returns if the server should not run*/
		return running;
	}
	
	protected int getServerId(){
		/**returns the server id*/
		return id;
	}
	
	protected void close(){
		/**closes the server and all its connections*/
		running = false;
		if(s!= null)
			try{
				s.close();
			} catch (IOException e) {
			}
	}
	
}
