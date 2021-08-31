package DemoC;

import net.minidev.json.JSONUtil;

public class Demo {
    /**
     * () [] {}
     */

    public static boolean stringCheck(String text){
        boolean result =false;
        if (null==text){
            System.out.println("raise exception");
        }
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (text.contains("(") || text.contains("{")){
                if (chars[text.indexOf("(")+1]==')' && text.indexOf("(")!=chars.length){
                    result = true;
                    continue;
                }else {
                    result = false;
                }
                if (chars[text.indexOf("{")+1]=='{' && text.indexOf("{")!=chars.length){
                    result = true;
                    continue;
                }else {
                    result = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result = stringCheck("abv{(}ax)");
        System.out.println(result);
    }
}
