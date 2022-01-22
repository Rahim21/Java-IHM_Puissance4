/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4.swing;

import static puissance4.swing.Main.instance;

/*
 * a la base on etait censé pouvoir choisir le username , mais ça cause trop de soucis donc j'ai remove ça ,
 * c'est juste devenu une fentre
 * de confirmation
 */
public class PseudoJoueur extends javax.swing.JFrame {

    /*
     * ce boolean est sert pour savoir si on doit ouvrir un serveur ou etre du côté client
     */
    public final boolean isServer;
    public javax.swing.JTextField user;

    public PseudoJoueur(boolean playerone) {


        isServer = playerone;
        createFrame();
        // on rends le textfield invisible
        user.setVisible(false);
        if (playerone) {
            setTitle("Joueur 1");
            user.setText("Joueur 1");
        } else {
            setTitle("Joueur 2");
            user.setText("Joueur 2");
        }
    }

    public String getUserName() {
        return user.getText();
    }


    private void createFrame() {

        user = new javax.swing.JTextField();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        user.setText("jTextField1");

        jButton1.setText("Connexion");
        jButton1.addActionListener(this::confirmActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(user)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 258, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
        );

        pack();
    }

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
        // on crée notre instance du jeu
        instance = new Puissance4Swing(isServer, getUserName());
        // on envoie l'username au cas ou :
        instance.send("name-swing");
        this.setVisible(false);
    }
}
