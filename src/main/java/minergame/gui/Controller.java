package minergame.gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

//hukgkgjmhcgjgj

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

import static javafx.scene.paint.Color.BROWN;

public class Controller {
    @FXML
    private Button initiateGameButton;
    @FXML
    private Button dirt;
    @FXML
    private TextField setDifficulty;
    @FXML
    private Pane gamePane;

    @FXML
    private GridPane GameGrid;
    public static Scanner input = new Scanner(System.in); // input generator
    public static Random rand = new Random(); // random generator
    private final ArrayList<RunGame> square = new ArrayList<>();
    boolean goNorth, goSouth, goEast, goWest;

    Miner myMiner;


    public Controller() {


    }

    @FXML
    public void gameStart(ActionEvent actionEvent) {
        //gamePane.getChildren().clear();
        new Miner();
        int squareXLength = 60;
        int squareYLength = 60;
        int squareWidth = 60;
        int squareHeight = 60;

        final int KEYBOARD_MOVEMENT_DELTA = 5;



        int n = rand.nextInt(10);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Rectangle rect = new Rectangle(squareXLength, squareYLength, squareWidth, squareHeight);
                Image rectImage = new Image("minergame/gui/Miner.PNG");
                rect.setFill(new ImagePattern(rectImage));



                rect.setWidth(60);
                rect.setHeight(60);
                Pane pne = new Pane();
                pne.setMinWidth(60);
                pne.setMinHeight(60);
                pne.setStyle("-fx-background-color: #4f2b00; ");
                pne.setOnMouseClicked(event -> {
                    pne.setVisible(false);

                });


                GridPane.setRowIndex(pne, row);
                GridPane.setColumnIndex(pne, col);
                GameGrid.getChildren().addAll(pne,rect);
            }
        }
    }

}





