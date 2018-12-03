package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements KeyListener
{
    private ImagePanel imagePanel = new ImagePanel();
    private DialogPanel dialogPanel = new DialogPanel();
    private MenuPanel menuPanel = new MenuPanel();
    
    MainFrame()
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
    }
    

    @Override
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("test");
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            dialogPanel.nextLine();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args)
    {
        MainFrame lft = new MainFrame();
    }
}
