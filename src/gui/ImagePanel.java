package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{

    private BufferedImage foreground = null;
    private BufferedImage background = null;

    public ImagePanel()
    {
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setPreferredSize(new Dimension(600, 400));
        try
        {
            foreground = ImageIO.read(new File(System.getProperty("user.home") + "/MNCHRM/resources/MCLogo.png"));
            background = ImageIO.read(new File(System.getProperty("user.home") + "/MNCHRM/resources/MCBG.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setForegroundImage(String filename) throws IOException
    {
        foreground = ImageIO.read(new File(filename));
        this.repaint();
    }

    public void setBackgroundImage(String filename) throws IOException
    {
        background = ImageIO.read(new File(filename));
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 600, 400, this);
        g.drawImage(foreground, 200, 100, 200, 200, this);
    }
}
