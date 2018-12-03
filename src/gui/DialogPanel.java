package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.TextHandler;

public class DialogPanel extends JPanel
{
    private JLabel displayText;
    private TextHandler th;
    
    public DialogPanel()
    {
        th = new TextHandler();
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setPreferredSize(new Dimension(800, 100));
        
        displayText = new JLabel(th.getLine());
        displayText.setFont(Font.getFont(Font.MONOSPACED));
        displayText.setForeground(Color.WHITE);
        
        add(displayText);
    }
    
    public void nextLine()
    {
        displayText.setText(th.getLine());
        repaint();
    }
}