import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
 
public class Eggs extends JComponent {
    private int x1 = 100, b, xw = 250;
	private int y = 50;
	private int i = 0;
	private boolean game = true;
    private int [] x = new int[] {100, 250, 400};
	
	public boolean getGame(){
		return game;
	}
	
	public boolean setGame(boolean g){
		this.game = g;
		return game;
	}
	
	public int setI(int i){
		this.i = 0;
		return i;
	}
 
    public Eggs() {
		
        
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				if (y > 350) {
					y = 50;
					if (x1 == xw) {
						i++;
					}
					else {
						game = false;
					}
					x1 = x[r.nextInt(x.length)];
				}
				if ((b == 39) && (xw < 400))
					xw += 150;
				if ((b == 37) && (xw > 100))
					xw = xw - 150;
				b = 0;
				repaint();
            }
        });
        timer.start();
    }

    void setXW(int b){
        this.b = b;
    }
 
    @Override
    protected void paintComponent(Graphics g) {
		int width = getWidth();
        int height = getHeight();
		setBackground(new Color(168, 188, 255));
		g.setColor(new Color(168, 188, 255));
        g.fillRect(0, 0, width, height);
		g.setFont(new Font("Arial", 1, 20));
		if (game) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setPaint(Color.white);
			g.fillRect(xw, 400, 100, 70);
			g.fillOval(x1, y, 75, 125);
			y += 5 + i / 3;
			g.setColor(new Color(0, 0, 0));
		}
		else {
			g.setColor(new Color(0, 0, 0));
			g.drawString("Game over", width / 2 - 50, height/ 2);
		}
		g.drawString("" + (i * 10), width - 50, height - 50);
	}
}
