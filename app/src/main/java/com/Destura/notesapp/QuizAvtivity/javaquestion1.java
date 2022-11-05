package com.Destura.notesapp.QuizAvtivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Destura.notesapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class javaquestion1 extends AppCompatActivity {

    private TextView tvQuestion, tvScore,tvQuestionNo,tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3,rb4;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score;

    ColorStateList dfRbcolor;
    boolean answered;

    CountDownTimer countDownTimer;

    private QuistionModel currentQuestion;

    private List<QuistionModel> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaquestion1);

        questionsList = new ArrayList<>();
        tvQuestion = findViewById(R.id.textQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo= findViewById(R.id.textQuestionNo);
        tvTimer = findViewById(R.id.textTimer);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnNext = findViewById(R.id.btnNext);

        dfRbcolor = rb1.getTextColors();

        addQuestions();

        totalQuestions = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();

                    }else {
                        Toast.makeText(javaquestion1.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();

                }
            }
        });



    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score: "+score);

        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalQuestions){
            btnNext.setText("Next");
        }else{
            btnNext.setText("Finish");
        }

    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbcolor);
        rb2.setTextColor(dfRbcolor);
        rb3.setTextColor(dfRbcolor);
        rb4.setTextColor(dfRbcolor);


        if(qCounter<totalQuestions){
            Collections.shuffle(questionsList);
            timer();
            currentQuestion=questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            qCounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question: "+qCounter+"/"+totalQuestions);
            answered = false;

        }else{
            finish();
        }

    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                tvTimer.setText("00: "+ l/1000);

            }

            @Override
            public void onFinish() {
                showNextQuestion();

            }
        }.start();
    }

    private void addQuestions() {
        questionsList.add(new QuistionModel("1. What is the maximum possible length of an identifier?","A.16","B.32","64","D.None of the above",4));
        questionsList.add(new QuistionModel("2. Who developed the Python language?","A. Zim Den","B. Guido van Rossum","C. Niene Stom","D. Wick van Rossum",2));
        questionsList.add(new QuistionModel("3. In which year was the Python language developed?","A. 1995","B. 1972","C. 1989","1981",3));
        questionsList.add(new QuistionModel("4.  In which language is Python written?","A. English","B. PHP","C.All of the above","D. C",4));
        questionsList.add(new QuistionModel("5. Which one of the following is the correct extension of the Python file?","A. py","B. .python","C. p","D. None of these",1));


    }
}
