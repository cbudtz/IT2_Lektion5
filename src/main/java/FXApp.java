import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class FXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Draw some lines");

        Polyline polyline = new Polyline();

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        drawLines();
                    }
                };

                new Thread(runnable).start();


            }

            private void drawLines() {
                for (int i = 0; i < 10; i++) {
                    polyline.getPoints().addAll(Math.random() * 640, Math.random() * 480);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button,polyline);
        Scene scene = new Scene(anchorPane,640,480);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
