import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.net.*;
import java.applet.Applet;
import java.io.*;
import javax.imageio.*;
 
public class Eggs extends JComponent {
    
    private final int maxk = 6;
    public int start = 700 / maxk;
	private int y = 50, b;
	private int i = 0;
	private int x1 = start;
	private int xw = start;
	private boolean game = true;
	private int block = start, m = start;
    private Image image;

	
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
				if (y > h - 97) {
					y = 50;
					if (x1 == xw) {
						i++;
					}
					else {
						game = false;
					}
					x1 = block * (r.nextInt(maxk - 1)+1);
				}
				if ((b == 39) && (xw < block * (maxk - 1)))
					xw += block;
				if ((b == 37) && (xw > block)){
					xw = xw - block;
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
    	Image egg = null;
		Image wolf = null;
		Image fon = null;
		try{
		wolf = ImageIO.read(new File("wolf.png"));
		egg = ImageIO.read(new File("egg.png"));
		fon = ImageIO.read(new File("fon.jpg"));
		}
		catch(IOException e){
			
		}
		int width = getWidth();
        int height = getHeight();
        g.drawImage(fon, 0, 0, width, height, null);

        block = (width - 80)/maxk;

		g.setFont(new Font("Arial", 1, 20));
		if (game) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setPaint(Color.white);
			g.drawImage(egg, x1, y, null);
			g.drawImage(wolf,xw-27,height-63,null);
	
			y += 5 + i / 5;
			
		}
		else {
			g.setColor(new Color(255, 255, 255));
			g.fillRect(width/2 - 90, height/2 - 40, 175, 100);
			g.setColor(new Color(0, 0, 0));
			g.drawString("Play again?", width / 2 - 50, height/ 2);
			g.drawString("Y/N", width / 2 - 25, height/ 2 + 25);
		}

		g.setColor(new Color(255, 255, 255));
		g.fillRect(width-70, height - 70, 60, 30);
		g.setColor(new Color(0, 0, 0));
		g.drawString("" + (i * 10), width - 60, height - 50);
	}
}
