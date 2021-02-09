package com.sorting.visualizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class WindowTest {	
	
	@Test
	public void makeSegmentTest() {
		//Ensure each cycle has a wavelength within the interval [51, 100]
		Window window = new Window();
		int x = window.makeSegment();
		assertTrue(x >= 51 && x <= 100);
		assertFalse(x < 51);
		assertFalse(x > 100);
		//Ensure the sum of the wavelengths of the cycles is never greater than the length of the frame
		int totalWaveLengthCount = 0;
		for(int i = 0; i < 100000; i++) { //Simulate adding cycles to the frame, testing if <= 845 is a valid condition to keep the total wave length count <= 975
			if(totalWaveLengthCount <= 845) {
				totalWaveLengthCount += window.makeSegment();
			}else break;
		}
		
		assertTrue(totalWaveLengthCount <= 975);
		
		
	}
}
