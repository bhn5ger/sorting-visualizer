package com.sorting.visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;




@SuppressWarnings("serial")
public class SinusoidSegment extends JPanel{
	
	public Color color = Color.BLACK;
	public static int numberOfSegments = 0;
	public static SinusoidSegment [] segments = new SinusoidSegment[13]; // *Contains all cycles/segments; data stored here is sorted*
	public static int sineLength = 0;
    public int width, points;
    private double[] sines;
    private int[] pts; 
     
    public SinusoidSegment() {
        points = 400; 
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / 200) * i;
            sines[i] = Math.sin(radians);
        }
        Random r = new Random();
        width = r.nextInt(40) + 51 ;
        sineLength += width;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = width; 
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight(); 
        pts = new int[points];
        for (int i = 0; i < points; i++)
            pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        g.setColor(color);
        
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hstep);
            int x2 = (int) (i * hstep);
            int y1 = pts[i - 1]; 
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
            
        }
        g.drawString("λ = " + width, width/2 - 5, 100);
   
    }
     
    
    public void setColor(Color c) {
    	this.color = c;
    	
    }
    public Color getColor() {
    	return this.color; 
    	
    }    
    
  


}
