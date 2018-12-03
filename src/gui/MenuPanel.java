package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MenuPanel extends JPanel
{
    public MenuPanel()
    {
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setPreferredSize(new Dimension(200, 400));
    }
}
