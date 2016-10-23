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
						if (!cort.getGame()) {
							if (e.getKeyCode() == 78)
								System.exit(0);
							if (e.getKeyCode() == 89){
								cort.setGame(true);
								cort.setI(0);
							}
						}
                    }
				});
				frame.setVisible(true);
			
            }
        });
       
	   
		
	}
  
}