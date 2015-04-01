package logic;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Image;

/**
 * Created by Liam on 29-Mar-15.
 */
public class LoadImages {

    public static ArrayList<Image> load(String fileName){
        ArrayList<Image> images = new ArrayList<>();

        try{
            java.util.regex.Pattern bit = java.util.regex.Pattern.compile("[01]");
            Scanner f = new Scanner(new File(fileName));
            while (f.hasNext()) {
                if (!f.next().equals("P1")) System.out.println("Not a P1 PBM file" );
                String category = f.next().substring(1);
                int rows = f.nextInt();
                int cols = f.nextInt();

                boolean[][] imagePixels = new boolean[rows][cols];
                for (int r=0; r<rows; r++){
                    for (int c=0; c<cols; c++){
                        imagePixels[r][c] = (f.findWithinHorizon(bit,0).equals("1"));
                    }
                }
                images.add(new Image(category, imagePixels));
            }

            f.close();

            return images;
        }
        catch(IOException e){System.out.println("Load from file failed"); }
        return null;
    }
}
