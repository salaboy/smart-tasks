package com.wordpress.salaboy.smarttasks.ui;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ShowImage extends Panel {
	BufferedImage image;

	public ShowImage(String imageName) {
		try {
			image = ImageIO.read(new File(ShowImage.class.getClassLoader().getResource(imageName)
					.getFile()));
			setSize(image.getWidth(),image.getHeight() + 20);
		} catch (IOException ie) {
			System.out.println("Error:" + ie.getMessage());
		}
	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
	}

	static public void main(String args[]) throws Exception {
		JFrame frame = new JFrame("Display image");
		Panel panel = new ShowImage("humanTask.png");
		frame.getContentPane().add(panel);
		frame.setSize(panel.getWidth(), panel.getHeight() + 20);
		frame.setVisible(true);
	}
}