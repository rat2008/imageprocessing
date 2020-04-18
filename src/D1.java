
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
public class D1 {
    public static void main(String[] args) {
        try{
            Scanner myObj = new Scanner(System.in);
            String file;
            System.out.println("Enter Image Name : "); 
            file = myObj.nextLine();
            FileInputStream myInputFile = new FileInputStream("image/"+file+".raw");
            FileOutputStream myOutputFile = new FileOutputStream("image/"+file+"_D1.raw");
            int value;
            int i=0;
            Scanner input_width = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int width = input_width.nextInt();
            
            Scanner input_height = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int height = input_height.nextInt();
            int[][] data = new int[height][width];
              
              int start_Width = 0;
              int start_Height = 0;
            while((value = myInputFile.read())!=-1){
                if((i%width==0)&&(i!=0)){
                    start_Height++;
                    start_Width = 0;
                }
                data[start_Height][start_Width]  = value;
                start_Width++;
                i++;
            }
        int w=0;
            for(int count = 0; count < height; count++){
                for(int num = 0; num < width; num++){
                    if(count%2==0){
                        if(w==0){
                           if(data[count][num]>=0){
                               data[count][num]=255;
                           }else{
                               data[count][num]=0;
                           }
                           w++;
                        }else{
                           w=0;
                           if(data[count][num]>128){
                               data[count][num]=255;
                           }else{
                               data[count][num]=0;
                           } 
                        }
                    }else{
                        if(w==0){
                           if(data[count][num]>192){
                               data[count][num]=255;
                           }else{
                               data[count][num]=0;
                           } 
                           w++;
                        }else{
                           if(data[count][num]>64){
                               data[count][num]=255;
                           }else{
                               data[count][num]=0;
                           } 
                           w=0;
                        }
                    } 
//                      myOutputFile.write(data[count][num]);
                }
//                System.out.println();
            }
            
            for(int count = 0; count < height; count++){
                for(int num = 0; num < width; num++){
//                    System.out.print("("+ count +" , "+ num +") : "+data[count][num]+" ");
                      myOutputFile.write(data[count][num]);
                }
//                System.out.println();
            }
            
            myInputFile.close();
            myOutputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
}
