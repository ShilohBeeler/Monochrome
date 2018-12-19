package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ChangeListener;

public class MainFrame extends JFrame
{
    private ImagePanel imagePanel = new ImagePanel();
    private DialogPanel dialogPanel = new DialogPanel();
    private MenuPanel menuPanel = new MenuPanel();

    public MainFrame()
    {
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        this.getContentPane().setBackground(Color.BLACK);

        add(imagePanel, BorderLayout.WEST);

        add(menuPanel, BorderLayout.EAST);

        add(dialogPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new ChangeListener());
    }

    public void setLine(String text)
    {
        dialogPanel.nextLine(text);
    }
    
    public void setForegroundImage(String path)
    {
        
    }
    
    public void setBackgroundImage(String path)
    {
        
    }
  
}
