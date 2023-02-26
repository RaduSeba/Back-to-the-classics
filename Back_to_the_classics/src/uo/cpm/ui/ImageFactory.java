package uo.cpm.ui;

import javax.swing.ImageIcon;


public class ImageFactory {
	
	static ImageIcon loadImage(String fqImageName) {
		return new ImageIcon(ImageFactory.class.getResource(fqImageName));
	}

}