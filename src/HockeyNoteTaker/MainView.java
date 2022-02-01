package HockeyNoteTaker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainView extends BorderPane {

    public static Button addNote;
    private static Button start;
    private static Button stop;

    public static TextField newNotes;
    public static ObservableList<String> notes;

    public static ToggleButton homeShot;
    public static ToggleButton awayShot;
    public static ToggleButton homeGoal;
    public static ToggleButton awayGoal;

    public static Label Home;
    public static Label Away;
    public static Label homeShots;
    public static Label awayShots;
    public static Label timer;
    public static Label period;

    public static MenuItem resetBoard;
    public static MenuItem resetScoreBoard;
    public static MenuItem resetClock;
    public static MenuItem clearNotes;
    public static MenuItem about;
    public static MenuItem period1;
    public static MenuItem period2;
    public static MenuItem period3;
    public static MenuItem overtime;


    public MainView(){
        ToggleGroup toggle = new ToggleGroup();
        homeShot = new ToggleButton("Shot");
        awayShot = new ToggleButton("Shot");
        Separator separator = new Separator();
        homeGoal = new ToggleButton("Goal");
        awayGoal = new ToggleButton("Goal");
        homeShot.setToggleGroup(toggle);
        awayShot.setToggleGroup(toggle);
        homeGoal.setToggleGroup(toggle);
        awayGoal.setToggleGroup(toggle);
        HBox hBoxToggleGroup = new HBox(homeShot, homeGoal, separator, awayShot, awayGoal);
        hBoxToggleGroup.setAlignment(Pos.CENTER);


        Label home = new Label("Home");
        Label away = new Label("Away");
        home.setFont(new Font(24));
        away.setFont(new Font(24));
        home.setTextFill(Color.FORESTGREEN);
        away.setTextFill(Color.TEAL);
        HBox labels = new HBox(home, away);
        labels.setAlignment(Pos.CENTER);
        labels.setSpacing(15);


        VBox dryBoard = new VBox(20, Main.rinkView,labels, hBoxToggleGroup);
        dryBoard.setAlignment(Pos.TOP_CENTER);
        dryBoard.setMinSize(400, 700);
        dryBoard.setPadding(new Insets(0,20,20,20));
        dryBoard.setSpacing(10);


        Menu help = new Menu("Help");
        about = new MenuItem("About");
        about.setOnAction(Main.controller.helpMenu);
        help.getItems().add(about);



        clearNotes = new MenuItem("Clear Notes");
        clearNotes.setOnAction(Main.controller.clearNotes);

        resetBoard = new MenuItem("Erase Dry Board");
        resetBoard.setOnAction(Main.controller.resetDryBoard);

        resetScoreBoard = new MenuItem("Reset Score Board");
        resetScoreBoard.setOnAction(Main.controller.resetScoreBoard);

        resetClock = new MenuItem("Reset Clock");
        resetClock.setOnAction(Main.controller.resetClock);

        Menu edit = new Menu("Edit");
        edit.getItems().add(clearNotes);
        edit.getItems().add(resetBoard);
        edit.getItems().add(resetScoreBoard);
        edit.getItems().add(resetClock);
        Menu setPeriod = new Menu("Set Period");
        edit.getItems().add(setPeriod);

        period1 = new MenuItem("1");
        period1.setOnAction(Main.controller.setPeriod1);
        period2 = new MenuItem("2");
        period2.setOnAction(Main.controller.setPeriod2);
        period3 = new MenuItem("3");
        period3.setOnAction(Main.controller.setPeriod3);
        overtime = new MenuItem("Overtime");
        overtime.setOnAction(Main.controller.setPeriodOvertime);

        setPeriod.getItems().addAll(period1, period2, period3, overtime);


        MenuBar menuBar = new MenuBar(edit, help);


        notes = FXCollections.observableArrayList();
        ListView<String> notesList = new ListView<>(notes);
        notesList.setEditable(true);

        Text noteTitle = new Text("Game Report");
        noteTitle.setFont(new Font(24));
        newNotes = new TextField();
        newNotes.setText("Enter Notes Here");
        addNote = new Button("Add Note");
        addNote.setOnAction(Main.controller.addNoteClicked);


        VBox noteVbox = new VBox(noteTitle, notesList, newNotes, addNote);
        noteVbox.setAlignment(Pos.TOP_CENTER);

        noteVbox.setPadding(new Insets(20, 20, 0, 20));
        noteVbox.setSpacing(20);



        Home = new Label("Home: 0");
        Home.setTextFill(Color.FORESTGREEN);
        Away = new Label("Away: 0");
        Away.setTextFill(Color.TEAL);
        Home.setFont(new Font(25));
        Away.setFont(new Font(25));


        Label shotsTitle = new Label("Shot Attempts: ");
        shotsTitle.setFont(new Font(25));

        homeShots = new Label("0");
        homeShots.setFont(new Font(25));
        homeShots.setTextFill(Color.FORESTGREEN);

        awayShots = new Label("0");
        awayShots.setFont(new Font(25));
        awayShots.setTextFill(Color.TEAL);
        HBox score = new HBox(Home, Away, shotsTitle, homeShots, awayShots );
        score.setAlignment(Pos.TOP_CENTER);
        score.setSpacing(20);

        timer = new Label();
        timer.setText("20:00");
        timer.setFont(new Font(25));


        period = new Label("Period: 1");
        period.setFont(new Font(25));



        stop = new Button("Stop");
        start = new Button("Start");

        start.setOnAction(Main.controller.startClock);
        stop.setOnAction(Main.controller.stopClock);



        HBox scoreClock = new HBox(period, timer, stop, start);
        scoreClock.setSpacing(30);
        scoreClock.setAlignment(Pos.CENTER);
        scoreClock.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));



        this.setCenter(noteVbox);

        dryBoard.setPadding(new Insets(50,10,10,10));
        this.setLeft(dryBoard);
        VBox top = new VBox(menuBar, scoreClock);
        this.setTop(top);

        score.setPadding(new Insets(0, 10,10, 10));
        score.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBottom(score);


        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMaxHeight(800);
    }
}
