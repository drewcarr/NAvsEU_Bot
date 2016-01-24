package navseu.core;

import java.io.IOException;

import navseu.display.DisplayFrame;
import navseu.processor.ProcessMessage;
import navseu.processor.Storage;
import navseu.server.Client;

public class Runner {
	public static Storage storage;
	public static Client client;
	public static ProcessMessage pm;
	public static DisplayFrame frame;
	public static void main(String args[]) throws IOException
	{
		storage = new Storage();
		client = null;
		pm = new ProcessMessage(client,storage);
		client = new Client(pm);
		frame = new DisplayFrame(storage);
		client.joinChannel("sodapoppin");
		run();
	}
	public static void run() throws IOException
	{
		while(true)
		{
			if(client.containsMessage() == true)
			{
				client.readMessage();
				frame.updateFrame();
			}
			
		}
	}
}
