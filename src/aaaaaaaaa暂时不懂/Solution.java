package aaaaaaaaa暂时不懂;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersCount; i++) {
            int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
            numbers.add(numbersItem);
        }

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.countPairs(numbers, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
