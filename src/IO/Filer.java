package IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Filer {
	
	/**
	 * Alex's
	 * 
	 *This Class writes or reads a file
	 */
	
	private static FileOutputStream out = null;
	private static FileInputStream in = null;
	
	public static void write(String path, String text){
		/**writes text to a path*/
		try{
		out = new FileOutputStream(new File(path));
		out.write(text.getBytes());
		} catch(Exception e){
			e.printStackTrace();
		}finally{
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		}
	}
	
	public static String read(String path){
		/**reads text from a path*/
		StringBuffer buff = new StringBuffer();
		int read;
		try{
		in = new FileInputStream(new File(path));
		while((read = in.read()) != -1){
			buff.append(((char)read));
		}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		}
		return buff.toString();
	}
}
