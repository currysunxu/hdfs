package demo3;

public class Demo {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            System.out.print("invalid array");
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle+1;
            } else {
                end = middle-1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (target> nums[i]){
                continue;
            }else {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Demo interview = new Demo();
        int[] array = new int[]{-1, 0, 3, 5, 9, 12};
        int result = interview.search(array, 22);
        System.out.println(result);
    }
}
