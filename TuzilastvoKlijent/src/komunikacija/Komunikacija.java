/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class Komunikacija {

    private Socket socket;
    private static Komunikacija instance;

    private Komunikacija() throws IOException {
    }

    public static Komunikacija getInstance() throws IOException {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void posaljiZahtev(TransferObjekatZahtev zahtev) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(zahtev);
    }

    public TransferObjekatOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (TransferObjekatOdgovor) inSocket.readObject();
    }

    public void konektujSe(String ipAdresa, int port) throws IOException {
        socket = new Socket(ipAdresa, port);
//        socket = new Socket("192.168.0.15", 808);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
}
