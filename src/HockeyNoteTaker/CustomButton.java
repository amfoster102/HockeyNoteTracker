package HockeyNoteTaker;


import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class CustomButton extends StackPane {

    Region outline;
    Text text = new Text();
    String highlighted = "-fx-background-color: orange; -fx-border-style: solid; -fx-border-width: 5; -fx-border-color: black;";
    String  normalColor = "-fx-background-color: gray; -fx-background-radius: 10 10 10 10;";


    public CustomButton(String title){
        this.text.setText(title);
        text.setFont(new Font(25));
        outline = new Region();
        this.setMaxSize(150, 40);
        outline.setStyle("-fx-background-color: gray; -fx-background-radius: 10 10 10 10;");

        this.getChildren().add(outline);
        this.getChildren().add(text);

    }


    public void isHighlighted(Boolean isHighlighted){
        if(isHighlighted){
            outline.setStyle(highlighted);
        }
        else{
            outline.setStyle(normalColor);
        }
    }
}
