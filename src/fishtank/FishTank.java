/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author spenc
 */
public class FishTank extends JFrame implements ActionListener{
    
    
    
    Image[] speciesImage;
    static int wx, wy, ww, wh;
    

    public FishTank(){
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        ww = 800;
        wh = 600;
        wx = (int)(res.getWidth()/2 - ww/2);
        wy = (int)(res.getHeight()/2 - wh/2);
        setBounds(wx, wy, ww, wh);
        setTitle("Fishtank A - Room 428C, Old Main");
        setVisible(true);
        
        AboutWindow w1 = new AboutWindow();
        w1.setBounds(w1.wx, w1.wy, w1.ww, w1.wh);
        w1.setVisible(true);
        w1.requestFocus();
    }
    
    public static void main(String[] args) {
        FishTank f1 = new FishTank();
        f1.setBounds(wx, wy, ww, wh);
        f1.setTitle("Fishtank A - Room 428C, Old Main");
        f1.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    
    //INNER CLASS AboutWindow
    class AboutWindow extends JFrame implements ActionListener
    {

        JButton closeButton = new JButton("Okay!");
        JLabel[] iLabel = new JLabel[3];
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int wx, wy, ww, wh;
            
        
        public AboutWindow(){
            ww = 480;
            wh = 128;
            wx = (int)(res.getWidth()/2 - ww/2);
            wy = (int)(res.getHeight()/2 - wh/2);
             iLabel[0] = new JLabel("This program generates its own unique data for each");
             iLabel[1] = new JLabel("species of fish, since no real data or peripheral is");
             iLabel[2] = new JLabel("is attached. Let me know where improvement can be made!");
            JPanel northPanel = new JPanel();
            JPanel southPanel = new JPanel();
            northPanel.setLayout(new GridLayout(3,1));
            
            this.add(northPanel);
                for(int i=0; i<3; i++){
                    northPanel.add(iLabel[i], BorderLayout.CENTER);
                }
            this.add(southPanel, BorderLayout.SOUTH);
                southPanel.add(closeButton);
                closeButton.addActionListener(this);
                
            
        }
        
        public void actionPerformed(ActionEvent event) {
            this.dispose();
        }
    
    }
    
}
