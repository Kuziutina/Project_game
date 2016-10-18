import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
 
public class Eggs extends JComponent {
    private int x1;
	private int y = 50;
 
    public Eggs() {
		Random r = new Random();
        int []x = new int[] {100, 250, 500};
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				if (y > 450) {
					x1 = x[r.nextInt(x.length)];
					y = 50;
				}
                repaint();
            }
        });
        timer.start();
    }
 
    @Override
    protected void paintComponent(Graphics g) {
		int width = getWidth();
        int height = getHeight();
		g.setColor(Color.blue);
        g.fillRect(0, 0, width, height);
        Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.white);
		g.fillOval(x1, y, 75, 125);
		y += 5;
	}
}
