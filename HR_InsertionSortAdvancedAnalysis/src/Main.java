import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static long insertionSort(int[] arr) {
        ISolution solution = new BITSolution();
        return solution.countNumOfSwaps(arr);
    }

    public static void main(String[] args) throws IOException {
        String testName = "00";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("tests/" + testName + ".txt"));
        Scanner scanner = new Scanner(bufferedReader);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long[] expectedOutput = parseExpectedResults("tests/" + testName + "_expected.txt");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long expected = expectedOutput[tItr];

            long result = insertionSort(arr);

            System.out.println(result + " - " + (result == expected ? "OK, correct" : " NO, differs from expected " + expected));
        }

        scanner.close();
    }

    private static long[] parseExpectedResults(String path) throws FileNotFoundException {
        List<Long> expected = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(path)));
            while (scanner.hasNext()) {
                expected.add(scanner.nextLong());
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }
        }
        finally {
            if (scanner != null)
                scanner.close();
        }

        int n = expected.size();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = expected.get(i);
        }
        return arr;
    }
}
