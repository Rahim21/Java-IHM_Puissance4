package puissance4.swing.engine;

import puissance4.swing.Main;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Puissance4Controller {
    public final Puissance4View ui;
    public final HashMap<Integer, JLabel> alreadyUsed = new HashMap<>();
    public final ArrayList<Integer> red = new ArrayList<>();
    public final ArrayList<Integer> jaune = new ArrayList<>();
    final ImageIcon jetonvide = new ImageIcon(this.getClass().getResource("/img/jetonvide.png"));
    final ImageIcon jeton1 = new ImageIcon(this.getClass().getResource("/img/jeton1.png"));
    final ImageIcon jeton2 = new ImageIcon(this.getClass().getResource("/img/jeton2.png"));
    AudioClip click;
    public JLabel lastPlayerOneMove;
    public JLabel lastPlayerTwoMove;

    public Puissance4Controller(Puissance4View ui) {
        this.ui = ui;

        //   try {
        //     click = new AudioStream(this.getClass().getResource("/sound/jeton_sound.wav").openStream());
        //  } catch (IOException e) {
        //    e.printStackTrace();
        //  }

        URL urlClick = this.getClass().getResource("jeton_sound.wav"); // son du jeton
        click = Applet.newAudioClip(urlClick);


        this.initListener();
    }

    private void initListener() {
        ui.col1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col1, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;
                    //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {

                ui.col1.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col1.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col2, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {

                ui.col2.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col2.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col3, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {

                ui.col3.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col3.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col4, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {

                ui.col4.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col4.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col5, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {

                ui.col5.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col5.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col6, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {
                ui.col6.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));

            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col6.setBackground(new Color(63, 71, 204));
            }
        });
        ui.col7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent evt) {
                if (ui.monTour) {
                    addTo(ui.col7, ui.tourJoueur1);
                    ui.monTour = !ui.monTour;      //.player.start(click);

                    //    //.player.stop(click); // joue le son du jeton
                    click.play(); // joue le son du jeton
                }
            }

            @Override
            public void mouseEntered(final MouseEvent evt) {
                ui.col7.setBackground(ui.tourJoueur1 ? new Color(231, 0, 20) : new Color(255, 225, 0));
            }

            @Override
            public void mouseExited(final MouseEvent evt) {
                ui.col7.setBackground(new Color(63, 71, 204));
            }
        });
    }

    public void checkWinner(final JLabel id) {
        if(alreadyUsed.size() >= 42 || red.size() >= 21 || jaune.size() >=21) {
            final int result = JOptionPane.showConfirmDialog(null, "Match Nul ! Rejouer ?", "Projet Puissance 4", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                Main.instance.send("reset");
                restart();
            } else if (result == 1) {
                Main.instance.send("end");
            }
        }
        if (red.contains(1) && red.contains(2) && red.contains(3) && red.contains(4)) {
            winner(true);
        }
        if ((red.contains(2)) && (red.contains(3)) && (red.contains(4)) && (red.contains(5))) {
            winner(true);
        }
        if ((red.contains(3)) && (red.contains(4)) && (red.contains(5)) && (red.contains(6))) {
            winner(true);
        }

        if ((red.contains(7)) && (red.contains(8)) && (red.contains(9)) && (red.contains(10))) {
            winner(true);
        }
        if ((red.contains(8)) && (red.contains(9)) && (red.contains(10)) && (red.contains(11))) {
            winner(true);
        }
        if ((red.contains(9)) && (red.contains(10)) && (red.contains(11)) && (red.contains(12))) {
            winner(true);
        }

        if ((red.contains(13)) && (red.contains(14)) && (red.contains(15)) && (red.contains(16))) {
            winner(true);
        }
        if ((red.contains(14)) && (red.contains(15)) && (red.contains(16)) && (red.contains(17))) {
            winner(true);
        }
        if ((red.contains(15)) && (red.contains(16)) && (red.contains(17)) && (red.contains(18))) {
            winner(true);
        }

        if ((red.contains(19)) && (red.contains(20)) && (red.contains(21)) && (red.contains(22))) {
            winner(true);
        }
        if ((red.contains(20)) && (red.contains(21)) && (red.contains(22)) && (red.contains(23))) {
            winner(true);
        }
        if ((red.contains(21)) && (red.contains(22)) && (red.contains(23)) && (red.contains(24))) {
            winner(true);
        }

        if ((red.contains(25)) && (red.contains(26)) && (red.contains(27)) && (red.contains(28))) {
            winner(true);
        }
        if ((red.contains(26)) && (red.contains(27)) && (red.contains(28)) && (red.contains(29))) {
            winner(true);
        }
        if ((red.contains(27)) && (red.contains(28)) && (red.contains(29)) && (red.contains(30))) {
            winner(true);
        }

        if ((red.contains(31)) && (red.contains(32)) && (red.contains(33)) && (red.contains(34))) {
            winner(true);
        }
        if ((red.contains(32)) && (red.contains(33)) && (red.contains(34)) && (red.contains(35))) {
            winner(true);
        }
        if ((red.contains(33)) && (red.contains(34)) && (red.contains(35)) && (red.contains(36))) {
            winner(true);
        }

        if ((red.contains(37)) && (red.contains(38)) && (red.contains(39)) && (red.contains(40))) {
            winner(true);
        }
        if ((red.contains(38)) && (red.contains(39)) && (red.contains(40)) && (red.contains(41))) {
            winner(true);
        }
        if ((red.contains(39)) && (red.contains(40)) && (red.contains(31)) && (red.contains(42))) {
            winner(true);
        }

        if ((red.contains(1)) && (red.contains(7)) && (red.contains(13)) && (red.contains(19))) {
            winner(true);
        }
        if ((red.contains(7)) && (red.contains(13)) && (red.contains(19)) && (red.contains(25))) {
            winner(true);
        }
        if ((red.contains(13)) && (red.contains(19)) && (red.contains(25)) && (red.contains(31))) {
            winner(true);
        }
        if ((red.contains(19)) && (red.contains(25)) && (red.contains(31)) && (red.contains(37))) {
            winner(true);
        }

        if ((red.contains(2)) && (red.contains(8)) && (red.contains(14)) && (red.contains(20))) {
            winner(true);
        }
        if ((red.contains(8)) && (red.contains(14)) && (red.contains(20)) && (red.contains(26))) {
            winner(true);
        }
        if ((red.contains(14)) && (red.contains(20)) && (red.contains(26)) && (red.contains(32))) {
            winner(true);
        }
        if ((red.contains(20)) && (red.contains(26)) && (red.contains(32)) && (red.contains(38))) {
            winner(true);
        }

        if ((red.contains(3)) && (red.contains(9)) && (red.contains(15)) && (red.contains(21))) {
            winner(true);
        }
        if ((red.contains(9)) && (red.contains(15)) && (red.contains(21)) && (red.contains(27))) {
            winner(true);
        }
        if ((red.contains(15)) && (red.contains(21)) && (red.contains(27)) && (red.contains(33))) {
            winner(true);
        }
        if ((red.contains(21)) && (red.contains(27)) && (red.contains(33)) && (red.contains(39))) {
            winner(true);
        }

        if ((red.contains(4)) && (red.contains(10)) && (red.contains(16)) && (red.contains(22))) {
            winner(true);
        }
        if ((red.contains(10)) && (red.contains(16)) && (red.contains(22)) && (red.contains(28))) {
            winner(true);
        }
  if ((red.contains(1)) && (red.contains(9)) && (red.contains(14)) && (red.contains(21))) {
            winner(true);
        }
  if ((jaune.contains(1)) && (jaune.contains(9)) && (jaune.contains(14)) && (jaune.contains(21))) {
            winner(false);
        }

        if ((red.contains(16)) && (red.contains(22)) && (red.contains(28)) && (red.contains(34))) {
            winner(true);
        }
        if ((red.contains(22)) && (red.contains(28)) && (red.contains(34)) && (red.contains(40))) {
            winner(true);
        }

        if ((red.contains(5)) && (red.contains(11)) && (red.contains(17)) && (red.contains(23))) {
            winner(true);
        }
        if ((red.contains(11)) && (red.contains(17)) && (red.contains(23)) && (red.contains(29))) {
            winner(true);
        }
        if ((red.contains(17)) && (red.contains(23)) && (red.contains(29)) && (red.contains(35))) {
            winner(true);
        }
        if ((red.contains(23)) && (red.contains(29)) && (red.contains(35)) && (red.contains(41))) {
            winner(true);
        }

        if ((red.contains(6)) && (red.contains(12)) && (red.contains(18)) && (red.contains(24))) {
            winner(true);
        }
        if ((red.contains(12)) && (red.contains(18)) && (red.contains(24)) && (red.contains(30))) {
            winner(true);
        }
        if ((red.contains(18)) && (red.contains(24)) && (red.contains(30)) && (red.contains(36))) {
            winner(true);
        }
        if ((red.contains(24)) && (red.contains(30)) && (red.contains(36)) && (red.contains(42))) {
            winner(true);
        }


        if ((red.contains(4)) && (red.contains(9)) && (red.contains(14)) && (red.contains(19))) {
            winner(true);
        }

        if ((red.contains(5)) && (red.contains(10)) && (red.contains(15)) && (red.contains(20))) {
            winner(true);
        }
        if ((red.contains(10)) && (red.contains(15)) && (red.contains(20)) && (red.contains(25))) {
            winner(true);
        }

        if ((red.contains(6)) && (red.contains(11)) && (red.contains(16)) && (red.contains(21))) {
            winner(true);
        }
        if ((red.contains(11)) && (red.contains(16)) && (red.contains(21)) && (red.contains(26))) {
            winner(true);
        }
        if ((red.contains(16)) && (red.contains(21)) && (red.contains(26)) && (red.contains(31))) {
            winner(true);
        }

        if ((red.contains(12)) && (red.contains(17)) && (red.contains(22)) && (red.contains(27))) {
            winner(true);
        }
        if ((red.contains(17)) && (red.contains(22)) && (red.contains(27)) && (red.contains(32))) {
            winner(true);
        }

        if (red.contains(22) && red.contains(27) && red.contains(32) && red.contains(37)) {
            winner(true);
        }

        if (jaune.contains(22) && jaune.contains(27) && jaune.contains(32) && jaune.contains(37)) {
            winner(false);
        }
        if ((red.contains(18)) && (red.contains(23)) && (red.contains(28)) && (red.contains(33))) {
            winner(true);
        }
        if ((red.contains(23)) && (red.contains(28)) && (red.contains(33)) && (red.contains(38))) {
            winner(true);
        }

        if ((red.contains(24)) && (red.contains(29)) && (red.contains(34)) && (red.contains(39))) {
            winner(true);
        }

        if (jaune.contains(1) && jaune.contains(2) && jaune.contains(3) && jaune.contains(4)) {
            winner(false);
        }
        if (jaune.contains(22) && jaune.contains(27) && jaune.contains(32) && jaune.contains(37)) {
            winner(false);
        }

        if ((jaune.contains(2)) && (jaune.contains(3)) && (jaune.contains(4)) && (jaune.contains(5))) {
            winner(false);
        }
        if ((jaune.contains(3)) && (jaune.contains(4)) && (jaune.contains(5)) && (jaune.contains(6))) {
            winner(false);
        }

        if ((jaune.contains(7)) && (jaune.contains(8)) && (jaune.contains(9)) && (jaune.contains(10))) {
            winner(false);
        }
        if ((jaune.contains(8)) && (jaune.contains(9)) && (jaune.contains(10)) && (jaune.contains(11))) {
            winner(false);
        }
        if ((jaune.contains(9)) && (jaune.contains(10)) && (jaune.contains(11)) && (jaune.contains(12))) {
            winner(false);
        }

        if ((jaune.contains(13)) && (jaune.contains(14)) && (jaune.contains(15)) && (jaune.contains(16))) {
            winner(false);
        }
        if ((jaune.contains(14)) && (jaune.contains(15)) && (jaune.contains(16)) && (jaune.contains(17))) {
            winner(false);
        }
        if ((jaune.contains(15)) && (jaune.contains(16)) && (jaune.contains(17)) && (jaune.contains(18))) {
            winner(false);
        }

        if ((jaune.contains(19)) && (jaune.contains(20)) && (jaune.contains(21)) && (jaune.contains(22))) {
            winner(false);
        }
        if ((jaune.contains(20)) && (jaune.contains(21)) && (jaune.contains(22)) && (jaune.contains(23))) {
            winner(false);
        }
        if ((jaune.contains(21)) && (jaune.contains(22)) && (jaune.contains(23)) && (jaune.contains(24))) {
            winner(false);
        }

        if ((jaune.contains(25)) && (jaune.contains(26)) && (jaune.contains(27)) && (jaune.contains(28))) {
            winner(false);
        }
        if ((jaune.contains(26)) && (jaune.contains(27)) && (jaune.contains(28)) && (jaune.contains(29))) {
            winner(false);
        }
        if ((jaune.contains(27)) && (jaune.contains(28)) && (jaune.contains(29)) && (jaune.contains(30))) {
            winner(false);
        }

        if ((jaune.contains(31)) && (jaune.contains(32)) && (jaune.contains(33)) && (jaune.contains(34))) {
            winner(false);
        }
        if ((jaune.contains(32)) && (jaune.contains(33)) && (jaune.contains(34)) && (jaune.contains(35))) {
            winner(false);
        }
        if ((jaune.contains(33)) && (jaune.contains(34)) && (jaune.contains(35)) && (jaune.contains(36))) {
            winner(false);
        }

        if ((jaune.contains(37)) && (jaune.contains(38)) && (jaune.contains(39)) && (jaune.contains(40))) {
            winner(false);
        }
        if ((jaune.contains(38)) && (jaune.contains(39)) && (jaune.contains(40)) && (jaune.contains(41))) {
            winner(false);
        }
        if ((jaune.contains(39)) && (jaune.contains(40)) && (jaune.contains(31)) && (jaune.contains(42))) {
            winner(false);
        }

        if ((jaune.contains(1)) && (jaune.contains(7)) && (jaune.contains(13)) && (jaune.contains(19))) {
            winner(false);
        }
        if ((jaune.contains(7)) && (jaune.contains(13)) && (jaune.contains(19)) && (jaune.contains(25))) {
            winner(false);
        }
        if ((jaune.contains(13)) && (jaune.contains(19)) && (jaune.contains(25)) && (jaune.contains(31))) {
            winner(false);
        }
        if ((jaune.contains(19)) && (jaune.contains(25)) && (jaune.contains(31)) && (jaune.contains(37))) {
            winner(false);
        }

        if ((jaune.contains(2)) && (jaune.contains(8)) && (jaune.contains(14)) && (jaune.contains(20))) {
            winner(false);
        }
        if ((jaune.contains(8)) && (jaune.contains(14)) && (jaune.contains(20)) && (jaune.contains(26))) {
            winner(false);
        }
        if ((jaune.contains(14)) && (jaune.contains(20)) && (jaune.contains(26)) && (jaune.contains(32))) {
            winner(false);
        }
        if ((jaune.contains(20)) && (jaune.contains(26)) && (jaune.contains(32)) && (jaune.contains(38))) {
            winner(false);
        }

        if ((jaune.contains(3)) && (jaune.contains(9)) && (jaune.contains(15)) && (jaune.contains(21))) {
            winner(false);
        }
        if ((jaune.contains(9)) && (jaune.contains(15)) && (jaune.contains(21)) && (jaune.contains(27))) {
            winner(false);
        }
        if ((jaune.contains(15)) && (jaune.contains(21)) && (jaune.contains(27)) && (jaune.contains(33))) {
            winner(false);
        }
        if ((jaune.contains(21)) && (jaune.contains(27)) && (jaune.contains(33)) && (jaune.contains(39))) {
            winner(false);
        }

        if ((jaune.contains(4)) && (jaune.contains(10)) && (jaune.contains(16)) && (jaune.contains(22))) {
            winner(false);
        }
        if ((jaune.contains(10)) && (jaune.contains(16)) && (jaune.contains(22)) && (jaune.contains(28))) {
            winner(false);
        }
        if ((jaune.contains(16)) && (jaune.contains(22)) && (jaune.contains(28)) && (jaune.contains(34))) {
            winner(false);
        }
        if ((jaune.contains(22)) && (jaune.contains(28)) && (jaune.contains(34)) && (jaune.contains(40))) {
            winner(false);
        }

        if ((jaune.contains(5)) && (jaune.contains(11)) && (jaune.contains(17)) && (jaune.contains(23))) {
            winner(false);
        }
        if ((jaune.contains(11)) && (jaune.contains(17)) && (jaune.contains(23)) && (jaune.contains(29))) {
            winner(false);
        }
        if ((jaune.contains(17)) && (jaune.contains(23)) && (jaune.contains(29)) && (jaune.contains(35))) {
            winner(false);
        }
        if ((jaune.contains(23)) && (jaune.contains(29)) && (jaune.contains(35)) && (jaune.contains(41))) {
            winner(false);
        }

        if ((jaune.contains(6)) && (jaune.contains(12)) && (jaune.contains(18)) && (jaune.contains(24))) {
            winner(false);
        }
        if ((jaune.contains(12)) && (jaune.contains(18)) && (jaune.contains(24)) && (jaune.contains(30))) {
            winner(false);
        }
        if ((jaune.contains(18)) && (jaune.contains(24)) && (jaune.contains(30)) && (jaune.contains(36))) {
            winner(false);
        }
        if ((jaune.contains(24)) && (jaune.contains(30)) && (jaune.contains(36)) && (jaune.contains(42))) {
            winner(false);
        }


        if ((jaune.contains(4)) && (jaune.contains(9)) && (jaune.contains(14)) && (jaune.contains(19))) {
            winner(false);
        }

        if ((jaune.contains(5)) && (jaune.contains(10)) && (jaune.contains(15)) && (jaune.contains(20))) {
            winner(false);
        }
        if ((jaune.contains(10)) && (jaune.contains(15)) && (jaune.contains(20)) && (jaune.contains(25))) {
            winner(false);
        }

        if ((jaune.contains(6)) && (jaune.contains(11)) && (jaune.contains(16)) && (jaune.contains(21))) {
            winner(false);
        }
        if ((jaune.contains(11)) && (jaune.contains(16)) && (jaune.contains(21)) && (jaune.contains(26))) {
            winner(false);
        }
        if ((jaune.contains(16)) && (jaune.contains(21)) && (jaune.contains(26)) && (jaune.contains(31))) {
            winner(false);
        }

        if ((jaune.contains(12)) && (jaune.contains(17)) && (jaune.contains(22)) && (jaune.contains(27))) {
            winner(false);
        }
        if ((jaune.contains(17)) && (jaune.contains(22)) && (jaune.contains(27)) && (jaune.contains(32))) {
            winner(false);
        }

        if (jaune.contains(22) && jaune.contains(27) && jaune.contains(32) && jaune.contains(37)) {
            winner(false);
        }

        if (jaune.contains(22) && jaune.contains(27) && jaune.contains(32) && jaune.contains(37)) {
            winner(false);
        }
        if ((jaune.contains(18)) && (jaune.contains(23)) && (jaune.contains(28)) && (jaune.contains(33))) {
            winner(false);
        }
        if ((jaune.contains(23)) && (jaune.contains(28)) && (jaune.contains(33)) && (jaune.contains(38))) {
            winner(false);
        }

        if ((jaune.contains(24)) && (jaune.contains(29)) && (jaune.contains(34)) && (jaune.contains(39))) {
            winner(false);
        }
    }

    public void winner(final boolean isRedWinner) {
        //explicit
        if (isRedWinner) {
            System.out.print("Rouge gagne");
            final int result = JOptionPane.showConfirmDialog(null, "VICTOIRE de Joueur 1 ! Rejouer ?", "Projet Puissance 4", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                Main.instance.send("reset");
                restart();
            } else if (result == 1) {
                Main.instance.send("end");
            }
        } else {
            final int result = JOptionPane.showConfirmDialog(null, "VICTOIRE de Joueur 2 ! Rejouer ?", "Projet Puissance 4", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                Main.instance.send("reset");
                restart();
            } else if (result == 1) {
                Main.instance.send("end");
            }
        }
    }

    // system d'ID mais pour les panels
    public int getCol(final JPanel col) {
        return Integer.parseInt(col.getAccessibleContext().getAccessibleName());
    }

    // method qui ajoute les jetons
    public void addTo(final JPanel col1, final boolean server) {
        int currentLabel = -1;
        final JLabel[] cells = new JLabel[col1.getComponents().length];
        for (int i = 0; i < col1.getComponents().length; ++i) {
            cells[i] = (JLabel) col1.getComponents()[i];
        }

        for (int o = 0; o < cells.length; o++) {
            final JLabel comp = cells[o];
            if (!this.alreadyUsed.containsValue(comp)) {
                currentLabel = o;

                if (server) {
                    //si on est jeton1
                    comp.setIcon(this.jeton1);
                    System.out.println("rouge : " + getID(comp));
                    comp.revalidate();
                    comp.repaint();
                    if (Main.instance.server != null) {
                        Main.instance.send("move-" + this.getCol(col1));
                        break;
                    }
                    break;
                } else {
                    comp.setIcon(this.jeton2);
                    System.out.println("jaune : " + getID(comp));
                    comp.revalidate();
                    comp.repaint();
                    if (Main.instance.client != null) {
                        Main.instance.send("move-" + this.getCol(col1));
                        break;
                    }
                    break;
                }
            }
        }

        // alreadyUsed permet de savoir si un jeton a déjà été utilisé
        this.alreadyUsed.put(Integer.parseInt(this.getID(cells[currentLabel])), cells[currentLabel]);
        if (cells[currentLabel].getIcon() == this.jeton1) {
            // si c'st un jeton rouge
            this.red.add(Integer.parseInt(this.getID(cells[currentLabel])));
            this.lastPlayerOneMove = cells[currentLabel];
            --ui.redRemain;
            ui.rougeIndicateur.setText(ui.redRemain + " Jetons Restants");
        } else if (cells[currentLabel].getIcon() == this.jeton2) {
            // si c'est un jaune
            this.jaune.add(Integer.parseInt(this.getID(cells[currentLabel])));
            this.lastPlayerTwoMove = cells[currentLabel];
            --ui.jauneRemain;
            ui.jauneIndicateur.setText(ui.jauneRemain + " Jetons Restants");
        }
        String playerTurn;
        if (!ui.monTour && ui.tourJoueur1) {
            playerTurn = "Joueur 1";
        } else if (ui.monTour && !ui.tourJoueur1) {
            playerTurn = "Joueur 1";
        } else if (ui.tourJoueur1) {
            playerTurn = "Joueur 2";
        } else {
            playerTurn = "Joueur 2";
        }
        ui.tourLabel.setText("Tour : " + playerTurn);
        this.checkWinner(cells[currentLabel]);
    }

    public String getID(final JLabel c) {
        // donne l'id (cf tout en bas pour des explications)
        return c.getAccessibleContext().getAccessibleName();
    }

    public void addToFromClient(final int c) {
        System.out.println(c);
        if (c == 1) {
            addTo(ui.col1, false);
        } else if (c == 2) {
            addTo(ui.col2, false);
        } else if (c == 3) {
            addTo(ui.col3, false);
        } else if (c == 4) {
            addTo(ui.col4, false);
        } else if (c == 5) {
            addTo(ui.col5, false);
        } else if (c == 6) {
            addTo(ui.col6, false);
        } else if (c == 7) {
            addTo(ui.col7, false);
        }


    }

    public void addToFromServer(final int c) {
        System.out.println(c);
        if (c == 1) {
            addTo(ui.col1, true);
        } else if (c == 2) {
            addTo(ui.col2, true);
        } else if (c == 3) {
            addTo(ui.col3, true);
        } else if (c == 4) {
            addTo(ui.col4, true);
        } else if (c == 5) {
            addTo(ui.col5, true);
        } else if (c == 6) {
            addTo(ui.col6, true);
        } else if (c == 7) {
            addTo(ui.col7, true);
        }

    }

    public void cancelFromClient() {
        this.cancel(false);
    }

    public void cancel(boolean server) {
        if (server) {
            if (lastPlayerOneMove != null) {
                this.lastPlayerOneMove.setIcon(this.jetonvide);
                if (this.jaune.contains(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1)) {
                    this.alreadyUsed.get(this.jaune.get(this.jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1))).setIcon(this.jetonvide);
                    this.jaune.remove(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1));
                    this.jaune.add(Integer.parseInt(this.getID(this.lastPlayerOneMove)));
                    this.lastPlayerOneMove.setIcon(this.jeton2);
                    this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1).setIcon(this.jetonvide);
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1);
                    this.checkWinner(this.lastPlayerOneMove);
                    lastPlayerOneMove = null;
                } else {
                    this.red.remove(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove))));
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)), this.lastPlayerOneMove);
                    lastPlayerOneMove = null;
                }
            }
        } else {

            if (lastPlayerTwoMove != null) {
                this.lastPlayerTwoMove.setIcon(this.jetonvide);
                if (this.red.contains(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1)) {
                    this.alreadyUsed.get(this.red.get(this.red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1))).setIcon(this.jetonvide);
                    this.red.remove(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1));
                    this.red.add(Integer.parseInt(this.getID(this.lastPlayerTwoMove)));
                    this.lastPlayerTwoMove.setIcon(this.jeton1);
                    this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1).setIcon(this.jetonvide);
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1);
                    this.checkWinner(this.lastPlayerTwoMove);
                    lastPlayerTwoMove = null;
                } else {
                    this.jaune.remove(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove))));
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)), this.lastPlayerTwoMove);
                    lastPlayerTwoMove = null;
                }


            }
        }
    }
    //hard coded method pour annulé un coup
       /* if (ui.isPlayerOne) {
            if (server && ui.isMyTurn) {
                if (this.jaune.contains(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1))) {
                    //    this.alreadyUsed.get(this.jaune.get(this.jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1))).setIcon(this.jetonvide);
                    this.jaune.remove(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1));
                    this.jaune.add(Integer.parseInt(this.getID(this.lastPlayerOneMove)));
                    this.lastPlayerOneMove.setIcon(this.jeton2);
                    this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1).setIcon(this.jetonvide);
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1);
                    this.alreadyUsed.put(Integer.parseInt(this.getID(this.lastPlayerOneMove)), lastPlayerOneMove);

                } else {
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)), this.lastPlayerOneMove);
                    System.out.println("we remove for player1");
                    this.lastPlayerOneMove.setIcon(this.jetonvide);
                    System.out.println(" remove for player1");
                }
                this.checkWinner(this.lastPlayerOneMove);
            } else  {
                if (this.red.contains(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1))) {
                    //    this.alreadyUsed.get(this.red.get(this.red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1))).setIcon(this.jetonvide);
                    this.red.remove(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1));
                    this.red.add(Integer.parseInt(this.getID(this.lastPlayerTwoMove)));
                    this.lastPlayerTwoMove.setIcon(this.jeton1);
                    this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1).setIcon(this.jetonvide);
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1);
                    this.alreadyUsed.put(Integer.parseInt(this.getID(this.lastPlayerTwoMove)), lastPlayerTwoMove);
                } else {
                    this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)), this.lastPlayerTwoMove);
                    this.lastPlayerTwoMove.setIcon(this.jetonvide);
                }
                this.checkWinner(this.lastPlayerTwoMove);
            }
            ui.isMyTurn = !ui.isMyTurn;
        } else if(!server && ui.isMyTurn) {
            if (this.jaune.contains(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1))) {
                //    this.alreadyUsed.get(this.jaune.get(this.jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1))).setIcon(this.jetonvide);
                this.jaune.remove(jaune.indexOf(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1));
                this.jaune.add(Integer.parseInt(this.getID(this.lastPlayerOneMove)));
                this.lastPlayerOneMove.setIcon(this.jeton2);
                this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1).setIcon(this.jetonvide);
                this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)) + 1);
                this.alreadyUsed.put(Integer.parseInt(this.getID(this.lastPlayerOneMove)), lastPlayerOneMove);

            } else {
                this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerOneMove)), this.lastPlayerOneMove);
                System.out.println("we remove for player1");
                this.lastPlayerOneMove.setIcon(this.jetonvide);
                System.out.println(" remove for player1");
            }
            this.checkWinner(this.lastPlayerOneMove);
        } else  {
            if (this.red.contains(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1))) {
                //    this.alreadyUsed.get(this.red.get(this.red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1))).setIcon(this.jetonvide);
                this.red.remove(red.indexOf(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1));
                this.red.add(Integer.parseInt(this.getID(this.lastPlayerTwoMove)));
                this.lastPlayerTwoMove.setIcon(this.jeton1);
                this.alreadyUsed.get(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1).setIcon(this.jetonvide);
                this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)) + 1);
                this.alreadyUsed.put(Integer.parseInt(this.getID(this.lastPlayerTwoMove)), lastPlayerTwoMove);
            } else {
                this.alreadyUsed.remove(Integer.parseInt(this.getID(this.lastPlayerTwoMove)), this.lastPlayerTwoMove);
                this.lastPlayerTwoMove.setIcon(this.jetonvide);
            }
            this.checkWinner(this.lastPlayerTwoMove);
        }
        ui.isMyTurn = !ui.isMyTurn;
        */


    public void restart() {
        this.alreadyUsed.keySet().forEach((id) -> {
            this.alreadyUsed.get(id).setIcon(this.jetonvide);
            this.alreadyUsed.get(id).revalidate();
            this.alreadyUsed.get(id).repaint();
        });
        this.alreadyUsed.clear();
        this.red.clear();
        this.jaune.clear();
        ui.jauneRemain = 21;
        ui.redRemain = 21;
        ui.jauneIndicateur.setText(ui.jauneRemain + " Jetons Restants");
        ui.rougeIndicateur.setText(ui.redRemain + " Jetons Restants");
        ui.tourLabel.setText("Joueur 1 commence");
        ui.monTour = ui.tourJoueur1;
        //   ui.isMyTurn = (ui.isPlayerOne && !ui.isMyTurn) || !(!ui.isPlayerOne && ui.isMyTurn);

    }
}
