package model;

import java.util.LinkedList;

public class TextHandler
{
    private LinkedList<String> textLines;
    String prev;
    
    public TextHandler()
    {
        textLines = new LinkedList<String>();
        textLines.add("First Line.");
        textLines.add("Second Line.");
        textLines.add("Third Line.");
        textLines.add("You get the idea.");
        textLines.add("<end>");
    }
    
    public String processLine()
    {
        String curr = textLines.remove();
        if(curr.equals("<end>"))
        {
            textLines.add("<end>");
            return prev;
        }
        else if(curr.startsWith("<img>"))
        {
            return "load image here";
        }
        else if(curr.startsWith("<load>"))
        {
            return "load text file here";
        }
        else
        {
            prev = curr;
            return curr;
        }
    }
}
