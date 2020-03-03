/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
import java.io.*;
public class ReadFile {
    public static void main(String[] args) {
        try{
            FileInputStream myInputFile = new FileInputStream("yoda.tif");
            int value,value1,value2,value3;
            String str1,str2,str3;
//            while((value = myInputFile.read()) != -1){
//                System.out.println(value);
//            }
            value1 = myInputFile.read();
            value2 = myInputFile.read();
            value3 = myInputFile.read();
            str1 = String.format("%02X", value1);
            str2 = String.format("%02X", value2);
            str3 = String.format("%02X", value3);
            System.out.println("Byte order	:" + str1 + str2 );
            System.out.println("Version         :" + str3 );
            System.out.println("Offset          :"  );
        
     // For storing result
     
            myInputFile.close();
        }catch(IOException ex){
            System.out.println("File error!");
        }
    }
    
    static void byteOrder(){
        
    }
    
}
