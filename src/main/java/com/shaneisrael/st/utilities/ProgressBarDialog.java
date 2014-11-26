package com.shaneisrael.st.utilities;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class ProgressBarDialog extends JFrame
{

    private JPanel contentPane;
    private JProgressBar progressBar;
    private int current;
    private int max;
    private String title;

    public ProgressBarDialog(String title, int max)
    {
        current = 0;
        this.max = max;
        this.title = title;
        
        initialize();
    }

    private void initialize()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 434, 128);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new MigLayout("", "[413.00]", "[][74.00][]"));
        
        progressBar = new JProgressBar();
        progressBar.setMaximum(max);
        progressBar.setStringPainted(true);
        
        panel.add(progressBar, "cell 0 1,grow");
        
        this.setTitle(title);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    public void updateProgress()
    {
        current += 1;
        progressBar.setValue(current);
        
        
        progressBar.setString(progressBar.getValue() + " / " + progressBar.getMaximum());
        if(progressBar.getValue() == progressBar.getMaximum())
            this.dispose();
    }

}