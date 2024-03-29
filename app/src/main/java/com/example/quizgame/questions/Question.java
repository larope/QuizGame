package com.example.quizgame.questions;

public class Question {
    public Question(String question, String[] options, int rightAnswer){
        this.question = question;
        this.Options = options;
        this.rightAnswer = rightAnswer;
    }
    public static Question[] AllQuestions = new Question[]{
            new Question(
                    "1+1=",
                    new String[]{"2", "3", "1", "4"},
                    0
                    ),
            new Question(
                    "23+22",
                    new String[]{"43", "67", "55", "7"},
                    2
            ),
            new Question(
                    "80-90",
                    new String[]{"0", "-10", "-20", "10"},
                    1
            ),
            new Question(
                    "0*7",
                    new String[]{"0", "7", "5", "5"},
                    0
            ),
    };

    public String question;
    public String[] Options = new String[4];
    public int rightAnswer;
}
