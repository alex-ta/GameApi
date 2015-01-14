package MAIN_EXAMPLE_SERVER;

import NetworkConnection.NetListener;

public class Connection implements NetListener{
	/**
	 * Listener Implementations which
	 * works with the Input
	 * from a Socketclient
	 * */
	
	String tag;
	
	public Connection(String tag){
	this.tag = tag;	
	}

	@Override
	public void update(Object o) {
		System.out.println(tag + o.toString());
	}

}
