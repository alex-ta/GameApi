package MAIN_EXAMPLE_SERVER;

import NetworkConnection.NetListener;

public class Connection implements NetListener{
	/**Server example*/
	String tag;
	
	public Connection(String tag){
	this.tag = tag;	
	}

	@Override
	public void update(Object o) {
		System.out.println(tag + o.toString());
	}

}
