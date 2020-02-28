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
                for (int i = 0; i < 1000; i++) {
                    polyline.getPoints().addAll(i*10.0%400, Math.random() * 480);
                    if (i >40){
                        polyline.getPoints().remove(0,2);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    polyline.getPoints().remove(0,2);
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
