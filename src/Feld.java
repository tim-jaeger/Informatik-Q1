import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 30.10.2020
 * @author
 */

public class Feld extends Application {
    // Anfang Attribute
    private NumberField numberField1 = new NumberField();
    private NumberField numberField2 = new NumberField();
    private NumberField numberField3 = new NumberField();
    private NumberField numberField4 = new NumberField();
    private NumberField numberField5 = new NumberField();
    private NumberField numberField6 = new NumberField();
    private NumberField numberField7 = new NumberField();
    private NumberField numberField8 = new NumberField();
    private NumberField numberField9 = new NumberField();
    private NumberField numberField10 = new NumberField();
    private NumberField numberField11 = new NumberField();
    private NumberField numberField12 = new NumberField();
    private NumberField numberField13 = new NumberField();
    private NumberField numberField14 = new NumberField();
    private NumberField numberField15 = new NumberField();
    private Button bFullen = new Button();
    private Button bNeu = new Button();
    private Button bSuchen = new Button();
    private Button bSortieren = new Button();

    private int[] feld = new int[15]; //Klasse heißt schon Feld
    private Label lEingabe = new Label();
    private NumberField numberField16 = new NumberField();
    // Ende Attribute

    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 819, 224);
        // Anfang Komponenten

        numberField1.setLayoutX(15);
        numberField1.setLayoutY(11);
        numberField1.setPrefHeight(25);
        numberField1.setPrefWidth(35);
        root.getChildren().add(numberField1);
        numberField2.setLayoutX(55);
        numberField2.setLayoutY(11);
        numberField2.setPrefHeight(25);
        numberField2.setPrefWidth(35);
        root.getChildren().add(numberField2);
        numberField3.setLayoutX(95);
        numberField3.setLayoutY(11);
        numberField3.setPrefHeight(25);
        numberField3.setPrefWidth(35);
        root.getChildren().add(numberField3);
        numberField4.setLayoutX(135);
        numberField4.setLayoutY(11);
        numberField4.setPrefHeight(25);
        numberField4.setPrefWidth(35);
        root.getChildren().add(numberField4);
        numberField5.setLayoutX(175);
        numberField5.setLayoutY(11);
        numberField5.setPrefHeight(25);
        numberField5.setPrefWidth(35);
        root.getChildren().add(numberField5);
        numberField6.setLayoutX(215);
        numberField6.setLayoutY(11);
        numberField6.setPrefHeight(25);
        numberField6.setPrefWidth(35);
        root.getChildren().add(numberField6);
        numberField7.setLayoutX(255);
        numberField7.setLayoutY(11);
        numberField7.setPrefHeight(25);
        numberField7.setPrefWidth(35);
        root.getChildren().add(numberField7);
        numberField8.setLayoutX(295);
        numberField8.setLayoutY(11);
        numberField8.setPrefHeight(25);
        numberField8.setPrefWidth(35);
        root.getChildren().add(numberField8);
        numberField9.setLayoutX(335);
        numberField9.setLayoutY(11);
        numberField9.setPrefHeight(25);
        numberField9.setPrefWidth(35);
        root.getChildren().add(numberField9);
        numberField10.setLayoutX(375);
        numberField10.setLayoutY(11);
        numberField10.setPrefHeight(25);
        numberField10.setPrefWidth(35);
        root.getChildren().add(numberField10);
        numberField11.setLayoutX(415);
        numberField11.setLayoutY(11);
        numberField11.setPrefHeight(25);
        numberField11.setPrefWidth(35);
        root.getChildren().add(numberField11);
        numberField12.setLayoutX(455);
        numberField12.setLayoutY(11);
        numberField12.setPrefHeight(25);
        numberField12.setPrefWidth(35);
        root.getChildren().add(numberField12);
        numberField13.setLayoutX(495);
        numberField13.setLayoutY(11);
        numberField13.setPrefHeight(25);
        numberField13.setPrefWidth(35);
        root.getChildren().add(numberField13);
        numberField14.setLayoutX(535);
        numberField14.setLayoutY(11);
        numberField14.setPrefHeight(25);
        numberField14.setPrefWidth(35);
        root.getChildren().add(numberField14);
        numberField15.setLayoutX(575);
        numberField15.setLayoutY(11);
        numberField15.setPrefHeight(25);
        numberField15.setPrefWidth(35);
        root.getChildren().add(numberField15);
        bFullen.setLayoutX(105);
        bFullen.setLayoutY(121);
        bFullen.setPrefHeight(25);
        bFullen.setPrefWidth(75);
        bFullen.setOnAction(
                (event) -> {bFullen_Action(event);}
        );
        bFullen.setText("F�llen");
        root.getChildren().add(bFullen);
        bNeu.setLayoutX(17);
        bNeu.setLayoutY(121);
        bNeu.setPrefHeight(25);
        bNeu.setPrefWidth(75);
        bNeu.setOnAction(
                (event) -> {bNeu_Action(event);}
        );
        bNeu.setText("Neu");
        root.getChildren().add(bNeu);
        bSuchen.setLayoutX(192);
        bSuchen.setLayoutY(120);
        bSuchen.setPrefHeight(25);
        bSuchen.setPrefWidth(75);
        bSuchen.setOnAction(
                (event) -> {bSuchen_Action(event);}
        );
        bSuchen.setText("Suchen");
        root.getChildren().add(bSuchen);
        bSortieren.setLayoutX(280);
        bSortieren.setLayoutY(120);
        bSortieren.setPrefHeight(25);
        bSortieren.setPrefWidth(75);
        bSortieren.setOnAction(
                (event) -> {bSortieren_Action(event);}
        );
        bSortieren.setText("Sortieren");
        root.getChildren().add(bSortieren);
        lEingabe.setLayoutX(16);
        lEingabe.setLayoutY(48);
        lEingabe.setPrefHeight(20);
        lEingabe.setPrefWidth(110);
        lEingabe.setText("Eingabe");
        root.getChildren().add(lEingabe);
        numberField16.setLayoutX(127);
        numberField16.setLayoutY(43);
        numberField16.setPrefHeight(25);
        numberField16.setPrefWidth(51);
        root.getChildren().add(numberField16);
        // Ende Komponenten

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Feld");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of public Feld

    // Anfang Methoden

    public static void main(String[] args) {
        launch(args);
    } // end of main

    public void bFullen_Action(Event evt) {
        Random rand = new Random();
        for (int i = 0; i < feld.length; i++) {
            feld[i] = rand.nextInt(999);
        }
        update();

    } // end of bFullen_Action

    public void bNeu_Action(Event evt) {
        for (int i = 0; i < feld.length; i++) {
            feld[i] = 0;
        }
        update();

    } // end of bNeu_Action

    public void bSuchen_Action(Event evt) {
        // TODO hier Quelltext einf�gen

        int eingabe = numberField16.getInt();

        System.out.println("Gefunden an der Stelle " + binaerSuchen(eingabe, feld, 0, feld.length - 1));

    } // end of bSuchen_Action

    private Integer binaerSuchen(int element, int[] feld, int start, int end) {

        int middle = (start + end) / 2;

        if (element == feld[middle]) {

            return middle;
        }
        else if ((end - start) == 0) {

            return null;
        }
        else if (element < feld[middle]) {

            return binaerSuchen(element, feld, start, middle - 1);
        }
        else {

            return  binaerSuchen(element, feld, middle + 1, end);
        }
    }

    public void bSortieren_Action(Event evt) {
        // TODO hier Quelltext einf�gen

        selectionSort();
        
        this.update();
    } // end of bSortieren_Action

    public int[] mergeSort(int[] feld) {

        if (feld.length == 1) {

            return feld;
        }
        else {

            int grenze = (int) Math.ceil(feld.length / 2);
            int[] linkerTeil = mergeSort(Arrays.copyOfRange(feld, 0, grenze));
            int[] rechterTeil = mergeSort(Arrays.copyOfRange(feld, grenze, feld.length));

            return zusammenfuehren(linkerTeil, rechterTeil);
        } // end of if-else
    }

    private int[] zusammenfuehren(int[] linkerTeil, int[] rechterTeil) {

        int indexLinks = 0;
        int indexRechts = 0;

        int[] result = new int[linkerTeil.length + rechterTeil.length];

        for(int i = 0; i < result.length; i++) {

            if (indexLinks >= linkerTeil.length) {

                result[i] = rechterTeil[indexRechts];
                indexRechts++;
            } // end of if
            else if(indexRechts >= rechterTeil.length) {

                result[i] = linkerTeil[indexLinks];
                indexLinks++;
            }
            else {

                if (linkerTeil[indexLinks] <= rechterTeil[indexRechts]) {

                    result[i] = linkerTeil[indexLinks];
                    indexLinks++;
                } // end of if
                else {

                    result[i] = rechterTeil[indexRechts];
                    indexRechts++;
                } // end of if-else
            }
        }

        return result;
    }
    
    public void selectionSort() {
        
        for(int i = 0; i < feld.length - 1; i++) {
            
            int positionMin = i;
            
            for(int j = i + 1; j < feld.length; j++) {
                
                if(feld[j] < feld[positionMin]) {
                    
                    positionMin = j;
                }
            }
            
            int element = feld[positionMin];
            
            feld[positionMin] = feld[i];
            feld[i] = element;
        }
    }

    public void insertionSort() {
        
        int j, element;

        for (int i = 1; i < feld.length; i++) {

            j = i;

            element = feld[i];

            while(j > 0 && feld[j-1] > element) {

                feld[j] = feld[j-1];

                j--;
            }

            feld[j] = element;
        }
    }
    
    private void update(){
        numberField1.setInt(feld[0]);
        numberField2.setInt(feld[1]);
        numberField3.setInt(feld[2]);
        numberField4.setInt(feld[3]);
        numberField5.setInt(feld[4]);
        numberField6.setInt(feld[5]);
        numberField7.setInt(feld[6]);
        numberField8.setInt(feld[7]);
        numberField9.setInt(feld[8]);
        numberField10.setInt(feld[9]);
        numberField11.setInt(feld[10]);
        numberField12.setInt(feld[11]);
        numberField13.setInt(feld[12]);
        numberField14.setInt(feld[13]);
        numberField15.setInt(feld[14]);
    }

    // Ende Methoden
} // end of class Feld


