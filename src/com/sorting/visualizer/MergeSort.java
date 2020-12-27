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
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        JPanel L[] = new JPanel[n1];
        JPanel R[] = new JPanel[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        int totalLength = (int)arr[k].getBounds().getX();
        while (i < n1 && j < n2) {
            if (L[i].getBounds().getWidth() <= R[j].getBounds().getWidth()) {
                arr[k] = L[i];
            	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
            	totalLength += (int)arr[k].getBounds().getWidth();
                i++;
            }
            else {
                arr[k] = R[j];
            	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
            	totalLength += (int)arr[k].getBounds().getWidth();
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
        	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
        	totalLength += (int)arr[k].getBounds().getWidth();
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
        	Window.segmentPanels[k].setBounds(totalLength, Window.cycleYPos, (int)arr[k].getBounds().getWidth(),100);
        	totalLength += (int)arr[k].getBounds().getWidth();
            j++;
            k++;

        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(JPanel arr[], int l, int r)
    {
    	int p = 0;
        	if (l < r) {
        		// Find the middle point
        		int m = (l + r) / 2;
 
        		// Sort first and second halves
        		sort(arr, l, m);
        		sort(arr, m + 1, r);
 
        		// Merge the sorted halves
        		merge(arr, l, m, r);
        	}
        	
        	
    }
    
    
    
    
    
    
    
    
	
}
