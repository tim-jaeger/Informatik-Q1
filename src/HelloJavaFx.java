import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
* To run a javafx class go to Run/Edit Configurations/Application/(class)/VM-Options and enter:
* "--module-path /Users/timjaeger/Desktop/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml"
* */

public class HelloJavaFx extends Application {

    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 100);

        Label label = new Label("Hello World!");
        label.setPrefSize(100, 25);
        label.setLayoutX(150);
        label.setLayoutY(38);
        root.getChildren().add(label);

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
