package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ShieldPanel extends JPanel {

	public JSpinner model = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	public JSpinner blockModel = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	public JComboBox<String> blockType;
	public JSpinner blockValueMax = new JSpinner(new SpinnerNumberModel(1, 1, 40, 1));
	public JSpinner coyoteTime = new JSpinner(new SpinnerNumberModel(0,0,20,1));

	String[] persistenceArray = { "Low", "Medium", "High" };
	public JComboBox<String> persistenceType = new JComboBox<String>(persistenceArray);

	public JSpinner playerBlockEffect = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
	public JSpinner entityBlockEffect = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));

	public JSpinner shieldTimeMax = new JSpinner(new SpinnerNumberModel(0, 0, 1200, 10));
	public JSpinner cooldownTime = new JSpinner(new SpinnerNumberModel(0, 0, 1200, 10));

	public JTextField durabilityMax = new JTextField(5);

	public JSpinner bashEffectID = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

	public String[] blockAngleArray = { "Narrow", "Average", "Wide" };
	public JComboBox<String> blockAngle = new JComboBox<String>(blockAngleArray);

	public JRadioButton canBlockArrows = new JRadioButton();

	public JRadioButton disableResist = new JRadioButton();

	public JTextField disableTime = new JTextField(5);

	public JCheckBox showDmgRed = new JCheckBox("Show Dmg. Reduction");
	public JCheckBox showBlockAngle = new JCheckBox("Show Angle");
	public JCheckBox showPersistence = new JCheckBox("Show Persistence");
	public JCheckBox showHoldTime = new JCheckBox("Show Hold Time");
	public JCheckBox showCooldown = new JCheckBox("Show Cooldown");

	public ShieldPanel() {

		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel modelLabel = new JLabel("Default Model");
		JLabel blockModelLabel = new JLabel("Blocking Model");

		JPanel modelPanel = new JPanel();
		modelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		modelPanel.add(modelLabel);
		modelPanel.add(model);
		modelPanel.add(blockModelLabel);
		modelPanel.add(blockModel);

		JLabel blockTypeLabel = new JLabel("Blocking Type");
		JLabel coyoteLabel = new JLabel("Coyote Time (Parry)");
		String[] blockTypeArray = { "Normal Blocking", "Parry Blocking" };
		blockType = new JComboBox<String>(blockTypeArray);
		JPanel blockTypePanel = new JPanel();
		blockTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		blockTypePanel.add(blockTypeLabel);
		blockTypePanel.add(blockType);
		blockTypePanel.add(blockValueMax);
		blockTypePanel.add(coyoteLabel);
		blockTypePanel.add(coyoteTime);

		JLabel persistenceLabel = new JLabel("Persistence");

		JPanel persistence = new JPanel();
		persistence.setLayout(new FlowLayout(FlowLayout.LEFT));
		persistence.add(persistenceLabel);
		persistence.add(persistenceType);

		JLabel pBELabel = new JLabel("Player Block Effect ID");
		JLabel eBELabel = new JLabel("Entity Block Effect ID");

		JPanel blockEffects = new JPanel();
		blockEffects.setLayout(new FlowLayout(FlowLayout.LEFT));

		blockEffects.add(pBELabel);
		blockEffects.add(playerBlockEffect);

		blockEffects.add(eBELabel);
		blockEffects.add(entityBlockEffect);

		JPanel shieldTechnical = new JPanel();
		Border shieldTechBorder = BorderFactory.createTitledBorder("Technical Stats");
		shieldTechnical.setBorder(shieldTechBorder);

		shieldTechnical.setLayout(new BoxLayout(shieldTechnical, BoxLayout.Y_AXIS));

		JPanel shieldTimes = new JPanel();
		shieldTimes.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel timeLabel = new JLabel("Max Time");
		JLabel cooldownLabel = new JLabel("Cooldown");

		shieldTimes.add(timeLabel);
		shieldTimes.add(shieldTimeMax);
		shieldTimes.add(cooldownLabel);
		shieldTimes.add(cooldownTime);

		shieldTechnical.add(shieldTimes);

		JPanel techStats = new JPanel();
		techStats.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel durabilityMaxLabel = new JLabel("Max Durability");
		JLabel bashEffectIDLabel = new JLabel("Bash Effect ID");
		JLabel blockAngleLabel = new JLabel("Block Angle");
		canBlockArrows.setText("Can Block Arrows");

		techStats.add(durabilityMaxLabel);
		techStats.add(durabilityMax);
		techStats.add(bashEffectIDLabel);
		techStats.add(bashEffectID);
		techStats.add(blockAngleLabel);
		techStats.add(blockAngle);
		techStats.add(canBlockArrows);

		shieldTechnical.add(techStats);

		JPanel disables = new JPanel();
		Border disableBorder = BorderFactory.createTitledBorder("Disabling");
		disables.setBorder(disableBorder);

		disables.setLayout(new FlowLayout(FlowLayout.LEFT));

		disableResist.setText("Disable Resistant");
		JLabel disableTimeLabel = new JLabel("Disable Time");
		disableTime.setText("160");

		disables.add(disableResist);
		disables.add(disableTimeLabel);
		disables.add(disableTime);

		JPanel visuals = new JPanel();
		Border visualsBorder = BorderFactory.createTitledBorder("Visuals");
		visuals.setBorder(visualsBorder);
		visuals.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		visuals.add(showDmgRed);
		visuals.add(showBlockAngle);
		visuals.add(showPersistence);
		visuals.add(showHoldTime);
		visuals.add(showCooldown);

		add(modelPanel);
		add(blockTypePanel);
		add(persistence);
		add(blockEffects);
		add(shieldTechnical);
		add(disables);
		add(visuals);
	}

	public ShieldPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ShieldPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ShieldPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
