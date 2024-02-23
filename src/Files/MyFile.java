package Files;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class MyFile {
    String fileName = "myFile.txt";
    File myFileObject;

    public MyFile() {
        createFile(); //creates a file
        write2File(); //Writes to a file
        readFromFile();
    }

    private void readFromFile() {
        //Reads the contents of the file with a scanner and writes it out
        try {
            Scanner myFileScanner = new Scanner(myFileObject);
            while (myFileScanner.hasNext()) {
                System.out.println(myFileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Could not read from file");
        }

    }

    private void write2File() {
        //Captures input from user and writes it then down in the file
        try {
            Scanner myKeyScanner = new Scanner(System.in);
            System.out.println("Do you want to overwrite the file? (y/n)");
            if (Objects.equals(myKeyScanner.nextLine(), "y")) {
                FileWriter myWriterObject = new FileWriter(fileName, false);
                System.out.println("What do you want to write in the file?");
                myWriterObject.write(myKeyScanner.nextLine());
                myWriterObject.close();
                System.out.println("I wrote to file " + fileName);
            } else {
                FileWriter myWriterObject = new FileWriter(fileName, true);
                System.out.println("What do you want to write in the file?");
                myWriterObject.write(myKeyScanner.nextLine());
                myWriterObject.close();
                System.out.println("I wrote to file " + fileName);
            }
        } catch (IOException e) {
            System.out.println("could not write to file");
        }
    }

    public void createFile() {
        //Creates a file
        myFileObject = new File(fileName);
        try {
            if (myFileObject.createNewFile()) {
                System.out.println(fileName + " has been created");
            } else {
                System.out.println(fileName + " already exists");
            }

        } catch (IOException ioErr) {
            System.out.println("file could not be created");

        } catch (Exception generalException) {
            System.out.println("something went wrong");
        }

    }


}