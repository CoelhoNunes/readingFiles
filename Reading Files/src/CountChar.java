/*
Daniel Coelho
PID: 6194506
COP3337 RVC 1211
04/06/2021 
Assignment 3
Dr. Fahad Saeed
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class CountChar {

    // Stating the file 
	public static final String filename = "Alice's_Adventures_in_Wonderland.txt";
    
    // Creating what is should be looking for

    public static final List<Character> 
    	punctuationList = Arrays.asList( '.', ',', ':', ';', '-', '_', '(',
								         ')', '{', '}', '[', ']', '!', '!',
								         '?', '/', '\'', '"', '&', '`' );

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        
        //All of the integers 
        
        int 	lowercase = 0, 
        		uppercase = 0, 
        		punctuations = 0, 
        		whitespaces = 0, 
        		others = 0;
        
        // Searching for parameters
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            for (int i = 0; i < line.length(); ++i) {
                char ch = line.charAt(i);

                if (Character.isLowerCase(ch)) {
                    ++lowercase;
                }
                else if (Character.isUpperCase(ch)) {
                    ++uppercase;
                }
              
                else if (Character.isWhitespace(ch)) {
                    ++whitespaces;
                }
                else if (punctuationList.contains(ch)) {
                    ++punctuations;
                }
                else {
                    ++others;
                }
            }
        }
        
        // Print out in results2.txt
        PrintWriter Res2 = new PrintWriter("results2.txt");
        Res2.println("Number of uppercase letters: " + uppercase);
        Res2.println("Number of lowercase letters: " + lowercase);
        Res2.println("Number of punctuation marks: " + punctuations);
        Res2.println("Number of whitespaces: " + whitespaces);
        Res2.println("Number of others: " + others);
        Res2.close();
        fileScanner.close(); 
      
    }
}