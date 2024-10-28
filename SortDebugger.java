
import java.util.Arrays;

public class SortDebugger {


    public static void debugSort(int[] array) {
        int i, j, key;

        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        int[] compromisedData = convertArray(args);
        debugSort(compromisedData);
        
        for (int d : compromisedData) {
          System.out.print(d + " ");
        }
        System.out.println();
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

