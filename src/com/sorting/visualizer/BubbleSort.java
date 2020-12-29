package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class BubbleSort {
	public static Color darkGreen = new Color(0 , 153, 0);
	public static int speed = 500;
	
	public static void sort(JPanel arr[]) //original
	    { 
	        int n = arr.length; //original
	        boolean swapped;
	        for (int i = 0; i < n-1; i++) { //original
	        	swapped = false;
	            for (int j = 0; j < n-i-1; j++) { //original
	            	if(arr[j+1] == null) break;
        	
					Cycle.cycles[j+1].setColor(Color.red); // turn j+1 to red
					Cycle.cycles[j+1].repaint();
					
					try {
						Sort.displayLoadingCaption(0, "bubble sort"); //delay
						Thread.sleep(speed); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	
					Cycle.cycles[j].setColor(Color.red); // turn j to red
					Cycle.cycles[j].repaint();
					
					if (arr[j].getBounds().getWidth() > arr[j+1].getBounds().getWidth()) //original
	                { 
	                    // swap arr[j+1] and arr[j] 
	                    JPanel temp = arr[j]; //original
	                    Cycle temp2 = Cycle.cycles[j];
	                    double temp3 = arr[j+1].getBounds().getX();
	                 
	                    arr[j+1].setBounds((int)arr[j].getBounds().getX(), Window.cycleYPos, (int)arr[j+1].getBounds().getWidth() ,100);	                    
	                    arr[j] = arr[j+1]; //original
	                    Cycle.cycles[j] = Cycle.cycles[j+1];	                    
	                    
	                    double shift = temp.getBounds().getWidth() - arr[j+1].getBounds().getWidth();
	                    temp.setBounds((int)(temp3 - shift), Window.cycleYPos, (int)temp.getBounds().getWidth() ,100);	                    	                    	
	                    arr[j+1] = temp;   //original
	                    Cycle.cycles[j+1] = temp2;
	                    
	                    swapped = true;
	                    
	                }
					
					try {
						Sort.displayLoadingCaption(1, "bubble sort"); //delay
						Thread.sleep(speed); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					Cycle.cycles[j].setColor(Color.black); // turn j to black
					Cycle.cycles[j].repaint();
					
					try {
						Sort.displayLoadingCaption(2, "bubble sort"); //delay
						Thread.sleep(speed); 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	
					Cycle.cycles[j+1].setColor(Color.black); // turn j+1 to black
					Cycle.cycles[j+1].repaint();
					
	    		}
	            
	            if(swapped == false) break;
	            
	        
	    	}
	         
	    } 
	

	
	
	
	
	
}

// Coloring pseudo code

// j+1 turn red
// delay
// j turn red
// swap
// delay
// j turn black
// delay
// j+1 turn black


