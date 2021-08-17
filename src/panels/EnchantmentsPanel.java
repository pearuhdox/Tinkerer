package panels;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class EnchantmentsPanel extends JPanel {

	// Array List for all buttons
	public ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();
	public ArrayList<JSpinner> spinnerList = new ArrayList<JSpinner>();

	// Create all buttons
	public JCheckBox cAquaAffinity = new JCheckBox("Aqua Affinity");
	public JSpinner sAquaAffinity = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cBlastProtection = new JCheckBox("Blast Protection");
	public JSpinner sBlastProtection = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cDepthStrider = new JCheckBox("Depth Strider");
	public JSpinner sDepthStrider = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	public JCheckBox cFeatherFalling = new JCheckBox("Feather Falling");
	public JSpinner sFeatherFalling = new JSpinner(new SpinnerNumberModel(1, 1, 7, 1));

	public JCheckBox cFireProtection = new JCheckBox("Fire Protection");
	public JSpinner sFireProtection = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cFrostWalker = new JCheckBox("Frost Walker");
	public JSpinner sFrostWalker = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cProjectileProtection = new JCheckBox("Projectile Protection");
	public JSpinner sProjectileProtection = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cProtection = new JCheckBox("Protection");
	public JSpinner sProtection = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));

	public JCheckBox cRespiration = new JCheckBox("Respiration");
	public JSpinner sRespiration = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cSoulSpeed = new JCheckBox("Soul Speed");
	public JSpinner sSoulSpeed = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cBaneArthropods = new JCheckBox("Bane of Arthropods");
	public JSpinner sBaneArthropods = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cFireAspect = new JCheckBox("Fire Aspect");
	public JSpinner sFireAspect = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	public JCheckBox cImpaling = new JCheckBox("Impaling");
	public JSpinner sImpaling = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cKnockback = new JCheckBox("Knockback");
	public JSpinner sKnockback = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cLooting = new JCheckBox("Looting");
	public JSpinner sLooting = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cSharpness = new JCheckBox("Sharpness");
	public JSpinner sSharpness = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cSmite = new JCheckBox("Smite");
	public JSpinner sSmite = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cSweepingEdge = new JCheckBox("Sweeping Edge");
	public JSpinner sSweepingEdge = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	public JCheckBox cChanneling = new JCheckBox("Channeling");
	public JSpinner sChanneling = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cFlame = new JCheckBox("Flame");
	public JSpinner sFlame = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cInfinity = new JCheckBox("Infinity");
	public JSpinner sInfinity = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cLoyalty = new JCheckBox("Loyalty");
	public JSpinner sLoyalty = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cMultishot = new JCheckBox("Multishot");
	public JSpinner sMultishot = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cPiercing = new JCheckBox("Piercing");
	public JSpinner sPiercing = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cPower = new JCheckBox("Power");
	public JSpinner sPower = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cPunch = new JCheckBox("Punch");
	public JSpinner sPunch = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cQuickCharge = new JCheckBox("Quick Charge");
	public JSpinner sQuickCharge = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	public JCheckBox cRiptide = new JCheckBox("Riptide");
	public JSpinner sRiptide = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	public JCheckBox cEfficiency = new JCheckBox("Efficiency");
	public JSpinner sEfficiency = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cFortune = new JCheckBox("Fortune");
	public JSpinner sFortune = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public JCheckBox cSilkTouch = new JCheckBox("Silk Touch");
	public JSpinner sSilkTouch = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cCurseBinding = new JCheckBox("Curse of Binding");
	public JSpinner sCurseBinding = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cCurseVanishing = new JCheckBox("Curse of Vanishing");
	public JSpinner sCurseVanishing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cMending = new JCheckBox("Mending");
	public JSpinner sMending = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public JCheckBox cUnbreaking = new JCheckBox("Unbreaking");
	public JSpinner sUnbreaking = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	public EnchantmentsPanel() {

		// Put all custom enchantments into the list. *sighs*
		boxList.add(cAquaAffinity);
		boxList.add(cBlastProtection);
		boxList.add(cDepthStrider);
		boxList.add(cFeatherFalling);
		boxList.add(cFireProtection);
		boxList.add(cFrostWalker);
		boxList.add(cProjectileProtection);
		boxList.add(cProtection);
		boxList.add(cRespiration);
		boxList.add(cAquaAffinity);

		boxList.add(cBaneArthropods);
		boxList.add(cFireAspect);
		boxList.add(cImpaling);
		boxList.add(cKnockback);
		boxList.add(cLooting);
		boxList.add(cSharpness);
		boxList.add(cSmite);
		boxList.add(cSweepingEdge);

		boxList.add(cChanneling);
		boxList.add(cFlame);
		boxList.add(cInfinity);
		boxList.add(cLoyalty);
		boxList.add(cMultishot);
		boxList.add(cPiercing);
		boxList.add(cPower);
		boxList.add(cPunch);
		boxList.add(cQuickCharge);
		boxList.add(cRiptide);

		boxList.add(cEfficiency);
		boxList.add(cFortune);
		boxList.add(cSilkTouch);

		boxList.add(cCurseBinding);
		boxList.add(cCurseVanishing);
		boxList.add(cMending);
		boxList.add(cUnbreaking);

		// Put all custom enchantments into the list but this time its a spinner. *sighs*
		spinnerList.add(sAquaAffinity);
		spinnerList.add(sBlastProtection);
		spinnerList.add(sDepthStrider);
		spinnerList.add(sFeatherFalling);
		spinnerList.add(sFireProtection);
		spinnerList.add(sFrostWalker);
		spinnerList.add(sProjectileProtection);
		spinnerList.add(sProtection);
		spinnerList.add(sRespiration);
		spinnerList.add(sAquaAffinity);

		spinnerList.add(sBaneArthropods);
		spinnerList.add(sFireAspect);
		spinnerList.add(sImpaling);
		spinnerList.add(sKnockback);
		spinnerList.add(sLooting);
		spinnerList.add(sSharpness);
		spinnerList.add(sSmite);
		spinnerList.add(sSweepingEdge);

		spinnerList.add(sChanneling);
		spinnerList.add(sFlame);
		spinnerList.add(sInfinity);
		spinnerList.add(sLoyalty);
		spinnerList.add(sMultishot);
		spinnerList.add(sPiercing);
		spinnerList.add(sPower);
		spinnerList.add(sPunch);
		spinnerList.add(sQuickCharge);
		spinnerList.add(sRiptide);

		spinnerList.add(sEfficiency);
		spinnerList.add(sFortune);
		spinnerList.add(sSilkTouch);

		spinnerList.add(sCurseBinding);
		spinnerList.add(sCurseVanishing);
		spinnerList.add(sMending);
		spinnerList.add(sUnbreaking);

		JPanel armorEnchants = new JPanel();
		armorEnchants.setBorder(BorderFactory.createTitledBorder("Armor"));

		armorEnchants.setLayout(new GridLayout(5, 2));

		// Add all buttons
		armorEnchants.add(sAquaAffinity);
		armorEnchants.add(cAquaAffinity);

		armorEnchants.add(sBlastProtection);
		armorEnchants.add(cBlastProtection);

		armorEnchants.add(sDepthStrider);
		armorEnchants.add(cDepthStrider);

		armorEnchants.add(sFeatherFalling);
		armorEnchants.add(cFeatherFalling);

		armorEnchants.add(sFireProtection);
		armorEnchants.add(cFireProtection);

		armorEnchants.add(sFrostWalker);
		armorEnchants.add(cFrostWalker);

		armorEnchants.add(sProjectileProtection);
		armorEnchants.add(cProjectileProtection);

		armorEnchants.add(sProtection);
		armorEnchants.add(cProtection);

		armorEnchants.add(sRespiration);
		armorEnchants.add(cRespiration);

		armorEnchants.add(sSoulSpeed);
		armorEnchants.add(cSoulSpeed);

		JPanel meleeEnchants = new JPanel();
		meleeEnchants.setBorder(BorderFactory.createTitledBorder("Melee"));

		meleeEnchants.setLayout(new GridLayout(4, 2));

		// Add all buttons
		meleeEnchants.add(sBaneArthropods);
		meleeEnchants.add(cBaneArthropods);

		meleeEnchants.add(sFireAspect);
		meleeEnchants.add(cFireAspect);

		meleeEnchants.add(sImpaling);
		meleeEnchants.add(cImpaling);

		meleeEnchants.add(sKnockback);
		meleeEnchants.add(cKnockback);

		meleeEnchants.add(sLooting);
		meleeEnchants.add(cLooting);

		meleeEnchants.add(sSharpness);
		meleeEnchants.add(cSharpness);

		meleeEnchants.add(sSmite);
		meleeEnchants.add(cSmite);

		meleeEnchants.add(sSweepingEdge);
		meleeEnchants.add(cSweepingEdge);

		JPanel rangedEnchants = new JPanel();
		rangedEnchants.setBorder(BorderFactory.createTitledBorder("Ranged"));

		rangedEnchants.setLayout(new GridLayout(5, 2));

		// Add all buttons
		rangedEnchants.add(sChanneling);
		rangedEnchants.add(cChanneling);

		rangedEnchants.add(sFlame);
		rangedEnchants.add(cFlame);

		rangedEnchants.add(sInfinity);
		rangedEnchants.add(cInfinity);

		rangedEnchants.add(sLoyalty);
		rangedEnchants.add(cLoyalty);

		rangedEnchants.add(sMultishot);
		rangedEnchants.add(cMultishot);

		rangedEnchants.add(sPiercing);
		rangedEnchants.add(cPiercing);

		rangedEnchants.add(sPower);
		rangedEnchants.add(cPower);

		rangedEnchants.add(sPunch);
		rangedEnchants.add(cPunch);

		rangedEnchants.add(sQuickCharge);
		rangedEnchants.add(cQuickCharge);

		rangedEnchants.add(sRiptide);
		rangedEnchants.add(cRiptide);

		JPanel toolEnchants = new JPanel();
		toolEnchants.setBorder(BorderFactory.createTitledBorder("Tools"));

		toolEnchants.setLayout(new GridLayout(3, 2));

		// Add all buttons
		toolEnchants.add(cEfficiency);
		toolEnchants.add(sEfficiency);

		toolEnchants.add(cFortune);
		toolEnchants.add(sFortune);

		toolEnchants.add(cSilkTouch);
		toolEnchants.add(sSilkTouch);

		JPanel otherEnchants = new JPanel();
		otherEnchants.setBorder(BorderFactory.createTitledBorder("Other and Curses"));

		otherEnchants.setLayout(new GridLayout(2, 2));

		// Add all buttons
		otherEnchants.add(sCurseBinding);
		otherEnchants.add(cCurseBinding);

		otherEnchants.add(sCurseVanishing);
		otherEnchants.add(cCurseVanishing);

		otherEnchants.add(sMending);
		otherEnchants.add(cMending);

		otherEnchants.add(sUnbreaking);
		otherEnchants.add(cUnbreaking);

		Border enchantsBorder = BorderFactory.createTitledBorder("Vanilla Enchants");
		setBorder(enchantsBorder);

		setLayout(new GridLayout(5, 1));
		add(armorEnchants);
		add(meleeEnchants);
		add(rangedEnchants);
		add(toolEnchants);
		add(otherEnchants);

	}

	public EnchantmentsPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public EnchantmentsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public EnchantmentsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
