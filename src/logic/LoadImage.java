package logic;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Liam on 29-Mar-15.
 */
public class LoadImage {

    public void load(){
        boolean[][] newimage = null;
        try{
            java.util.regex.Pattern bit = java.util.regex.Pattern.compile("[01]");
            Scanner f = new Scanner(new File(FileDialog.open()));
            if (!f.next().equals("P1")) System.out.println("Not a P1 PBM file" );
            String category = f.next().substring(1);
            int rows = f.nextInt();
            int cols = f.nextInt();

            newimage = new boolean[rows][cols];
            for (int r=0; r<rows; r++){
                for (int c=0; c<cols; c++){
                    newimage[r][c] = (f.findWithinHorizon(bit,0).equals("1"));
                }
            }
            f.close();
        }
        catch(IOException e){System.out.println("Load from file failed"); }
    }
}
