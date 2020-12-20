package com.sorting.visualizer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window implements ActionListener {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Window() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame("Sinusoid Segment Sorting Visualizer");
		frame.setBounds(100, 100, 784, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		panel.setBounds(-15, 172, 793, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null); 
		
		
		JButton btnNewButton = new JButton("Add Cycle");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(347, 24, 108, 23);
		panel.add(btnNewButton);
		
		
		frame.setResizable(false);
		/*
		int totalLength = 0;
		for(int i = 0; i < 10; i++) {
	
			totalLength = SinusoidSegment.sineLength; 
			DrawSegment d1 = new DrawSegment();
			JPanel panel_1 = d1;
			panel_1.setBounds(totalLength, 0, d1.seg.width, 140);
			frame.getContentPane().add(panel_1);
		}
		
		*/
		//makeSegment();
	}
	

	
	
	public void makeSegment() { 
		
		int totalLength = 0;
		
	
			totalLength = SinusoidSegment.sineLength; 
			DrawSegment d1 = new DrawSegment();
			JPanel panel_1 = d1;
			panel_1.setBounds(totalLength, 0, d1.seg.width, 140);
			frame.getContentPane().add(panel_1);
		 
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add Cycle")) {
			makeSegment();
			
		}
		
	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
