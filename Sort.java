
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reader.Reader;

public class SingleSort {



    public static void sort(String[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            String keyRow = data[i];   // entire row data
            String key = keyRow.split(",")[0]; // account number
            float keyValue = Integer.parseInt(key);
            int j = i - 1;
            
            while (j >= 0 && Integer.parseInt(data[j].split(",")[0]) < keyValue) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = keyRow;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        List<String> data = new ArrayList<>();
        List<String> noHeader = new ArrayList<>();

        data = Reader.readCSV(path);
        noHeader = data.subList(1, data.size());
        String[] arr = new String[noHeader.size()];
        arr = noHeader.toArray(arr);
        sort(arr);

        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);
    }
}
