package HockeyNoteTaker;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleGoal extends Circle {
    private Color color;

    public CircleGoal(double size, Color colorIn){
        super(size);
        this.color = colorIn;
    }

    public Color getColor() {
        return color;
    }
}
