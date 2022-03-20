/*
Daniel Coelho
PID: 6194506
COP3337 RVC 1211
04/06/2021 
Assignment 3
Dr. Fahad Saeed
 */


import java.util.*;
import java.io.*;

public class Histogram {

    public static int others = 0, ranged = 0;
    public static int[] counts;
    public static Scanner filescan;
    
    // FileNotFound is needed to scan files and tell the program it's properties

    public static void main(String[] args) throws FileNotFoundException {

    	// The start to how the file is printed in reasult1.txt
        PrintWriter out = new PrintWriter("result1.txt");
        counts = new int[10];
        
        //Created a loop for the number of files needed to check and run
        for (int x = 1; x <= 3; x++) {
        	
            String testFileName = "test" + x + ".txt";
            
            // How it will apply in the result
            System.out.println("Readings from file's integers: " + testFileName);
            String filename = testFileName;
            File file = new File(filename);
            try {
                filescan = new Scanner(file);
            }
            
            // Corrupted File error when not found
            catch (Exception e) {
                System.out.println("Corrupted File Error");
                System.exit(0);
            }
            readFiles();
            
            // How the results file will look in the file
            out.println();
            out.println("Reading integers from File: " + testFileName);
            out.println("Number of integers in the interval[1,100]: " + ranged);
            out.println("Others: " + others);
            out.println("Histogram\n");
            
            for (int i = 0; i < 10; i++) {
            	
                // How the result file will look
                out.print(((i * 10) + 1) + " - " + ((i * 10) + 10) + " |");
            for (int j = 0; j < counts[i]; j++)
                out.print("*"); 
                out.println();

            }
        }
        out.close();

    }
    
    // The created method readFile() is going to perform Histogram
    // Setting up what the Histogram
    
    public static void readFiles() {
        try {
            while (filescan.hasNextLine()) {
                int num = filescan.nextInt();

                if (num > 0 && num <= 10)
                    counts[0]++;

                else if (num > 10 && num <= 20)
                    counts[1]++;

                else if (num > 20 && num <= 30)
                    counts[2]++;

                else if (num > 30 && num <= 40)
                    counts[3]++;

                else if (num > 40 && num <= 50)
                    counts[4]++;

                else if (num > 50 && num <= 60)
                    counts[5]++;

                else if (num > 60 && num <= 70)
                    counts[6]++;
                
                else if (num > 70 && num <= 80)
                    counts[7]++;
                
                else if (num > 80 && num <= 90)
                    counts[8]++;
                
                else if (num > 90 && num <= 100)
                    counts[9]++;
                
                else
                    others++;
                
                if (num > 0 && num <= 100)
                    ranged++;
            }
        }
        
        // To keep reading the file until the file is fully read
        catch (Exception e) {
            others++;
            if (filescan.hasNextLine())
                filescan.nextLine();
            readFiles();
        }
    }
}