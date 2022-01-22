package sample;

import sample.irc.Client;
import sample.irc.Server;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application
{
    public static Controller controller;

    public static boolean tourJoueur1 = false;
// --Commented out by Inspection START (01/05/2021 01:11):
//    // --Commented out by Inspection (01/05/2021 01:11):public static String PlayerName = "";
//    // --Commented out by Inspection (01/05/2021 01:11):public static String otherPlayerName = "";
// --Commented out by Inspection STOP (01/05/2021 01:11)
    public static String tempName = "";
    public static Server server;
    public static Client client;
    // --Commented out by Inspection (01/05/2021 01:11):public static boolean isFX;

    @Override
    public void start(Stage primaryStage) throws Exception {
     Alert dBox = new Alert(Alert.AlertType.CONFIRMATION);
        dBox.setTitle("Puissance 4 JavaFX - HAYAT");
        dBox.setHeaderText(null);
        dBox.setContentText("Vous etes le Joueur 1 ?");
        ButtonType btnYes = new ButtonType("OUI");
        ButtonType btnNo = new ButtonType("NON");
        dBox.getButtonTypes().setAll(btnYes, btnNo);
        Optional<ButtonType> choice = dBox.showAndWait();
        if (choice.get() == btnYes) {
            tourJoueur1 = true;
         server =  new Server();
            server.main();
            server.write("name-fx");
        }
        else if (choice.get() == btnNo) {
            tourJoueur1 = false;
         client = new Client();
         client.main();
            client. write("name-fx");
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Puissance4FX.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();
        MenuBar menuBar = barreMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);
        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Puissance 4 JavaFX | HAYAT  ["+ (tourJoueur1? "Joueur 1":"Joueur 2")+"]");
        primaryStage.setResizable(false);
        primaryStage.show();
        controller.reset.setVisible(tourJoueur1);
        controller.reset.setOnMouseClicked(event -> controller.resetGame());
    }

    public MenuBar barreMenu() {
        Menu ongletMenu1 = new Menu("Fichier"); // nom de la barre du menu

        MenuItem optionRecommencer = new MenuItem("Recommencer"); // menu > Bouton Recommencer
        optionRecommencer.setOnAction(event -> {
            controller.resetGame();
            controller.resetPanel();
        });

        SeparatorMenuItem separationOptionMenu = new SeparatorMenuItem(); // séparateur menu

        MenuItem optionQuitter = new MenuItem("Quitter"); // menu > Bouton Quitter
        optionQuitter.setOnAction(event -> boutonQuitter());

        ongletMenu1.getItems().addAll(optionRecommencer, separationOptionMenu, optionQuitter);

        MenuBar barreMenu1 = new MenuBar();
        barreMenu1.getMenus().addAll(ongletMenu1);
        return barreMenu1;
    }

    private void boutonQuitter() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
