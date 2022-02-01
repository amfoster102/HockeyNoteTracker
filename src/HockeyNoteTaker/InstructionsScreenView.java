package HockeyNoteTaker;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InstructionsScreenView extends StackPane {

    Text shots;
    Text goals;
    Text toggleButton;
    Text editMenuHelp;
    Text clockHelp;
    Text scoreBoardHelp;
    Text addNote;

    CustomButton returnToMain = new CustomButton("Return");

    public InstructionsScreenView(){
        Font font = new Font(14);

        clockHelp = new Text("Stop and Start Timer Here");
        clockHelp.setFont(font);
        scoreBoardHelp = new Text("Score Board Updates Based on Clicks to Ice Surface");
        scoreBoardHelp.setFont(font);
        editMenuHelp = new Text("Go to Edit Tab to Change Period or Reset Progress");
        editMenuHelp.setFont(font);
        shots = new Text("X Represents Shots");
        shots.setFont(font);
        goals = new Text("Circles Represent Goals");
        goals.setFont(font);
        toggleButton = new Text("Select Button then Click Ice Surface");
        toggleButton.setFont(font);
        addNote = new Text("Enter Other Notes in Text Field then click Add Note");
        addNote.setFont(font);

        Image helpImage = new Image("images/demo.PNG");
        ImageView help = new ImageView(helpImage);
        help.setFitHeight(550);
        help.setFitWidth(800);


        this.getChildren().add(help);
        this.getChildren().addAll(returnToMain, shots, goals, toggleButton, editMenuHelp, scoreBoardHelp, clockHelp, addNote);


        editMenuHelp.setTranslateX(-350);
        editMenuHelp.setTranslateY(-300);
        shots.setTranslateX(-500);
        goals.setTranslateX(-500);
        goals.setTranslateY(100);
        toggleButton.setTranslateX(-450);
        toggleButton.setTranslateY(200);

        returnToMain.setTranslateX(500);
        returnToMain.setTranslateY(350);

        scoreBoardHelp.setTranslateY(350);
        clockHelp.setTranslateY(-350);
        addNote.setTranslateX(375);

        //TODO Change the lines, could just redo in paint and take screenshot
        Line line1 = new Line();
        line1.setStartX(100);
        line1.setStartY(10);
        line1.setEndX(150);
        line1.setEndY(100);
        line1.setTranslateY(-290);
        line1.setTranslateX(40);

        Line line2 = new Line();
        line2.setStartX(0);
        line2.setEndX(0);
        line2.setStartY(0);
        line2.setEndY(35);
        line2.setTranslateX(-380);
        line2.setTranslateY(-270);

        Line line3 = new Line();
        line3.setStartX(0);
        line3.setEndX(0);
        line3.setStartY(0);
        line3.setEndY(50);
        line3.setTranslateY(310);

        Line line4 = new Line();
        line4.setStartX(0);
        line4.setEndX(100);
        line4.setStartY(0);
        line4.setEndY(10);
        line4.setTranslateX(-400);
        line4.setTranslateY(220);

        Line line5 = new Line();
        line5.setStartX(70);
        line5.setEndX(0);
        line5.setStartY(0);
        line5.setEndY(100);
        line5.setTranslateX(300);
        line5.setTranslateY(70);

        Line line6 = new Line();
        line6.setStartX(0);
        line6.setEndX(200);
        line6.setStartY(40);
        line6.setEndY(55);
        line6.setTranslateX(-400);
        line6.setTranslateY(120);

        Line line7 = new Line();
        line7.setStartX(0);
        line7.setEndX(210);
        line7.setStartY(0);
        line7.setEndY(55);
        line7.setTranslateX(-400);
        line7.setTranslateY(40);



        Text author = new Text("Adam Foster, Student Number: 3589048");
        author.setFont(new Font(25));
        author.setTranslateX(-360);
        author.setTranslateY(-380);

        this.getChildren().addAll(line1, line2, line3, line4, line5, line6, line7, author);


        returnToMain.setOnMouseEntered(Main.controller.returnButtonHighlighted);
        returnToMain.setOnMouseClicked(Main.controller.returnToMainScreen);
        returnToMain.setOnMouseExited(Main.controller.returnButtonNotHighlighted);
    }
}
