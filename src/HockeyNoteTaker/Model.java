package HockeyNoteTaker;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Model {

    private SimpleListProperty<CircleGoal> circleListProperty;
    private SimpleListProperty<Shot> xShotListProperty;

    //Original is a double
    private int shapeSideLength;


    public Model(int shapeSideLength) {
        ArrayList<CircleGoal> circles = new ArrayList<CircleGoal>();
        ObservableList<CircleGoal> observableList = (ObservableList<CircleGoal>) FXCollections.observableArrayList(circles);
        circleListProperty = new SimpleListProperty<CircleGoal>(observableList);

        ArrayList<Shot> x = new ArrayList<Shot>();
        ObservableList<Shot> observableList2 = (ObservableList<Shot>) FXCollections.observableArrayList(x);
        xShotListProperty = new SimpleListProperty<Shot>(observableList2);

        this.shapeSideLength = shapeSideLength;
    }


    public SimpleListProperty<CircleGoal> circleListProperty(){
        return circleListProperty;
    }
    public SimpleListProperty<Shot> xShotListProperty() {return xShotListProperty;}

    public int getShapeSideLength() {return shapeSideLength;}


    public void addCircle(double x, double y) {
        double size = Main.model.getShapeSideLength()/2;
        Color color;
        if(MainView.homeGoal.isSelected()){
            color = Color.FORESTGREEN;
        }
        else{
            color = Color.TEAL;
        }
        CircleGoal newCircle = new CircleGoal(size, color);
        newCircle.setCenterX(x);
        newCircle.setCenterY(y);
        circleListProperty.add(newCircle);
    }
    public void addX(double x, double y){
        Color color;
        if(MainView.homeShot.isSelected()){
            color = Color.FORESTGREEN;
        }
        else{
            color = Color.TEAL;
        }

        Line line1 = new Line();
        line1.setStartX(x - 5);
        line1.setEndX(x + 5);
        line1.setStartY(y - 5);
        line1.setEndY(y + 5);
        line1.setStrokeWidth(3);

        Line line2 = new Line();
        line2.setStartX(x - 5);
        line2.setEndX(x + 5);
        line2.setStartY(y + 5 );
        line2.setEndY(y -5);
        line2.setStrokeWidth(3);

        Shot shot = new Shot(line1, line2, color);

        xShotListProperty().add(shot);
    }

    public void deleteCircleAt(int x, int y)
    {
        Shape delShape = getShapeAt(x, y);
        circleListProperty.remove(delShape);
    }

    private Shape getShapeAt(int x, int y)
    {
        Shape shape = null;

        for (Shape s : circleListProperty)
        {
            if (s.contains(x, y))
            {
                shape = s;
            }
        }

        return shape;
    }

}


