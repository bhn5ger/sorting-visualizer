package com.sorting.visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;




@SuppressWarnings("serial")
public class Cycle extends JPanel{
	
	public Color color = Color.BLACK;
	public static int numberOfCycles = 0;
	public static Cycle [] cycles = new Cycle[13]; // *Contains all cycles/segments; data stored here is sorted*
	public static int totalWaveLength = 0;
    public int cycleWaveLength, points;
    private double[] sines;
    private int[] pts; 
     
    public Cycle() {
        points = 400; 
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / 200) * i;
            sines[i] = Math.sin(radians);
        }
        Random r = new Random();
        cycleWaveLength = r.nextInt(40) + 51 ;
        totalWaveLength += cycleWaveLength;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = cycleWaveLength; 
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
        g.drawString("λ = " + cycleWaveLength, cycleWaveLength/2 - 5, 100);
       
        g.drawLine(0,maxHeight/2,cycleWaveLength,maxHeight/2);
        g.drawLine(cycleWaveLength/2, maxHeight/4,cycleWaveLength/2, (maxHeight / 4) * 3);
        
        int spacingFactor = cycleWaveLength/7;
        g.setColor(new Color(240,240,240));
        g.drawLine(0,maxHeight/2,spacingFactor,maxHeight/2);
        g.drawLine(spacingFactor * 2,maxHeight/2, spacingFactor * 3,maxHeight/2);
        g.drawLine(spacingFactor * 4,maxHeight/2, spacingFactor * 5,maxHeight/2);
        g.drawLine(spacingFactor * 6,maxHeight/2, spacingFactor * 7,maxHeight/2);
        g.setColor(color);
   
    }
     
    
    public void setColor(Color c) {
    	this.color = c;
    	
    }
    public Color getColor() {
    	return this.color; 
    	
    }    
    
  


}