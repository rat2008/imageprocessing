/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Student
 */
public class WriteFile {
    public static void main(String[] args){
        try{
            FileOutputStream myOutputFile = new FileOutputStream("yoda.tif");
            myOutputFile.write(1);
            myOutputFile.write(2);
            myOutputFile.write('T');
            myOutputFile.close();
        }catch(IOException ex){
            System.out.println("File Output error!");
        }
    }
}
