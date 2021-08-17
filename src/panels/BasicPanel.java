package panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class BasicPanel extends JPanel {

	public JComboBox type;
	public JTextField typeAddendum;
	public JRadioButton overwriteMainhand = new JRadioButton("Slot Override: Mainhand");
	public JRadioButton overwriteOffhand = new JRadioButton("Slot Override: Offhand");
	public JComboBox tier;
	public JTextField id;
	public JSpinner count;
	public JTextField attack;
	public JTextField speed;
	public JTextField armor;
	public JTextField toughness;
	public JTextField damage;
	public JTextField name;
	public JCheckBox extraDetails = new JCheckBox("Show Extra Details");
	public JCheckBox smartLore = new JCheckBox("Use Smarter Lore Splitting");
	public JColorChooser nameColor;
	public JTextField lore;
	
	public BasicPanel() {
		super();
		
		String[] typeList = {"Melee Weapon", "Ranged Weapon", "Tool", "Hybrid Weapon", "Armor", "Offhand", "Shield", "Consumable", "Empowered Item", "Material", "Objective Item"};
		type = new JComboBox(typeList);
		JLabel typeLabel = new JLabel("Type");
		typeAddendum = new JTextField(20);
		ButtonGroup overwrite = new ButtonGroup();
		overwrite.add(overwriteMainhand);
		overwrite.add(overwriteOffhand);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		typePanel.add(typeLabel);
		typePanel.add(type);
		typePanel.add(typeAddendum);
		typePanel.add(overwriteMainhand);
		typePanel.add(overwriteOffhand);
		
		String[] tierList = {"Common Item", "Uncommon Item", "Unique Item", "Artifact", "Relic"};
		tier = new JComboBox(tierList);
		JLabel tierLabel = new JLabel("Tier");
		JPanel tierPanel = new JPanel();
		tierPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tierPanel.add(tierLabel);
		tierPanel.add(tier);
		
		id = new JTextField(20);
		JLabel idLabel = new JLabel("Id");
		JPanel idPanel = new JPanel();
		damage = new JTextField(10);
		JLabel damageLabel = new JLabel("Damage");
		idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		idPanel.add(idLabel);
		idPanel.add(id);
		idPanel.add(damageLabel);
		idPanel.add(damage);
		
		count = new JSpinner(new SpinnerNumberModel(1,1,64,1));
		JLabel countLabel = new JLabel("Count");
		JPanel countPanel = new JPanel();
		countPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		countPanel.add(countLabel);
		countPanel.add(count);
		
		attack = new JTextField(10);
		JLabel attackLabel = new JLabel("Atk Damage");
		speed = new JTextField(10);
		JLabel speedLabel = new JLabel("Atk Speed");
		JPanel defaultPanel = new JPanel();
		defaultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		defaultPanel.add(attackLabel);
		defaultPanel.add(attack);
		defaultPanel.add(speedLabel);
		defaultPanel.add(speed);
		
		armor = new JTextField(10);
		JLabel armorLabel = new JLabel("Armor");
		toughness = new JTextField(10);
		JLabel toughnessLabel = new JLabel("Armor Toughness");
		defaultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		defaultPanel.add(armorLabel);
		defaultPanel.add(armor);
		defaultPanel.add(toughnessLabel);
		defaultPanel.add(toughness);
		
		name = new JTextField(20);
		nameColor = new JColorChooser();
		
		
		JLabel nameLabel = new JLabel("Name");
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(name);
		namePanel.add(extraDetails);
		namePanel.add(smartLore);
		
		lore = new JTextField(50);
		JLabel loreLabel = new JLabel("Lore");
		JPanel lorePanel = new JPanel();
		lorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lorePanel.add(loreLabel);
		lorePanel.add(lore);
		
		JPanel basicTop = new JPanel();
		basicTop.setLayout(new GridLayout(4,1));
		JPanel basicLow = new JPanel();
		basicLow.setLayout(new GridLayout(2,1));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(typePanel);
		add(tierPanel);
		add(idPanel);
		add(countPanel);
		add(defaultPanel);
		add(nameColor);
		add(namePanel);
		add(lorePanel);
		
		//basic.add(basicTop);
		//basic.add(basicLow);		
		
		Border basicBorder = BorderFactory.createTitledBorder("Basic Stats");
		setBorder(basicBorder);

		
	}

	public BasicPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BasicPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BasicPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
