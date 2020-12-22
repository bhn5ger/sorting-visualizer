package com.sorting.visualizer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Window implements ActionListener {

	
	public static JFrame frame;
	public static JLabel lblNewLabel_1;
	public static JPanel [] segmentPanels = new JPanel[13]; // store panels for future removal
	public static boolean isSorting = false;
	public static JComboBox comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					Window.frame.setVisible(true);
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
		frame = new JFrame("Sorting Visualizer");
		frame.setBounds(100, 100, 784, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(-15, 172, 793, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null); 
		
		
		JButton btnNewButton = new JButton("Add Cycle");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(39, 27, 108, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Control Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(39, 8, 152, 14);
		panel.add(lblNewLabel);
		
		JButton playAnimation = new JButton("Sort");
		//playAnimation.setIcon(new ImageIcon("res/unnamed.png"));
		
		
		playAnimation.addActionListener(this);
		playAnimation.setBounds(625, 27, 108, 23);
		panel.add(playAnimation);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		
		btnClear.setBounds(161, 27, 108, 23);
		panel.add(btnClear);
		
		
		
		
		
		String [] sortOptions = {"Nothing", "Selection Sort"};
		comboBox = new JComboBox(sortOptions);
		comboBox.addActionListener(this);
		comboBox.setBounds(284, 27, 108, 23);
		panel.add(comboBox);
		
		JSlider slider = new JSlider();
		slider.setBorder(null);
		slider.setBackground(UIManager.getColor("Button.background"));
		slider.setBounds(507, 28, 108, 23);
		panel.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("Animation Speed");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(405, 29, 134, 19);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(571, 145, 185, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Wavelength Sorting Visualizer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(22, 1, 245, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		frame.setResizable(false);

	}
	

	
	
	public int makeSegment() { 
		
			int totalLength = 0; 
			totalLength = SinusoidSegment.sineLength; 
			DrawSegment d1 = new DrawSegment();
		
		 
		 
			JPanel panel_1 = d1;
			segmentPanels[SinusoidSegment.numberOfSegments] = panel_1; // store panels for future removal
			
			
			int wid = d1.seg.width;
			panel_1.setBounds(totalLength, 35, wid, 100); 
			frame.getContentPane().add(panel_1);
			frame.setVisible(true);
		
			SinusoidSegment.segments[SinusoidSegment.numberOfSegments] = d1.seg;
			SinusoidSegment.numberOfSegments++;
			return wid;
		

			
  
	} 

 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add Cycle") && isSorting == false) {
			if(SinusoidSegment.sineLength <= 700) { 
				lblNewLabel_1.setText("Cycle with wavelength " + makeSegment() + " added.");
			}
			else {lblNewLabel_1.setText("Cannot add more cycles!");}
			

		}
		
		
		
		
		if(e.getActionCommand().equals("Sort") && isSorting == false) {
			Sort s = new Sort(String.valueOf(comboBox.getSelectedItem()));
			isSorting = true;
		}
		
		
		
		if(e.getActionCommand().equals("Clear") && isSorting == false) {
			clearSegments();
			
		}
		
			
			
		 
		
	}
	
    public void clearSegments() {
    	
    	for (int i = 0; i < SinusoidSegment.segments.length; i++) {
    		if(SinusoidSegment.numberOfSegments != 0) {
				Window.frame.getContentPane().remove(Window.segmentPanels[i]);
				  
				Window.frame.revalidate(); 
				Window.frame.repaint();
    			Window.segmentPanels[i] = null; 
    			SinusoidSegment.segments[i] = null;
    			SinusoidSegment.numberOfSegments--;
				 
    		} 
    	} 
    	lblNewLabel_1.setText("Cleared!");
    	SinusoidSegment.numberOfSegments = 0;
    	SinusoidSegment.sineLength = 0; 
    
    }
}
