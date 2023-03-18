import animatefx.animation.FadeInDownBig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

import static javafx.scene.paint.Color.TRANSPARENT;

//import nickyb.sqleonardo.environment.Application;
//import static org.jdesktop.swingx.graphics.BlendComposite.Color;


public class AppInitializer extends Application {
    Parent root;
    double xOffset, yOffset;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/LoginForm.fxml")));
//            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/PlaceOrderForm.fxml")));
            Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            new FadeInDownBig(root).play();
            scene.setFill(TRANSPARENT);
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
