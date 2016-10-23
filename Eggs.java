import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
 
public class Eggs extends JComponent {
    
	private int y = 50, b;
	private int i = 0;
	private int x1 = 175;
	private int xw = 175;
	private boolean game = true;
	private int block = 175, m = 175;
    private int [] x = new int[] {1, 2, 3};
	
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
       			int w = getWidth();
		        int h = getHeight();
		        if (m != block){
       				x1 = block * x1 / m;
       				xw = block * xw / m;
       				m = block;
       			}

				Random r = new Random();
				if (y > h - 70) {
					y = 50;
					if (x1 == xw) {
						i++;
					}
					else {
						//System.out.println();
						//System.out.println(x1 + " " + xw);
						game = false;
					}
					x1 = block * x[r.nextInt(x.length)];
					//System.out.println(block + " " + x1);
				}
				if ((b == 39) && (xw < block * 3))
					xw += block;
				if ((b == 37) && (xw > block)){
					xw = xw - block;
					//System.out.println(xw);
				}

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
        //System.out.println(width);
        block = width/4;
		setBackground(new Color(168, 188, 255));
		g.setColor(new Color(168, 188, 255));
        g.fillRect(0, 0, width, height);
		g.setFont(new Font("Arial", 1, 20));
		if (game) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setPaint(Color.white);
			g.fillRect(xw, height-70, 100, 70);
			g.fillOval(x1, y, 75, 125);
			y += 5 + i / 5;
			g.setColor(new Color(0, 0, 0));
		}
		else {
			g.setColor(new Color(0, 0, 0));
			g.drawString("Play again?", width / 2 - 50, height/ 2);
			g.drawString("Y/N", width / 2 - 25, height/ 2 + 25);
		}
		g.drawString("" + (i * 10), width - 50, height - 50);
	}
}
