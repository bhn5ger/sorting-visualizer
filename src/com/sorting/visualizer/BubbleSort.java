package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class BubbleSort {
	public static Color darkGreen = new Color(0 , 153, 0);
	public static int speed = 500;
	
	public static void sort(JPanel arr[]) //original
	    { 
	        int n = arr.length; //original
	        for (int i = 0; i < n-1; i++) //original
	            for (int j = 0; j < n-i-1; j++) //original
	            	if(arr[j+1] == null) break;
	            	else if (arr[j].getBounds().getWidth() > arr[j+1].getBounds().getWidth()) //original
	                { 
	                    // swap arr[j+1] and arr[j] 
	                    JPanel temp = arr[j]; //original
	                    SinusoidSegment temp2 = SinusoidSegment.segments[j];
	                    double temp3 = arr[j+1].getBounds().getX();
	                 
	                    arr[j+1].setBounds((int)arr[j].getBounds().getX(), Window.cycleYPos, (int)arr[j+1].getBounds().getWidth() ,100);	                    
	                    arr[j] = arr[j+1]; //original
	                    SinusoidSegment.segments[j] = SinusoidSegment.segments[j+1];	                    
	                    
	                    double shift = temp.getBounds().getWidth() - arr[j+1].getBounds().getWidth();
	                    temp.setBounds((int)(temp3 - shift), Window.cycleYPos, (int)temp.getBounds().getWidth() ,100);	                    	                    	
	                    arr[j+1] = temp;   //original
	                    SinusoidSegment.segments[j+1] = temp2;
	
	                    
	                }
	         
	    } 
	
	
}
