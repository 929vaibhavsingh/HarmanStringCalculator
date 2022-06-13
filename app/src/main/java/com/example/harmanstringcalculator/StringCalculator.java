package com.example.harmanstringcalculator;

public class StringCalculator {
    //This method will handle various cases for string calculation
    public static int add(String text){
        if(text.equals("")){
            return 0;
        }
        else{
            String delimiter = ",";
            if(text.matches("//(.*)\n(.*)")){
                delimiter = Character.toString(text.charAt(2));
                text = text.substring(4);
            }

            String[] numList = splitNumbers(text, delimiter + "|\n");
            return totalSum(numList);
        }
    }

    private static int convertToInt(String number){
        return Integer.parseInt(number);
    }

    private static String[] splitNumbers(String numbers, String divider){
        return numbers.split(divider);
    }

    private static int totalSum(String[] numbers){
        int sumTotal = 0;
        StringBuilder negString = new StringBuilder();

        for(String number : numbers){
            if(convertToInt(number) < 0){
                if(negString.toString().equals(""))
                    negString = new StringBuilder(number);
                else
                    negString.append(",").append(number);
            }
            if(convertToInt(number) < 1000)
                sumTotal += convertToInt(number);
        }

        if(!negString.toString().equals("")){
            throw new IllegalArgumentException("-ve values are not allowed: " + negString);
        }

        return sumTotal;
    }
}
