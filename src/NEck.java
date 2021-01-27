import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NEck extends Application {

    Turtle turtle;

    NumberField inputLength = new NumberField();
    NumberField inputN = new NumberField();
    Label lLenght = new Label("Seitenlänge");
    Label lN = new Label("Anzahl der Ecken");

    Button btDraw = new Button("Zeichne");

    public void start(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 200);

        turtle = new Turtle(500, 300);
        turtle.setLayoutX(0);
        turtle.setLayoutY(0);
        root.getChildren().add(turtle);

        lLenght.setPrefSize(100, 25);
        lLenght.setLayoutX(10);
        lLenght.setLayoutY(388);
        root.getChildren().add(lLenght);

        inputLength.setPrefSize(50, 25);
        inputLength.setLayoutX(120);
        inputLength.setLayoutY(388);
        root.getChildren().add(inputLength);

        lN.setPrefSize(100, 25);
        lN.setLayoutX(200);
        lN.setLayoutY(388);
        root.getChildren().add(lN);

        inputN.setPrefSize(50, 25);
        inputN.setLayoutX(310);
        inputN.setLayoutY(388);
        root.getChildren().add(inputN);

        btDraw.setPrefSize(100, 25);
        btDraw.setLayoutX(400);
        btDraw.setLayoutY(388);
        btDraw.setOnAction(evt -> {draw(evt);});
        root.getChildren().add(btDraw);

        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setTitle("N-Eck");
        stage.setScene(scene);
        stage.show();
    }

    private void draw(Event evt) {

        turtle.clear();

        int length = inputLength.getInt();
        int n = inputN.getInt();
        double angle = 360.0 / (double) n;

        turtle.setPosition(250 - length / 2, 10);

        for(int i = 0; i < n; i++) {

            turtle.draw(length);
            turtle.turn(angle);
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
