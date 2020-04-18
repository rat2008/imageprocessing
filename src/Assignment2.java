
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.Scanner; // import the Scanner class 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Assignment2 {
    public static void main(String[] args) {
        try{
            Scanner myObj = new Scanner(System.in);
            
            String file;
//            System.out.println("Enter Image Name : "); 
//            file = myObj.nextLine();
            file = "yoda";
            FileInputStream myInputFile = new FileInputStream("image/"+file+".raw");
            FileOutputStream myOutputFile = new FileOutputStream("image/"+file+"_pattern.raw");
            int value;
            int i=0;
            Scanner input_width = new Scanner(System.in);
            System.out.println("Enter the Width of image: "); 
            int width = input_width.nextInt();
            
            Scanner input_height = new Scanner(System.in);
            System.out.println("Enter Height of image: "); 
            int height = input_height.nextInt();
//            int width = 123;
            
            int[][] data = new int[((height+1)*3)][((width+1)*3)];
            int num_pat = 0;
            int[][] pattern = { { 0, 0, 0 }, { 0, 0, 0 },{ 0, 0, 0 } };
            int[][] pattern1 = { { 0, 0, 0 }, { 0, 0, 0 },{ 0, 0, 255 } };
            int[][] pattern2 = { { 255, 0, 0 }, { 0, 0, 0 },{ 0, 0, 255 } };
            int[][] pattern3 = { { 255, 0, 255 }, { 0, 0, 0 },{ 0, 0, 255 } };
            int[][] pattern4 = { { 255, 0, 255 }, { 0, 0, 0 },{ 255, 0, 255 } };
            int[][] pattern5 = { { 255, 0, 255 }, { 0, 0, 0 },{ 255, 255, 255 } };
            int[][] pattern6 = { { 255, 0, 255 }, { 255, 0, 0 },{ 255, 255, 255 } };
            int[][] pattern7 = { { 255, 255, 255 }, { 255, 0, 0 },{ 255, 255, 255 } };
            int[][] pattern8 = { { 255, 255, 255 }, { 255, 0, 255 },{ 255, 255, 255 } };
            int[][] pattern9 = { { 255, 255, 255 }, { 255, 255, 255 },{ 255, 255, 255 } };
              int start_width = 0;
              int start_height = 0;
            while((value = myInputFile.read())!=-1){
                num_pat = getPattern(value);
                if((i%width==0)&&(i!=0)){
                    start_height = start_height + 3;
                    start_width = 0;
                }
                switch (num_pat) {
                    case 0:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern[m][j];
                            }
                        }   break;
                    case 1:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern1[m][j];
                            }
                        }   break;
                    case 2:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern2[m][j];
                            }
                        }   break;
                    case 3:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern3[m][j];
                            }
                        }   break;
                    case 4:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern4[m][j];
                            }
                        }   break;
                    case 5:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern5[m][j];
                            }
                        }   break;
                    case 6:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern6[m][j];
                            }
                        }   break;
                    case 7:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern7[m][j];
                            }
                        }   break;
                    case 8:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern8[m][j];
                            }
                        }   break;
                    case 9:
                        for (int m = 0; m < 3; m++) {
                            for (int j = 0; j < 3; j++) {
                                data[start_height+m][start_width+j]  = pattern9[m][j];
                            }
                        }   break;
                    default:
                    break;
                }
                start_width = start_width + 3;
                i++;
            }      
            for(int count = 0; count < (height*3); count++){
                for(int num = 0; num < (width*3); num++){
//                    System.out.print("("+ count +" , "+ num +") : "+data[count][num]+" ");
                      myOutputFile.write(data[count][num]);
                }
            }
            myInputFile.close();
            myOutputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
    public static int getPattern(int value){
        int data=0;
        if(value<=25){
             data = 0;
        }else if((value>25)&&(value<=50)){
             data = 1;
        }else if((value>50)&&(value<=75)){
             data = 2;
        }else if((value>75)&&(value<=100)){
             data = 3;
        }else if((value>100)&&(value<=125)){
             data = 4;
        }else if((value>125)&&(value<=150)){
             data = 5;
        }else if((value>150)&&(value<=175)){
             data = 6;
        }else if((value>175)&&(value<=200)){
             data = 7;
        }else if((value>200)&&(value<=225)){
             data = 8;
        }else{
             data = 9;
        }
        return data;
    }
}
