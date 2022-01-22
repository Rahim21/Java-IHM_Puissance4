/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4.swing;

import javax.swing.*;

public class Main {

    public static Puissance4Swing instance;
    public static boolean tourJoueur1;
    public static PseudoJoueur user;

    public static boolean duFX;

    public static void main(String[] args) {

        // désactiver pour modifier le GUI


        int result = JOptionPane.showConfirmDialog(null, "Vous etes le Joueur 1 ?", "Puissance 4 | HAYAT",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            tourJoueur1 = true;
        } else if (result == JOptionPane.NO_OPTION) {
            tourJoueur1 = false;
        }

        // user = new UsernameUI(isPlayerOne); // bouton connect
        instance = new Puissance4Swing (tourJoueur1, tourJoueur1 ? "joueur 1" : "joueur2"); // sans bouton connect
//        user.setVisible(true);

        // désactiver jusque là

        // activer pour modif le GUI
        // instance = new Puissance4Swing(true, "Joueur 1");
    }

}
