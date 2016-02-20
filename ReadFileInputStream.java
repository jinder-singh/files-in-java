/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitprojectsReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Jinder Singh treams {
 *
 */
public class ReadFileInputStream {

    ReadFileInputStream() {
        //create a local varibale to store txt file path
        String userInput;
        
        //ask to the user for file path
        System.out.println("File path (only txt files): ");
        
        //store user's input
        userInput = readLine();
        
        //returns true if file specified by user is a .txt file
        if (userInput.substring(userInput.indexOf(".") + 1).equalsIgnoreCase("txt")) {
            //we call openfile method
            openFile(userInput);
        } else {
            System.out.println("No suitable file extension");
        }
    }
    //returns what user has been typing
    private String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    
    //we pass a path as a parameter
    private void openFile(String path) {
        
        //declare variable of type FileInputStream and BufferedStream.
        FileInputStream fi;
        BufferedReader br;

        try {
            
            fi = new FileInputStream(path);//creates an object and passing a string(file path).
            br = new BufferedReader(new InputStreamReader(fi));
            String lines;//declare variable to store lines while reading.

            //while loop will end when the varibale lines is null
            while ((lines = br.readLine()) != null) {
                System.out.println(br.readLine());//printing lines
            }
            
            //close bufferedStream and fileStream
            br.close();
            fi.close();

        } catch (FileNotFoundException ex) {
            //throws exception when the specified file is not founded
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadFileInputStream readWithStreams = new ReadFileInputStream();
    }
}
