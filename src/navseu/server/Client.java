package navseu.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
	public String servername = "irc.twitch.tv";
	public int port = 6667;
	public Socket socket;
	public String username = "remywarfly";
	public String password = "oauth:68phvkvj3jiuxucmxgnblrkqvdgc4a";
	public PrintWriter pw;
	public BufferedReader br;
	public InputStreamReader isr;
	public Client()
	{
		
		try
		{
			socket = new Socket(servername,port);
			pw = new PrintWriter(socket.getOutputStream());
			isr = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isr);
			String message = br.readLine();
			System.out.println("Server says: " + message);
			sendMessage("PASS " + password);
			sendMessage("NICK " + username);
			
			while(socket.isConnected() == true)
			{
				message = br.readLine();
				System.out.println("Server sent " + message);
				proccessMessage(message);
			}
		}
		catch(IOException ioException)
		{
			System.out.println("Error");
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch(IOException ioException)
			{
				ioException.printStackTrace();
			}
			
		}
		
		
	}
	public void sendMessage(String mess)
	{
		try
		{
			mess = mess + "\n";
			pw.print(mess);
			pw.flush();
			System.out.println("Sent message: " + mess);
			String message = br.readLine();
			System.out.println("Server says: " + message);
		}
		catch(IOException ioException)
		{
			System.out.println("Error");
		}
		
	}
	public void proccessMessage(String message)
	{
		
	}
}
