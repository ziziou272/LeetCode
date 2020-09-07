package blackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Problem2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

    }

    public static void doSomething(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes

        // corner: if pattern is empty
        if (pattern.equals("")) {
            System.out.println("0|0|0|0|0");
            return;
        }

        // init res
        String res = "";

        // traverse the blobs
        int sum = 0;
        int blobStart = 0;
        while (blobStart < blobs.length()) {
            // find the blob end
            int blobEnd = blobStart;
            while (blobEnd < blobs.length()) {
                if (blobs.charAt(blobEnd) == '|') break;
                blobEnd++;
            }

            int freq = 0;
            // take the substrings with same length as pattern
            for (int start = blobStart; start + pattern.length() - 1 < blobEnd; start++) {
                int end = start + pattern.length() - 1;
                String sub = blobs.substring(start, end + 1);
                // if meet pattern, add to freq
                if (sub.equals(pattern)) freq++;
            }
            // add to res
            res = res + freq;
            res = res + "|";

            // update blobStart
            blobStart = blobEnd + 1;
            sum += freq;
        }

        // add the final sum part
        res += sum;
        System.out.println(res);

    }
}