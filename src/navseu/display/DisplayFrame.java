package navseu.display;

import javax.swing.JFrame;
import javax.swing.JPanel;

import navseu.processor.Storage;

public class DisplayFrame extends JFrame{
	public StatPanel statPanel;
	Storage storage;
	public DisplayFrame(Storage s)
	{
		storage = s;
		statPanel = new StatPanel(storage);
		this.add(statPanel);
		this.setVisible(true);
		this.setTitle("NA vs EU");
		this.setSize(2000, 2000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void updateFrame()
	{
		statPanel.updatePanel();
		this.revalidate();
		this.repaint();
	}
}
