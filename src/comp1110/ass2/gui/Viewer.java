package comp1110.ass2.gui;
//Pc02900i Py04400i Pp04100i Pr00600i A14S  Bp12p23y30p11y05c21y04c30c30y30p30p30y26r17y02r18c25r02y25y21n00y11p29p29c04c04y20r25p19r24c23c23c14r15r25p24r24p22p22r22c20p14p24p16p16p27p27y22y22 to have winner p ==>

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.awt.*;

public class Viewer extends Application {

    private static final int VIEWER_WIDTH = 1200;
    private static final int VIEWER_HEIGHT = 700;

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField boardTextField;

    public void processBoard(String a,double xCoor,double yCoor){
        String color = String.valueOf(a.charAt(0));

        Image rugR = new Image("file:src/comp1110/ass2/gui/Rug_R.png");
        Image rugC = new Image("file:src/comp1110/ass2/gui/Rug_C.png");
        Image rugY = new Image("file:src/comp1110/ass2/gui/Rug_Y.png");
        Image rugP = new Image("file:src/comp1110/ass2/gui/Rug_P.png");
        switch (color) {
            case "r" -> {
                ImageView rugView = new ImageView(rugR);
                rugView.setFitWidth(123);
                rugView.setFitHeight(72);
                rugView.setX(xCoor);
                rugView.setY(yCoor);
                root.getChildren().add(rugView);
            }
            case "p" -> {
                ImageView rugView = new ImageView(rugP);
                rugView.setFitWidth(123);
                rugView.setFitHeight(72);
                rugView.setX(xCoor);
                rugView.setY(yCoor);
                root.getChildren().add(rugView);
            }
            case "y" -> {
                ImageView rugView = new ImageView(rugY);
                rugView.setFitWidth(123);
                rugView.setFitHeight(72);
                rugView.setX(xCoor);
                rugView.setY(yCoor);
                root.getChildren().add(rugView);
            }
            case "c" -> {
                ImageView rugView = new ImageView(rugC);
                rugView.setFitWidth(123);
                rugView.setFitHeight(72);
                rugView.setX(xCoor);
                rugView.setY(yCoor);
                root.getChildren().add(rugView);
            }
        }




    }


    /**
     * Draw a placement in the window, removing any previously drawn placements
     *
     * @param state an array of two strings, representing the current game state
     */
    void displayState(String state) {

        root.getChildren().clear();
        Image backgroundImage = new Image("file:src/comp1110/ass2/gui/Board Image.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        double desiredWidth = 1200;
        double desiredHeight = 700;
        backgroundImageView.setFitWidth(desiredWidth);
        backgroundImageView.setFitHeight(desiredHeight);
        root.getChildren().add(backgroundImageView);


        String trimPlayer = state.substring(state.indexOf('A'),state.indexOf('B'));
        String trimBoard = state.substring(state.indexOf('B')+1);


        int stringSize= trimBoard.length()/3;
        String[] boardArray= new String[stringSize];
        for (int i = 0; i < stringSize; i++) {
            boardArray[i]=trimBoard.substring(i*3,i*3+3);
        }
        int index =0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                double xCoor2= 179+i*123;
                double yCoor2= 105+j*72;
                processBoard(boardArray[index],xCoor2,yCoor2);
                index++;
            }
        }
        int x = Character.getNumericValue(trimPlayer.charAt(1));
        int y = Character.getNumericValue(trimPlayer.charAt(2));
        String orientation = String.valueOf(trimPlayer.charAt(3));
        double xCoor= 179+x*123;
        double yCoor= 105+y*72;
        Image assamSouth = new Image("file:src/comp1110/ass2/gui/South.png");
        Image assamWest = new Image("file:src/comp1110/ass2/gui/West.png");
        Image assamNorth = new Image("file:src/comp1110/ass2/gui/North.png");
        Image assamEast = new Image("file:src/comp1110/ass2/gui/East.png");

        switch (orientation) {
            case "S" -> {
                ImageView assamView = new ImageView(assamSouth);
                assamView.setFitWidth(123);
                assamView.setFitHeight(72);
                assamView.setX(xCoor);
                assamView.setY(yCoor);
                root.getChildren().add(assamView);
            }
            case "W" -> {
                ImageView assamView = new ImageView(assamWest);
                assamView.setFitWidth(123);
                assamView.setFitHeight(72);
                assamView.setX(xCoor);
                assamView.setY(yCoor);
                root.getChildren().add(assamView);
            }
            case "E" -> {
                ImageView assamView = new ImageView(assamEast);
                assamView.setFitWidth(123);
                assamView.setFitHeight(72);
                assamView.setX(xCoor);
                assamView.setY(yCoor);
                root.getChildren().add(assamView);
            }
            case "N" -> {
                ImageView assamView = new ImageView(assamNorth);
                assamView.setFitWidth(123);
                assamView.setFitHeight(72);
                assamView.setX(xCoor);
                assamView.setY(yCoor);
                root.getChildren().add(assamView);
            }

        }
        Label boardLabel = new Label("Game State:");
        boardTextField = new TextField();
        boardTextField.setPrefWidth(800);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayState(boardTextField.getText());
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(boardLabel,
                boardTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(180);
        hb.setLayoutY(612);
        root.getChildren().add(hb);





//        Pc02900i Py04400i Pp04100i Pr00600i A14S  Bp12p23y30p11y05c21y04c30c30y30p30p30y26r17y02r18c25r02y25y21n00y11p29p29c04c04y20r25p19r24c23c23c14r15r25p24r24p22p22r22c20p14p24p16p16p27p27y22y22 to have winner p ==>


//        Rectangle cell1 = new Rectangle(179, 105, 123, 72);
//        cell1.setFill(Color.RED);
//        root.getChildren().add(cell1);


//        p12p23y30p11y05c21y04c30c30y30p30p30y26r17y02r18c25r02y25y21n00y11p29p29c04c04y20r25p19r24c23c23c14r15r25p24r24p22p22r22c20p14p24p16p16p27p27y22y22



        // FIXME Task 5: implement the simple state viewer
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label boardLabel = new Label("Game State:");
        boardTextField = new TextField();
        boardTextField.setPrefWidth(800);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                displayState(boardTextField.getText());
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(boardLabel,
                boardTextField, button);
        hb.setSpacing(10);
        hb.setLayoutX(50);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Marrakech Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        Circle marker = new Circle(5, Color.RED);
        scene.setOnMouseClicked(event -> {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();


            marker.setCenterX(mouseX);
            marker.setCenterY(mouseY);


            System.out.println("Mouse Click Location: X=" + mouseX + ", Y=" + mouseY);
        });

        root.getChildren().addAll(marker);
        root.getChildren().add(controls);
        makeControls();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
