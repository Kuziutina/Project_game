import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.util.*;

public class Wolf  {	
	
		public static void main(String[] args){
			
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Wolf");
                final Eggs cort = new Eggs();
                frame.add(cort);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						cort.setXW (e.getKeyCode());
                    }
				});
                frame.setVisible(true);
				/*JButton tryAgain = new JButton("Try again");
				JButton exit = new JButton("Exit");
				frame.add(exit);
				frame.add(tryAgain);
				exit.setVisible(!cort.getGame());
				tryAgain.setVisible(!cort.getGame());
				exit.setBounds(cort.getWidth()/2, cort.getHeight()/2, 100, 30); 
				tryAgain.setBounds(cort.getWidth()/2 - 150, cort.getHeight()/2, 100, 30); 
				exit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("Exit")) {
							System.exit(0);
						}
					}
				});
				tryAgain.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("Try again")) {
							cort.setGame(true);
							cort.setI(0);
						}
					}
				});*/
            }
        });
       
		
	}
  
}