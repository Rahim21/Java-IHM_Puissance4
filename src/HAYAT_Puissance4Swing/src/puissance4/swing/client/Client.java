package puissance4.swing.client;


import puissance4.swing.Main;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    // encrypt
    private static final String ALGORITHM = "AES";
    private static SecretKeySpec secretKey;
    //encrypt

    // le socket pour communiqué
    public Socket socket;

    // la reception
    public String inputLine = " ";

    //dataouputstrem pour lire ce que dit le server et automatiquement le deserialisé
    public DataInputStream in;
    // dataouputstrem pour repondre su server et automatiquement le serialisé
    public DataOutputStream out;

    public boolean running = false;

    public Client() {
        init();
    }

    // on initialise le client et on se connecte au server
    public void init() {
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 6666);
            if (socket.isConnected()) {
                System.out.println("Connecté à : " + socket.getPort() + " " + socket.getInetAddress());
                this.in = new DataInputStream(socket.getInputStream());//new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.out = new DataOutputStream(socket.getOutputStream());//new PrintWriter(socket.getOutputStream(), true);
                // le client est connecté, il fonctionné donc on run
                running = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        // le tout dans un thread pour pas arreté le mainthread
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
                System.out.println("le serveur a dit : " + inputLine);
                if (inputLine.contains("end")) {
                    end();
                } else {
                    parse(inputLine);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void end() {
        this.close();
        System.gc();
        System.exit(1);
    }

    public void write(String message) {
        System.out.println("Envoie [" + encrypt(message, "hayat") + "/" + decrypt(encrypt(message, "hayat"), "hayat") + "] au client");

        try {
            out.writeUTF(encrypt(message, "hayat"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERREUR : Nous ne pouvons pas sérialiser car : "+ e.getMessage());
        }

    }

    // encrypter le message (code pris sur le net)
    public void prepareSecreteKey(String myKey) {
        MessageDigest sha;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // encrypter le message (code pris sur le net)
    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Erreur lors du cryptage : " + e.toString());
        }
        return "error";
    }

    // décrypter le message (code pris sur le net)
    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Erreur lors du décryptage : " + e.toString());
        }
        return "error";
    }


    public void close() {
        try {
            // Fermeture + Arrêt du serveur
            out.close();
            in.close();
            running = false;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // on parse le message après l'avoir décrypter
    private void parse(String msg) {
        if (msg.contains("move-")) {
            final int column = Integer.parseInt(msg.split("-")[1]);
            Main.instance.partie.control.addToFromServer(column);
            Main.instance.partie.monTour = !Main.instance.partie.monTour;
        } else if (msg.equals("cancel")) {
            Main.instance.partie.control.cancel(true);
            Main.instance.partie.monTour = !Main.instance.partie.monTour;
        } else if (msg.equals("reset")) {
            Main.instance.partie.control.restart();
        } else if (msg.contains("name")) {
            final String id = msg.split("-")[1];
            Main.duFX = id.equals("fx");
            Main.instance.partie.annuler.setVisible(!Main.duFX);
        }
    }
}
