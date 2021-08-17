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

public class SpecialPanel extends JPanel {

	public JTextField specialNameField = new JTextField(10);
	public JTextField specialDescField = new JTextField(50);
	public JCheckBox negative = new JCheckBox("Negative");

	public SpecialPanel() {
		
		super();
		
		Border specialBorder = BorderFactory.createTitledBorder("Special Effect");
		setBorder(specialBorder);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel specialName = new JPanel();
		JPanel specialDesc = new JPanel();

		JLabel specialNameLabel = new JLabel("Special Effect");
		JLabel specialDescLabel = new JLabel("Description");
				
		specialName.add(specialNameField);
		specialName.add(specialNameLabel);
		specialName.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		specialDesc.add(specialDescField);
		specialDesc.add(specialDescLabel);
		specialDesc.setLayout(new FlowLayout(FlowLayout.LEFT));

		add(specialName);
		add(specialDesc);
		add(negative);


	}

	public SpecialPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public SpecialPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public SpecialPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
