package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TextHandler
{
    private LinkedList<String> textLines;
    private String prev;
    private File sourceFile;

    public TextHandler()
    {
        textLines = new LinkedList<String>();
        textLines.add("First Line.");
        textLines.add("Second Line.");
        textLines.add("Third Line.");
        textLines.add("You get the idea.");
        textLines.add("<end>");
    }

    public TextHandler(File file)
    {
        this();
        setFile(file);
        try
        {
            parseFile(0);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public TextHandler(String file)
    {
        this(new File(file));
    }

    private void parseFile(int index) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        textLines.clear();

        int skipLines = index;
        // reads to index location for file chunking.
        while (skipLines > 0 && br.ready())
        {
            br.readLine();
            skipLines--;
        }

        int chunkSize = 4;

        while (br.ready() && chunkSize > 0)
        {
            textLines.add(br.readLine());
            chunkSize--;
            index++;
        }

        if (br.ready())
        {
            textLines.add("<chunk> " + index);
        }

        br.close();
    }

    private void setFile(File file)
    {
        sourceFile = file;
    }

    public String processLine()
    {
        String curr = textLines.remove();
        if (curr.equals("<end>"))
        {
            textLines.add("<end>");
            return prev;
        } else if (curr.startsWith("<img>"))
        {
            return "load image here";
        } else if (curr.startsWith("<load>"))
        {
            return "load text file here";
        } else if (curr.startsWith("<chunk>"))
        {
            // return "chunk file here";
            int index = Integer.parseInt(curr.split(" ")[1]);
            try
            {
                parseFile(index);
            } catch (IOException e)
            {
                return "Error loading next text chunk.";
            }
            curr = textLines.remove();
            prev = curr;
            return curr;
        } else
        {
            prev = curr;
            return curr;
        }
    }
}
