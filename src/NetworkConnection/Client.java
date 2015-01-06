package NetworkConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Client extends Thread {
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
	 *Client that can receive Massages and knows which
	 *server it is connected
	 */
	
	
	private static Socket connection;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private boolean running;
	private int serverid;

	protected void write(Object o) throws IOException{
		/**write an Object trough the Connection to the server*/
		if(out != null){
		out.writeObject(o);
		out.flush();
		}
	}
	
	private Object read() throws ClassNotFoundException, IOException{
		/**Reads a Object from the Server*/
		Object o = in.readObject();
		if(!o.toString().equals("-1"))
			return o;
			running = false;
			connection.close();
		return "closed";
	}
	
	protected Client () {
		serverid = 0;
	}
	
	public Client createClient(SocketAddress ip){
		/**connect the client to a IP*/
		connection = new Socket();
		try {
			connection.connect(ip,500);
		} catch (IOException e) {
			close();
		}
		create();
		return this;
	}	
	
	public Client createServerClient(Socket s,int serverid){
		/**creates a Client on the Serverside*/
		connection = s;
		this.serverid = serverid;
		create();
		return this;
	}
	
	private void create() {
		/**opens the in and Output streams*/
		if(!connection.isClosed())
		try {
		out = new ObjectOutputStream(connection.getOutputStream());
		in = new ObjectInputStream(connection.getInputStream());
		running = true;
		System.out.println("Client created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	protected void close(){
		/**closes the Client connection*/
		if(connection != null){
		try {
			write(-1);
			connection.close();
		} catch (IOException e) {
			// closes here on multiple clients, but dont know why
		}
		running = false;
		}
	}
	
	protected boolean isRunning(){
		/**returns if the client is running*/
		return running;
	}

	protected int getServerId(){
		/**returns the connected server id*/
		return serverid;
	}

	@Override
	public void run(){
		/**Client Lifecycle*/
		System.out.println("Client runs");
		while(running){
		for(NetListener l : Network.listener){
			try {
				System.out.println("Client reads");
				l.update(read());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				running = false;
			}
			}
		synchronized(this){
			try {
				this.wait(Network.sleeptime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		System.out.println("Client stopped");
	}

}

