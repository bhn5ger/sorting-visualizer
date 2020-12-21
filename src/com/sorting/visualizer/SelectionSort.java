package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class SelectionSort {
	
	

    public static void sort(SinusoidSegment arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(SinusoidSegment.segments[i] != null) {
				SinusoidSegment.segments[i].setColor(Color.green);
				SinusoidSegment.segments[i].repaint();
			}

			
        	
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
            	
            	if(arr[j] == null) {
            		break;
            	}
            	
            	/*
    			try {
    				Thread.sleep(600);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    			SinusoidSegment.segments[j-1].setColor(Color.black);
    			SinusoidSegment.segments[j-1].repaint();
    			
    			SinusoidSegment.segments[j].setColor(Color.red);
    			SinusoidSegment.segments[j].repaint();
    			
            	 */
    		
            	
            	if (arr[j].width < arr[min_idx].width){
                	min_idx = j; 
                } 
  
            // Swap the found minimum element with the first 
            // element 
            }

            
            
            
            
            
            
            if(Window.segmentPanels[min_idx] != null) {
                SinusoidSegment temp = arr[min_idx]; 
                double temp2 = Window.segmentPanels[min_idx].getBounds().getX();
                JPanel temp3 = Window.segmentPanels[min_idx];
                
                arr[min_idx] = arr[i]; 
                Window.segmentPanels[min_idx].setBounds((int)Window.segmentPanels[i].getBounds().getX(), 35, (int)Window.segmentPanels[min_idx].getBounds().getWidth(), 100);
                Window.segmentPanels[min_idx] = Window.segmentPanels[i];
                
                
                double shift = Window.segmentPanels[i].getBounds().getWidth() - temp3.getBounds().getWidth();
                
                //Shift cycles in between the two cycles being switched
                for(int k = 0; k < Window.segmentPanels.length; k++) {
                	
                	if(Window.segmentPanels[k] == null) break;
                	
                	else if(Window.segmentPanels[k].getBounds().getX() > (int)Window.segmentPanels[i].getBounds().getX()
                		&& Window.segmentPanels[k].getBounds().getX() < (int)temp2){
                		
                		Window.segmentPanels[k].setBounds((int)(Window.segmentPanels[k].getBounds().getX() - shift), 35, (int)Window.segmentPanels[k].getBounds().getWidth() ,100);
                		
                		
                		
                	}
                	 
                	
                }
                
                
                
                arr[i] = temp; 
                Window.segmentPanels[i].setBounds((int)(temp2 - shift), 35, (int)Window.segmentPanels[i].getBounds().getWidth(), 100);
                Window.segmentPanels[i] = temp3;
         	
            }

            
            
        }
        
       for(int i = 0; i< Window.segmentPanels.length; i++) {
    	   if(Window.segmentPanels[i] == null) break;
    	   else {
    		   Window.frame.getContentPane().add(Window.segmentPanels[i]);
    		

    	   }
       } 
  
      
    }  
	
	
    
    
	
	
}
