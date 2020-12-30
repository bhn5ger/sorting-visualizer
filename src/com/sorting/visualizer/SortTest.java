package com.sorting.visualizer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
	Window window;
	@Before
	public void setUp(){
		window = new Window();
		int totalWaveLengthCount = 0;
		for(int i = 0; i < 100000; i++) { //Simulate adding a wave to the frame
			if(totalWaveLengthCount <= 775) {
				totalWaveLengthCount += window.makeSegment();
			}else break;
		}
	}
	
	@After
	public void tearDown(){ //after each test, set all variables back to zero and destroy the frame
		window.clearSegments(); 
		Window.frame.dispose();
	}

	@Test
	public void selectionSortTest() {
		SelectionSort.speed = 25;
		SelectionSort.sort(Cycle.cycles); //Do a selection sort with the cycles generated in setUp()
		
		for(int i = 0; i < Cycle.cycles.length - 1; i++) {
			if(Cycle.cycles[i + 1] == null) break;
			assertTrue(Cycle.cycles[i].cycleWaveLength <= Cycle.cycles[i + 1].cycleWaveLength); //Ensure they are in ascending order after sorting
		} 
		
	}
	
	@Test
	public void insertionSortTest() {
		InsertionSort.speed = 75;
		InsertionSort.sort(Window.segmentPanels); //Do an insertion sort with the cycles generated in setUp()
		
		for(int i = 0; i < Cycle.cycles.length - 1; i++) {
			if(Cycle.cycles[i + 1] == null) break;
			assertTrue(Cycle.cycles[i].cycleWaveLength <= Cycle.cycles[i + 1].cycleWaveLength); //Ensure they are in ascending order after sorting
		}
		
	}
	
	@Test
	public void bubbleSortTest() {
		BubbleSort.speed = 25;
		BubbleSort.sort(Window.segmentPanels); //Do a bubble sort with the cycles generated in setUp()
		
		for(int i = 0; i < Cycle.cycles.length - 1; i++) {
			if(Cycle.cycles[i + 1] == null) break;
			assertTrue(Cycle.cycles[i].cycleWaveLength <= Cycle.cycles[i + 1].cycleWaveLength); //Ensure they are in ascending order after sorting
		}
		
	}
	
	@Test
	public void mergeSortTest() {
		MergeSort.speed = 75;
		MergeSort.sort(Window.segmentPanels, 0, Cycle.numberOfCycles - 1); //Do a merge sort with the cycles generated in setUp()
		
		for(int i = 0; i < Cycle.cycles.length - 1; i++) {
			if(Cycle.cycles[i + 1] == null) break;
			assertTrue(Cycle.cycles[i].cycleWaveLength <= Cycle.cycles[i + 1].cycleWaveLength); //Ensure they are in ascending order after sorting
		}
		
	}
	
	
	

}
