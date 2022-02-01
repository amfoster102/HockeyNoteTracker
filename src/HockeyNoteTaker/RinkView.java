package HockeyNoteTaker;

import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class RinkView extends Pane {

   public RinkView(){
       Image rink = new Image("images/hockey.jpg");
       BackgroundImage backgroundimage = new BackgroundImage(rink,
               BackgroundRepeat.NO_REPEAT,
               BackgroundRepeat.NO_REPEAT,
               BackgroundPosition.DEFAULT,
               BackgroundSize.DEFAULT);

       Background background = new Background(backgroundimage);
       this.setPadding(new Insets(50,50,50,50));
       this.setBackground(background);
       this.setMinSize(rink.getWidth(), rink.getHeight());
       this.setMaxSize(rink.getWidth(), rink.getHeight());


        Main.model.circleListProperty().addListener(new ListChangeListener<Shape>() {
            @Override
            public void onChanged(Change<? extends Shape> c) {

                draw();
            }
        });

        Main.model.xShotListProperty().addListener(new ListChangeListener<Shot>() {
            @Override
            public void onChanged(Change<? extends Shot> c) {
                draw();
            }
        });

   }
   public void layoutChildren(){
       draw();
   }
   private void draw(){
       this.getChildren().clear();


       for(CircleGoal s : Main.model.circleListProperty()){
           Circle r = new Circle(
                   s.getCenterX(),
                   s.getCenterY(),
                  7
           );
           r.setFill(s.getColor());

           r.setStroke(Color.BLACK);
           this.getChildren().add(r);
       }

       for(Shot p : Main.model.xShotListProperty()){
           Line line1 = new Line();
           Line line2 = new Line();
           line1 = p.getLine1();
           line2 = p.getLine2();
           line1.setStroke(p.getColor());
           line2.setStroke(p.getColor());



           this.getChildren().add(line1);
           this.getChildren().add(line2);
       }

    }
}
