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

public class MainFrame extends JFrame implements KeyListener, ActionListener
{
    private ImagePanel imagePanel = new ImagePanel();
    private DialogPanel dialogPanel = new DialogPanel();
    private MenuPanel menuPanel = new MenuPanel();

    MainFrame()
    {
        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        this.getContentPane().setBackground(Color.BLACK);

        menuPanel.loadButton.addActionListener(this);
        menuPanel.quitButton.addActionListener(this);

        add(imagePanel, BorderLayout.WEST);

        add(menuPanel, BorderLayout.EAST);

        add(dialogPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setFocusable(true);
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
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            dialogPanel.nextLine();
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton clicked = (JButton) e.getSource();
        if (clicked.getText().equals("Load"))
        {
            JFileChooser fc = new JFileChooser(System.getProperty("user.home") + "/MNCHRM/");
            FileFilter filter = new FileNameExtensionFilter("MONOCHROME File", "mono");
            File file = null;
            fc.setFileFilter(filter);

            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                file = fc.getSelectedFile();
                dialogPanel.getTextHandler().setFile(file);
                dialogPanel.nextLine();
            }
        } else if (clicked.getText().equals("Quit"))
        {
            System.exit(0);
        }

    }

    public static void main(String[] args)
    {
        MainFrame lft = new MainFrame();
    }
}
