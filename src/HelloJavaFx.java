import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
