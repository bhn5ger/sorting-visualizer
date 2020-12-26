package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JLabel;

public class Sort implements Runnable{

	private String sortAlgo; 
	private int speed;
	
	public Sort(String sortAlgo, int speed) {
		this.speed = speed;
		this.sortAlgo = sortAlgo;
		Thread t = new Thread(this);
		t.start();
	
		
	} 
	 
	
	 
	
	
	@Override
	public void run() {
		if(this.sortAlgo.equals("Selection Sort")) {
			SelectionSort.speed = this.speed;
			SelectionSort.sort(SinusoidSegment.segments);
			displayLoadingCaption(3, "selection sort");
		}
		if(this.sortAlgo.equals("Insertion Sort")) {
			InsertionSort.speed = this.speed;
			InsertionSort.sort(Window.segmentPanels);
			displayLoadingCaption(3, "insertion sort");
		}		
		if(this.sortAlgo.equals("Bubble Sort")) {
			BubbleSort.speed = this.speed;
			BubbleSort.sort(Window.segmentPanels);
			displayLoadingCaption(3, "bubble sort");
		}
		
		
		clearColors(SinusoidSegment.numberOfSegments);
		Window.isSorting = false;
		
	}
	
	
	
	public static void clearColors(int index){
		for(int i = 0; i < index; i++) {
			SinusoidSegment.segments[i].setColor(Color.black);
			SinusoidSegment.segments[i].repaint();

			
		}
	}
	
	
	public static void displayLoadingCaption(int x, String sortAlgo) {
		
		if(x == 0) Window.lblNewLabel_1.setText("Sorting with " + sortAlgo + ".");
		else if (x == 1) Window.lblNewLabel_1.setText("Sorting with " + sortAlgo + ".  .");
		else if (x == 2) Window.lblNewLabel_1.setText("Sorting with " + sortAlgo + ".  .  ."); 
		else Window.lblNewLabel_1.setText(""); 
	
		
	}
	

	
	
	
}
