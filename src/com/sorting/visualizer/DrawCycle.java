package com.sorting.visualizer;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;



@SuppressWarnings("serial")
public class DrawCycle extends JPanel {
    public Cycle seg = new Cycle(); 
  

    public DrawCycle() {
		
      super(new BorderLayout());
      add(BorderLayout.CENTER,seg);
          
    } 


    
}