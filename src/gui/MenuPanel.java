package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.ChangeListener;

public class MenuPanel extends JPanel
{
    public JButton loadButton;
    public JButton quitButton;
    private Font font = FontContainer.getFont();
    
    public MenuPanel()
    {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        
        setLayout(layout);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setPreferredSize(new Dimension(200, 400));
        
        Border line = new LineBorder(Color.WHITE);
        Border space = new EmptyBorder(5,15,5,15);
        Border compound = new CompoundBorder(line, space);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        loadButton = new JButton("Load");
        loadButton.setFocusable(false);
        loadButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        loadButton.setBackground(Color.BLACK);
        loadButton.setForeground(Color.WHITE);
        loadButton.setFocusPainted(false);
        loadButton.setOpaque(true);
        loadButton.setBorder(compound);
        loadButton.setFont(font);
        add(loadButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        quitButton = new JButton("Quit");
        quitButton.setFocusable(false);
        quitButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);
        quitButton.setFocusPainted(false);
        quitButton.setOpaque(true);
        quitButton.setBorder(compound);
        quitButton.setFont(font);
        add(quitButton);
        
        loadButton.addActionListener(new ChangeListener());
        quitButton.addActionListener(new ChangeListener());
    }
}
