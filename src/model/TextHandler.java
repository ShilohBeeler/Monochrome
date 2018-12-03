package model;

import java.util.LinkedList;

public class TextHandler
{
    private LinkedList<String> textLines;
    
    public TextHandler()
    {
        textLines = new LinkedList<String>();
        textLines.add("First Line.");
        textLines.add("Second Line.");
        textLines.add("Third Line.");
        textLines.add("You get the idea.");
    }
    
    public String getLine()
    {
        return textLines.remove();
    }
}
