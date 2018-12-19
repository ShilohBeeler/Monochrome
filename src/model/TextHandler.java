package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import gui.MainFrame;

public class TextHandler
{
    private LinkedList<String> textLines;
    private String prev;
    private File sourceFile;
    private File gameDir;
    private MainFrame mainFrame;

    public TextHandler(MainFrame mf, File file)
    {
        textLines = new LinkedList<String>();
        textLines.add("Default");
        mainFrame = mf;
        setFile(file);
        try
        {
            parseFile(0);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public TextHandler(MainFrame mf, String file)
    {
        this(mf, new File(file));
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

        int chunkSize = 200;

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

    public void setFile(File file)
    {
        sourceFile = file;
        gameDir = sourceFile.getParentFile();
        try
        {
            parseFile(0);
        } catch (IOException e)
        {
            textLines.add("File could not be loaded.");
        }
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
            String ground = curr.split(" ")[1];
            String path = gameDir.getAbsolutePath() + "/img/" + curr.split(" ")[2];
            try
            {
                if (ground.equals("b"))
                {
                    mainFrame.setBackgroundImage(path);
                } else
                {
                    mainFrame.setForegroundImage(path);
                }
                return processLine();
            } catch (IOException e)
            {
                return "Failed to load image.";
            }
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
