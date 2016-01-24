package navseu.processor;

import java.util.ArrayList;

import navseu.server.Client;

public class ProcessMessage {
	public Client client;
	public Storage storage;
	public ProcessMessage(Client c,Storage s)
	{
		client = c;
		storage = s;
	}
	public void receiveMessage(String mess)
	{
		String[] Premessage = mess.split(":");
		Premessage[1] = Premessage[1].trim();
		switch(Premessage[1])
		{
			case "PING": client.pong();
		}
		String[] message = Premessage[2].split(" ");
		for(int x = 0; x < message.length; x++)
		{
			switch(message[x])
			{
				case "NA": storage.addNA();
				case "EU": storage.addEU();
				case "Kappa": storage.addKappa();
				case "PogChamp": storage.addPogchamp();
			}
		}
	}
}
