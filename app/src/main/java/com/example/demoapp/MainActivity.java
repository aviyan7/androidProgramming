package com.example.demoapp;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//    private TextView mQuestionTextView;
//    private RadioGroup mAnswerRadioGroup;
//    private RadioButton mAnswerRadioButton1;
//    private RadioButton mAnswerRadioButton2;
//    private RadioButton mAnswerRadioButton3;
//    private RadioButton mAnswerRadioButton4;
//    private Button mNextButton;
//
//    private String[][] mQuestions = {
//            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid"},
//            {"What is the largest country in the world?", "Russia", "Canada", "China", "United States"},
//            {"What is the currency of Japan?", "Yen", "Dollar", "Euro", "Pound"}
//    };
//
//    private int mCurrentIndex = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mQuestionTextView = findViewById(R.id.question_text_view);
//        mAnswerRadioGroup = findViewById(R.id.answer_radio_group);
//        mAnswerRadioButton1 = findViewById(R.id.answer_radio_button_1);
//        mAnswerRadioButton2 = findViewById(R.id.answer_radio_button_2);
//        mAnswerRadioButton3 = findViewById(R.id.answer_radio_button_3);
//        mAnswerRadioButton4 = findViewById(R.id.answer_radio_button_4);
//        mNextButton = findViewById(R.id.next_button);
//
//        updateQuestion();
//
//        mNextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkAnswer();
//                mCurrentIndex++;
//                if (mCurrentIndex < mQuestions.length) {
//                    updateQuestion();
//                } else {
//                    endQuiz();
//                }
//            }
//        });
//
//        private void updateQuestion() {
//            String question = mQuestions[mCurrentIndex][0];
//            String answer1 = mQuestions[mCurrentIndex][1];
//            String answer2 = mQuestions[mCurrentIndex][2];
//            String answer3 = mQuestions[mCurrentIndex][3];
//            String answer4 = mQuestions[mCurrentIndex][4];
//        }
//    }
//}


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionView;
    private RadioGroup radioGroup;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;
    private Button nextButton;

    int index =0;
    ArrayList<quiz> quizzes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        quizzes.add(new quiz("How", "Are", "U", "Aviyan", "Dahal", "Are"));
        quizzes.add(new quiz("I", "am", "Fine", "What", "about", "I"));
        quizzes.add(new quiz("U", "I", "am", "also", "fine", "U"));
        quizzes.add(new quiz("Oh", "Its", "good", "to", "hear", "hear"));


        questionView = findViewById(R.id.question_text_view);
        radioGroup = findViewById(R.id.answer_radio_group);
        answer1 = findViewById(R.id.answer_radio_button_1);
        answer2 = findViewById(R.id.answer_radio_button_2);
        answer3 = findViewById(R.id.answer_radio_button_3);
        answer4 = findViewById(R.id.answer_radio_button_4);
        nextButton = findViewById(R.id.next_button);

//        questionView = quizzes.get(question);

        setUpQuizView(index);

        answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                 checkAnswerAndMoveOn(compoundButton.getText().toString());
                }
            }
        });answer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                 checkAnswerAndMoveOn(compoundButton.getText().toString());
                }
            }
        });answer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                 checkAnswerAndMoveOn(compoundButton.getText().toString());
                }
            }
        });answer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                 checkAnswerAndMoveOn(compoundButton.getText().toString());
                }
            }
        });

    }

    private void setUpQuizView(int index){
        questionView.setText(quizzes.get(index).question);
        answer1.setText(quizzes.get(index).answer1);
        answer2.setText(quizzes.get(index).answer2);
        answer3.setText(quizzes.get(index).answer3);
        answer4.setText(quizzes.get(index).answer4);

    }

    private void  checkAnswerAndMoveOn(String opt){
      //  String opt = compoundButton.getText().toString();
        if (opt.equalsIgnoreCase(quizzes.get(index).correctAnswer)){

        }else {

        }

        index = index+1;
        setUpQuizView(index);

    }


}


