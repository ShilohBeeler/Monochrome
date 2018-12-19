package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.MainFrame;

public class ChangeListener implements ActionListener, KeyListener
{
    private static MainFrame mf;
    private static TextHandler th;

    public ChangeListener()
    {

    }

    public ChangeListener(MainFrame mainFrame, TextHandler textHandler)
    {
        mf = mainFrame;
        th = textHandler;
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
            mf.setLine(th.processLine());
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
                th.setFile(file);
                mf.setLine(th.processLine());
            }
        } else if (clicked.getText().equals("Quit"))
        {
            System.exit(0);
        }

    }
}
