package com.example.quizgame.questions;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateQuestion {

    private static <T> List<T> convertArrayToList(T array[])
    {

        // Create an empty List
        List<T> list = new ArrayList<>();

        // Iterate through the array
        for (T t : array) {
            // Add each element into the list
            list.add(t);
        }

        // Return the converted List
        return list;
    }
    private static int GetRandomInt(int min, int max){
        return (int)(Math.random() * (max - min) + min);
    }

    private static char GetRandomOperation(){
        int num =  GetRandomInt(0, 100);

        if(num < 25){
            return '-';
        }
        else {
            return '+';
        }
        /*
        else if(num > 50 && num < 75){
            return '/';
        }
        else{
            return '*';
        }*/
    }
    public static Question GenerateIntQuestion(){
        int num1 = GetRandomInt(0, 100);
        int num2 = GetRandomInt(0, 100);

        int result = 0;

        char operation = GetRandomOperation();

        if(operation == '-'){
            result = num1 - num2;
        }
        else{
            result = num1 + num2;
        }

        String question = num1 + " " + Character.toString(operation) + " " +num2 + " = ";
        ArrayList<String> optionsList = new ArrayList<String>();
        optionsList.add(result+"");
        optionsList.add(GetRandomInt(-100, 100)+"");
        optionsList.add(GetRandomInt(-100, 100)+"");
        optionsList.add(GetRandomInt(-100, 100)+"");

        Collections.shuffle(optionsList);

        int rightOption = 0;

        for(int i = 0; i < optionsList.size(); i++){
            Log.i("BUGAGA", (result + "") + " " + optionsList.get(i) + " " + ((result + "") == optionsList.get(i)));
            if((result + "").equals(optionsList.get(i))){
                rightOption = i;
            }
        }

        Question newQuestion = new Question(
                question,
                optionsList.toArray(new String[0]),
                rightOption);

        return newQuestion;
    }

}
