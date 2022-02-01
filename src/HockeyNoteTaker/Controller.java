package HockeyNoteTaker;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Controller {

    private int homeGoals = 0;
    private int awayGoals = 0;
    private int awayShots = 0;
    private int homeShots = 0;

    private Timeline timeline;

    private static Integer STARTTIME = 1200;
    private Integer timeSeconds = STARTTIME;



    public Controller(){

        Main.rinkView.addEventHandler(MouseEvent.ANY, new MouseHandler());

    }


    public class MouseHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {

            /* TODO: Change hardcoded values */
            if(event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getX() >= 50 && event.getX() <= 316
                && event.getY() >= 3 && event.getY() <= 545){
                if(MainView.homeGoal.isSelected()){
                    Main.model.addCircle(event.getX(), event.getY());
                    homeGoals++;
                    MainView.Home.setText("Home: " + homeGoals);
                    String goalMessage = "";
                    goalMessage += (MainView.period.getText() + "\t" + MainView.timer.getText() + "\t Home Goal!");
                    MainView.notes.add(goalMessage);

                }
                else if(MainView.awayGoal.isSelected()){
                    Main.model.addCircle(event.getX(), event.getY());
                    awayGoals++;
                    MainView.Away.setText("Away: "+ awayGoals);
                    String goalMessage = "";
                    goalMessage += (MainView.period.getText() + "\t" + MainView.timer.getText() + "\t Away Goal!");
                    MainView.notes.add(goalMessage);

                }
                else if(MainView.awayShot.isSelected()){
                    Main.model.addX(event.getX(), event.getY());
                    awayShots++;
                    MainView.awayShots.setText(awayShots + "");
                    String shotMessage = "";
                    shotMessage += (MainView.period.getText() + "\t" + MainView.timer.getText() + "\t Away Shot Attempt");
                    MainView.notes.add(shotMessage);

                }
                else if(MainView.homeShot.isSelected()){
                    Main.model.addX(event.getX(), event.getY());
                    homeShots++;
                    MainView.homeShots.setText(homeShots + "");
                    String shotMessage = "";
                    shotMessage += (MainView.period.getText() + "\t" + MainView.timer.getText() + "\t Home Shot Attempt");
                    MainView.notes.add(shotMessage);
                }
            }
        }
    }


    EventHandler<ActionEvent> addNoteClicked = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            String note = (MainView.period.getText()+ "\t"+ MainView.timer.getText() + "\t");
            note += MainView.newNotes.getText();
            MainView.notes.add(note);
            MainView.newNotes.setText("");
        }
    };

       EventHandler<ActionEvent> startClock =  new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               if (timeline != null) {
                   timeline.stop();
               }
               timeSeconds = STARTTIME;

               timeline = new Timeline();
               timeline.setCycleCount(Timeline.INDEFINITE);
               timeline.getKeyFrames().add(
                       new KeyFrame(Duration.seconds(1),
                               new EventHandler() {
                                   // KeyFrame event handler
                                   public void handle(Event event) {
                                       timeSeconds--;
                                       // update timerLabel
                                       int minutes = timeSeconds/60;
                                       int seconds = timeSeconds%60;
                                       if(seconds < 10){
                                           MainView.timer.setText(minutes +":0"+ seconds);
                                       }
                                       else{
                                           MainView.timer.setText(minutes +":"+ seconds);
                                       }


                                       if (timeSeconds <= 0) {
                                           timeline.stop();
                                       }
                                   }
                               }));
               timeline.playFromStart();
           }
       };

       EventHandler<ActionEvent> stopClock = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try{
                   timeline.stop();
                   STARTTIME = timeSeconds;
               }
               catch(NullPointerException e){

               }

           }
       };

       EventHandler<ActionEvent> resetDryBoard = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Main.model.xShotListProperty().clear();
               Main.model.circleListProperty().clear();
           }
       };

       EventHandler<ActionEvent> resetScoreBoard = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
             homeGoals = 0;
             awayGoals = 0;
             homeShots = 0;
             awayShots = 0;
               MainView.homeShots.setText("0");
               MainView.awayShots.setText("0");
               MainView.Home.setText("Home: 0");
               MainView.Away.setText("Away: 0");
           }
       };

       EventHandler<ActionEvent> resetClock = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try{
                   timeline.stop();
               }
               catch(NullPointerException e){

               }
                STARTTIME = 1200;
               MainView.timer.setText("20:00");
           }
       };

       EventHandler<ActionEvent> clearNotes = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               MainView.notes.clear();
           }
       };

       EventHandler<MouseEvent> startGame = new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {

               FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), Main.splash);
               fadeOut.setFromValue(0);
               fadeOut.setToValue(1);
               fadeOut.setCycleCount(1);

               fadeOut.play();

               Main.scene.setRoot(Main.main);


           }
       };

       EventHandler<MouseEvent> startButtonHighlighted = new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {

               Main.splash.start.isHighlighted(true);
           }
       };

      EventHandler<MouseEvent> startButtonNotHighlighted = new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            Main.splash.start.isHighlighted(false);
          }
      };

      EventHandler<ActionEvent> setPeriod1 = new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              Main.main.period.setText("Period: 1");
          }
      };

     EventHandler<ActionEvent> setPeriod2 = new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
             Main.main.period.setText("Period: 2");
         }
     };
     EventHandler<ActionEvent> setPeriod3 = new EventHandler<ActionEvent>() {
         @Override
           public void handle(ActionEvent event) {
             Main.main.period.setText("Period: 3");
         }
        };
     EventHandler<ActionEvent> setPeriodOvertime = new EventHandler<ActionEvent>() {
           @Override
         public void handle(ActionEvent event) {
             Main.main.period.setText("Period: Overtime");
         }
      };

    EventHandler<ActionEvent> helpMenu = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            Main.scene.setRoot(Main.instructions);


        }
    };

    EventHandler<MouseEvent> returnButtonHighlighted = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            Main.instructions.returnToMain.isHighlighted(true);
        }
    };

    EventHandler<MouseEvent> returnButtonNotHighlighted = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Main.instructions.returnToMain.isHighlighted(false);
        }
    };

    EventHandler<MouseEvent> returnToMainScreen = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Main.scene.setRoot(Main.main);
        }
    };


}
