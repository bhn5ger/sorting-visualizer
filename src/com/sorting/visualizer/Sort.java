package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JLabel;

public class Sort implements Runnable{

	
	public Sort() {
		Thread t = new Thread(this);
		t.start();
	
		
	} 
	 
	
	 
	
	
	@Override
	public void run() {
		
		SelectionSort.sort(SinusoidSegment.segments);	
		clearColors(SinusoidSegment.numberOfSegments);
		displayLoadingCaption(3);
		Window.isSorting = false;
		
	}
	
	
	
	public static void clearColors(int index){
		for(int i = 0; i < index; i++) {
			SinusoidSegment.segments[i].setColor(Color.black);
			SinusoidSegment.segments[i].repaint();

			
		}
	}
	
	
	public static void displayLoadingCaption(int x) {
		
		if(x == 0) Window.lblNewLabel_1.setText("Sorting.");
		else if (x == 1) Window.lblNewLabel_1.setText("Sorting.  .");
		else if (x == 2) Window.lblNewLabel_1.setText("Sorting.  .  ."); 
		else Window.lblNewLabel_1.setText(""); 
	
		
	}
	

	
	
	
}
