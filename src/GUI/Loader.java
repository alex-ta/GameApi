package GUI;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * Alex's
 * 
 *Loads Ressources from a Path, here just Images
 *
 */

public class Loader {
	
	public static Image loadImage(String path){
		Image img = null;
		try{
		img = ImageIO.read(new File(path));
		} catch(Exception e){
			System.out.println("Ressource "+path+" not found");
		}
		return img;
	}

}
