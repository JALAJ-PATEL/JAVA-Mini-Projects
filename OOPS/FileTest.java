/*
 Write a program to write and read data to and from a file. 

 Write a program to identify which classes provide faster read and writes to a file. 
 Show time difference. I.e. FileIO, Buffer, etc... 
 Everything must be defined in classes and use single try, catch.

 */

package OOPS;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        FileIOTest fileIOTest = new FileIOTest();
        BufferTest bufferTest = new BufferTest();

        fileIOTest.test();
        bufferTest.test();
    }
}

class FileIOTest {
    void test() {
        try {
            long startTime = System.nanoTime();
            writeFile();
            long endTime = System.nanoTime();
            System.out.println("Time taken by FileOutputStream: " + (endTime - startTime));

            startTime = System.nanoTime();
            readFile();
            endTime = System.nanoTime();
            System.out.println("Time taken by FileInputStream: " + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write("Hello, World!".getBytes());
        fos.close();
    }

    void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        fis.read(new byte[1024]);
        fis.close();
    }
}

class BufferTest {
    void test() {
        try {
            long startTime = System.nanoTime();
            writeFile();
            long endTime = System.nanoTime();
            System.out.println("Time taken by BufferedWriter: " + (endTime - startTime));

            startTime = System.nanoTime();
            readFile();
            endTime = System.nanoTime();
            System.out.println("Time taken by BufferedReader: " + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
        bw.write("Hello, World!");
        bw.close();
    }

    void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        br.readLine();
        br.close();
    }
}