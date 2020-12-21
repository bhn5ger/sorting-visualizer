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
		
		/* Code to traverse
		for(int i = 0; i < SinusoidSegment.numberOfSegments; i++) {
			

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			SinusoidSegment.segments[i].setColor(Color.red);
			SinusoidSegment.segments[i].repaint();
			if(i != 0) {
				SinusoidSegment.segments[i-1].setColor(Color.black);
				SinusoidSegment.segments[i-1].repaint();
			}
		
			if(i == 0 || i == 3 || i == 6 || i == 9 || i== 12) Window.lblNewLabel_1.setText("Sorting.");
			else if (i == 1 || i == 4 || i == 7 || i == 10) Window.lblNewLabel_1.setText("Sorting.  .");
			else Window.lblNewLabel_1.setText("Sorting.  .  ."); 
			
			
		}
		*/
		Window.isSorting = false;
		
	}


	
	
	
}
