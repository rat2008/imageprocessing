
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
public class D2 {
    public static void main(String[] args) {
        try{
            Scanner myObj = new Scanner(System.in);
            String file;
            System.out.println("Enter Image Name : "); 
            file = myObj.nextLine();
            FileInputStream myInputFile = new FileInputStream("image/"+file+".raw");
            FileOutputStream myOutputFile = new FileOutputStream("image/"+file+"_D2.raw");
            int value;
            int i=0;
            Scanner input_width = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int width = input_width.nextInt();
            
            Scanner input_height = new Scanner(System.in);
            System.out.println("Enter Width : "); 
            int height = input_height.nextInt();
            int[][] data = new int[height][width];
            int [][] data2 = { { 0, 128, 32, 160 }, { 192, 64, 224, 96 },{ 48, 176, 16, 144 },{240,112,208,80} };
              
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
            int h=0;
            for(int count = 0; count < height; count++){
                for(int num = 0; num < width; num++){
                    if(data[count][num]>data2[h][w]){
                        data[count][num]=255;
                    }else{
                        data[count][num]=0;
                    }
                    if(w!=3){
                        w++;
                    }else{
                        w=0;
                    }
                }
                if(h!=3){
                    h++;
                }else{
                    h=0;
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
