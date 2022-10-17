package it.fi.itismeucci;
import java.io.*;
import java.net.*;

public class MioThread extends Thread
{
    Socket cli;
    public MioThread(Socket client) {
        this.cli = client;
    }

    public void run() {
        for(;;)
        {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(cli.getInputStream()));
                DataOutputStream out = new DataOutputStream(cli.getOutputStream());
                String recv = in.readLine();
                System.out.print("Stringa ricevuta: " + recv);
                String modifiedRecv = recv.toUpperCase();
                out.writeBytes(modifiedRecv + '\n');
                
            } catch (IOException e) {
                System.out.println("Evvove mio");
            }
        }
            
        
        
    }
}
