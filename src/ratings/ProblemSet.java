package ratings;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProblemSet {

    public static double sum(ArrayList<Double> arrIn) {
        double out = 0;
        for (int x = 0; x < arrIn.size(); x++) {
            out += arrIn.get(x);

        }
        return out;
    }

    public static double average(ArrayList<Double> input) {
        if (input.isEmpty()){
            return 0.0;
        } else if (input.size() ==1 ){
            return 0.0;
        }
        double total = sum(input);
        double count = input.size();
        double avg = total / count;
        return avg;



    }

//test case with average with 1 number




    //public static ArrayList<Double> average(ArrayList<Double> numbers)

    //return 0.0;

    // TODO: Implement this method to return the average of all the numbers in the input ArrayList
    //       If the ArrayList is empty, return 0.0
    //
    // Examples
    // [1.0,2.0,3.0] returns 2.0
    // [-5.0,5.0] returns 0.0
    // [6.5,6.5,8.5,8.5] returns 7.5
    // [] returns 0.0


    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number = number/10;
        }


        return sum;
    }



    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9


    public static String bestKey(HashMap<String,Integer> input) {
        int max = 0;
        String maxkey = "";
        if (input.isEmpty()){
            return maxkey;
        }

        for (Map.Entry<String, Integer> entry : input.entrySet()){
                int value = entry.getValue();
                String key = entry.getKey();

                if (value >= 0 && value > max){
                    max = value;
                    maxkey = key;

            }

        }
        return maxkey;




    }
}


    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""


