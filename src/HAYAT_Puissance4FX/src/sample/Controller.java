package sample;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sample.Main.tourJoueur1;

public class Controller implements Initializable {

    private static final int colonnes = 7;
    private static final int lignes = 6;
    private static final int diametre_cerlce = 80;
    private static final String jetonRouge = Color.RED.toString();
    private static final String jetonJaune = Color.YELLOW.toString();

    private static final String PseudoJ1 = "Luffy";
    private static final String PseudoJ2 = "Law";

    private boolean tourDuJoueur1 = true;

    private final Disc[][] insererJetonArray = new Disc[lignes][colonnes];

    @FXML
    public GridPane plateauDeJeu;

    @FXML
    public Pane ajouterJetons;

    @FXML
    public Label nomJoueur;

    @FXML
    public Label rouge;

    @FXML
    public Label jaune;

    @FXML
    public Button reset;


    public static int rougeInt = 21;
    public static int jauneInt = 21;

    public boolean peutInsererJeton = tourJoueur1;

    // --Commented out by Inspection (01/05/2021 01:11):protected Rectangle rectangle;

    protected List<Rectangle> box_rectangle;

    public void createPlayground() {



        nomJoueur.setText(PseudoJ1);
        box_rectangle = creerColonneCliquable();
            for (Rectangle rectangle : box_rectangle) {
                plateauDeJeu.add(rectangle, 0, 1);
            }
        Shape rectangleWithHoles = creerGrille();
        plateauDeJeu.add(rectangleWithHoles, 0, 1);

    }

    private Shape creerGrille() {
        Shape rectangleWithHoles = new Rectangle((colonnes +1)* diametre_cerlce, (lignes +1)* diametre_cerlce);

        for(int row = 0; row< lignes; row++)
        {
            for(int col = 0; col< colonnes; col++)
            {
                Circle circle = new Circle();
                circle.setRadius(diametre_cerlce /2);
                circle.setCenterX(diametre_cerlce /2);
                circle.setCenterY(diametre_cerlce /2);
                circle.setSmooth(true);

                circle.setTranslateX(col * (diametre_cerlce +5)+ diametre_cerlce /4);
                circle.setTranslateY(row * (diametre_cerlce +5)+ diametre_cerlce /4);
                rectangleWithHoles = Shape.subtract(rectangleWithHoles, circle);
            }
        }
        rectangleWithHoles.setFill(Color.rgb(64,91,231));
        return rectangleWithHoles;
    }

    private List<Rectangle> creerColonneCliquable() {
        List<Rectangle> rectangleList = new ArrayList<>();

        for(int col = 0; col< colonnes; col++)
        {
            Rectangle rectangle = new Rectangle(diametre_cerlce, (lignes + 1) * diametre_cerlce);
           rectangle.setFill(Color.TRANSPARENT);
            rectangle.setTranslateX(col * (diametre_cerlce +5)+ diametre_cerlce / 4);
            rectangle.setOnMouseEntered(event -> rectangle.setFill(tourDuJoueur1 ? Color.valueOf("#FF000050"): Color.valueOf("#FFFF0050"))); // colonne de couleur selon le tour du joueur
            rectangle.setOnMouseExited(event -> rectangle.setFill(Color.TRANSPARENT));

            final int column = col;
            final int coltosend = col+1;
            rectangle.setOnMouseClicked(event -> {
                if(peutInsererJeton)
                {
                    insertDisk(new Disc(tourDuJoueur1), column);

                   /* rouge.setText(rougeInt + " Jetons Restants");
                    jaune.setText(jauneInt + " Jetons Restants");*/
                    if(tourJoueur1) {
                        Main.server.write("move-" + coltosend);

                    } else {
                        Main.client.write("move-" + coltosend);
                    }
                }
            });
            rectangleList.add(rectangle);
        }
        return rectangleList;
    }

    public void insertDisk(Disc disc, int column) {
        int row = lignes - 1;
        while (row >= 0){

            if (jetonPresent(row, column) == null)
                break;
            row--;
        }

        if(row < 0)
            return;
        insererJetonArray[row][column] = disc;
        ajouterJetons.getChildren().add(disc);
        disc.setTranslateX(column * (diametre_cerlce +5)+ diametre_cerlce / 4);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), disc);
        int currentRow = row;
        translateTransition.setToY(row * (diametre_cerlce +5)+ diametre_cerlce /4);
        translateTransition.setOnFinished(event -> {
            if(gameEnded(currentRow, column)){
                finPartie();
                return;
            }
            tourDuJoueur1 = !tourDuJoueur1;
            peutInsererJeton = !peutInsererJeton;
           nomJoueur.setText(tourDuJoueur1 ? PseudoJ1 : PseudoJ2);
        });
        translateTransition.play();
    }

    private boolean gameEnded(int row, int column) {
        List<Point2D> verticalPoints = IntStream.rangeClosed(row-3,row+3)
                .mapToObj(r -> new Point2D(r,column))
                .collect(Collectors.toList());

        List<Point2D> horizontalPoints = IntStream.rangeClosed(column-3,column+3)
                .mapToObj(col -> new Point2D(row,col))
                .collect(Collectors.toList());

        Point2D startPoint1 = new Point2D(row -3, column + 3);
        List<Point2D> diagonal1Point = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> startPoint1.add(i, -i))
                .collect(Collectors.toList());

        Point2D startPoint2 = new Point2D(row -3, column - 3);
        List<Point2D> diagonal2Point = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> startPoint2.add(i, i))
                .collect(Collectors.toList());

        return checkLesCombi(verticalPoints) || checkLesCombi(horizontalPoints) || checkLesCombi(diagonal1Point) || checkLesCombi(diagonal2Point);
    }

    private boolean checkLesCombi(List<Point2D> points) {
        int chain = 0;

        for(Point2D point: points)
        {
            int presentLigne = (int) point.getX();
            int presentColonne = (int) point.getY();
            Disc jeton = jetonPresent(presentLigne, presentColonne);
            if(jeton !=null && jeton.isPlayerOneMove == tourDuJoueur1){
                chain++;
                if(chain == 4)
                {
                    return true;
                }
            }
            else {
                chain=0;
            }
        }
        return false;
    }

    private Disc jetonPresent(int row, int column){
        if(row >= lignes || row <0 || column >= colonnes || column <0)
            return null;
        return insererJetonArray[row][column];
    }

    private void finPartie() {
        String winner = tourDuJoueur1 ? PseudoJ1 : PseudoJ2;
        System.out.println("VICTOIRE DE: "+winner);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Puissance 4 JavaFX - FIN DE LA PARTIE");
        alert.setHeaderText("VICTOIRE DE: "+winner);
        alert.setContentText("REJOUER ?");
        ButtonType yesBtn = new ButtonType("OUI");
        ButtonType noBtn = new ButtonType("NON, Quitter");
        alert.getButtonTypes().setAll(yesBtn, noBtn);
        Platform.runLater(() -> {
            Optional<ButtonType> btnClicked = alert.showAndWait();
            if(btnClicked.isPresent() && btnClicked.get() == yesBtn) {
                resetGame();
            }else {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public void resetGame() {
        ajouterJetons.getChildren().clear();
        for(int ligne = 0; ligne< insererJetonArray.length; ligne++)
        {
            Arrays.fill(insererJetonArray[ligne], null);
        }

            rougeInt = 21;
            Main.controller.rouge.setText(rougeInt + " Jetons Restants");
            jauneInt = 21;
            Main.controller.jaune.setText(jauneInt + " Jetons Restants");

        tourDuJoueur1 = true;
        createPlayground();
    }

    public void resetPanel(){
            nomJoueur.setText(PseudoJ1);
            for (Rectangle rectangle : box_rectangle) {
                plateauDeJeu.getChildren().remove(rectangle);
            }
    }

    public void insertDiskFromServ(Disc disc, int column) {
        insertDisk(disc, column-1);
    }

    public static class Disc extends Circle{

        private final boolean isPlayerOneMove;

        public Disc(boolean isPlayerOneMove){
            if(isPlayerOneMove) {
                rougeInt--;
                Main.controller.rouge.setText(rougeInt + " Jetons Restants");
            } else {
                jauneInt--;
                Main.controller.jaune.setText(jauneInt + " Jetons Restants");
            }
            this.isPlayerOneMove = isPlayerOneMove;
            setRadius(diametre_cerlce /2);
            setFill(isPlayerOneMove? Color.valueOf(jetonRouge): Color.valueOf(jetonJaune));
            setCenterX(diametre_cerlce /2);
            setCenterY(diametre_cerlce /2);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
