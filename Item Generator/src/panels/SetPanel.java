package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SetPanel extends JPanel {

	public JTextField setNameField = new JTextField(10);
	public JTextField setPerField = new JTextField(10);
	public JTextField setOneField = new JTextField(10);
	public JTextField setTwoField = new JTextField(10);
	public JTextField setThreeField = new JTextField(10);
	public JTextField setFourField = new JTextField(10);
	public JTextField setFiveField = new JTextField(10);
	public JTextField setSixField = new JTextField(10);
	
	public ArrayList<JTextField> setList = new ArrayList<JTextField>();
	
	public SetPanel() {
		
		super();
		
		Border setBorder = BorderFactory.createTitledBorder("Set Bonus");
		setBorder(setBorder);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel setNamePer = new JPanel();
		JPanel setOneTwo = new JPanel();
		JPanel setThreeFour = new JPanel();
		JPanel setFiveSix = new JPanel();

		JLabel setNameLabel = new JLabel("Set Name");
		JLabel setPerLabel = new JLabel("Per Item Bonus");
		JLabel setOneLabel = new JLabel("1 Item Bonus");
		JLabel setTwoLabel = new JLabel("2 Item Bonus");
		JLabel setThreeLabel = new JLabel("3 Item Bonus");
		JLabel setFourLabel = new JLabel("4 Item Bonus");
		JLabel setFiveLabel = new JLabel("5 Item Bonus");
		JLabel setSixLabel = new JLabel("6 Item Bonus");
				
		setNamePer.add(setNameField);
		setNamePer.add(setNameLabel);
		setNamePer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setNamePer.add(setPerField);
		setNamePer.add(setPerLabel);
		setNamePer.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setOneTwo.add(setOneField);
		setOneTwo.add(setOneLabel);
		setOneTwo.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setOneTwo.add(setTwoField);
		setOneTwo.add(setTwoLabel);
		setOneTwo.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setThreeFour.add(setThreeField);
		setThreeFour.add(setThreeLabel);
		setThreeFour.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setThreeFour.add(setFourField);
		setThreeFour.add(setFourLabel);
		setThreeFour.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setFiveSix.add(setFiveField);
		setFiveSix.add(setFiveLabel);
		setFiveSix.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setFiveSix.add(setSixField);
		setFiveSix.add(setSixLabel);
		setFiveSix.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(setNamePer);
		add(setOneTwo);
		add(setThreeFour);
		add(setFiveSix);
		
		setList.add(setNameField);
		setList.add(setPerField);
		setList.add(setOneField);
		setList.add(setTwoField);
		setList.add(setThreeField);
		setList.add(setFourField);
		setList.add(setFiveField);
		setList.add(setSixField);

	}

	public SetPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public SetPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public SetPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
