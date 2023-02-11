package Q3;

import java.io.*;

public abstract class Task<L extends Number> {
    private BufferedReader templateReader;
    private BufferedReader configReader;
    private BufferedWriter mergedWriter;
    {
        try {
            templateReader = new BufferedReader(new FileReader("C:\\Users\\Shan\\Desktop\\attachments\\Question 3\\sdxl.txt"));
            configReader = new BufferedReader(new FileReader("C:\\Users\\Shan\\Desktop\\attachments\\Question 3\\sdxl.txt"));
            mergedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Shan\\Desktop\\attachments\\Question 3\\sdxl.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Task(BufferedReader templateReader, BufferedReader configReader, BufferedWriter mergedWriter) {
        this.templateReader = templateReader;
        this.configReader = configReader;
        this.mergedWriter = mergedWriter;
    }
    public abstract Long execute();
}



