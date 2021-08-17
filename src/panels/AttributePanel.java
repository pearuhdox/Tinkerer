package panels;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class AttributePanel extends JPanel {

	public ArrayList<JComboBox<String>> boxList = new ArrayList<JComboBox<String>>();
	public ArrayList<JTextField> fieldList = new ArrayList<JTextField>();
	
	JComboBox<String> attrHealthOption;
	JComboBox<String> attrKBROption;
	JComboBox<String> attrSpeedOption;
	JComboBox<String> attrDamageOption;
	JComboBox<String> attrArmorOption;
	JComboBox<String> attrToughnessOption;
	JComboBox<String> attrAttackSpeedOption;
	JComboBox<String> attrLuckOption;

	JTextField attrHealthAmount;
	JTextField attrKBRAmount;
	JTextField attrSpeedAmount;
	JTextField attrDamageAmount;
	JTextField attrArmorAmount;
	JTextField attrToughnessAmount;
	JTextField attrAttackSpeedAmount;
	JTextField attrLuckAmount;

	public AttributePanel() {
		super();
		
		
		Border attributesBorder = BorderFactory.createTitledBorder("Attributes");
		setBorder(attributesBorder);

		JPanel attributeHealth = new JPanel();
		JPanel attributeKBR = new JPanel();
		JPanel attributeSpeed = new JPanel();
		JPanel attributeDamage = new JPanel();
		JPanel attributeArmor = new JPanel();
		JPanel attributeToughness = new JPanel();
		JPanel attributeAttackSpeed = new JPanel();
		JPanel attributeLuck = new JPanel();

		String[] attrOptions = { "Add", "Multiply Base", "Multiply" };

		attrHealthOption = new JComboBox<String>(attrOptions);
		attrKBROption = new JComboBox<String>(attrOptions);
		attrSpeedOption = new JComboBox<String>(attrOptions);
		attrDamageOption = new JComboBox<String>(attrOptions);
		attrArmorOption = new JComboBox<String>(attrOptions);
		attrToughnessOption = new JComboBox<String>(attrOptions);
		attrAttackSpeedOption = new JComboBox<String>(attrOptions);
		attrLuckOption = new JComboBox<String>(attrOptions);

		attrHealthAmount = new JTextField(10);
		attrKBRAmount = new JTextField(10);
		attrSpeedAmount = new JTextField(10);
		attrDamageAmount = new JTextField(10);
		attrArmorAmount = new JTextField(10);
		attrToughnessAmount = new JTextField(10);
		attrAttackSpeedAmount = new JTextField(10);
		attrLuckAmount = new JTextField(10);

		JLabel attrHealthLabel = new JLabel("Max Health");
		JLabel attrKBRLabel = new JLabel("KBR");
		JLabel attrSpeedLabel = new JLabel("Move Speed");
		JLabel attrDamageLabel = new JLabel("Damage");
		JLabel attrArmorLabel = new JLabel("Armor");
		JLabel attrToughnessLabel = new JLabel("Toughness");
		JLabel attrAttackSpeedLabel = new JLabel("Attack Speed");
		JLabel attrLuckLabel = new JLabel("Luck");

		attributeHealth.add(attrHealthLabel);
		attributeHealth.add(attrHealthOption);
		attributeHealth.add(attrHealthAmount);

		attributeHealth.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeKBR.add(attrKBRLabel);
		attributeKBR.add(attrKBROption);
		attributeKBR.add(attrKBRAmount);

		attributeKBR.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeSpeed.add(attrSpeedLabel);
		attributeSpeed.add(attrSpeedOption);
		attributeSpeed.add(attrSpeedAmount);

		attributeSpeed.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeDamage.add(attrDamageLabel);
		attributeDamage.add(attrDamageOption);
		attributeDamage.add(attrDamageAmount);

		attributeDamage.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeArmor.add(attrArmorLabel);
		attributeArmor.add(attrArmorOption);
		attributeArmor.add(attrArmorAmount);

		attributeArmor.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeToughness.add(attrToughnessLabel);
		attributeToughness.add(attrToughnessOption);
		attributeToughness.add(attrToughnessAmount);

		attributeToughness.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeAttackSpeed.add(attrAttackSpeedLabel);
		attributeAttackSpeed.add(attrAttackSpeedOption);
		attributeAttackSpeed.add(attrAttackSpeedAmount);

		attributeAttackSpeed.setLayout(new FlowLayout(FlowLayout.LEFT));

		attributeLuck.add(attrLuckLabel);
		attributeLuck.add(attrLuckOption);
		attributeLuck.add(attrLuckAmount);

		attributeLuck.setLayout(new FlowLayout(FlowLayout.LEFT));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(attributeArmor); // Armor
		add(attributeToughness); // Armor Toughness
		add(attributeAttackSpeed); // Attack Speed
		add(attributeKBR); // Knockback Resistance
		add(attributeLuck); // Luck
		add(attributeHealth); // Max Health
		add(attributeDamage); // Melee Damage
		add(attributeSpeed); // Speed
		
		//Add attributes to lists.
		boxList.add(attrArmorOption); // Armor
		boxList.add(attrToughnessOption); // Armor Toughness
		boxList.add(attrAttackSpeedOption); // Attack Speed
		boxList.add(attrKBROption); // Knockback Resistance
		boxList.add(attrLuckOption); // Luck
		boxList.add(attrHealthOption); // Max Health
		boxList.add(attrDamageOption); // Melee Damage
		boxList.add(attrSpeedOption); // Speed
		
		fieldList.add(attrArmorAmount); // Armor
		fieldList.add(attrToughnessAmount); // Armor Toughness
		fieldList.add(attrAttackSpeedAmount); // Attack Speed
		fieldList.add(attrKBRAmount); // Knockback Resistance
		fieldList.add(attrLuckAmount); // Luck
		fieldList.add(attrHealthAmount); // Max Health
		fieldList.add(attrDamageAmount); // Melee Damage
		fieldList.add(attrSpeedAmount); // Speed
	}

	public AttributePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public AttributePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public AttributePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
