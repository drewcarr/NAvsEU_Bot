package navseu.display;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import navseu.processor.Storage;

public class StatPanel extends JPanel{
	public Storage storage;
	public JLabel na;
	public JLabel eu;
	public JLabel kappa;
	public JLabel pogchamp;
	public ImageIcon naIcon,euIcon,kappaIcon,pogchampIcon;
	public StatPanel(Storage s)
	{
		this.setSize(1000,1000);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		storage = s;
		Dimension d = new Dimension(200,200);
		Font font = new Font("Monotype Corsivia",1,40);
		loadIcons();
		
		na = new JLabel("Total Na's : " + storage.getNA());
		na.setPreferredSize(d);
		na.setFont(font);
		eu = new JLabel("Total EU's : " + storage.getEU());
		eu.setPreferredSize(d);
		eu.setFont(font);
		kappa = new JLabel("Total Kappa's: " + storage.getKappa());
		kappa.setPreferredSize(d);
		kappa.setFont(font);
		kappa.setIcon(kappaIcon);
		pogchamp = new JLabel("Total PogChamp's: " + storage.getPogchamp());
		pogchamp.setPreferredSize(d);
		pogchamp.setFont(font);
		pogchamp.setIcon(pogchampIcon);
		
		this.add(na);
		this.add(eu);
		this.add(kappa);
		this.add(pogchamp);
	}
	public void updatePanel()
	{
		na.setText("Total Na's : " + storage.getNA());
		eu.setText("Total EU's : " + storage.getEU());
		kappa.setText("Total Kappa's: " + storage.getKappa());
		pogchamp.setText(("Total PogChamp's: " + storage.getPogchamp()));
		this.revalidate();
		this.repaint();
	}
	public void loadIcons()
	{
		BufferedImage img = null;
		try 
		{
		    img = ImageIO.read(new File("C:/Users/DNAKMEMES/git/NAvsEU_Bot/gjn81wvxqsq6yzcwubok.png"));
		    kappaIcon = new ImageIcon(img);
		    img = ImageIO.read(new File("C:/Users/DNAKMEMES/git/NAvsEU_Bot/pogchamp.jpg"));
		    pogchampIcon = new ImageIcon(img);
		} 
		catch (IOException e)
		{
			System.out.println("Couldn't load image");
		}
		
	}
}
