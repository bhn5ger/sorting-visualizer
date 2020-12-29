package com.sorting.visualizer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.TitledBorder;

public class Window implements ActionListener, ChangeListener{

	
	public static JFrame frame;
	public static JLabel lblNewLabel_1;
	public static JPanel [] segmentPanels = new JPanel[13]; // store panels for future removal
	public static boolean isSorting = false;
	public static JComboBox comboBox;
	public static JSlider slider;
	
	private static int speed = 600 - 300;
	
	public static int cycleYPos = 50;
	

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
		frame.setBounds(100, 100, 864, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Control Panel", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(-789, 187, 1699, 79);
		frame.getContentPane().add(panel);
		panel.setLayout(null); 
		
		
		JButton btnNewButton = new JButton("Add Cycle");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(879, 27, 108, 23);
		panel.add(btnNewButton);
		
		JButton playAnimation = new JButton("Sort");
		playAnimation.setBackground(Color.LIGHT_GRAY);
		//playAnimation.setIcon(new ImageIcon("res/unnamed.png"));
		
		
		playAnimation.addActionListener(this);
		playAnimation.setBounds(1443, 27, 108, 23);
		panel.add(playAnimation);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.addActionListener(this);
		
		btnClear.setBounds(997, 27, 108, 23);
		panel.add(btnClear);
		
		
		
		
		
		String [] sortOptions = {"Select...", "Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort"};
		comboBox = new JComboBox(sortOptions);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.addActionListener(this);
		comboBox.setBounds(1115, 27, 108, 23);
		panel.add(comboBox);
		
		slider = new JSlider();
		
		slider.setMaximum(500);
		slider.setMinimum(100);
		
		slider.setValue(300);
		
		slider.setMinorTickSpacing(100);
		//slider.setPaintTicks(true);
		
		slider.addChangeListener(this);
		slider.setBorder(null);
		slider.setBackground(UIManager.getColor("Button.background"));
		slider.setBounds(1328, 18, 108, 42);
		panel.add(slider);
		
		JLabel lblNewLabel_2 = new JLabel("Animation Speed");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(1233, 28, 134, 19);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(650, 164, 185, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Wavelength Sorting Visualizer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(22, 6, 245, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		frame.setResizable(false);

	}
	

	
	
	public int makeSegment() { 
		
			int totalLength = 0; 
			totalLength = Cycle.totalWaveLength; 
			DrawCycle d1 = new DrawCycle();
		
		 
		 
			JPanel panel_1 = d1;
			segmentPanels[Cycle.numberOfCycles] = panel_1; // store panels for future removal
			
			
			int wid = d1.seg.cycleWaveLength;
			panel_1.setBounds(totalLength, cycleYPos, wid, 100); 
			frame.getContentPane().add(panel_1);
			frame.setVisible(true);
		
			Cycle.cycles[Cycle.numberOfCycles] = d1.seg;
			Cycle.numberOfCycles++;
			return wid;
		

			
  
	} 

 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Cycle") && isSorting == false) {
			if(Cycle.totalWaveLength <= 775) { 
				lblNewLabel_1.setText("Cycle with wavelength " + makeSegment() + " added.");
			}
			else {lblNewLabel_1.setText("Cannot add more cycles!");}
			

		}
		
		
		
		
		if(e.getActionCommand().equals("Sort") && isSorting == false) {
			Sort s = new Sort(String.valueOf(comboBox.getSelectedItem()), speed);
			isSorting = true;
		}
		
		
		
		if(e.getActionCommand().equals("Clear") && isSorting == false) {
			clearSegments();
			
		}
		

	}

	
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
      	JSlider source = (JSlider)e.getSource();
      	speed = 600 - source.getValue();
		
	}
	
	
	
	
    public void clearSegments() {
    	
    	for (int i = 0; i < Cycle.cycles.length; i++) {
    		if(Cycle.numberOfCycles != 0) {
				Window.frame.getContentPane().remove(Window.segmentPanels[i]);
				  
				Window.frame.revalidate(); 
				Window.frame.repaint();
    			Window.segmentPanels[i] = null; 
    			Cycle.cycles[i] = null;
    			Cycle.numberOfCycles--;
				 
    		} 
    	} 
    	lblNewLabel_1.setText("Cleared!");
    	Cycle.numberOfCycles = 0;
    	Cycle.totalWaveLength = 0; 
    
    }
}
