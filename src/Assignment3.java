import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Assignment3 {
    public static void main(String[] args) {
        try{
            Scanner myObj = new Scanner(System.in);
            
            String file;
//           
            file = "yoda";
            FileInputStream myInputFile = new FileInputStream("image/"+file+".raw");
            FileOutputStream myOutputFile = new FileOutputStream("image/"+file+"_his.raw");
            
            Scanner input_width = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int width = input_width.nextInt();
            
            Scanner input_height = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int height = input_height.nextInt();
            
            int data[] = new int [256];
            int image[] = new int [width*height];
            int num[] = new int [256];
            int pixel[] = new int [256];
            int value;
            int a=0;
            int sum = 0;
            double no  = 0.0;
            int mutiple = 0;
            int total = 0;
            while((value = myInputFile.read())!=-1){
                image[a] = value;
                data[value] = data[value]+1;    
                a++;
            }
//            System.out.println("-----------------------------Header Info-----------------------------");
//            System.out.println("Gray-level--No of Pixel--Rum Sum--Normalized--Mutiple 7--No of Pixel-");
            for(int i=0;i<256;i++){
                sum  += data[i];
                no = ((double)sum/a);
                mutiple = (int) Math.round(no * 255);
                num[i] = mutiple;
                
//                pixel = mutiple;
                if(i!=0){
                    if(num[i]==num[i-1]){
                        pixel[mutiple] = pixel[mutiple]+data[i];
                    }else{
                        pixel[mutiple] = data[i];
                    }
                }else{
                    pixel[mutiple] = data[i];
                }
//                System.out.println(i+"               "+data[i]+"           "+sum+"         "+nor+"          "+mutiple+"           "+pixel[i]+"        ");
            }
            for(int b=0;b<a;b++){
                  image[b] = num[image[b]];
                  myOutputFile.write(image[b]);
//                System.out.println(image[k]);
//                total = total + pixel[k];
            }
            
            
            
            myInputFile.close();
            myOutputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
}