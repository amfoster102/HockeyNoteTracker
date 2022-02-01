package HockeyNoteTaker;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SplashScreenView extends StackPane {

    public CustomButton start;

    public SplashScreenView(){


        Image splash = new Image("images/splashScreen.jpg");
        BackgroundImage backgroundimage = new BackgroundImage(splash,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);

        this.setBackground(background);


        start = new CustomButton("Start Game");
        start.setOnMouseClicked(Main.controller.startGame);
        start.setOnMouseEntered(Main.controller.startButtonHighlighted);
        start.setOnMouseExited(Main.controller.startButtonNotHighlighted);

        this.getChildren().add(start);
    }

}
