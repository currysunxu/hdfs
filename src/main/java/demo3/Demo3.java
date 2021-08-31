package demo3;

import java.util.LinkedHashMap;

public class Demo3 {

/*    you are given an array of N integers. you want to split them into N/2 pairs in such a way that
    the sum of integers in each pair is odd. N is even and every element of the array must be present in exactly one pair

    your task is to dertemine wheter it is possible to split the numbers into such pairs.
    For ex, given[2,7,4,6,3,1],
    the answer is true, one of the possible set of pairs is (2,7),(6,3),(4,1).
    The sum are respectively 9,9,5 which are all odd.

    1) given A = [2,7,4,6,3,1] should return true, as explained above
    2) given A = [-1,1] should return false, possible pair are (-1,1) which is -1+1 = 0
    3) given A = [2,-1], should return true. only one pair has sum odd which is -1+2 = 1
    4) given A = [1,2,4,3] should return true. possible pairs = (1,2)(4,3)*/
    public static boolean calculation(int[] array){
        if (array.length==0){
            System.out.println("raise exception");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i+=2) {
            sum= array[i]+array[i+1];
            if (sum%2 ==0){
                return false;
            }
        }
        return true;
    }

    public static String removeDuplicate(String text){
        StringBuilder sb = new StringBuilder();
        String str = "";
        char[] chars = text.toCharArray();
        for (char c:chars) {
            if (!sb.toString().contains(String.valueOf(c))) {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }

    public static String compressString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        char[] ca=s.toCharArray();
        char cur=ca[0];
        int curCount=1;
        StringBuilder res=new StringBuilder();
        res.append(ca[0]);
        for(int i=0;i<ca.length-1;i++){
            if(cur==ca[i+1]){
                curCount++;
                if(i==ca.length-2) res.append(curCount); //last index need append
            }else{
                cur=ca[i+1];
                res.append(curCount);
                res.append(cur);
                curCount=1;
                if(i==ca.length-2) res.append(curCount); // last index
            }
        }
        return res.toString().length()<s.length()?res.toString():s;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,7,4,6,3,1};
        boolean result = calculation(test);
        String result2 = removeDuplicate("testtttcccassaaa");
        String result3 = compressString("aabbbccddddya");
        System.out.println(result3);
    }
}
