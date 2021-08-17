package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ActivePanel extends JPanel {

	public JTextField activeNameField = new JTextField(10);
	public JTextField activeDescField = new JTextField(50);
	public JTextField activeCooldown = new JTextField(10);
	public JRadioButton noCooldown = new JRadioButton("No Cooldown");

	public ActivePanel() {
		
		super();
		
		Border activeBorder = BorderFactory.createTitledBorder("Active Effect");
		setBorder(activeBorder);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel activeName = new JPanel();
		JPanel activeDesc = new JPanel();
		JPanel activeCool = new JPanel();

		JLabel activeNameLabel = new JLabel("Active Effect");
		JLabel activeDescLabel = new JLabel("Description");
		JLabel activeCoolLabel = new JLabel("Cooldown");

		activeName.add(activeNameField);
		activeName.add(activeNameLabel);
		activeName.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		activeDesc.add(activeDescField);
		activeDesc.add(activeDescLabel);
		activeDesc.setLayout(new FlowLayout(FlowLayout.LEFT));

		activeCool.add(activeCooldown);
		activeCool.add(activeCoolLabel);
		activeCool.add(noCooldown);
		activeCool.setLayout(new FlowLayout(FlowLayout.LEFT));

		
		add(activeName);
		add(activeDesc);
		add(activeCool);


	}

	public ActivePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ActivePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ActivePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
