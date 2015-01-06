package IO;
import GUI.Gui;
import GUI.Position;
import GUI.Tile;


public class Mapper {
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
	 *This class prepares to write a map
	 *
	 */
	public static final String seperator1 ="#";
	public static final String seperator2 ="<";
	
	public void writeMap(String path,Gui g){
		/**writes the Map to a file*/
		Filer.write(path, g.getMap().toString(seperator2,seperator1));
	}
	
	public void readMap(String path,Gui g){
		/**reads a map from a file into Map*/
		String[] read = Filer.read(path).split(seperator1);
		String[] value = new String [3];
		
		for(int i =0; i<read.length; i++){
			value = read[i].split(seperator2);
			if(value.length <2)
				break;
			g.getMap().add(new Position(value[1]), new Tile(value[0]));
			
		}
		
	}
	

}
