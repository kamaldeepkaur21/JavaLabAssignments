import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
public class Internal extends JFrame implements ActionListener {
	
	JTextField tf = new JTextField(20);
	String font = "";
	int size;
	int type;
	JButton button1 ;
	JButton button2;
	Font basicFont = tf.getFont();
	JCheckBox bold;
	JCheckBox italics;
	JCheckBox regular;
	JRadioButton size1;
	JRadioButton size2 ;
	JRadioButton size3 ;
	JRadioButton red;
	JRadioButton green;
	JRadioButton font1;
	JRadioButton font2;
	JRadioButton font3;
	JRadioButton font4;
	
	
	public Internal()
	{
		super("Form4");
		setSize(800,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 tf.setBounds(200,  20,  160, 35);
		 JLabel text1 = new JLabel("Text1");
		 text1.setBounds(100, 20, 100, 30);
		
		 ButtonGroup bg1=new ButtonGroup();  
	     font1 = new JRadioButton("Courier");
	     font1.setFocusable( false );
	     font2 = new JRadioButton("Comic Sans MS");
	     font2.setFocusable( false );
	     font3 = new JRadioButton("Harlow Solid");
	     font3.setFocusable( false );
	     font4 = new JRadioButton("Bahnschrift");
	     font4.setFocusable( false );
	    
	     bg1.add(font1);
	     bg1.add(font2);
	     bg1.add(font3);
	     bg1.add(font4);
	     
	     
	     
	     JPanel fontName = new JPanel();
	     fontName.add(font1);
	     fontName.setLayout(new GridLayout(0, 1));
	     fontName.add(font2);
	     fontName.add(font3);
	     fontName.add(font4);
	     
	     Border border = BorderFactory.createTitledBorder("Font name");
	     fontName.setBorder(border);
	     fontName.setBounds(50,  150, 300, 200);
	     
	     
	     
	     ButtonGroup bg2=new ButtonGroup(); 
	     red = new JRadioButton("Red");
	     red.setFocusable( false );
	     green = new JRadioButton("Green");
	     green.setFocusable( false );
	     bg2.add(red);
	     bg2.add(green);
	     
	     JPanel colorPanel = new JPanel();
	     colorPanel.setLayout(new GridLayout(0, 1));
	     colorPanel.add(red);
	     colorPanel.add(green);

	     
	     Border border1 = BorderFactory.createTitledBorder("Colour");
	     colorPanel.setBorder(border1);
	     colorPanel.setBounds(400, 100, 150, 100);
	     
	     
	     ButtonGroup bg3=new ButtonGroup(); 
	     size1 = new JRadioButton("10");
	     size1.setFocusable( false );
	     size2 = new JRadioButton("20");
	     size2.setFocusable( false );
	     size3 = new JRadioButton("30");
	     size3.setFocusable( false );
	     bg3.add(size1);
	     bg3.add(size2);
	     bg3.add(size3);
	     
	     JPanel sizePanel = new JPanel();
	     sizePanel.setLayout(new GridLayout(0, 1));
	     sizePanel.add(size1);
	     sizePanel.add(size2);
	     sizePanel.add(size3);
	     

	     
	     Border border3 = BorderFactory.createTitledBorder("Size");
	     sizePanel.setBorder(border3);
	     sizePanel.setBounds(400, 250, 300, 150);
	     
	     
	     bold = new JCheckBox("Bold");
	     bold.setFocusable( false );
	     italics = new JCheckBox("Italics");
	     italics.setFocusable( false );
	     regular = new JCheckBox("Regular");
	     regular.setFocusable( false );
	     
	     JPanel stylePanel = new JPanel();
	     stylePanel.setLayout(new GridLayout(0, 1));
	     stylePanel.add(bold);
	     stylePanel.add(italics);
	     stylePanel.add(regular);
	     
	     Border border4 = BorderFactory.createTitledBorder("Font Style");
	     stylePanel.setBorder(border4);
	     stylePanel.setBounds(50, 400, 200, 150);
	     
	     button1 = new JButton("Reset");
	     button2 = new JButton("Apply Format");
	     button1.setBounds(400, 420, 100, 30);
	     button2.setBounds(550, 420, 150, 30);
	     button2.addActionListener(this);
	     button1.addActionListener(this);
	     
	     
	     
	     
	    add(text1);
	    add(tf);
	    add(button1);
	    add(button2);
	    add(fontName);
	    add(colorPanel);
	    add(sizePanel);
	    add(stylePanel);
		setLayout(null);  
		setVisible(true);
	}
	

    public void actionPerformed(ActionEvent e){
    	
    	
    	font = "";
    	size = 14;
    	type=0;
    	if(e.getSource() == button2)
    	{
    		if(font1.isSelected())
    			font = "Courier";
    		if(font2.isSelected())
    			font = "Comic Sans MS";
    		if(font3.isSelected())
    			font = "Harlow Solid";
    		if(font4.isSelected())
    			font = "Bahnschrift";
    		if(size1.isSelected())
        		size = 10;
    		if(size2.isSelected())
        		size = 20;
    		if(size3.isSelected())
        		size = 30;
    		if(bold.isSelected())
        		type+=Font.BOLD;
    		if(italics.isSelected())
				type+=Font.ITALIC;
    		if(regular.isSelected())
    			type = 0;
    		
    		
    		
    		
    		tf.setForeground(Color.black);
    		tf.setFont(new Font (font , type , size));
    		if(red.isSelected())
        		tf.setForeground(Color.RED);
    		else if(green.isSelected())
        		tf.setForeground(Color.GREEN);

    		
    	}
    	if(e.getSource()==button1)
    	{
    		 tf.setFont(basicFont);
    		 tf.setForeground(Color.black);
    	}
    }
	
	public static void main(String args[])
	{
		new Internal();
	}
}
