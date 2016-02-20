/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitprojectsReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jinder Singh
 */
public class GitProjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Create a new instance of Scanner clas to read from keyboard
        Scanner sc = new Scanner(System.in);

        //printout msg in the console
        System.out.println("Introduce file path to read with txt extension: ");

        //save in variable, user's input
        String path = sc.nextLine();
        String paths = path.substring(path.indexOf(".") + 1);

        //returns true if the extension of file is txt.
        boolean txt = paths.equalsIgnoreCase("txt");
        //call openFile metodo to which pass path of txt file

        try {
            if (txt) {
                openFile(path);
            } else {
                throw new Exception("Invalid extension");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    private static void openFile(String path) {
        //we declare variables of type FileReader and BufferedReader.
        FileReader fr = null;
        BufferedReader br = null;

        //In this varibale save the extension of file.(Only txt file)
        try {

            //create a instance of file class which takes a path from arguments.
            File f = new File(path);

            //condition to check the path that user has specified is a file.
            if (f.isFile()) {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                String lines;
                while ((lines = br.readLine()) != null) {
                    System.out.println(lines);
                }
            } else {
                throw new Exception("It is not a file o haven't specify extension");
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException  e) {
            System.out.println(e.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
