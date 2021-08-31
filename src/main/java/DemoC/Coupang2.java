package DemoC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Coupang2 {

    public static int checkSum(int[] nums){
//        Arrays.sort(nums);
        int sum =0;
        int result = nums[0];
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                sum=sum+nums[j];
//                result = Math.max(sum, result);
                list.add(sum);
            }
            sum=0;
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = checkSum(arrays);
//        int result = maxSubArray(arrays);
        System.out.println(result);
    }
}
