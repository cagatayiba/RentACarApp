package com.group38;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    private File file =  null;
    private Scanner fileIn = null;
    private List<String> lines = new ArrayList<String>(20);
    public FileIO(String fileName){
        file = new File(fileName);
    }
    public List<String> getLines(){
        try{
            fileIn  = new Scanner(new FileInputStream(file));
            String line = null;
            while (fileIn.hasNext() && fileIn.hasNextLine() && ((line = fileIn.nextLine()) != null)){
                lines.add(line);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        fileIn.close();
        return lines;
    }
}
