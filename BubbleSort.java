
public class ModifiedBubble {

    public static int[] findAccessLevel(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] < nums[i + 1]) {
          int temp = nums[i];
          nums[i] = nums[i + 1];
          nums[i + 1] = temp;
        }
      }
      return nums;
    }

    public static void main(String[] args) {
        int[] secretCodes = convertArray(args);
        int[] sorted = findAccessLevel(secretCodes);
        System.out.println("The access level is: " + sorted[sorted.length - 1]);
    }

    public static int[] convertArray(String[] nums) {
      int len = nums.length;
      int[] ints = new int[len];

      for(int i = 0; i < len; i++) {
        ints[i] = Integer.parseInt(nums[i]);
      }

      return ints;
    }
}
