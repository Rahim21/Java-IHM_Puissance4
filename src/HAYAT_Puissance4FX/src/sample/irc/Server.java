package sample.irc;

import javafx.application.Platform;
import sample.Controller;
import sample.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static sample.encrypt.Crypter.decrypt;
import static sample.encrypt.Crypter.encrypt;


public class Server {

    public static DataInputStream in;
    public static DataOutputStream out;

    public static void main() {
        try {
            ServerSocket s = new ServerSocket(6666);
            Socket socket = s.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                while (true) {
                    String clientMessage = null;
                    try {
                        clientMessage = in.readUTF();
                        String finalClientMessage = clientMessage;
                        Platform.runLater(() -> parseClientMessage(decrypt(finalClientMessage, "ssoross")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            System.out.println("Could not establish connection to server. Program terminating..");
            System.exit(1);
        }
    }


    private static void parseClientMessage(String msg) {
        System.out.println("client said : " + msg);
        // update the JavaFX UI
        if (msg.contains("move-")) {
            final int column = Integer.parseInt(msg.split("-")[1]);
            Main.controller.insertDiskFromServ(new Controller.Disc(false), column);
        } else if (msg.equals("reset")) {
            Main.controller.resetGame();
        }
    }

    public void write(String str) {
        System.out.println("we send [" + encrypt(str, "ssoross") + "/" + decrypt(encrypt(str, "ssoross"), "ssoross") + "] to the client");
        try {
            out.writeUTF(encrypt(str, "ssoross"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}