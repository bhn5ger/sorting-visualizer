package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class MergeSort {
	public static Color darkGreen = new Color(0 , 153, 0);
	public static int speed = 500;
	
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(JPanel arr[], int l, int m, int r)
    {
		SinusoidSegment.segments[m].setColor(Color.blue); 
		SinusoidSegment.segments[m].repaint();
    	
		SinusoidSegment.segments[l].setColor(darkGreen); 
		SinusoidSegment.segments[l].repaint();
		
		SinusoidSegment.segments[r].setColor(darkGreen); 
		SinusoidSegment.segments[r].repaint();
		

		
		try {
			Sort.displayLoadingCaption(0, "merge sort"); 
			Thread.sleep(speed); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        JPanel L[] = new JPanel[n1];
        JPanel R[] = new JPanel[n2];
 
        SinusoidSegment L2[] = new SinusoidSegment[n1];
        SinusoidSegment R2[] = new SinusoidSegment[n2];
        
        /*Copy data to temp arrays*/
        for (int i = 0, j = 0; i < n1 || j < n2; ++i, j++) {
        	if(i < n1) {
            	L[i] = arr[l + i];
            	
            	L2[i] = SinusoidSegment.segments[l + i];
        	}
        	
        	if(i < n1 && SinusoidSegment.segments[l + i].getColor() == Color.black) {
        		SinusoidSegment.segments[l + i].setColor(Color.red); 
        		SinusoidSegment.segments[l + i].repaint();	
        	}
        	      	       	
        	if(j < n2 && SinusoidSegment.segments[m + 1 + j].getColor() == Color.black) {
        		SinusoidSegment.segments[m + 1 + j].setColor(Color.red); 
        		SinusoidSegment.segments[m + 1 + j].repaint();
        	}
    		if(i < n1 && j < n2) {
        		try {
        			Sort.displayLoadingCaption(1, "merge sort"); 
        			Thread.sleep(speed); 
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}	
    			
    		}
    		
    		if(i < n1 && SinusoidSegment.segments[l + i].getColor() == Color.red) {
        		SinusoidSegment.segments[l + i].setColor(Color.black); 
        		SinusoidSegment.segments[l + i].repaint();
    		}
    		
    		if(j < n2 && SinusoidSegment.segments[m + 1 + j].getColor() == Color.red) {
    			SinusoidSegment.segments[m + 1 + j].setColor(Color.black); 
    			SinusoidSegment.segments[m + 1 + j].repaint();
    		}

    		
        }
        for (int j = 0; j < n2; ++j) {
        	R[j] = arr[m + 1 + j];
        	
        	R2[j] = SinusoidSegment.segments[m + 1 + j];
    		

        }
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        int totalLength = (int)arr[k].getBounds().getX();
        while (i < n1 && j < n2) {

            if (L[i].getBounds().getWidth() <= R[j].getBounds().getWidth()) {
                arr[k] = L[i];
                SinusoidSegment.segments[k] = L2[i];
            	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
            	totalLength += (int)arr[k].getBounds().getWidth();
                i++;

            }
            else {
                arr[k] = R[j];
                SinusoidSegment.segments[k] = R2[j];
            	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
            	totalLength += (int)arr[k].getBounds().getWidth();
                j++;
                
            }

            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            SinusoidSegment.segments[k] = L2[i];
        	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
        	totalLength += (int)arr[k].getBounds().getWidth();
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            SinusoidSegment.segments[k] = R2[j];
        	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
        	totalLength += (int)arr[k].getBounds().getWidth();
            j++;
            k++;

        }
        
        
		
		SinusoidSegment.segments[l].setColor(Color.black); 
		SinusoidSegment.segments[l].repaint();
		
		SinusoidSegment.segments[r].setColor(Color.black); 
		SinusoidSegment.segments[r].repaint();
		
		SinusoidSegment.segments[m].setColor(Color.black); 
		SinusoidSegment.segments[m].repaint();
		
		Sort.clearColors(r);
	
		try {
			Sort.displayLoadingCaption(2, "merge sort"); //delay
			Thread.sleep(speed); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(JPanel arr[], int l, int r)
    {

        	if (l < r) {
        		// Find the middle point
        		int m = (l + r) / 2;
        	
        		// Sort first and second halves
        		sort(arr, l, m);
        		sort(arr, m + 1, r);
        		
        		// Merge the sorted halves
        		merge(arr, l, m, r);
        		for(int i = l; i < r + 1; i++) {
            		SinusoidSegment.segments[i].setColor(Color.red); 
            		SinusoidSegment.segments[i].repaint();
            		
            		try {
            			Sort.displayLoadingCaption(2, "merge sort"); //delay
            			Thread.sleep(speed); 
            		} catch (InterruptedException e) {
            			e.printStackTrace();
            		}
            		
            		SinusoidSegment.segments[i].setColor(Color.black); 
            		SinusoidSegment.segments[i].repaint();
        			
        		}
        		
        		try {
        			Sort.displayLoadingCaption(2, "merge sort"); //delay
        			Thread.sleep(speed); 
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
        		
        		
        		
        	}
        	
        	
    }
    
    
    
    
    
    
    
    
	
}

//set l/r green
//set m blue

//set inner cycles red


















