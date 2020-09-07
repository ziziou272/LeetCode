/*
CS5004 - PS3 - Problem_1
Author: Zongwei Fan
Last Changed: Jan 31, 2020
 */
import java.io.*;
import java.util.Scanner;

public class Encrypt {

    public static void main(String[] args) throws IOException {
        // open the input file
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new FileInputStream(args[0]));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(0);
        }

        // prompts the user to enter a key k
        Scanner inputk = new Scanner(System.in);
        System.out.println("Enter a key k:");
        int k = inputk.nextInt();

        // open the output file
        BufferedWriter outputFile = null;
        try {
            outputFile = new BufferedWriter(new FileWriter(args[1]));
        }
        catch (IOException excpt)
        {
            System.out.println("File not found.");
            excpt.printStackTrace();
        }

        // encrypt the input file and write the encrypted file to the output file
        while (inputFile.hasNextLine()) {
            String content = inputFile.nextLine();
            char[] contentChar = content.toCharArray();
            k = k % 26;
            for (char c : contentChar) {
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c)) {
                        c = (c + k > 90) ? (char) (c + k - 26) : (char)(c + k);
                    }
                    else {
                        c = (c + k > 122) ? (char) (c + k - 26) : (char)(c + k);
                    }
                }
                outputFile.write(c);
            }
            outputFile.newLine();
        }

        inputFile.close();
        outputFile.close();
    }
}
