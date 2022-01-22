package sample.irc;

import javafx.application.Platform;
import sample.Controller;
import sample.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static sample.encrypt.Crypter.decrypt;
import static sample.encrypt.Crypter.encrypt;


public class Client {


    public static DataInputStream in;
    public static DataOutputStream out;
    // --Commented out by Inspection (01/05/2021 01:11):private static boolean appRunning = true;

    public static void main() {
        try {
            Socket socket = new Socket("localhost", 6666);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {

                while (true) {
                    String serverMessage = null;
                    try {
                        serverMessage = Client.in.readUTF();
                        String finalServerMessage = serverMessage;
                        Platform.runLater(() -> parseServerMessage(decrypt(finalServerMessage, "ssoross")));
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

    private static void parseServerMessage(String msg) {
        System.out.println("server said : " + msg);
        if (msg.contains("move-")) {
            final int column = Integer.parseInt(msg.split("-")[1]);
            Main.controller.insertDiskFromServ(new Controller.Disc(true), column);
        } else if (msg.equals("reset")) {
            Main.controller.resetGame();
        }
    }

    public void write(String str) {
        System.out.println("we send [" + encrypt(str, "ssoross") + "/" + str + "] to the server");
        try {
            out.writeUTF(encrypt(str, "ssoross"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}