package HockeyNoteTaker;

import javafx.animation.FadeTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main  extends Application {


    public static final Model model = new Model(20);
    public static final RinkView rinkView = new RinkView();
    public static final Controller controller = new Controller();


    public static Stage primaryStage;

    public static MainView main;
    public static SplashScreenView splash;
    public static InstructionsScreenView instructions;


    public static Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hockey Note Optimizer");


        main = new MainView();
        splash = new SplashScreenView();
        instructions = new InstructionsScreenView();


        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), splash);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        fadeIn.play();

        
        scene = new Scene(splash,1200,800);


        primaryStage.setScene(scene);
        primaryStage.show();






    }



}
