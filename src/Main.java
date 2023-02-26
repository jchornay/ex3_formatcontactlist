/*
 * CMSY 167-N090 Spring 2023
 * Exercise: Format Contact List
 * Copyright 2023 Howard Community College
 * @author Jonathan Chornay
 * @v1.0
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //creates new path object using relative path of contacts list (same directory as java project)
        Path path = Paths.get("contacts.txt");

        //try catch block for scanner using newly created path as input
        try(Scanner input = new Scanner(path)){

            //try catch block for creation of new file
            try(Formatter output = new Formatter("formatted-contacts.txt")) {

            //iterates loop until end of file
            while(input.hasNext()){

                    //saves current line as string
                    String currentLine = input.nextLine();

                    //splits current line into tokens delimited by comma
                    String[] tokens = currentLine.split(",");

                    //rearranges tokens and adds to output file
                    output.format("\n%s, %s <%s>", tokens[2], tokens[1], tokens[3]);

                }

            }

            //catches errors for file creation
            catch(FileNotFoundException error){
                error.printStackTrace();
            }

        }

        //catches errors for file reading
        catch (IOException | NoSuchElementException | IllegalStateException error){
            error.printStackTrace();
        }

    }
}