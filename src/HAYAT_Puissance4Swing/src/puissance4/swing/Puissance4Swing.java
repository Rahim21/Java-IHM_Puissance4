/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4.swing;

import puissance4.swing.client.Client;
import puissance4.swing.engine.Puissance4View;
import puissance4.swing.server.Server;

import javax.swing.*;
import java.awt.*;

public class Puissance4Swing {

    public final Server server;
    public final Client client;

    public final String pseudoJoueur;

    public final boolean tourJoueur1;
    public final Puissance4View partie;

    public Puissance4Swing(boolean joueur1, String name) {
        tourJoueur1 = joueur1;
        pseudoJoueur = name;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        int largeur = (int)width;
        int hauteur = (int)height;
        // désactiver le if et le else pour modifier le GUI

        if (tourJoueur1) {
            server = new Server();
            client = null;
            partie = new Puissance4View(true);
            double gameWidth = partie.getSize().getWidth();
            double gameHeight = partie.getSize().getHeight();
            int gameLargeur = (int)gameWidth;
            int gameHauteur = (int)gameHeight;
            partie.setLocation(largeur/2-gameLargeur,hauteur/3); // coordonnées de la fenêtre selon la taille de mon écran 17 pouces
            partie.getRootPane().setBorder(
                    BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(0xFF0000))
            );

        } else {
            client = new Client();
            server = null;
            partie = new Puissance4View(false);
            double gameWidth = partie.getSize().getWidth();
            double gameHeight = partie.getSize().getHeight();
            int gameLargeur = (int)gameWidth;
            int gameHauteur = (int)gameHeight;
            partie.setLocation(largeur/2-1/gameLargeur,hauteur/3); // coordonnées de la fenêtre selon la taille de mon écran 17 pouces
            partie.getRootPane().setBorder(
                    BorderFactory.createMatteBorder(6, 6, 6, 6, new Color(0xFFFA00))
            );
        }

        // activer pour modif le GUI
        /*
        game = new UI(true); // activer pour modifier le GUI
        client = null; // activer pour modifier le GUI
        server = null; // activer pour modifier le GUI
        */
        // activer jusqu'ici pour modif le GUI

        partie.setTitle("Puissance 4 - HAYAT [" + this.pseudoJoueur + "]");
        partie.setVisible(true);
    }


    public void send(String string) {
        if (tourJoueur1) {
            if (server != null) {
                server.write(string);
            } else {
                System.out.println("erreur étrange mais le serveur est null");
            }
        } else {
            if (client != null) {
                client.write(string);
            } else {
                System.out.println("erreur étrange mais le client est nul");
            }
        }
    }
}
