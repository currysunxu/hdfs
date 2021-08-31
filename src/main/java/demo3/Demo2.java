package demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo2 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            System.out.println("invalid array");
        }
        List<String> list = Arrays.asList(strs);
        list.sort((a,b)-> a.length() - b.length());
        String theShortestText = list.get(0);
        if (list.size()==1){
            return theShortestText;
        }
        boolean flag = false;
        char[] chars = theShortestText.toCharArray();
        for (int j = chars.length; j > 0; j--) {
            theShortestText = theShortestText.substring(0,j);
            for (int i = 1; i < list.size(); i++) {
                if (!list.get(i).startsWith(theShortestText)){
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag){
                return theShortestText;
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        String[] strings = new String[]{"flower","flow","flight"};
        String[] strings = new String[]{"d"};
        String result = new Demo2().longestCommonPrefix(strings);
        System.out.println(result);
    }
}
