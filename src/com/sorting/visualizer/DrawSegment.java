package com.sorting.visualizer;


import javax.swing.JPanel;
import java.awt.BorderLayout;



@SuppressWarnings("serial")
public class DrawSegment extends JPanel {
    public SinusoidSegment seg = new SinusoidSegment(); 
  

    public DrawSegment() { 
      super(new BorderLayout());
        add(BorderLayout.CENTER,seg);
   
          
    } 


    
}