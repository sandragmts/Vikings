
package com.example.android.vikings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Welcome extends AppCompatActivity {

    /**
     * Initial score int
     */

    int correctAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        // **get the text from MainActivity
        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        // use the text in a TextView
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }

    /**
     * Display quiz score result in a toast
     */


    public void submitAnswers(View view) {
        int correctAnswers = getPlayerScore();
        String scoreMessage = ("Your score is " + correctAnswers + " out of 12 points");
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

        /**Create method to open page results*/

        if (correctAnswers >= 10) {
            startActivity(new Intent(this, ResultsWin.class));
        } else if (correctAnswers >= 6 & correctAnswers <= 8) {
            startActivity(new Intent(this, ResultsMid.class));
        } else if (correctAnswers < 4) {
            startActivity(new Intent(this, ResultsTry.class));

        }
    }


    /**
     * Calculate quiz score result
     */
    private int getPlayerScore() {
        int correctAnswers = 0;
        correctAnswers = ScoreQuestionOne() + ScoreQuestionTwo() + ScoreQuestionThree() + ScoreQuestionFour() +
                ScoreQuestionFive() + ScoreQuestionSix();
        return correctAnswers;
    }

    /**
     * Check Score for Question Six
     */

    private int ScoreQuestionSix() {
        EditText sixthTextBox = (EditText) findViewById(R.id.sixth_question);
        String questionOneAnswer = sixthTextBox.getText().toString();
        if (questionOneAnswer.equalsIgnoreCase("pirate raid")) {
            return 2;
        } else return 0;
    }

    /**
     * Check Score for Question One
     */

    private int ScoreQuestionOne() {

        int questionOneScore = 0;

        CheckBox germanyOne = findViewById(R.id.option1_question1);
        CheckBox icelandTwo = findViewById(R.id.option2_question1);
        CheckBox norwayThree = findViewById(R.id.option3_question1);
        CheckBox russiaFour = findViewById(R.id.option4_question1);

        if (russiaFour.isChecked()) {
            questionOneScore = +0;
        } else if (germanyOne.isChecked() && icelandTwo.isChecked() && norwayThree.isChecked()) {
            questionOneScore = +2;
        }

        return questionOneScore;
    }

    /**
     * Check Score for Question Two
     */

    private int ScoreQuestionTwo() {
        RadioButton trueRadioButton = findViewById(R.id.option1_question2);
        if (trueRadioButton.isChecked()) {
            return 2;
        } else return 0;
    }


    /**
     * Check Score for Question Three
     */


    private int ScoreQuestionThree() {
        RadioButton valkyrieRadioButton = findViewById(R.id.option1_question3);
        if (valkyrieRadioButton.isChecked()) {
            return 2;
        } else return 0;
    }

    /**
     * Check Score for Question Four
     */

    private int ScoreQuestionFour() {

        int questionFourScore = 0;

        CheckBox thorOne = findViewById(R.id.option1_question4);
        CheckBox odinTwo = findViewById(R.id.option2_question4);
        CheckBox ragnarokThree = findViewById(R.id.option3_question4);
        CheckBox freyjaFour = findViewById(R.id.option4_question4);

        if (ragnarokThree.isChecked()) {
            questionFourScore = +0;
        } else if (thorOne.isChecked() && odinTwo.isChecked() && freyjaFour.isChecked()) {
            questionFourScore = +2;
        }

        return questionFourScore;
    }


    /**
     * Check Score for Question Five
     */

    private int ScoreQuestionFive() {
        RadioButton tuesdayRadioButton = findViewById(R.id.option2_question5);
        if (tuesdayRadioButton.isChecked()) {
            return 2;
        } else return 0;
    }


}


