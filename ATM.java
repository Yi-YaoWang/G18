package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ATM extends JPanel implements ActionListener {
	
	public static final long serialVersionUID = 1L;
    public static final int WIDTH=400;
    public static final int HEIGHT=500;
	
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private JButton[] numButtons;
    private JButton[] opButtons;
    
    private String ip = " ";
    
    private int [][] numConstraints = new int[][]{
    		{1,4,1,1},
    		{0,3,1,1},
    		{1,3,1,1},
    		{2,3,1,1},
    		{0,2,1,1},
    		{1,2,1,1},
    		{2,2,1,1},
    		{0,1,1,1},
    		{1,1,1,1},
    		{2,1,1,1},
    		{2,4,1,1}
    };
    
    private int [][] opConstraints = new int[][]{
    		{3,4,1,1},
    		{3,3,1,1},
    		{3,2,1,1},
    		{3,1,1,1},
    		{0,4,1,1}
    };
   
    private JTextField field;
    
	private double num1, answer;
	private int op;

	
    public ATM(){
	   	setPreferredSize(new Dimension(WIDTH,HEIGHT));
	   	layout = new GridBagLayout();
	   	layout.columnWidths = new int[] {100,100,100,100};
	   	layout.rowHeights = new int[]{100,100,100,100,100};
	   	setLayout(layout);
	   	
	   	numButtons = new JButton[11];
	   	gbc = new GridBagConstraints();
	   	
	   	for(int i=0;i<numButtons.length-1;i++){
	   		numButtons[i] = new JButton(""+i);
	   		numButtons[i].addActionListener(this);
	   		gbc.gridx = numConstraints[i][0];
	   		gbc.gridy = numConstraints[i][1];
	   		gbc.gridwidth = numConstraints[i][2];
	   		gbc.gridheight = numConstraints[i][3];
	   		gbc.fill = GridBagConstraints.BOTH;
	   		gbc.insets = new Insets(2,2,2,2);
	   		add(numButtons[i],gbc);	
	   	}
	   	
	   	numButtons[10] = new JButton("00");
   		numButtons[10].addActionListener(this);
   		gbc.gridx = numConstraints[10][0];
   		gbc.gridy = numConstraints[10][1];
   		gbc.gridwidth = numConstraints[10][2];
   		gbc.gridheight = numConstraints[10][3];
   		gbc.fill = GridBagConstraints.BOTH;
   		gbc.insets = new Insets(2,2,2,2);
   		add(numButtons[10],gbc);	
	   	
	   	opButtons = new JButton[5];
	   	opButtons[0] = new JButton("Deposit");
	   	opButtons[1] = new JButton("Withdraw");
	   	opButtons[2] = new JButton("Check");
	   	opButtons[3] = new JButton("Clear");
	   	opButtons[4] = new JButton(".");
	   	
	   	for(int i=0;i<opButtons.length;i++){
	   		gbc.gridx = opConstraints[i][0];
	   		gbc.gridy = opConstraints[i][1];
	   		gbc.gridwidth = opConstraints[i][2];
	   		gbc.gridheight = opConstraints[i][3];
	   		gbc.fill = GridBagConstraints.BOTH;
	   		gbc.insets = new Insets(2,2,2,2);
	   		add(opButtons[i],gbc);
	   		opButtons[i].addActionListener(this);
	   		
	   	}
	   	
	   	field = new JTextField();
	   	field.setEditable(false);
	   	field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	   	field.setFont(new Font("Arial", Font.PLAIN, 50));
	   	field.setHorizontalAlignment(JTextField.RIGHT);
   		gbc.gridx = 0;
   		gbc.gridy = 0;
   		gbc.gridwidth = 4;
   		gbc.gridheight = 1;
   		gbc.fill = GridBagConstraints.BOTH;
   		gbc.insets = new Insets(2,2,2,2);
   		add(field,gbc);	
	   	
	}

	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < numButtons.length-1; i++){
			if(e.getSource() == numButtons[i]){
				field.setText(field.getText()+i);
			}
		}
		if(e.getSource() == numButtons[10]){
			field.setText(field.getText()+"00");
		}
		
		if(e.getSource() == opButtons[0] ){
			num1 = Double.parseDouble(field.getText());
			field.setText("");
		}else if(e.getSource() == opButtons[1]){
			num1 = Double.parseDouble(field.getText());
			field.setText("");
		}
		//op[2] = check
		else if(e.getSource() == opButtons[2]){
			num1 = Double.parseDouble(field.getText());
			field.setText(field.getText());
			ip = field.getText();
			new ClientThreadCode(ip, 8000).run();
			System.out.println(ip);
		}
		else if(e.getSource() == opButtons[3]){
			num1 = Double.parseDouble(field.getText());
			field.setText("");
		}
//		else if(e.getSource() == opButtons[4] && !field.getText().contains(".")){
//			field.setText(field.getText()+ ".");
//		}
		else if(e.getSource() == opButtons[4]){
			field.setText(field.getText()+ ".");
		}
	}
	public String get_ip(){
		return field.getText();
	}
}
