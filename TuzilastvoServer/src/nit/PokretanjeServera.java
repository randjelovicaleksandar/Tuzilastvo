/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import forme.GlavnaFormaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class PokretanjeServera extends Thread {

    private GlavnaFormaServer gf;
    private boolean kraj = false;
    private ServerSocket serverSocket;

    public PokretanjeServera() {
    }

    public PokretanjeServera(GlavnaFormaServer gf) {
        this.gf = gf;
    }

    @Override
    public void run() {
        int port = gf.vratiIzabraniPort();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server pokrenut na portu: " + port);
            gf.postaviStatusServera("Server je pokrenut na portu: " + port, true);
            gf.osveziDugmice(true);
            while (!kraj) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao");
                new KlijentNit(socket, gf).start();
            }
        } catch (IOException ex) {
            gf.postaviStatusServera("Server je zaustavljen", false);
        }
    }

    public void zaustaviServer() {
        try {
            kraj = true;
            serverSocket.close();
            gf.osveziDugmice(false);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
