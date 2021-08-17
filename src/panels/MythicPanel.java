package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MythicPanel extends JPanel {

	public JTextField mythNameField = new JTextField(10);
	public JTextField mythDescField = new JTextField(50);
	public JCheckBox negative = new JCheckBox("Negative");
	
	public MythicPanel() {

		super();
		
		Border mythicBorder = BorderFactory.createTitledBorder("Mythic Effect");
		setBorder(mythicBorder);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel mythName = new JPanel();
		JPanel mythDesc = new JPanel();

		JLabel mythNameLabel = new JLabel("Mythical Effect");
		JLabel mythDescLabel = new JLabel("Description");
				
		mythName.add(mythNameField);
		mythName.add(mythNameLabel);
		mythName.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		mythDesc.add(mythDescField);
		mythDesc.add(mythDescLabel);
		mythDesc.setLayout(new FlowLayout(FlowLayout.LEFT));

		add(mythName);
		add(mythDesc);
		add(negative);
		
	}

	public MythicPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public MythicPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MythicPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
