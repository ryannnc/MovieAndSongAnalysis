package tests;

import org.junit.Assert;
import org.junit.Test;
import ratings.ProblemSet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblemSet {
    @Test
    public void average(){
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(1.0);
        arr.add(2.0);
        arr.add(3.0);
        assertEquals(2.0,ProblemSet.average(arr), 0.001);
        ArrayList<Double> arr2 = new ArrayList<>();
        arr2.add(-5.0);
        arr2.add(5.0);
        assertEquals(0.0,ProblemSet.average(arr2),0.001);
        ArrayList<Double> arr3 = new ArrayList<>();
        arr3.add(6.5);
        arr3.add(6.5);
        arr3.add(8.5);
        arr3.add(8.5);
        assertEquals(7.5,ProblemSet.average(arr3),0.0001);
        ArrayList<Double> arr4 = new ArrayList<>();
        assertEquals(0.0,ProblemSet.average(arr4),0.001);
        ArrayList<Double> arr5 = new ArrayList<>();
        arr5.add(2.0);
        assertEquals(2.0,ProblemSet.average(arr5),0.001);
    }
    @Test
    public void testsumOfDigits(){
        assertTrue(ProblemSet.sumOfDigits(123) == 6);
        assertTrue(ProblemSet.sumOfDigits(57)== 12);
        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
    }

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    @Test
    public void testbestKey() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("CSE", 100);
        map.put("MTH", 90);
        map.put("MGT", 10);

        assertEquals(ProblemSet.bestKey(map), ("CSE"));
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("cat", 5);
        map2.put("dog", 5);
        map2.put("fox", 4);
        String result = ProblemSet.bestKey(map2);
        assertTrue(result.equals("cat") || result.equals("dog"));
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("dog", -6);
        map3.put("cat", 5);
        map3.put("fox", 4);
        assertEquals(ProblemSet.bestKey(map3), ("cat"));
        HashMap<String, Integer> map4 = new HashMap<>();

        assertEquals(ProblemSet.bestKey(map4), (""));

        HashMap<String, Integer> map5 = new HashMap<>();
        map5.put("neg", -1);
        map5.put("as", -4);
        map5.put("aw", -7);
        assertEquals(ProblemSet.bestKey(map5), ("neg"));
    }
}
