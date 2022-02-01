package HockeyNoteTaker;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Shot {

    private Line line1;
    private Line line2;
    private Color color;

    public Shot(Line line1, Line line2, Color color){
        this.line1 = line1;
        this.line2 = line2;
        this.color = color;
    }

    public Line getLine1(){
        return line1;
    }

    public Line getLine2(){
        return line2;
    }

    public Color getColor(){
        return color;
    }


}
