import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class StartWindow extends Application {

    private Label lblTop;
    private Label lblCenter;
    private Button btnNo, btnYes;
    private Button btnStart;
    private HBox hbxBot;
    private VBox vbxMid;
    private int questionIndex = 1;

    private HashMap<String, String> specs = new HashMap<>();
    private HashMap<Integer, Boolean> answers = new HashMap<>();

    @Override
    public void start (Stage stage){
        stage.setTitle("World of Warcraft Spec Quiz");
        BorderPane pane = new BorderPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setHeight(650);
        stage.setWidth(600);
    }

    private void initContent(BorderPane pane){

        lblTop = new Label("Welcome to the Quiz");
        lblCenter = new Label("Find out what DPS Spec to play after answering these few simple questions!");
        hbxBot = new HBox(10);
        vbxMid = new VBox(10);
        btnStart = new Button("Start Quiz");
        btnNo = new Button ("No");
        btnYes = new Button ("Yes");
        hbxBot.getChildren().add(btnStart);
        vbxMid.getChildren().add(lblCenter);

        pane.setTop(lblTop);
        pane.setCenter(lblCenter);
        pane.setBottom(hbxBot);
        BorderPane.setAlignment(lblTop, Pos.CENTER);
        lblTop.setFont(Font.font(50));
        lblCenter.setFont(Font.font(30));
        lblCenter.setWrapText(true);
        vbxMid.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(vbxMid, Pos.CENTER);
        lblCenter.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(hbxBot, Pos.TOP_CENTER);
        hbxBot.setAlignment(Pos.TOP_CENTER);
        btnStart.setPrefSize(150, 75);
        btnYes.setPrefSize(150, 75);
        btnNo.setPrefSize(150, 75);
        btnNo.setOnAction(event -> noAction());
        btnYes.setOnAction(event -> yesAction());
        btnStart.setOnAction(event -> startAction());
        BorderPane.setMargin(hbxBot, new Insets(0, 0, 150, 0));

        specs.put("Death Knight", "Frost");
        specs.put("Death Knight", "Unholy");
        specs.put("Demon Hunter", "Havoc");
        specs.put("Druid", "Balance");
        specs.put("Druid", "Feral");
        specs.put("Evoker", "Devestation");
        specs.put("Hunter", "Beast Mastery");
        specs.put("Hunter", "Marksmanship");
        specs.put("Hunter", "Survival");
        specs.put("Mage", "Arcane");
        specs.put("Mage", "Fire");
        specs.put("Mage", "Frost");
        specs.put("Monk", "Windwalker");
        specs.put("Paladin", "Retribution");
        specs.put("Priest", "Shadow");
        specs.put("Rogue", "Assassination");
        specs.put("Rogue", "Outlaw");
        specs.put("Rogue", "Subtlety");
        specs.put("Shaman", "Elemental");
        specs.put("Shaman", "Enhancement");
        specs.put("Warlock", "Affliction");
        specs.put("Warlock", "Demonology");
        specs.put("Warlock", "Destruction");
        specs.put("Warrior", "Arms");
        specs.put("Warrior", "Fury");

    }

    private void startAction(){
        hbxBot.getChildren().remove(btnStart);
        hbxBot.getChildren().add(btnNo);
        hbxBot.getChildren().add(btnYes);
        question(questionIndex);
    }
    private void noAction(){
        answers.put(questionIndex, false);
        questionIndex++;
        question(questionIndex);
        if (questionIndex >= 10){
            calculateResult();
        }

    }
    private void yesAction(){
        answers.put(questionIndex, true);
        questionIndex++;
        question(questionIndex);
        if (questionIndex >= 10){
            calculateResult();
        }
    }

    private void calculateResult(){


        if(answers.get(1) == true){
            specs.remove("Warrior", "Arms");
            specs.remove("Warrior", "Fury");
            specs.remove("Shaman", "Enhancement");
            specs.remove("Rogue", "Assassination");
            specs.remove("Rogue", "Outlaw");
            specs.remove("Rogue", "Subtlety");
            specs.remove("Paladin", "Retribution");
            specs.remove("Monk", "Windwalker");
            specs.remove("Hunter", "Survival");
            specs.remove("Druid", "Feral");
            specs.remove("Death Knight", "Frost");
            specs.remove("Death Knight", "Unholy");
            specs.remove("Demon Hunter", "Havoc");
        }
        else if (answers.get(1) == false){
            specs.remove("Warlock", "Affliction");
            specs.remove("Warlock", "Demonology");
            specs.remove("Warlock", "Destruction");
            specs.remove("Shaman", "Elemental");
            specs.remove("Priest", "Shadow");
            specs.remove("Mage", "Arcane");
            specs.remove("Mage", "Fire");
            specs.remove("Mage", "Frost");
            specs.remove("Hunter", "Beast Mastery");
            specs.remove("Hunter", "Marksmanship");
            specs.remove("Evoker", "Devestation");
            specs.remove("Druid", "Balance");
        }

        if(answers.get(2) == false){
            specs.remove("Death Knight", "Unholy");
            specs.remove("Death Knight", "Frost");
            specs.remove("Druid", "Feral");
            specs.remove("Warlock", "Affliction");
            specs.remove("Warlock", "Demonology");
        }



    }

    private void question(int questionIndex){

        switch (questionIndex){
            case 1:

                lblTop.setText("Question 1");
                lblCenter.setText("I Tend to Mostly Enjoy:");
                btnNo.setText("Melee Combat");
                btnYes.setText("Ranged Combat");

                 break;
            case 2:

                lblTop.setText("Question 2");
                lblCenter.setText("I Am Okay With Slow Ramp-Up");
                btnNo.setText("No");
                btnYes.setText("Yes");
                break;
            case 3:

                lblTop.setText("Question 3");
                lblCenter.setText("I Tend to Mostly Enjoy Dealing With:");
                btnNo.setText("Physical Damage");
                btnYes.setText("Magical Damage");

                break;
            case 4:

                lblTop.setText("Question 4");
                lblCenter.setText("My Spec Needs to be -Easy- to Learn and Play");
                btnNo.setText("No");
                btnYes.setText("Yes");

                break;
            case 5:

                lblTop.setText("Question 5");
                lblCenter.setText("High mobility and movement is very important for my class");
                btnNo.setText("No");
                btnYes.setText("Yes");

                break;
            case 6:

                lblTop.setText("Question 6");
                lblCenter.setText("I NEED to be able to switch to another DPS Spec without Rerolling my Class");
                btnNo.setText("No");
                btnYes.setText("Yes");

                break;
            case 7:

                lblTop.setText("Question 7");
                lblCenter.setText("I want a Focus on:");
                btnYes.setText("AoE Damage");
                btnNo.setText("Single Target");

                break;
            case 8:

                lblTop.setText("Question 8");
                lblCenter.setText("High survivability is important for my class");

                break;
            case 9:

                lblTop.setText("Question 9");
                lblCenter.setText("I NEED to have a required utility for M+ (Battle ress, lust/hero, rogue");
                btnNo.setText("No");
                btnYes.setText("Yes");
                break;
            case 10:

                lblTop.setText("Question 10");
                lblCenter.setText("I NEED to have a required utility for M+ (Battle ress, lust/hero, rogue)");
                btnNo.setText("No");
                btnYes.setText("Yes");
                break;
        }
    }

}

