package Files;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class MyFile {
    String fileName = "myFile.txt";
    String wFile = "words.txt";
    File myFileObject;
    File wFileObject = new File(wFile);

    public MyFile() {
        createFile(); //creates a file
        //write2File(); //Writes to a file
        //readFromFile();
        //readAndSortNames();
        readFromWFile();
    }

    private void readFromWFile() {
        // Reads from the other file with words then keeps track of the longest word and after scanning through prints out the word it found
        try {
            Scanner myFileScanner = new Scanner(wFileObject);
            String longestWord = "";

            while (myFileScanner.hasNext()) {
                String currentWord = myFileScanner.next();

                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
            }

            System.out.println("Longest Word: " + longestWord);

        } catch (IOException e) {
            System.out.println("Could not read from file");
        }
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

    private void readAndSortNames() {
        //Reads the names in the file then by comparing them we sort them in alphabetical order
        try {
            Scanner myFileScanner = new Scanner(myFileObject);

            String[] namesArray = new String[15];
            int count = 0;

            while (myFileScanner.hasNext()) {
                namesArray[count] = myFileScanner.nextLine();
                count++;
            }

            sort(namesArray, count);

            System.out.println("Sorted Names:");
            for (int i = 0; i < count; i++) {
                System.out.println(namesArray[i]);
            }

        } catch (IOException e) {
            System.out.println("Could not read from file");
        }
    }

    private void sort(String[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void write2File() {
        //Captures input from user and writes it then down in the file
        try {
            Scanner myKeyScanner = new Scanner(System.in);
            System.out.println("Do you want to overwrite the file? (y/n)");
            FileWriter myWriterObject;
            if (Objects.equals(myKeyScanner.nextLine(), "y")) {
                myWriterObject = new FileWriter(fileName, false);

            } else {
                myWriterObject = new FileWriter(fileName, true);

            }
            System.out.println("What do you want to write in the file?");
            myWriterObject.write(myKeyScanner.nextLine());
            myWriterObject.close();
            System.out.println("I wrote to file " + fileName);
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