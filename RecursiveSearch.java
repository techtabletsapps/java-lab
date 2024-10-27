import java.io.IOException;
import reader.Reader;

public class RecursiveSearch {

    public static int linearSearch(String[] arr, int index, String element) {

        if (index >= arr.length) {
            return -1;
        }
        if (Integer.parseInt(arr[index]) == Integer.parseInt(element)) {
            return index;
        }

        return linearSearch(arr, index + 1, element);
    }


    public static void main(String[] args) throws IOException {
        String path = args[0];
        String target = args[1];
        String type = args[2];
        String[] data = Reader.parseCSV(path, type);

        int result = linearSearch(data, 0, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
