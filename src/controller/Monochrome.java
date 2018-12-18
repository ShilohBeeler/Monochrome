package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import gui.MainFrame;

public class Monochrome
{
    public static void main(String[] args)
    {
        String folder = System.getProperty("user.home")+"/MNCHRM";
        File path = new File(folder);
        
        if(!(path.exists() && path.isDirectory()))
        {
            path.mkdir();
            new File(folder+"/resources").mkdir();
            File font = new File("src/resources/AppleII.ttf");
            File def = new File("src/resources/Default.mono");
            try
            {
                Files.copy(font.toPath(), new File(folder + "/resources/AppleII.ttf").toPath());
                Files.copy(def.toPath(), new File(folder + "/Default.mono").toPath());
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        MainFrame mf = new MainFrame();
    }
}
