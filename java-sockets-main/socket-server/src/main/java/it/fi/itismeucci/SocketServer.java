package it.fi.itismeucci;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SocketServer {

    static boolean serverAttivo = true;

    public void avvia() throws IOException {
        ServerSocket server = new ServerSocket(6789);
        ArrayList<Socket> S = new ArrayList<>();
        while (serverAttivo) {
            try {
                Socket client = server.accept();
                S.add(client);
                MioThread t1 = new MioThread(client, S, server);
                t1.start();
            } catch (Exception e) {
                /// mi  sto per spegnere
            }
        }
    }

    /*
     * void communicate(Socket client) throws IOException {
     * BufferedReader in = new BufferedReader(new
     * InputStreamReader(client.getInputStream()));
     * DataOutputStream out = new DataOutputStream(client.getOutputStream());
     * String recv = in.readLine();
     * System.out.print("Stringa ricevuta: " + recv);
     * String modifiedRecv = recv.toUpperCase();
     * out.writeBytes(modifiedRecv + '\n');
     * client.close();
     * }
     */
}
