package com.example.quizgame;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizgame.questions.GenerateQuestion;
import com.example.quizgame.questions.Question;

//TODO Divide this class into smaller classes to follow single responsibility principle
public class Play extends AppCompatActivity {
    private final int optionsCount = 4;
    private final int startQuestionIndex = 0;
    private Button _options[] = new Button[optionsCount];
    private Button _nextButton;

    private TextView _questionText;
    private TextView _scoreText;

    private Question _currentQuestion;
    private Question _previousQuestion;

    private int _questionIndex = startQuestionIndex;

    private int _score = 0;

    private boolean _questionAsked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //TODO Change this part so that questions can be loaded not from java file but from some storage file


        _currentQuestion = Question.AllQuestions[_questionIndex];

        _options[0] = findViewById(R.id.option1);
        _options[1] = findViewById(R.id.option2);
        _options[2] = findViewById(R.id.option3);
        _options[3] = findViewById(R.id.option4);

        _nextButton = findViewById(R.id.next);

        _questionText = findViewById(R.id.Question);
        _scoreText = findViewById(R.id.Score);

        for(int i = 0; i < optionsCount; i++) {
            int ind = i;
            _options[i].setOnClickListener(listener -> TryOption(ind));
        }

        _nextButton.setOnClickListener(listener -> SetNewQuestion());

        RefreshPage();
    }

    private void TryOption(int option){
        if(_previousQuestion == _currentQuestion) {
            return;
        }


        if(CheckOption(_currentQuestion, option) == true){
            _score++;
        }

        _options[option].setBackgroundColor(getResources().getColor(R.color.red));
        _options[_currentQuestion.rightOption].setBackgroundColor(getResources().getColor(R.color.green));


        _previousQuestion = _currentQuestion;
    }

    private void SetNewQuestion(){
        if(_questionIndex + 1 < Question.AllQuestions.length){
            //ChangeQuestion(Question.AllQuestions[++_questionIndex]);
            ChangeQuestion(GenerateQuestion.GenerateIntQuestion());
            RefreshPage();
        }
        else{
            End();
        }
    }

    private boolean CheckOption(Question question, int option){
        if(option == question.rightOption) {
            return true;
        }
        else {
            return false;
        }
    }

    private void ChangeQuestion(Question newQuestion){
        _currentQuestion = newQuestion;
    }

    private void RefreshPage(){
        _questionText.setText(_currentQuestion.question);
        _scoreText.setText("Score: " + _score);

        for(int i = 0; i < optionsCount; i++){
            _options[i].setText(_currentQuestion.options[i]);
            _options[i].setBackgroundColor(getResources().getColor(R.color.btn_default));
        }
    }

    private void End(){
        //TODO Add something in the end of quiz

        Log.i("MY_MESSAGES", "End of quiz.");
    }
}