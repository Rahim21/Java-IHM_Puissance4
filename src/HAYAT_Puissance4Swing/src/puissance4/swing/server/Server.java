package puissance4.swing.server;


import puissance4.swing.Main;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Home
 */
public class Server {
    // encrypter
    private static final String ALGORITHM = "AES";
    private static SecretKeySpec secretKey;
    // encrypter

    // le serveur
    public ServerSocket serverSocket;

    // le client qui va se connecter
    public Socket clientSocket;

    // cf Client.class
    public String inputLine = " ";

    // sérialisation
    public DataInputStream in;
    public DataOutputStream out;
    public boolean running = false;


    public Server() {
        init();
    }

    // on ouvre le serveur
    public void init() {
        try {
            System.out.println("En attente du port 6666...");
            serverSocket = new ServerSocket(6666);
            System.out.println("Lecture sur le port 6666");
        } catch (IOException ex) {
            System.out.println("ERREUR");
            System.out.println(ex.getMessage());
            System.out.println("FERMETURE");
            close();
        }

        try {
            clientSocket = serverSocket.accept();
            System.out.println("CONNEXION ETABLIE");
            this.in = new DataInputStream(clientSocket.getInputStream());//new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out =new DataOutputStream(clientSocket.getOutputStream());//new PrintWriter(clientSocket.getOutputStream(), true);
            running = true;
        } catch (IOException ex) {
            System.out.println("ERREUR");
            System.out.println(ex.getMessage());
            System.out.println("FERMETURE");
            close();
        }
        Thread read = new Thread(() -> {
            while (running) {
                read();
            }
        });
        read.start();


    }

    public void read() {
        try {
            while ((inputLine = decrypt(in.readUTF(), "hayat")) != null) {
                System.out.println("le client a dit : " + inputLine);
                if (inputLine.contains("end")) {
                    close();
                    System.exit(1);
                } else {
                    parse(inputLine);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void write(String message) {
        //    out.println(encrypt(message, "hayat"));
        System.out.println("Envoie [" + encrypt(message, "hayat") + "/" + decrypt(encrypt(message, "hayat"), "hayat") + "] au client");
        //   out.println(encrypt(str,"hayat"));
        try {
            out.writeUTF(encrypt(message, "hayat"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERREUR : Nous ne pouvons pas sérialiser car : "+ e.getMessage());
        }

    }

    // encrypter le message
    public void prepareSecreteKey(String myKey) {
        MessageDigest sha;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Erreur lors du cryptage : " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Erreur lors du décryptage : " + e.toString());
        }
        return null;
    }


    public void close() {
        try {
            out.close();
            in.close();
            running = false;
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void parse(String msg) {
        if (msg.contains("move-")) {
            final int column = Integer.parseInt(msg.split("-")[1]);
            Main.instance.partie.control.addToFromClient(column);
            Main.instance.partie.monTour = !Main.instance.partie.monTour;
        } else if (msg.contains("cancel")) {
            Main.instance.partie.control.cancelFromClient();
            Main.instance.partie.monTour = !Main.instance.partie.monTour;
        } else if (msg.contains("reset")) {
            Main.instance.partie.control.restart();
        } else if (msg.contains("name")) {
            final String id = msg.split("-")[1];
            Main.duFX = id.equals("fx");
            Main.instance.partie.annuler.setVisible(!Main.duFX);
        }

    }
}
