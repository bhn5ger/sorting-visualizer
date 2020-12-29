package com.sorting.visualizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class WindowTest {	
	
	@Test
	public void makeSegmentTest() {
		//Ensure each cycle has a wavelength within the interval [51, 90]
		Window window = new Window();
		int x = window.makeSegment();
		assertTrue(x >= 51 && x <= 90);
		assertFalse(x < 51);
		assertFalse(x > 90);
		//Ensure the sum of the wavelengths of the cycles is never greater than the length of the frame
		int totalWaveLengthCount = 0;
		for(int i = 0; i < 100000; i++) { //Simulate adding a cycle to the frame
			if(totalWaveLengthCount <= 775) {
				totalWaveLengthCount += window.makeSegment();
			}else break;
		}
		
		assertTrue(totalWaveLengthCount <= 864);
		
		
	}
}
