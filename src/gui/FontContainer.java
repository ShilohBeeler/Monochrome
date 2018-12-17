package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;

public class FontContainer 
{
    private static Font font;
    
    public static Font getFont()
    {
        try
        {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    new FileInputStream(System.getProperty("user.home") + "/MNCHRM/resources/AppleII.ttf"));
        } catch (FontFormatException e)
        {
            e.printStackTrace();
            return null;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        
        font = font.deriveFont(12f);
        
        return font;
    }
}
