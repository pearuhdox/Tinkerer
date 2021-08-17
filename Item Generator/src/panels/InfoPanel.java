package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InfoPanel extends JPanel {

	public JTextField infoNameField = new JTextField(10);
	public JTextField infoDescField = new JTextField(50);
	public JRadioButton beforeMain = new JRadioButton("Before Main Stats");
	public JRadioButton afterMain = new JRadioButton("After Main Stats");

	public InfoPanel() {
		
		super();
		
		Border infoBorder = BorderFactory.createTitledBorder("Information Tile");
		setBorder(infoBorder);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel infoName = new JPanel();
		JPanel infoDesc = new JPanel();

		JLabel infoNameLabel = new JLabel("Special Effect");
		JLabel infoDescLabel = new JLabel("Description");
				
		infoName.add(infoNameField);
		infoName.add(infoNameLabel);
		infoName.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		infoDesc.add(infoDescField);
		infoDesc.add(infoDescLabel);
		infoDesc.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(beforeMain);
		buttonPanel.add(afterMain);
		
		ButtonGroup buttons = new ButtonGroup();
		
		buttons.add(beforeMain);
		buttons.add(afterMain);
		
		add(infoName);
		add(infoDesc);
		add(buttonPanel);

	}

	public InfoPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public InfoPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public InfoPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
