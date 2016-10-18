import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Wolf {	
	
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Wolf");
                frame.add(new Eggs());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.setVisible(true);
            }
        });
		
	}
}