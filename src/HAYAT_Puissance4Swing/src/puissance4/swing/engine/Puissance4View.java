/**
 * L'ID correspond à chaque emplacement du plateau


 6  12  18  24  30  36  42
 5  11  17  23  29  35  41
 4  10  16  22  28  34  40
 3  9   15  21  27  33  39
 2  8   14  20  26  32  38
 1  7   13  19  25  31  37

 */
package puissance4.swing.engine;

import puissance4.swing.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Puissance4View extends JFrame {

    // partie game
    public final boolean tourJoueur1;

    // les icons
    final ImageIcon jetonvide = new ImageIcon(this.getClass().getResource("/img/jetonvide.png"));
    final ImageIcon jeton1 = new ImageIcon(this.getClass().getResource("/img/jeton1.png"));
    final ImageIcon jeton2 = new ImageIcon(this.getClass().getResource("/img/jeton2.png"));

    public boolean monTour;
    public int redRemain;
    public int jauneRemain;
    public JLabel jauneIndicateur;
    public JLabel rougeIndicateur;
    public JButton annuler;
    public JPanel col1;
    public JPanel col2;
    public JPanel col3;
    public JPanel col4;
    public JPanel col5;
    public JPanel col6;
    public JPanel col7;
    public JLabel tourLabel;

    public final Puissance4Controller control;

    public Puissance4View(final boolean monTour) {
        this.redRemain = 21;
        this.jauneRemain = 21;

        this.tourJoueur1 = monTour; // on verifie si on est le server/joueur 1
        this.monTour = monTour;    // si on est le joueur 1 on est forcement le premier a jouer

        this.creerFrame(); // on creé la gui
        control = new Puissance4Controller(this);
        // et on ajoute les different listener qui vont nous permettre de faire en sorte que le jeur fonctionne

        this.tourLabel.setText("Joueur 1 commence");
    }


    public void creerFrame() {
        JLayeredPane jLayeredPane1 = new JLayeredPane();

        final ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/ocean.gif"));
        JPanel mainPanel = (new JPanel() {                                                             // initialisation JPanel menu
            Image img = icon.getImage();                                                 // ajout d'une image

            // initialiseur d'instance
            {
                setOpaque(false);
            }

            public void paintComponent(Graphics graphics) {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        });


        JPanel panelJeu = new JPanel();
        this.col1 = new JPanel();
        // partie UI
        JLabel cell2 = new JLabel();
        JLabel cell3 = new JLabel();
        JLabel cell4 = new JLabel();
        JLabel cell5 = new JLabel();
        JLabel cell6 = new JLabel();
        JLabel cell44 = new JLabel();
        this.col2 = new JPanel();
        JLabel cell43 = new JLabel();
        JLabel cell45 = new JLabel();
        JLabel cell46 = new JLabel();
        JLabel cell47 = new JLabel();
        JLabel cell48 = new JLabel();
        JLabel cell49 = new JLabel();
        this.col3 = new JPanel();
        JLabel cell50 = new JLabel();
        JLabel cell51 = new JLabel();
        JLabel cell52 = new JLabel();
        JLabel cell53 = new JLabel();
        JLabel cell54 = new JLabel();
        JLabel cell55 = new JLabel();
        this.col4 = new JPanel();
        JLabel cell56 = new JLabel();
        JLabel cell57 = new JLabel();
        JLabel cell58 = new JLabel();
        JLabel cell59 = new JLabel();
        JLabel cell60 = new JLabel();
        JLabel cell61 = new JLabel();
        this.col5 = new JPanel();
        JLabel cell62 = new JLabel();
        JLabel cell63 = new JLabel();
        JLabel cell64 = new JLabel();
        JLabel cell65 = new JLabel();
        JLabel cell66 = new JLabel();
        JLabel cell67 = new JLabel();
        this.col7 = new JPanel();
        JLabel cell74 = new JLabel();
        JLabel cell75 = new JLabel();
        JLabel cell76 = new JLabel();
        JLabel cell77 = new JLabel();
        JLabel cell78 = new JLabel();
        JLabel cell79 = new JLabel();
        this.col6 = new JPanel();
        JLabel cell68 = new JLabel();
        JLabel cell69 = new JLabel();
        JLabel cell70 = new JLabel();
        JLabel cell71 = new JLabel();
        JLabel cell72 = new JLabel();
        JLabel cell73 = new JLabel();
        final ImageIcon wood = new ImageIcon("src/img/banner.png");
        Image imgWood = wood.getImage();
        JPanel sidePane = new JPanel(){
            Image imgWood = wood.getImage();
            // initialiseur d'instance
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(imgWood, -1000, 0, this);
                super.paintComponent(graphics);
            }
        };
        JButton restart = new JButton();
        this.annuler = new JButton();
        JTextArea desc = new JTextArea();
        this.tourLabel = new JLabel();
        JPanel redpan = new JPanel();
        JLabel iconRed = new JLabel();
        this.rougeIndicateur = new JLabel();
        JPanel jaunePan = new JPanel();
        JLabel iconJaune = new JLabel();
        this.jauneIndicateur = new JLabel();
        final GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // mainPanel.setBackground(new Color(127, 127, 127));
        panelJeu.setBackground(new Color(63, 71, 204));
        this.col1.setBackground(new Color(63, 71, 204));
        cell2.setIcon(jetonvide);
        cell2.setIconTextGap(-35);
        cell3.setIcon(jetonvide);
        cell4.setIcon(jetonvide);
        cell5.setIcon(jetonvide);
        cell6.setIcon(jetonvide);
        cell6.setToolTipText("");
        cell6.setIconTextGap(-8);
        cell6.setInheritsPopupMenu(false);
        cell44.setIcon(jetonvide);
        final GroupLayout col1Layout = new GroupLayout(this.col1);
        this.col1.setLayout(col1Layout);
        col1Layout.setHorizontalGroup(col1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col1Layout.createSequentialGroup().addContainerGap().addGroup(col1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell6).addComponent(cell2).addComponent(cell4).addComponent(cell3).addComponent(cell44).addComponent(cell5)).addContainerGap(-1, 32767)));
        col1Layout.setVerticalGroup(col1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col1Layout.createSequentialGroup().addComponent(cell5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell44).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell6).addContainerGap()));
        cell2.getAccessibleContext().setAccessibleName("2");
        cell3.getAccessibleContext().setAccessibleName("4");
        cell4.getAccessibleContext().setAccessibleName("3");
        cell5.getAccessibleContext().setAccessibleName("6");
        cell6.getAccessibleContext().setAccessibleName("1");
        cell44.getAccessibleContext().setAccessibleName("5");
        this.col2.setBackground(new Color(63, 71, 204));
        cell43.setIcon(jetonvide);
        cell43.setIconTextGap(-35);
        cell45.setIcon(jetonvide);
        cell46.setIcon(jetonvide);
        cell47.setIcon(jetonvide);
        cell48.setIcon(jetonvide);
        cell49.setIcon(jetonvide);
        final GroupLayout col2Layout = new GroupLayout(this.col2);
        this.col2.setLayout(col2Layout);
        col2Layout.setHorizontalGroup(col2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col2Layout.createSequentialGroup().addContainerGap().addGroup(col2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell48).addComponent(cell43).addComponent(cell46).addComponent(cell45).addComponent(cell49).addComponent(cell47)).addContainerGap(-1, 32767)));
        col2Layout.setVerticalGroup(col2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col2Layout.createSequentialGroup().addComponent(cell47).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell49).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell45).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell46).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell43).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell48).addGap(59, 59, 59)));
        cell43.getAccessibleContext().setAccessibleName("8");
        cell45.getAccessibleContext().setAccessibleName("10");
        cell46.getAccessibleContext().setAccessibleName("9");
        cell47.getAccessibleContext().setAccessibleName("12");
        cell48.getAccessibleContext().setAccessibleName("7");
        cell49.getAccessibleContext().setAccessibleName("11");
        this.col3.setBackground(new Color(63, 71, 204));
        cell50.setIcon(jetonvide);
        cell50.setIconTextGap(-35);
        cell51.setIcon(jetonvide);
        cell52.setIcon(jetonvide);
        cell53.setIcon(jetonvide);
        cell54.setIcon(jetonvide);
        cell55.setIcon(jetonvide);
        final GroupLayout col3Layout = new GroupLayout(this.col3);
        this.col3.setLayout(col3Layout);
        col3Layout.setHorizontalGroup(col3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col3Layout.createSequentialGroup().addContainerGap().addGroup(col3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell54).addComponent(cell50).addComponent(cell52).addComponent(cell51).addComponent(cell55).addComponent(cell53)).addContainerGap(-1, 32767)));
        col3Layout.setVerticalGroup(col3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col3Layout.createSequentialGroup().addComponent(cell53).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell55).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell51).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell52).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell50).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell54).addGap(47, 47, 47)));
        cell50.getAccessibleContext().setAccessibleName("14");
        cell50.getAccessibleContext().setAccessibleDescription("");
        cell51.getAccessibleContext().setAccessibleName("16");
        cell52.getAccessibleContext().setAccessibleName("15");
        cell53.getAccessibleContext().setAccessibleName("18");
        cell54.getAccessibleContext().setAccessibleName("13");
        cell55.getAccessibleContext().setAccessibleName("17");
        this.col4.setBackground(new Color(63, 71, 204));
        cell56.setIcon(jetonvide);
        cell56.setIconTextGap(-35);
        cell57.setIcon(jetonvide);
        cell58.setIcon(jetonvide);
        cell59.setIcon(jetonvide);
        cell60.setIcon(jetonvide);
        cell61.setIcon(jetonvide);
        final GroupLayout col4Layout = new GroupLayout(this.col4);
        this.col4.setLayout(col4Layout);
        col4Layout.setHorizontalGroup(col4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col4Layout.createSequentialGroup().addContainerGap().addGroup(col4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell60).addComponent(cell56).addComponent(cell58).addComponent(cell57).addComponent(cell61).addComponent(cell59)).addContainerGap(-1, 32767)));
        col4Layout.setVerticalGroup(col4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col4Layout.createSequentialGroup().addComponent(cell59).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell61).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell57).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell58).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell56).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell60).addGap(59, 59, 59)));
        cell56.getAccessibleContext().setAccessibleName("20");
        cell57.getAccessibleContext().setAccessibleName("22");
        cell58.getAccessibleContext().setAccessibleName("21");
        cell59.getAccessibleContext().setAccessibleName("24");
        cell60.getAccessibleContext().setAccessibleName("19");
        cell61.getAccessibleContext().setAccessibleName("23");
        this.col5.setBackground(new Color(63, 71, 204));
        cell62.setIcon(jetonvide);
        cell62.setIconTextGap(-35);
        cell63.setIcon(jetonvide);
        cell64.setIcon(jetonvide);
        cell65.setIcon(jetonvide);
        cell66.setIcon(jetonvide);
        cell67.setIcon(jetonvide);
        final GroupLayout col5Layout = new GroupLayout(this.col5);
        this.col5.setLayout(col5Layout);
        col5Layout.setHorizontalGroup(col5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col5Layout.createSequentialGroup().addContainerGap().addGroup(col5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell66).addComponent(cell62).addComponent(cell64).addComponent(cell63).addComponent(cell67).addComponent(cell65)).addContainerGap(-1, 32767)));
        col5Layout.setVerticalGroup(col5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col5Layout.createSequentialGroup().addComponent(cell65).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell67).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell63).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell64).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell62).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell66).addContainerGap()));
        cell62.getAccessibleContext().setAccessibleName("26");
        cell63.getAccessibleContext().setAccessibleName("28");
        cell64.getAccessibleContext().setAccessibleName("27");
        cell65.getAccessibleContext().setAccessibleName("30");
        cell66.getAccessibleContext().setAccessibleName("25");
        cell67.getAccessibleContext().setAccessibleName("29");
        this.col7.setBackground(new Color(63, 71, 204));
        cell74.setIcon(jetonvide);
        cell74.setIconTextGap(-35);
        cell75.setIcon(jetonvide);
        cell76.setIcon(jetonvide);
        cell77.setIcon(jetonvide);
        cell78.setIcon(jetonvide);
        cell79.setIcon(jetonvide);
        final GroupLayout col7Layout = new GroupLayout(this.col7);
        this.col7.setLayout(col7Layout);
        col7Layout.setHorizontalGroup(col7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col7Layout.createSequentialGroup().addContainerGap().addGroup(col7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell78).addComponent(cell74).addComponent(cell76).addComponent(cell75).addComponent(cell79).addComponent(cell77)).addContainerGap(-1, 32767)));
        col7Layout.setVerticalGroup(col7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col7Layout.createSequentialGroup().addComponent(cell77).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell79).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell75).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell76).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell74).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell78).addGap(62, 62, 62)));
        cell74.getAccessibleContext().setAccessibleName("38");
        cell75.getAccessibleContext().setAccessibleName("40");
        cell76.getAccessibleContext().setAccessibleName("39");
        cell77.getAccessibleContext().setAccessibleName("42");
        cell78.getAccessibleContext().setAccessibleName("37");
        cell79.getAccessibleContext().setAccessibleName("41");
        this.col6.setBackground(new Color(63, 71, 204));
        cell68.setIcon(jetonvide);
        cell68.setIconTextGap(-35);
        cell69.setIcon(jetonvide);
        cell70.setIcon(jetonvide);
        cell71.setIcon(jetonvide);
        cell72.setIcon(jetonvide);
        cell73.setIcon(jetonvide);
        final GroupLayout col6Layout = new GroupLayout(this.col6);
        this.col6.setLayout(col6Layout);
        col6Layout.setHorizontalGroup(col6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col6Layout.createSequentialGroup().addContainerGap().addGroup(col6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cell72).addComponent(cell68).addComponent(cell70).addComponent(cell69).addComponent(cell73).addComponent(cell71)).addContainerGap(-1, 32767)));
        col6Layout.setVerticalGroup(col6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(col6Layout.createSequentialGroup().addComponent(cell71).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(cell73).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell69).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell70).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell68).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cell72).addGap(41, 41, 41)));
        cell68.getAccessibleContext().setAccessibleName("32");
        cell69.getAccessibleContext().setAccessibleName("34");
        cell70.getAccessibleContext().setAccessibleName("33");
        cell71.getAccessibleContext().setAccessibleName("36");
        cell71.getAccessibleContext().setAccessibleDescription("");
        cell72.getAccessibleContext().setAccessibleName("31");
        cell73.getAccessibleContext().setAccessibleName("35");
        final GroupLayout gamePanelLayout = new GroupLayout(panelJeu);
        panelJeu.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gamePanelLayout.createSequentialGroup().addComponent(this.col1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.col2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.col3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.col4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.col5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.col6, -2, -1, -2).addGap(4, 4, 4).addComponent(this.col7, -2, -1, -2).addGap(0, 0, 32767)));
        gamePanelLayout.setVerticalGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gamePanelLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gamePanelLayout.createSequentialGroup().addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.col2, -2, 263, -2).addComponent(this.col1, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(-1, 32767)).addGroup(gamePanelLayout.createSequentialGroup().addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.col7, -2, 0, 32767).addComponent(this.col6, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.col5, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.col4, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.col3, GroupLayout.Alignment.LEADING, -2, 263, -2)).addGap(0, 0, 32767)))));
        this.col1.getAccessibleContext().setAccessibleName("1");
        this.col2.getAccessibleContext().setAccessibleName("2");
        this.col3.getAccessibleContext().setAccessibleName("3");
        this.col4.getAccessibleContext().setAccessibleName("4");
        this.col5.getAccessibleContext().setAccessibleName("5");
        this.col7.getAccessibleContext().setAccessibleName("7");
        this.col6.getAccessibleContext().setAccessibleName("6");
        sidePane.setBackground(new Color(195, 195, 195));
        restart.setVisible(this.tourJoueur1);
        restart.setBackground(new Color(195, 195, 195));
        restart.setText("REJOUER");
        restart.addActionListener(this::restartActionPerformed);

        this.annuler.setVisible(!Main.duFX);
        this.annuler.setBackground(new Color(63, 71, 203, 255));
        this.annuler.setForeground(Color.WHITE);
        this.annuler.setText("Retour");

        this.annuler.addActionListener(this::cancelActionPerformed);
        desc.setEditable(false);
        desc.setColumns(20);
        desc.setRows(5);
        desc.setText("----- PUISSANCE 4 ----- \n \n Ce puissance 4 à été réalisé \n par Rahim HAYAT. \n \n Retour > retourner en \n arrière d'un jeton. \n \n REJOUER > Recommencer \n une nouvelle partie.");
        desc.setBackground(new Color(0x9AFFFFFF, true));
        desc.setFont(new Font("Tahoma", Font.BOLD, 12));
        final GroupLayout sidePaneLayout = new GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(sidePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(sidePaneLayout.createSequentialGroup().addContainerGap().addGroup(sidePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, sidePaneLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(restart, -2, 188, -2)).addComponent(this.annuler, -1, -1, 32767).addGroup(sidePaneLayout.createSequentialGroup().addComponent(desc, -2, 182, -2).addGap(0, 0, 32767))).addContainerGap()));
        sidePaneLayout.setVerticalGroup(sidePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(sidePaneLayout.createSequentialGroup().addContainerGap().addComponent(desc, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.annuler, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(restart, -2, 60, -2).addContainerGap(-1, 32767)));
        this.tourLabel.setForeground(new Color(255, 255, 255));

        // Crée le font

        try {
            //create the font to use. Specify the size!
            Font customFont =Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/font/one_piece.ttf").openStream()).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);

            tourLabel.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }


        //this.turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        this.tourLabel.setText("Tour : Joueur 1 ");
        redpan.setBackground(new Color(231, 0, 20, 230));
        iconRed.setIcon(jeton1);
        this.rougeIndicateur.setForeground(new Color(255, 255, 255));
        this.rougeIndicateur.setText("21 Jetons Restants");
        final GroupLayout redpanLayout = new GroupLayout(redpan);
        redpan.setLayout(redpanLayout);
        redpanLayout.setHorizontalGroup(redpanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(redpanLayout.createSequentialGroup().addContainerGap().addComponent(iconRed).addGap(18, 18, 18).addComponent(this.rougeIndicateur, -1, 66, 32767).addContainerGap()));
        redpanLayout.setVerticalGroup(redpanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, redpanLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(redpanLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(iconRed, -1, -1, 32767).addComponent(this.rougeIndicateur, -1, -1, 32767)).addGap(19, 19, 19)));
        iconRed.getAccessibleContext().setAccessibleName("cell1");
        jaunePan.setBackground(new Color(255, 225, 0, 204));
        iconJaune.setIcon(jeton2);
        this.jauneIndicateur.setForeground(new Color(0, 0, 0));
        this.jauneIndicateur.setText("21 Jetons Restants");
        final GroupLayout jaunePanLayout = new GroupLayout(jaunePan);
        jaunePan.setLayout(jaunePanLayout);
        jaunePanLayout.setHorizontalGroup(jaunePanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jaunePanLayout.createSequentialGroup().addContainerGap().addComponent(iconJaune).addGap(18, 18, 18).addComponent(this.jauneIndicateur).addContainerGap(35, 32767)));
        jaunePanLayout.setVerticalGroup(jaunePanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jaunePanLayout.createSequentialGroup().addContainerGap().addGroup(jaunePanLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jauneIndicateur, -1, -1, 32767).addComponent(iconJaune, -1, -1, 32767)).addContainerGap(-1, 32767)));
        final GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(mainPanelLayout.createSequentialGroup().addComponent(redpan, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jaunePan, -2, -1, -2)).addComponent(panelJeu, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.tourLabel, -2, 433, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(sidePane, -2, -1, -2).addGap(0, 0, 0)));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(redpan, -2, 53, -2).addComponent(jaunePan, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(panelJeu, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.tourLabel).addContainerGap(24, 32767)).addComponent(sidePane, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(mainPanel, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(mainPanel, -2, -1, -2).addGap(0, 0, 32767)));


        this.setResizable(false);
        this.pack();
    }

    public void restartActionPerformed(final ActionEvent evt) {
        control.restart();
        if (this.tourJoueur1) {
            Main.instance.server.write("reset");
        }
    }

    public void cancelActionPerformed(final ActionEvent evt) {
        if(monTour) {
            control.cancel(tourJoueur1);
            Main.instance.send("cancel");
            this.monTour = !this.monTour;
        }
    }


}