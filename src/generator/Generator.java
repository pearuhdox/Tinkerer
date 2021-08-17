package generator;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

import lore.Line;
import lore.Lore;
import panels.ActivePanel;
import panels.AttributePanel;
import panels.BasicPanel;
import panels.ConsumablePanel;
import panels.CustomEnchantPanel;
import panels.EnchantmentsPanel;
import panels.InfoPanel;
import panels.MythicPanel;
import panels.SetPanel;
import panels.ShieldPanel;
import panels.SpecialPanel;
import tools.RomanNumeral;
import tools.StringSplitter;

public class Generator {

	// Colors used for beginning/ending of item, stat titles,
	// and descriptions of effects.
	static String colorEndings = "#CFCFCF";
	static String colorTitle = "#FFFFFF";
	static String colorDescribe = "#EBEBEB";

	// Colors for names of Common and Uncommon tiers
	static String colorCommon = "#FFFCAB";
	static String colorUncommon = "#A8FFFC";

	static String colorEmpty = "#000000";

	// Colors used for "positive combat stats" (damage/toughness etc)
	static String colorCombatImgStat = "#4CC753";
	static String colorCombatStat = "#A8FFAB";

	// Colors used for positive enchant stats (sharpness/efficiency etc)
	static String colorEnchantImgStat = "#A665D1";
	static String colorEnchantStat = "#DDABFF";

	// Colors used for positive attribute stats (bonus max health etc)
	// Also used for positive potion effects
	static String colorAttributeImgStat = "#6683D1";
	static String colorAttributeStat = "#ABC7FF";

	// Colors used for *any* negative or null effect
	// (curses, negative attributes, negative potion effects)
	static String colorCurseImgStat = "#D16E66";
	static String colorCurseStat = "#FFAEA8";

	// Colors used for special effects
	static String colorSpecialImgStat = "#D66289";
	static String colorSpecialStat = "#FFB0CA";

	// Colors used for set bonus effects
	static String colorSetImgStat = "#D6D67A";
	static String colorSetStat = "#FDFFBF";

	// Colors used for mythic bonus effects
	static String colorMythicImgStat = "#D6A25E";
	static String colorMythicStat = "#FFD6B3";

	static String colorActiveImgStat = "#D6D65E";
	static String colorActiveStat = "#FCFCB1";

	// Images for combat stats
	static String meleeImg = "🗡 ";
	static String rangeImg = "🏹 ";
	static String hybridImg = "🔱 ";
	static String blockImg = "🛡 ";
	static String pickImg = "⛏ ";

	// Image for when an armor piece has "0 armor" (or any item has a 0 stat)
	static String voidImg = "✖ ";

	// Images for applied potion effects
	// Splash Potion is used on throwable potions
	static String potionImg = "🧪 ";
	static String splashPotionImg = "⚗ ";

	// Images for types of stat addons
	// Curse image is also used for negative attributes
	// Curse image is also used for negative potion effects
	static String enchantImg = "◆ ";
	static String attributeImg = "★ ";
	static String curseImg = "☠ ";

	// Images for set bonus descriptors
	static String setImg = "◎ ";
	static String setPieceImg = " ○ ";

	// Image for special effect descriptors
	static String infoImg = "✎ ";
	static String specialImg = "✣ ";
	static String mythicImg = "۞ ";
	static String activeImg = "❉ ";

	// Image for health icon.
	static String healthImg = "❤";

	// Images for fractions.
	static String halfImg = "½";
	static String thirdImg = "⅓";
	static String fourthImg = "¼";

	static String threeFourthsImg = "¾";
	static String twoThirdsTimg = "⅔";

	// Set maximum Character limit for lore strings.
	// Disable smartSplit by default.
	static int defaultCharLimit = 32;
	static int characterLimit = 32;
	static boolean smartSplitSetting = false;

	static BasicPanel basic;
	static EnchantmentsPanel enchants;
	static CustomEnchantPanel customEnchants;
	static AttributePanel attributes;
	static SetPanel set;
	static SpecialPanel special;
	static MythicPanel mythic;
	static InfoPanel info;
	static ActivePanel active;
	static ConsumablePanel consumable;
	static ShieldPanel cushields;

	static JTextArea output = new JTextArea(10, 85);
	static JButton copy = new JButton("Copy");
	
	public static void run() {
		runUI();
	}

	private static void runUI() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) size.getWidth();
		int height = (int) size.getHeight();

		// width = width / 2;
		// height = height / 2;

		JFrame frame = new JFrame();
		frame.setSize(width, height);

		/**
		 * Basic is the "Basic Item" stats panel. This includes: Item Type Item Class
		 * (Melee Range Consumable Etc) Count Durability Damage Default
		 * Damage/Armor/Speed/Toughness Stats Slot of item
		 * (main/off/head/body/legs/feet) Name Lore
		 **/
		basic = new BasicPanel();
		basic.setName("Basic Item Stats");

		/**
		 * Enchants is the "Enchantments" stats panel. This includes: All Vanilla
		 * Enchantments
		 **/
		enchants = new EnchantmentsPanel();
		enchants.setName("Vanilla Enchants");

		/**
		 * Custom Enchants is the "Custom Enchantments" stats panel. This includes: All
		 * Cartographer Enchantments Unbreakable Consumable Infinity Irreparable (aka
		 * Repair Cost 60)
		 **/
		customEnchants = new CustomEnchantPanel();
		customEnchants.setName("Custom Enchants");

		/**
		 * Attributes is the "Attributes" stats panel. This includes: All Attribute
		 * Modifiers Modifiers are default set to slot of the item specified in basic
		 * stats. Changes to base stats done in Basic Stats panel.
		 **/
		attributes = new AttributePanel();
		attributes.setName("Attributes");

		/**
		 * Set is the "Set Bonus" stats panel. This includes: Name of the Set Bonus
		 * Description of the bonus per item in set (up to 6)
		 **/
		set = new SetPanel();
		set.setName("Set Bonus");

		/**
		 * Special is the "Special Effect" stats panel. This includes: Name of the
		 * Special Effect Description of Effect
		 **/
		special = new SpecialPanel();
		special.setName("Special Effect");

		/**
		 * Mythic is the "Mythic Effect" stats panel. This includes: Name of the Mythic
		 * Effect Description of Effect
		 **/
		mythic = new MythicPanel();
		mythic.setName("Mythic Effect");

		/**
		 * Info is the "Information" stats panel. This is a similar format to the
		 * Special and Mythic, but for explaning mechanics.
		 */
		info = new InfoPanel();
		info.setName("Information Panel");

		/**
		 * Active is the "Active" stats pannel. This is a format similar to Special and
		 * Mythic but for active effects.
		 */

		active = new ActivePanel();
		active.setName("Active Panel");

		/**
		 * Consumable is the consumable stats panel. This includes: All potion effects
		 * gained by consuming the item. Infinity or Satiaton (from Custom Enchantments)
		 * will show in this section.
		 **/
		consumable = new ConsumablePanel();
		consumable.setName("Consumable Stats");

		/**
		 * CuShields is the custom sheilds panel. This includes: All custom shields
		 * stats (that are allowed to change).
		 **/
		cushields = new ShieldPanel();
		cushields.setName("Custom Shield Stats");

		/**
		 * View is the viewing panel. This includes: A demonstration of the item's
		 * appearance.
		 **/
		JPanel view = new JPanel();
		view.setName("View");

		Border viewBorder = BorderFactory.createTitledBorder("View");
		view.setBorder(viewBorder);

		/**
		 * Get is the getting panel. This includes: Ability to copy code of item.
		 **/
		JPanel get = new JPanel();
		get.setName("Results");

		Border getBorder = BorderFactory.createTitledBorder("Results");
		get.setBorder(getBorder);

		output.setLineWrap(true);

		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Copying item to clipboard.");

				// Copy to Clipboard
				String copy = output.getText();
				StringSelection stringSelection = new StringSelection(copy);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		});

		get.add(output);
		get.add(copy);

		// Add all panels - Put Stat Settings into a Settings Panel
		JTabbedPane settingsTabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		JPanel viewHalf = new JPanel();

		// settingsTabs.setLayout(new BoxLayout(settingsTabs, BoxLayout.Y_AXIS));

		settingsTabs.addTab("Basic Stats", basic);
		settingsTabs.addTab("Vanilla Enchantments", enchants);
		settingsTabs.addTab("Custom Enchantments", customEnchants);
		settingsTabs.addTab("Attributes", attributes);
		settingsTabs.addTab("Set Bonuses", set);
		settingsTabs.addTab("Special Effect", special);
		settingsTabs.add("Mythical Effect", mythic);
		settingsTabs.addTab("Information", info);
		settingsTabs.addTab("Active Effects", active);
		settingsTabs.add("Consumable Stats", consumable);
		settingsTabs.add("Custom Shields", cushields);

		JLabel statLabel = new JLabel("Basic Stats");
		statLabel.setPreferredSize(new Dimension(65, 35));
		settingsTabs.setTabComponentAt(0, statLabel);

		// JScrollPane scrollSettings = new JScrollPane(settingsTabs);
		// scrollSettings.getVerticalScrollBar().setUnitIncrement(20);

		JPanel generatorButtonPanel = new JPanel();

		generatorButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		generatorButtonPanel.setPreferredSize(new Dimension(65, 35));
		JButton generator = new JButton("Generate Item");

		generator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Generating Item");
				// Do view

				// Do Generation
				generateItem();
			}
		});

		generatorButtonPanel.add(generator);

		viewHalf.setLayout(new BoxLayout(viewHalf, BoxLayout.Y_AXIS));
		viewHalf.add(view);
		viewHalf.add(generatorButtonPanel);
		viewHalf.add(get);

		frame.setLayout(new GridLayout(1, 2));

		frame.add(settingsTabs);
		frame.add(viewHalf);

		frame.setTitle("Item Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void generateItem() {

		smartSplitSetting = basic.smartLore.isSelected();
		
		if(smartSplitSetting == true) {
			if (basic.name.getText().length() > characterLimit) {
				characterLimit = basic.name.getText().length();
			}
		}
		
		String giveCommand = "give @p ";

		// Start command with item id
		giveCommand = giveCommand + "minecraft:" + basic.id.getText() + "{";

		// Add the Hide Flags tag
		giveCommand = giveCommand + "HideFlags:127,";

		// Continue command with nbt
		giveCommand = giveCommand + enchantsNBT();
		giveCommand = giveCommand + attributeNBT();
		giveCommand = giveCommand + specialNBT();
		giveCommand = giveCommand + consumableNBT();
		if (basic.type.getSelectedItem().equals("Shield"))
			giveCommand = giveCommand + shieldNBT();

		// Create display nbt
		giveCommand = giveCommand + displayNBT();

		// Add damage if needed
		if (!basic.damage.getText().isEmpty())
			giveCommand = giveCommand + ",Damage:" + Integer.parseInt(basic.damage.getText());

		// End nbt
		giveCommand = giveCommand + "}";

		// Finish command by adding count.
		int stringCount = (int) basic.count.getValue();
		giveCommand = giveCommand + " " + stringCount;

		// System.out.println(giveCommand);

		// Print the command to the output box.
		output.setText(giveCommand);
		
		//Reset Character Limit
		characterLimit = defaultCharLimit;
	}

	public static String enchantsNBT() {
		String result = "";

		// Normal Enchantments
		result = result + "Enchantments:[";

		boolean hasEnchants = false;

		String[] enchantRoster = { "minecraft:aqua_affinity", "minecraft:blast_protection", "minecraft:depth_strider",
				"minecraft:feather_falling", "minecraft:fire_protection", "minecraft:frost_walker",
				"minecraft:projectile_protection", "minecraft:protection", "minecraft:respiration",
				"minecraft:soul_speed", "minecraft:bane_of_arthropods", "minecraft:fire_aspect", "minecraft:impaling",
				"minecraft:knockback", "minecraft:looting", "minecraft:sharpness", "minecraft:smite",
				"minecraft:sweeping_edge", "minecraft:channeling", "minecraft:flame", "minecraft:infinity",
				"minecraft:loyalty", "minecraft:multishot", "minecraft:piercing", "minecraft:power", "minecraft:punch",
				"minecraft:quick_charge", "minecraft:riptide", "minecraft:efficiency", "minecraft:fortune",
				"minecraft:silk_touch", "minecraft:curse_of_binding", "minecraft:curse_of_vanishing",
				"minecraft:mending", "minecraft:unbreaking" };

		for (int i = 0; i < enchants.boxList.size(); i++) {

			if (enchants.boxList.get(i).isSelected()) {
				result = result + "{id:" + "\"" + enchantRoster[i] + "\",lvl:" + enchants.spinnerList.get(i).getValue()
						+ "s},";
				hasEnchants = true;
			}
		}

		result = result.substring(0, result.length() - 1);

		result = result + "],";

		if (hasEnchants == false) {
			result = result.replace("Enchantments:],", "");
		}

		// Custom Enchantments
		result = result + "CustomEnchantments:[";

		boolean hasCustomEnchants = false;

		String[] customEnchantRoster = { "adrenaline", "agility", "aquadynamic", "concealed", "fatigue_cleansing",
				"slowness_cleansing", "weakness_cleansing", "poison_cleansing", "wither_cleansing", "energetic",
				"evasion", "frenzy", "lifesteal", "rally", "regeneration", "satiation", "second_wind", "spurs",
				"soulbound", "bleeding", "duelist", "echo", "electrocute", "evocation", "executioner", "exposing",
				"frostbite", "hunter", "infecting", "stunning", "surging_strike", "transfiguration", "vanquisher",
				"auto_charge", "bleed", "current", "deadeye", "electrode", "expose", "frost", "hydraulic", "flash",
				"fleetfoot", "infect", "overcharge", "point_blank", "repeating", "ricochet", "sharpshot", "tempest",
				"tempo_theft", "trueshot", "volatile", "eruption", "sapper", "splintering", "curse_of_encumbering",
				"curse_of_irreparability", "curse_of_malevolence", "curse_of_regret", "curse_of_shattering",
				"two_Handed", "infinity", "unbreakable", "loyalty", "thorns" };

		for (int i = 0; i < customEnchants.boxList.size(); i++) {

			if (customEnchants.boxList.get(i).isSelected()) {
				result = result + "{id:" + "\"" + customEnchantRoster[i] + "\",lvl:"
						+ customEnchants.spinnerList.get(i).getValue() + "s},";
				hasCustomEnchants = true;
			}
		}

		result = result.substring(0, result.length() - 1);

		result = result + "],";

		if (hasCustomEnchants == false) {
			result = result.replace("CustomEnchantments:],", "");
		}

		if (hasEnchants == false && hasCustomEnchants == true) {
			result = result + "Enchantments:[{}],";
		}

		return result;
	}

	public static String attributeNBT() {
		String result = "AttributeModifiers:[";

		// AttributeModifiers:[{AttributeName:"generic.max_health",Name:"generic.max_health",Amount:1,Operation:0,UUID:[I;-1684046824,1697139755,-1404116804,-491617690]}]}

		String[] attributeRoster = { "\"generic.armor\"", "\"generic.armor_toughness\"", "\"generic.attack_speed\"",
				"generic.knockback_resistance\"", "\"generic.luck\"", "\"generic.max_health\"",
				"\"generic.attack_damage\"", "\"generic.movement_speed\"" };

		boolean hasAttribute = false;

		// Determine the slot
		String[] slots = { "\"mainhand\"", "\"offhand\"", "\"feet\"", "\"legs\"", "\"chest\"", "\"head\"" };
		int slotID = -1;

		String typeTest = (String) basic.type.getSelectedItem();

		// Get the slot we're going to use.
		if (basic.id.getText().equals("leather_helmet") || basic.id.getText().equals("golden_helmet")
				|| basic.id.getText().equals("chainmail_helmet") || basic.id.getText().equals("iron_helmet")
				|| basic.id.getText().equals("diamond_helmet") || basic.id.getText().equals("netherite_helmet")
				|| basic.id.getText().equals("turtle_helmet") || basic.id.getText().equals("zombie_head")
				|| basic.id.getText().equals("creeper_head") || basic.id.getText().equals("player_head")
				|| basic.id.getText().equals("skeleton_skull") || basic.id.getText().equals("wither_skeleton_skull")
				|| basic.id.getText().equals("dragon_head") || basic.id.getText().equals("carved_pumpkin")) {
			slotID = 5;
		} else if (basic.id.getText().equals("leather_chestplate") || basic.id.getText().equals("golden_chestplate")
				|| basic.id.getText().equals("chainmail_chestplate") || basic.id.getText().equals("iron_chestplate")
				|| basic.id.getText().equals("diamond_chestplate") || basic.id.getText().equals("netherite_chestplate")
				|| basic.id.getText().equals("elytra")) {
			slotID = 4;
		} else if (basic.id.getText().equals("leather_leggings") || basic.id.getText().equals("golden_leggings")
				|| basic.id.getText().equals("chainmail_leggings") || basic.id.getText().equals("iron_leggings")
				|| basic.id.getText().equals("diamond_leggings") || basic.id.getText().equals("netherite_leggings")) {
			slotID = 3;
		} else if (basic.id.getText().equals("leather_boots") || basic.id.getText().equals("golden_boots")
				|| basic.id.getText().equals("chainmail_boots") || basic.id.getText().equals("iron_boots")
				|| basic.id.getText().equals("diamond_boots") || basic.id.getText().equals("netherite_boots")) {
			slotID = 2;
		} else if (typeTest.equals("Melee Weapon") || typeTest.equals("Tool")) {
			slotID = 0;
		} else if (typeTest.equals("Ranged Weapon") || typeTest.equals("Hybrid Weapon")) {
			slotID = 1;
		} else if (typeTest.equals("Offhand")) {
			slotID = 1;
		} else if (basic.overwriteMainhand.isSelected()) {
			slotID = 0;
		} else if (basic.overwriteOffhand.isSelected()) {
			slotID = 1;
		}

		for (int i = 0; i < attributes.boxList.size(); i++) {

			if (!attributes.fieldList.get(i).getText().isEmpty()) {
				String attributeName = attributeRoster[i];
				String value = attributes.fieldList.get(i).getText();
				int operation = attributes.boxList.get(i).getSelectedIndex();

				int[] UUID = { 0, 0, 0, 0 };

				Random rand = new Random();
				for (int j = 0; j < 4; j++) {
					int randomInt = rand.nextInt(2147483647);
					UUID[j] = randomInt;
				}

				result = result + "{AttributeName:" + attributeName + ",Name:" + attributeName + ",Amount:" + value
						+ ",Operation:" + operation + ",UUID:[I;" + UUID[0] + "," + UUID[1] + "," + UUID[2] + ","
						+ UUID[3] + "],Slot:" + slots[slotID] + "},";
				hasAttribute = true;
			}
		}

		// Do standard stats (default attack speeds and damages, armor and armor
		// toughnesses)

		// Attack Damage
		if (!basic.attack.getText().isEmpty()) {
			double amount = Double.parseDouble(basic.attack.getText()) - 1;

			int[] UUID = { 0, 0, 0, 0 };

			Random rand = new Random();
			for (int j = 0; j < 4; j++) {
				int randomInt = rand.nextInt(2147483647);
				UUID[j] = randomInt;
			}

			result = result + "{AttributeName:\"generic.attack_damage\",Name:\"generic.atack_damage\",Amount:" + amount
					+ ",Operation:0,UUID:[I;" + UUID[0] + "," + UUID[1] + "," + UUID[2] + "," + UUID[3]
					+ "],Slot:\"mainhand\"},";
			hasAttribute = true;
		}

		// Attack Speed
		if (!basic.speed.getText().isEmpty()) {
			double amount = 4 - Double.parseDouble(basic.speed.getText());
			amount = amount * -1;

			int[] UUID = { 0, 0, 0, 0 };

			Random rand = new Random();
			for (int j = 0; j < 4; j++) {
				int randomInt = rand.nextInt(2147483647);
				UUID[j] = randomInt;
			}

			result = result + "{AttributeName:\"generic.attack_speed\",Name:\"generic.atack_speed\",Amount:" + amount
					+ ",Operation:0,UUID:[I;" + UUID[0] + "," + UUID[1] + "," + UUID[2] + "," + UUID[3]
					+ "],Slot:\"mainhand\"},";
			hasAttribute = true;
		}

		// Armor
		if (!basic.armor.getText().isEmpty()) {
			double amount = Double.parseDouble(basic.armor.getText());

			int[] UUID = { 0, 0, 0, 0 };

			Random rand = new Random();
			for (int j = 0; j < 4; j++) {
				int randomInt = rand.nextInt(2147483647);
				UUID[j] = randomInt;
			}

			result = result + "{AttributeName:\"generic.armor\",Name:\"generic.armor\",Amount:" + amount
					+ ",Operation:0,UUID:[I;" + UUID[0] + "," + UUID[1] + "," + UUID[2] + "," + UUID[3] + "],Slot:"
					+ slots[slotID] + "},";
			hasAttribute = true;
		}

		// Armor Toughness
		if (!basic.toughness.getText().isEmpty()) {
			double amount = Double.parseDouble(basic.toughness.getText());

			int[] UUID = { 0, 0, 0, 0 };

			Random rand = new Random();
			for (int j = 0; j < 4; j++) {
				int randomInt = rand.nextInt(2147483647);
				UUID[j] = randomInt;
			}

			result = result + "{AttributeName:\"generic.armor_toughness\",Name:\"generic.armor_toughness\",Amount:"
					+ amount + ",Operation:0,UUID:[I;" + UUID[0] + "," + UUID[1] + "," + UUID[2] + "," + UUID[3]
					+ "],Slot:" + slots[slotID] + "},";
			hasAttribute = true;
		}

		// Tie off String
		result = result.substring(0, result.length() - 1);

		result = result + "],";

		if (hasAttribute == false) {
			result = result.replace("AttributeModifiers:],", "");
		}

		return result;
	}

	public static String specialNBT() {
		String result = "";

		String setNBT = set.setNameField.getText();
		String specialNBT = special.specialNameField.getText();
		String mythicNBT = mythic.mythNameField.getText();
		String activeNBT = active.activeNameField.getText();

		setNBT = setNBT.replace(" ", "");
		specialNBT = specialNBT.replace(" ", "");
		mythicNBT = mythicNBT.replace(" ", "");
		activeNBT = activeNBT.replace(" ", "");

		setNBT = setNBT.replace("'", "");
		specialNBT = specialNBT.replace("'", "");
		mythicNBT = mythicNBT.replace("'", "");
		activeNBT = activeNBT.replace(" ", "");

		mythicNBT = mythicNBT.replace("Mythical", "");
		mythicNBT = mythicNBT.replace("Myth", "");
		mythicNBT = mythicNBT.replace("Mythically", "");
		mythicNBT = mythicNBT.replace("Mythic", "");

		if (!set.setNameField.getText().isEmpty()) {
			result = result + "set" + setNBT + ":1b,";
		}
		if (!special.specialNameField.getText().isEmpty()) {
			result = result + "special" + specialNBT + ":1b,";
		}
		if (!mythic.mythNameField.getText().isEmpty()) {
			result = result + "myth" + mythicNBT + ":1b,";
		}
		if (!active.activeNameField.getText().isEmpty()) {
			result = result + "active" + mythicNBT + ":1b,";
		}

		return result;
	}

	public static String consumableNBT() {
		String result = "";

		boolean hasEffect = false;

		if (basic.id.getText().equals("suspicious_stew")) {
			result = result + "Effects:[";
			for (int i = 0; i < consumable.durationList.size(); i++) {
				if (!consumable.durationList.get(i).getText().isEmpty()) {
					int duration = Integer.parseInt(consumable.durationList.get(i).getText());
					int id = i + 1;
					result = result + "{EffectId:" + id + "b,EffectDuration:" + duration + "},";
					hasEffect = true;
				}
			}

			// Tie off String
			result = result.substring(0, result.length() - 1);

			result = result + "],";

			if (hasEffect == false) {
				result = result.replace("Effects:],", "");
			}
		} else {
			result = result + "Potion:\"minecraft:thick\",CustomPotionEffects:[";
			for (int i = 0; i < consumable.durationList.size(); i++) {
				if (!consumable.durationList.get(i).getText().isEmpty()) {
					int duration = Integer.parseInt(consumable.durationList.get(i).getText());
					int potency = (Integer) consumable.potencyList.get(i).getValue() - 1;
					int id = i + 1;
					result = result + "{Id:" + id + "b,Amplifier:" + potency + "b,Duration:" + duration + "},";
					hasEffect = true;
				}
			}

			// Tie off String
			result = result.substring(0, result.length() - 1);

			result = result + "],";

			if (hasEffect == false) {
				result = result.replace("Potion:\"minecraft:thick\",CustomPotionEffects:],", "");
			}
		}

		return result;
	}

	public static String shieldNBT() {
		String result = "";

		// {CustomModelData:1,shield:{default_model:1,blocking_model:1,block_value:4,minimum_block_value:2,player_block_effect:1,

		result = result + "CustomModelData:" + (int) cushields.model.getValue() + ",shield:{default_model:"
				+ (int) cushields.model.getValue();
		result = result + ",blocking_model:" + (int) cushields.blockModel.getValue();

		if (cushields.blockType.getSelectedItem().equals("Normal Blocking")) {
			result = result + ",block_value:" + (int) cushields.blockValueMax.getValue();

			int persistVal = 0;

			persistVal = (int) cushields.blockValueMax.getValue();

			if (cushields.persistenceType.getSelectedIndex() == 0) {
				persistVal = (int) (persistVal * 0.1);
			} else if (cushields.persistenceType.getSelectedIndex() == 1) {
				persistVal = (int) (persistVal * 0.4);
			} else if (cushields.persistenceType.getSelectedIndex() == 2) {
				persistVal = (int) (persistVal * 0.7);
			}

			if (persistVal == 0)
				persistVal = 1;

			result = result + ",minimum_block_value:" + persistVal;

			result = result + ",player_block_effect:" + (int) cushields.playerBlockEffect.getValue();
			result = result + ",entity_block_effect:" + (int) cushields.entityBlockEffect.getValue();

			result = result + ",parry_time:8";
		} else if (cushields.blockType.getSelectedItem().equals("Parry Blocking")) {
			int coyoteTimeVal = (int) cushields.coyoteTime.getValue();

			result = result + "player_parry_effect:" + (int) cushields.playerBlockEffect.getValue();
			result = result + "entity_parry_effect:" + (int) cushields.entityBlockEffect.getValue();

			if (coyoteTimeVal == 0) {
				result = result + ",can_coyote:0b";
			} else {
				result = result + ",can_coyote:1b";
				result = result + ",coyote_time:" + coyoteTimeVal;
			}

			result = result + ",parry_time:" + (int) cushields.shieldTimeMax.getValue();
		}

		// entity_block_effect:1,max_time:10,cooldown:10,durability:15,bash_effect:1,x_angle:90,y_angle:90,can_reflect_arrows:0b,
		// disable_time:50}}

		result = result + ",bash_effect:" + (int) cushields.bashEffectID.getValue();
		result = result + ",max_time:" + (int) cushields.shieldTimeMax.getValue();
		result = result + ",cooldown:" + (int) cushields.cooldownTime.getValue();
		result = result + ",durability:" + Integer.parseInt(cushields.durabilityMax.getText());
		result = result + ",x_angle:90";

		if (cushields.blockAngle.getSelectedIndex() == 0) {
			result = result + ",y_angle:60";
		} else if (cushields.blockAngle.getSelectedIndex() == 1) {
			result = result + ",y_angle:90";
		} else if (cushields.blockAngle.getSelectedIndex() == 2) {
			result = result + ",y_angle:120";
		}

		if (cushields.canBlockArrows.isSelected()) {
			result = result + ",can_reflect_arrows:1b";
		} else {
			result = result + ",can_reflect_arrows:0b";
		}

		if (cushields.disableResist.isSelected()) {
			result = result + ",disable_resistant:1b},";
		} else {
			result = result + ",disable_time:" + Integer.parseInt(cushields.disableTime.getText()) + "},";
		}

		return result;
	}

	public static String displayNBT() {
		String result = "display:{";

		// Name
		result = result + "Name:";

		boolean boldCheck = false;
		boolean underCheck = false;

		if (basic.tier.getSelectedIndex() >= 2)
			boldCheck = true;
		if (basic.tier.getSelectedIndex() >= 3)
			underCheck = true;

		// Name:'{"text":"Alchemic
		// Artillery","color":"#DE4BD5","bold":true,"italic":false,"underlined":true}'
		// Name:'{"text":"Cool Item","color":"#FF3333","italic":false","bold":true}'

		Line itemName = new Line();

		if (basic.tier.getSelectedIndex() == 0)
			itemName.addColor(colorCommon);
		else if (basic.tier.getSelectedIndex() == 1)
			itemName.addColor(colorUncommon);
		else {
			Color nameColorObj = basic.nameColor.getColor();
			String hexColor = String.format("#%02X%02X%02X", nameColorObj.getRed(), nameColorObj.getGreen(),
					nameColorObj.getBlue());
			itemName.addColor(hexColor);
		}

		itemName.addSegment(basic.name.getText());

		result = result + itemName.createNameString(boldCheck, underCheck);

		// Lore
		Lore itemLore = new Lore();

		// Display item tier and type.
		Line tierLine = new Line(colorEndings, (String) basic.tier.getSelectedItem());
		Line typeLine = new Line();
		if (!basic.typeAddendum.getText().isEmpty()) {
			typeLine = new Line(colorEndings,
					(String) basic.type.getSelectedItem() + " - " + basic.typeAddendum.getText());
		} else {
			typeLine = new Line(colorEndings, (String) basic.type.getSelectedItem());
		}
		Line spacer = new Line(colorEmpty, " ");

		String typeTest = (String) basic.type.getSelectedItem();

		ArrayList<Line> itemMainStatsList = new ArrayList<Line>();

		// Determine if we need "head/body/legs/feet/main hand/off hand/either hand"
		// Then display the proper one.
		Line whenLine;

		boolean isArmor = false;
		boolean noMainStats = false;

		if (basic.id.getText().equals("leather_helmet") || basic.id.getText().equals("golden_helmet")
				|| basic.id.getText().equals("chainmail_helmet") || basic.id.getText().equals("iron_helmet")
				|| basic.id.getText().equals("diamond_helmet") || basic.id.getText().equals("netherite_helmet")
				|| basic.id.getText().equals("turtle_helmet") || basic.id.getText().equals("zombie_head")
				|| basic.id.getText().equals("creeper_head") || basic.id.getText().equals("player_head")
				|| basic.id.getText().equals("skeleton_skull") || basic.id.getText().equals("wither_skeleton_skull")
				|| basic.id.getText().equals("dragon_head") || basic.id.getText().equals("carved_pumpkin")) {
			whenLine = new Line(colorTitle, "When on Head:");
			isArmor = true;
		} else if (basic.id.getText().equals("leather_chestplate") || basic.id.getText().equals("golden_chestplate")
				|| basic.id.getText().equals("chainmail_chestplate") || basic.id.getText().equals("iron_chestplate")
				|| basic.id.getText().equals("diamond_chestplate") || basic.id.getText().equals("netherite_chestplate")
				|| basic.id.getText().equals("elytra")) {
			whenLine = new Line(colorTitle, "When on Body:");
			isArmor = true;
		} else if (basic.id.getText().equals("leather_leggings") || basic.id.getText().equals("golden_leggings")
				|| basic.id.getText().equals("chainmail_leggings") || basic.id.getText().equals("iron_leggings")
				|| basic.id.getText().equals("diamond_leggings") || basic.id.getText().equals("netherite_leggings")) {
			whenLine = new Line(colorTitle, "When on Legs:");
			isArmor = true;
		} else if (basic.id.getText().equals("leather_boots") || basic.id.getText().equals("golden_boots")
				|| basic.id.getText().equals("chainmail_boots") || basic.id.getText().equals("iron_boots")
				|| basic.id.getText().equals("diamond_boots") || basic.id.getText().equals("netherite_boots")) {
			whenLine = new Line(colorTitle, "When on Feet:");
			isArmor = true;
		} else if (typeTest.equals("Melee Weapon") || typeTest.equals("Tool")) {
			whenLine = new Line(colorTitle, "When in Main Hand:");
		} else if (typeTest.equals("Ranged Weapon") || typeTest.equals("Hybrid Weapon")) {
			whenLine = new Line(colorTitle, "When in Either Hand:");
		} else if (typeTest.equals("Offhand")) {
			whenLine = new Line(colorTitle, "When in Off Hand:");
		} else if (basic.overwriteMainhand.isSelected()) {
			whenLine = new Line(colorTitle, "When in Main Hand:");
		} else if (basic.overwriteOffhand.isSelected()) {
			whenLine = new Line(colorTitle, "When in Off Hand:");
		} else if (typeTest.equals("Consumable")) {
			whenLine = new Line(colorTitle, "When Used:");
		} else if (typeTest.equals("Empowered Item")) {
			whenLine = new Line(colorTitle, "Not Used");
			noMainStats = true;
		} else {
			System.out.println("Error: Something went wrong with the type of the item.");
			whenLine = null;
			noMainStats = true;
		}

		if (whenLine != null)
			itemMainStatsList.add(whenLine);

		// Create null lines.
		Line atkStat = null;
		Line atkSpdStat = null;
		Line armorStat = null;
		Line toughnessStat = null;
		Line rngStat = null;
		Line digStat = null;

		// If the item has Attack Damage, display it as a combat stat.
		double attackValue;
		if (basic.attack.getText().isEmpty())
			attackValue = 0;
		else
			attackValue = Double.parseDouble(basic.attack.getText());

		if (attackValue > 0) {
			atkStat = new Line();
			atkStat.addSet(colorCombatImgStat, meleeImg);
			if (attackValue == (long) attackValue) {
				atkStat.addSet(colorCombatStat, String.format("%d", (long) attackValue) + " Melee Damage");
			} else {
				atkStat.addSet(colorCombatStat, String.format("%s", attackValue) + " Melee Damage");
			}

			itemMainStatsList.add(atkStat);
		}

		// If the item has Attack Speed, display it as a combat stat.
		double attackSpeedValue;
		if (basic.speed.getText().isEmpty())
			attackSpeedValue = 0;
		else
			attackSpeedValue = Double.parseDouble(basic.speed.getText());

		if (attackSpeedValue > 0) {
			atkSpdStat = new Line();
			atkSpdStat.addSet(colorCombatImgStat, meleeImg);
			if (attackSpeedValue == (long) attackSpeedValue) {
				atkSpdStat.addSet(colorCombatStat, String.format("%d", (long) attackSpeedValue) + " Attack Speed");
			} else {
				atkSpdStat.addSet(colorCombatStat, String.format("%s", attackSpeedValue) + " Attack Speed");
			}

			itemMainStatsList.add(atkSpdStat);
		}

		// If the item has Armor, display it as a combat stat.
		double armorValue;
		if (basic.armor.getText().isEmpty())
			armorValue = 0;
		else
			armorValue = Double.parseDouble(basic.armor.getText());

		if (armorValue > 0) {
			armorStat = new Line();
			armorStat.addSet(colorCombatImgStat, blockImg);
			if (armorValue == (long) armorValue) {
				armorStat.addSet(colorCombatStat, String.format("%d", (long) armorValue) + " Armor");
			} else {
				armorStat.addSet(colorCombatStat, String.format("%s", armorValue) + " Armor");
			}

			itemMainStatsList.add(armorStat);
		}

		// If the item has 0 Armor and IS and armor item, display that.
		if (armorValue == 0 && isArmor) {
			armorStat = new Line();
			armorStat.addSet(colorCurseImgStat, voidImg);
			armorStat.addSet(colorCurseStat, "0 Armor");

			itemMainStatsList.add(armorStat);
		}

		// If the item has Toughness, display it as a combat stat.
		double toughnessValue;
		if (basic.toughness.getText().isEmpty())
			toughnessValue = 0;
		else
			toughnessValue = Double.parseDouble(basic.toughness.getText());

		if (toughnessValue > 0) {
			toughnessStat = new Line();
			toughnessStat.addSet(colorCombatImgStat, blockImg);
			if (toughnessValue == (long) toughnessValue) {
				toughnessStat.addSet(colorCombatStat, String.format("%d", (long) toughnessValue) + " Armor Toughness");
			} else {
				toughnessStat.addSet(colorCombatStat, String.format("%s", toughnessValue) + " Armor Toughness");
			}

			itemMainStatsList.add(toughnessStat);
		}

		// If the item is a specific ranged weapon, display the proper ranged damage for
		// that weapon type.
		if (basic.id.getText().equals("bow")) {
			rngStat = new Line();
			rngStat.addSet(colorCombatImgStat, rangeImg);
			rngStat.addSet(colorCombatStat, "6-10 Ranged Damage");

			itemMainStatsList.add(rngStat);
		}

		if (basic.id.getText().equals("crossbow")) {
			rngStat = new Line();
			rngStat.addSet(colorCombatImgStat, rangeImg);
			rngStat.addSet(colorCombatStat, "6-11 Ranged Damage");

			itemMainStatsList.add(rngStat);
		}

		if (basic.id.getText().equals("trident")) {
			rngStat = new Line();
			rngStat.addSet(colorCombatImgStat, hybridImg);
			rngStat.addSet(colorCombatStat, "8 Ranged Damage");

			itemMainStatsList.add(rngStat);
		}

		// If the item is a tool, display Mining Speed
		if (typeTest.equals("Tool")) {
			digStat = new Line();
			digStat.addSet(colorCombatImgStat, pickImg);
			if (basic.id.getText().equals("wooden_axe") || basic.id.getText().equals("wooden_hoe")
					|| basic.id.getText().equals("wooden_pickaxe") || basic.id.getText().equals("wooden_shovel"))
				digStat.addSet(colorCombatStat, "2 Mining Speed");
			if (basic.id.getText().equals("stone_axe") || basic.id.getText().equals("stone_hoe")
					|| basic.id.getText().equals("stone_pickaxe") || basic.id.getText().equals("stone_shovel"))
				digStat.addSet(colorCombatStat, "4 Mining Speed");
			if (basic.id.getText().equals("iron_axe") || basic.id.getText().equals("iron_hoe")
					|| basic.id.getText().equals("iron_pickaxe") || basic.id.getText().equals("iron_shovel"))
				digStat.addSet(colorCombatStat, "6 Mining Speed");
			if (basic.id.getText().equals("diamond_axe") || basic.id.getText().equals("diamond_hoe")
					|| basic.id.getText().equals("diamond_pickaxe") || basic.id.getText().equals("diamond_shovel"))
				digStat.addSet(colorCombatStat, "8 Mining Speed");
			if (basic.id.getText().equals("netherite_axe") || basic.id.getText().equals("netherite_hoe")
					|| basic.id.getText().equals("netherite_pickaxe") || basic.id.getText().equals("netherite_shovel"))
				digStat.addSet(colorCombatStat, "9 Mining Speed");
			if (basic.id.getText().equals("golden_axe") || basic.id.getText().equals("golden_hoe")
					|| basic.id.getText().equals("golden_pickaxe") || basic.id.getText().equals("golden_shovel"))
				digStat.addSet(colorCombatStat, "12 Mining Speed");
			if (basic.id.getText().equals("wooden_sword") || basic.id.getText().equals("stone_sword")
					|| basic.id.getText().equals("iron_sword") || basic.id.getText().equals("diamond_sword")
					|| basic.id.getText().equals("netherite_sword") || basic.id.getText().equals("golden_sword"))
				digStat.addSet(colorCombatStat, "1.5 Mining Speed");

			itemMainStatsList.add(digStat);
		}

		// Display Enchantments
		ArrayList<Line> itemEnchantList = new ArrayList<Line>();

		ArrayList<Line> itemCurseList = new ArrayList<Line>();

		String[] enchantRoster = { "Aqua Affinity", "Blast Protection", "Depth Strider", "Feather Falling",
				"Fire Protection", "Frost Walker", "Projectile Protection", "Protection", "Respiration", "Soul Speed",
				"Bane of Arthropods", "Fire Aspect", "Impaling", "Knockback", "Looting", "Sharpness", "Smite",
				"Sweeping Edge", "Channeling", "Flame", "Infinity", "Loyalty", "Multishot", "Piercing", "Power",
				"Punch", "Quick Charge", "Riptide", "Efficiency", "Fortune", "Silk Touch", "Curse of Binding",
				"Curse of Vanishing", "Mending", "Unbreaking" };

		boolean[] hasLevels = { false, true, true, true, true, true, true, true, true, true, true, true, true, true,
				true, true, true, true, false, false, false, true, false, true, true, true, true, true, true, true,
				false, false, false, false, true };

		for (int i = 0; i < enchants.boxList.size(); i++) {

			if (enchants.boxList.get(i).isSelected()) {
				Line enchantToAdd = new Line();
				if (enchantRoster[i].contains("Curse of")) {
					enchantToAdd.addSet(colorCurseImgStat, curseImg);
					enchantToAdd.addSet(colorCurseStat, enchantRoster[i]);

					int enchantLevel = (int) enchants.spinnerList.get(i).getValue();

					if (hasLevels[i]) {
						enchantToAdd.addSet(colorCurseStat, " " + RomanNumeral.toRoman(enchantLevel));
					}

					itemCurseList.add(enchantToAdd);
				} else {
					enchantToAdd.addSet(colorEnchantImgStat, enchantImg);
					enchantToAdd.addSet(colorEnchantStat, enchantRoster[i]);

					int enchantLevel = (int) enchants.spinnerList.get(i).getValue();

					if (hasLevels[i]) {
						enchantToAdd.addSet(colorEnchantStat, " " + RomanNumeral.toRoman(enchantLevel));
						if (basic.extraDetails.isSelected()) {
							if (enchantRoster[i].equals("Bane of Arthropods")) {
								double dmgVal = enchantLevel * 2.5;
								if (dmgVal == (long) dmgVal) {
									enchantToAdd.addSet(colorCombatStat, " (+" + String.format("%d", (long) dmgVal)
											+ " Magic Damage to Arthropods)");
								} else {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%s", dmgVal) + " Magic Damage to Arthropods)");
								}
							} else if (enchantRoster[i].equals("Smite")) {
								double dmgVal = enchantLevel * 2.5;
								if (dmgVal == (long) dmgVal) {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%d", (long) dmgVal) + " Magic Damage to Undead)");
								} else {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%s", dmgVal) + " Magic Damage to Undead)");
								}
							} else if (enchantRoster[i].equals("Sharpness")) {
								double dmgVal = 0;
								if (enchantLevel == 1) {
									dmgVal = 1;
								} else if (enchantLevel > 1) {
									dmgVal = 1 + ((enchantLevel - 1) * 0.5);
								}
								if (dmgVal == (long) dmgVal) {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%d", (long) dmgVal) + " Magic Damage)");
								} else {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%s", dmgVal) + " Magic Damage)");
								}
							} else if (enchantRoster[i].equals("Efficiency")) {
								int digVal = (int) (1 + (Math.pow(enchantLevel, 2)));
								enchantToAdd.addSet(colorCombatStat,
										" (+" + String.format("%s", digVal) + " Mining Speed)");
							}
						}
					}

					itemEnchantList.add(enchantToAdd);
				}
			}
		}

		String[] customEnchantRoster = { "Adrenaline", "Agility", "Aquadynamic", "Concealed", "Fatigue Cleansing",
				"Slowness Cleansing", "Weakness Cleansing", "Poison Cleansing", "Wither Cleansing", "Energetic",
				"Evasion", "Frenzy", "Lifesteal", "Rally", "Regeneration", "Satiation", "Second Wind", "Spurs",
				"Soulbound", "Bleeding", "Duelist", "Echo", "Electrocute", "Evocation", "Executioner", "Exposing",
				"Frostbite", "Hunter", "Infecting", "Stunning", "Surging Strike", "Transfiguration", "Vanquisher",
				"Auto Charge", "Bleed", "Current", "Deadeye", "Electrode", "Expose", "Frost", "Hydraulic", "Flash",
				"Fleetfoot", "Infect", "Overcharge", "Point Blank", "Repeating", "Ricochet", "Sharpshot", "Tempest",
				"Tempo Theft", "Trueshot", "Volatile", "Eruption", "Sapper", "Splintering", "Curse of Encumbering",
				"Curse of Irreparability", "Curse of Malevolence", "Curse of Regret", "Curse of Shattering",
				"Two Handed", "Infinity", "Unbreakable", "Loyalty", "Thorns" };

		boolean[] hasLevelsCustom = { true, true, false, false, false, false, false, false, false, true, true, true,
				true, true, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true,
				true, true, true, true, false, false, false, false, false, false, false, false, false, false, false,
				true, true, true, true, true, true, true, false, false, true, true, false, false, true, false, true,
				false, false, false, false, true, true };

		for (int i = 0; i < customEnchants.boxList.size(); i++) {

			if (customEnchants.boxList.get(i).isSelected()) {
				Line enchantToAdd = new Line();
				if (customEnchantRoster[i].contains("Curse of") || customEnchantRoster[i].equals("Two Handed")) {
					enchantToAdd.addSet(colorCurseImgStat, curseImg);
					enchantToAdd.addSet(colorCurseStat, customEnchantRoster[i]);

					int enchantLevel = (int) customEnchants.spinnerList.get(i).getValue();

					if (hasLevelsCustom[i]) {
						enchantToAdd.addSet(colorCurseStat, " " + RomanNumeral.toRoman(enchantLevel));
					}

					// It is a curse, so add it to the curse list.
					itemCurseList.add(enchantToAdd);
				} else {
					enchantToAdd.addSet(colorEnchantImgStat, enchantImg);
					enchantToAdd.addSet(colorEnchantStat, customEnchantRoster[i]);

					int enchantLevel = (int) customEnchants.spinnerList.get(i).getValue();

					if (hasLevelsCustom[i]) {
						enchantToAdd.addSet(colorEnchantStat, " " + RomanNumeral.toRoman(enchantLevel));
						if (basic.extraDetails.isSelected()) {
							if (customEnchantRoster[i].equals("Duelist")) {
								double dmgVal = enchantLevel * 2.5;
								if (dmgVal == (long) dmgVal) {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%d", (long) dmgVal) + " Magic Damage to Illagers)");
								} else {
									enchantToAdd.addSet(colorCombatStat,
											" (+" + String.format("%s", dmgVal) + " Magic Damage to Illagers)");
								}
							} else if (customEnchantRoster[i].equals("Hunter")) {
								double dmgVal = enchantLevel * 2.5;
								if (dmgVal == (long) dmgVal) {
									enchantToAdd.addSet(colorCombatStat, " (+" + String.format("%d", (long) dmgVal)
											+ " Magic Damage to Strange Creatures)");
								} else {
									enchantToAdd.addSet(colorCombatStat, " (+" + String.format("%s", dmgVal)
											+ " Magic Damage to Strange Creatures)");
								}
							}
						}
					}

					// Its not a curse, so add it to the enchant list
					itemEnchantList.add(enchantToAdd);
				}
			}
		}

		// Display Attributes
		ArrayList<Line> itemAttributeList = new ArrayList<Line>();

		String[] attributeRoster = { "Armor", "Armor Toughness", "Attack Speed", "Knockback Resistance", "Luck",
				"Max Health", "Melee Damage", "Speed" };

		for (int i = 0; i < attributes.boxList.size(); i++) {
			if (!attributes.fieldList.get(i).getText().isEmpty()) {
				Line attributeToAdd = new Line();

				// Determine how the effect is being added to stats.

				// If its "add" (aka option 0) then the exact stat amount input should display.
				// If its 1 or 2 (either Multiply option) then the amount input should display
				// as a percentage instead.
				if (attributes.boxList.get(i).getSelectedIndex() == 0) {
					// If the attribute is positive, we are going to display in Blue color with a
					// plus sign.
					// Otherwise we display in Red color with a minus sign.
					double amount = Double.parseDouble(attributes.fieldList.get(i).getText());

					if (attributeRoster[i].equals("Knockback Resistance")) {
						amount = amount * 10;
					}

					if (amount > 0) {
						attributeToAdd.addSet(colorAttributeImgStat, attributeImg);

						// Display the next line properly with decimals/integer
						if (amount == (long) amount) {
							attributeToAdd.addSet(colorAttributeStat, "+" + String.format("%d", (long) amount));
						} else {
							attributeToAdd.addSet(colorAttributeStat, "+" + String.format("%s", amount));
						}
						// Finish the description with a space and the name of the attribute.
						attributeToAdd.addSet(colorAttributeStat, " " + attributeRoster[i]);

						// It is not a curse, add it to attribute list.
						itemAttributeList.add(attributeToAdd);
					} else if (amount <= 0) {
						attributeToAdd.addSet(colorCurseImgStat, curseImg);

						// Display the next line properly with decimals/integer
						if (amount == (long) amount) {
							attributeToAdd.addSet(colorCurseStat, String.format("%d", (long) amount));
						} else {
							attributeToAdd.addSet(colorCurseStat, String.format("%s", amount));
						}
						// Finish the description with a space and the name of the attribute.
						attributeToAdd.addSet(colorCurseStat, " " + attributeRoster[i]);

						// It is a curse, add it to the curse list.
						itemCurseList.add(attributeToAdd);
					}
				} else if (attributes.boxList.get(i).getSelectedIndex() > 0) {
					// First, multiply the input by 100.
					// If the attribute is positive, we are going to display in Blue color with a
					// plus sign.
					// Otherwise we display in Red color with a minus sign.
					double amount = Double.parseDouble(attributes.fieldList.get(i).getText());
					amount = amount * 100;

					if (amount > 0) {
						attributeToAdd.addSet(colorAttributeImgStat, attributeImg);

						// Display the next line properly with decimals/integer
						if (amount == (long) amount) {
							attributeToAdd.addSet(colorAttributeStat, "+" + String.format("%d", (long) amount));
						} else {
							toughnessStat.addSet(colorAttributeStat, "+" + String.format("%s", amount));
						}
						// Finish the description with a percent, space and the name of the attribute.
						attributeToAdd.addSet(colorAttributeStat, "% " + attributeRoster[i]);

						// It is not a curse, add it to attributes list.
						itemAttributeList.add(attributeToAdd);
					} else if (amount <= 0) {
						attributeToAdd.addSet(colorCurseImgStat, curseImg);

						// Display the next line properly with decimals/integer
						if (amount == (long) amount) {
							attributeToAdd.addSet(colorCurseStat, String.format("%d", (long) amount));
						} else {
							toughnessStat.addSet(colorCurseStat, String.format("%s", amount));
						}
						// Finish the description with a percent, space and the name of the attribute.
						attributeToAdd.addSet(colorCurseStat, "% " + attributeRoster[i]);

						// It is a curse, put it in the curse list.
						itemCurseList.add(attributeToAdd);
					}

				}

			}

		}

		// Display "When Consumed" if the item is a consumable.
		ArrayList<Line> itemConsumeList = new ArrayList<Line>();

		String[] effectRoster = { "Speed", "Slowness", "Haste", "Mining Fatigue", "Strength", "Instant Health",
				"Instant Damage", "Jump Boost", "Nausea", "Regeneration", "Resistance", "Fire Resistance",
				"Water Breathing", "Invisibility", "Blindness", "Night Vision", "Hunger", "Weakness", "Poison",
				"Wither", "Health Boost", "Absorption", "Saturation", "Glowing", "Levitation", "Luck", "Bad Luck",
				"Slow Falling", "Conduit Power", "Dolphin's Grace", "Bad Omen", "Hero of the Village" };

		boolean[] isEffectPositive = { true, false, true, false, true, true, false, true, false, true, true, true, true,
				true, false, true, false, false, false, false, true, true, true, true, false, true, false, true, true,
				true, false, true };

		boolean inflictsOverApplies = false;

		if (typeTest.equals("Consumable")) {
			if (basic.id.getText().equals("splash_potion") || basic.id.getText().equals("lingering_potion")
					|| basic.id.getText().equals("tipped_arrow")) {
				inflictsOverApplies = true;
			}

			for (int i = 0; i < consumable.durationList.size(); i++) {
				if (!consumable.durationList.get(i).getText().isEmpty()) {
					Line effectToAdd = new Line();

					int effectPotency = (int) consumable.potencyList.get(i).getValue();
					int effectDuration = Integer.parseInt(consumable.durationList.get(i).getText());

					// For display, convert the tick time to second time.
					effectDuration = effectDuration / 20;

					int durationMinutes = effectDuration / 60;
					int durationSeconds = effectDuration % 60;

					if (isEffectPositive[i]) {

						if (!inflictsOverApplies)
							effectToAdd.addSet(colorAttributeImgStat, potionImg);
						else
							effectToAdd.addSet(colorAttributeImgStat, splashPotionImg);

						effectToAdd.addSet(colorAttributeStat, effectRoster[i] + " ");
						if (effectPotency > 1)
							effectToAdd.addSet(colorAttributeStat, RomanNumeral.toRoman(effectPotency) + " ");

						if (!effectRoster[i].equals("Instant Health") || !effectRoster[i].equals("Instant Damage")) {
							if (durationSeconds > 0 || durationMinutes > 0) {
								if (durationSeconds < 10)
									effectToAdd.addSet(colorAttributeStat,
											"(" + durationMinutes + ":" + String.format("%02d", durationSeconds) + ")");
								else
									effectToAdd.addSet(colorAttributeStat,
											"(" + durationMinutes + ":" + durationSeconds + ")");
							} else if (effectRoster[i].equals("Instant Health")) {
								effectToAdd.addSet(colorAttributeStat, "(");

								int heartNumber = (int) (2 * Math.pow(2, effectPotency - 1));

								for (int j = 0; j < heartNumber; j++) {
									effectToAdd.addSet(colorAttributeStat, healthImg);
								}
								effectToAdd.addSet(colorAttributeStat, ")");
							}
						}

						if (itemConsumeList.size() > 1)
							itemConsumeList.add(1, effectToAdd);
						else
							itemConsumeList.add(effectToAdd);

					} else {

						if (!inflictsOverApplies)
							effectToAdd.addSet(colorCurseImgStat, potionImg);
						else
							effectToAdd.addSet(colorCurseImgStat, splashPotionImg);

						effectToAdd.addSet(colorCurseStat, effectRoster[i] + " ");
						if (effectPotency > 1)
							effectToAdd.addSet(colorCurseStat, RomanNumeral.toRoman(effectPotency) + " ");

						if (!effectRoster[i].equals("Instant Health") || !effectRoster[i].equals("Instant Damage")) {
							if (durationSeconds > 0 || durationMinutes > 0) {
								if (durationSeconds < 10)
									effectToAdd.addSet(colorCurseStat,
											"(" + durationMinutes + ":" + String.format("%02d", durationSeconds) + ")");
								else
									effectToAdd.addSet(colorCurseStat,
											"(" + durationMinutes + ":" + durationSeconds + ")");
							} else if (effectRoster[i].equals("Instant Damage")) {

								int heartNumber = (int) (3 * Math.pow(2, effectPotency - 1));

								effectToAdd.addSet(colorCurseStat, "(");
								for (int j = 0; j < heartNumber; j++) {
									effectToAdd.addSet(colorCurseStat, healthImg);
								}
								effectToAdd.addSet(colorCurseStat, ")");
							}

							itemConsumeList.add(effectToAdd);
						}
					}
				}
			}
		}

		// Display "When Blocking" if the item is a shield. These stats come after the
		// mainhand/offhand.

		ArrayList<Line> itemBlockStatsList = new ArrayList<Line>();

		if (typeTest.equals("Shield")) {
			itemBlockStatsList.add(new Line(colorTitle, "When Blocking:"));
			if (cushields.showDmgRed.isSelected()) {
				Line blockDetailAmt = new Line();
				if (cushields.blockType.getSelectedIndex() == 0) {
					// Normal Blocking
					blockDetailAmt.addSet(colorCombatImgStat, blockImg);
					blockDetailAmt.addSet(colorCombatStat,
							(int) cushields.blockValueMax.getValue() + " Max Damage Reduction");
				} else {
					// Parry Blocking
					blockDetailAmt.addSet(colorCombatImgStat, blockImg);
					blockDetailAmt.addSet(colorCombatStat, "Parries Attacks");
				}
				itemBlockStatsList.add(blockDetailAmt);
			}
			if (cushields.showBlockAngle.isSelected()) {
				Line blockAngleSize = new Line();
				blockAngleSize.addSet(colorCombatImgStat, blockImg);
				blockAngleSize.addSet(colorCombatStat,
						(String) cushields.blockAngle.getSelectedItem() + " Blocking Angle");
				itemBlockStatsList.add(blockAngleSize);
			}
			if (cushields.showPersistence.isSelected()) {
				Line blockPersistence = new Line();
				blockPersistence.addSet(colorCombatImgStat, blockImg);
				blockPersistence.addSet(colorCombatStat,
						(String) cushields.persistenceType.getSelectedItem() + " Block Persistence");
				itemBlockStatsList.add(blockPersistence);
			}
			if (cushields.showHoldTime.isSelected()) {
				Line blockTime = new Line();
				blockTime.addSet(colorCombatImgStat, blockImg);
				blockTime.addSet(colorCombatStat, ((int) cushields.shieldTimeMax.getValue() / 20) + " Second Duration");
				itemBlockStatsList.add(blockTime);
			}
			if (cushields.showCooldown.isSelected()) {
				Line blockCooldown = new Line();
				blockCooldown.addSet(colorCombatImgStat, blockImg);
				blockCooldown.addSet(colorCombatStat,
						((int) cushields.cooldownTime.getValue() / 20) + " Second Cooldown");
				itemBlockStatsList.add(blockCooldown);
			}
			if (cushields.disableResist.isSelected()) {
				Line canResistDisable = new Line();
				canResistDisable.addSet(colorCombatImgStat, blockImg);
				canResistDisable.addSet(colorCombatStat, "Disable Resistant");
				itemBlockStatsList.add(canResistDisable);
			}
			if (!cushields.canBlockArrows.isSelected()) {
				Line canBlockArrowsLine = new Line();
				canBlockArrowsLine.addSet(colorCurseImgStat, voidImg);
				canBlockArrowsLine.addSet(colorCurseStat, "Cannot Block Arrows");
				itemBlockStatsList.add(canBlockArrowsLine);
			}
		}

		// Display Set Bonus stats if needed.
		ArrayList<Line> itemSetList = new ArrayList<Line>();
		if (!set.setNameField.getText().isEmpty()) {
			Line setNameLine = new Line();
			setNameLine.addSet(colorSetImgStat, setImg);
			setNameLine.addSet(colorSetStat, set.setNameField.getText() + " Set");
			itemSetList.add(setNameLine);

			if (!set.setPerField.getText().isEmpty()) {
				Line setPerLine = new Line();
				setPerLine.addSet(colorSetImgStat, setPieceImg);
				setPerLine.addSet(colorSetStat, "(Per Item) ");
				itemSetList.add(setPerLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setPerField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}

			}

			if (!set.setOneField.getText().isEmpty()) {
				Line setOneLine = new Line();
				setOneLine.addSet(colorSetImgStat, setPieceImg);
				setOneLine.addSet(colorSetStat, "(1 Item) ");
				itemSetList.add(setOneLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setOneField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}

			}
			if (!set.setTwoField.getText().isEmpty()) {
				Line setTwoLine = new Line();
				setTwoLine.addSet(colorSetImgStat, setPieceImg);
				setTwoLine.addSet(colorSetStat, "(2 Items) ");
				itemSetList.add(setTwoLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setTwoField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}
			}
			if (!set.setThreeField.getText().isEmpty()) {
				Line setThreeLine = new Line();
				setThreeLine.addSet(colorSetImgStat, setPieceImg);
				setThreeLine.addSet(colorSetStat, "(3 Items) ");
				itemSetList.add(setThreeLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setThreeField.getText(),
						characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}
			}
			if (!set.setFourField.getText().isEmpty()) {
				Line setFourLine = new Line();
				setFourLine.addSet(colorSetImgStat, setPieceImg);
				setFourLine.addSet(colorSetStat, "(4 Items) ");
				itemSetList.add(setFourLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setFourField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}
			}
			if (!set.setFiveField.getText().isEmpty()) {
				Line setFiveLine = new Line();
				setFiveLine.addSet(colorSetImgStat, setPieceImg);
				setFiveLine.addSet(colorSetStat, "(5 Items) ");
				itemSetList.add(setFiveLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setFiveField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}
			}
			if (!set.setSixField.getText().isEmpty()) {
				Line setSixLine = new Line();
				setSixLine.addSet(colorSetImgStat, setPieceImg);
				setSixLine.addSet(colorSetStat, "(6 Items) ");
				itemSetList.add(setSixLine);
				ArrayList<String> splitSetDesc = StringSplitter.splitString(set.setSixField.getText(), characterLimit, smartSplitSetting);
				for (int i = 0; i < splitSetDesc.size(); i++) {
					Line descToAdd = new Line();
					descToAdd.addSetKeywords(colorDescribe, splitSetDesc.get(i));
					itemSetList.add(descToAdd);
				}
			}
		}

		// Add Special effects to the item.
		ArrayList<Line> itemSpecialList = new ArrayList<Line>();
		if (!special.specialNameField.getText().isEmpty()) {
			Line specialNameLine = new Line();
			if (special.negative.isSelected()) {
				specialNameLine.addSet(colorCurseImgStat, curseImg);
				specialNameLine.addSet(colorCurseStat, special.specialNameField.getText());
			} else {
				specialNameLine.addSet(colorSpecialImgStat, specialImg);
				specialNameLine.addSet(colorSpecialStat, special.specialNameField.getText());
			}
			itemSpecialList.add(specialNameLine);

			String specialDescription = special.specialDescField.getText();
			ArrayList<String> splitSpecialDesc = StringSplitter.splitString(specialDescription, characterLimit, smartSplitSetting);

			for (int i = 0; i < splitSpecialDesc.size(); i++) {
				Line descToAdd = new Line();
				descToAdd.addSetKeywords(colorDescribe, splitSpecialDesc.get(i));
				itemSpecialList.add(descToAdd);
			}
		}

		// Add Mythical effects to the item.
		ArrayList<Line> itemMythicList = new ArrayList<Line>();
		if (!mythic.mythNameField.getText().isEmpty()) {
			Line mythicNameLine = new Line();
			if (mythic.negative.isSelected()) {
				mythicNameLine.addSet(colorCurseImgStat, curseImg);
				mythicNameLine.addSet(colorCurseStat, mythic.mythNameField.getText());
			} else {
				mythicNameLine.addSet(colorMythicImgStat, mythicImg);
				mythicNameLine.addSet(colorMythicStat, mythic.mythNameField.getText());
			}
			itemMythicList.add(mythicNameLine);

			String mythicDescription = mythic.mythDescField.getText();
			ArrayList<String> splitMythDesc = StringSplitter.splitString(mythicDescription, characterLimit, smartSplitSetting);

			for (int i = 0; i < splitMythDesc.size(); i++) {
				Line descToAdd = new Line();
				descToAdd.addSetKeywords(colorDescribe, splitMythDesc.get(i));
				itemMythicList.add(descToAdd);
			}
		}

		// Add Info descriptor to the item.
		ArrayList<Line> itemInfoList = new ArrayList<Line>();
		if (!info.infoNameField.getText().isEmpty()) {
			Line infoNameLine = new Line();
			infoNameLine.addSet(colorCombatImgStat, infoImg);
			infoNameLine.addSet(colorCombatStat, info.infoNameField.getText());
			itemInfoList.add(infoNameLine);

			String infoDescription = info.infoDescField.getText();
			ArrayList<String> splitInfoDesc = StringSplitter.splitString(infoDescription, characterLimit, smartSplitSetting);

			for (int i = 0; i < splitInfoDesc.size(); i++) {
				Line descToAdd = new Line();
				descToAdd.addSetKeywords(colorDescribe, splitInfoDesc.get(i));
				itemInfoList.add(descToAdd);
			}
		}

		// Add Special effects to the item.
		ArrayList<Line> itemActiveList = new ArrayList<Line>();
		if (!active.activeNameField.getText().isEmpty()) {
			Line activeNameLine = new Line();
			activeNameLine.addSet(colorActiveImgStat, activeImg);
			activeNameLine.addSet(colorActiveStat, active.activeNameField.getText());

			itemActiveList.add(activeNameLine);

			String activeDescription = active.activeDescField.getText();
			ArrayList<String> splitActiveDesc = StringSplitter.splitString(activeDescription, characterLimit, smartSplitSetting);

			for (int i = 0; i < splitActiveDesc.size(); i++) {
				Line descToAdd = new Line();
				descToAdd.addSetKeywords(colorDescribe, splitActiveDesc.get(i));
				itemActiveList.add(descToAdd);
			}

			if (!active.noCooldown.isSelected()) {
				Line activeCooldownLine = new Line();
				activeCooldownLine.addSet(colorActiveStat, "Cooldown: ");
				activeCooldownLine.addSet(colorDescribe, active.activeCooldown.getText());

				itemActiveList.add(activeCooldownLine);
			}
		}

		// Add Flavor Lore to the item.
		ArrayList<Line> loreLineList = new ArrayList<Line>();

		ArrayList<String> flavorLore = new ArrayList<String>();
		String loreToConvert = basic.lore.getText();

		if (!loreToConvert.isEmpty()) {
			flavorLore = StringSplitter.splitString(loreToConvert, characterLimit, smartSplitSetting);
			loreLineList = new ArrayList<Line>();

			for (int i = 0; i < flavorLore.size(); i++) {
				Line loreToAdd = new Line(colorEndings, flavorLore.get(i), true);
				loreLineList.add(loreToAdd);
			}

			// loreLine = new Line(colorEndings, flavorLore, true);
		}

		itemLore.addLine(tierLine);
		itemLore.addLine(typeLine);

		if (!itemSpecialList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemSpecialList.size(); i++) {
				itemLore.addLine(itemSpecialList.get(i));
			}
		}

		if (!itemMythicList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemMythicList.size(); i++) {
				itemLore.addLine(itemMythicList.get(i));
			}
		}

		if (!itemSetList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemSetList.size(); i++) {
				itemLore.addLine(itemSetList.get(i));
			}
		}

		if (info.beforeMain.isSelected()) {
			if (!itemInfoList.isEmpty()) {
				itemLore.addLine(spacer);
				for (int i = 0; i < itemInfoList.size(); i++) {
					itemLore.addLine(itemInfoList.get(i));
				}
			}
		}

		if (!itemBlockStatsList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemBlockStatsList.size(); i++) {
				itemLore.addLine(itemBlockStatsList.get(i));
			}
		}

		if (!itemMainStatsList.isEmpty() && noMainStats == false) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemMainStatsList.size(); i++) {
				itemLore.addLine(itemMainStatsList.get(i));
			}
		}

		if (!itemConsumeList.isEmpty()) {
			for (int i = 0; i < itemConsumeList.size(); i++) {
				itemLore.addLine(itemConsumeList.get(i));
			}
		}

		if (!itemEnchantList.isEmpty()) {
			for (int i = 0; i < itemEnchantList.size(); i++) {
				itemLore.addLine(itemEnchantList.get(i));
			}
		}

		if (!itemAttributeList.isEmpty()) {
			for (int i = 0; i < itemAttributeList.size(); i++) {
				itemLore.addLine(itemAttributeList.get(i));
			}
		}

		if (!itemCurseList.isEmpty()) {
			for (int i = 0; i < itemCurseList.size(); i++) {
				itemLore.addLine(itemCurseList.get(i));
			}
		}

		if (!itemActiveList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < itemActiveList.size(); i++) {
				itemLore.addLine(itemActiveList.get(i));
			}
		}

		if (info.afterMain.isSelected()) {
			if (!itemInfoList.isEmpty()) {
				itemLore.addLine(spacer);
				for (int i = 0; i < itemInfoList.size(); i++) {
					itemLore.addLine(itemInfoList.get(i));
				}
			}
		}

		if (!loreLineList.isEmpty()) {
			itemLore.addLine(spacer);
			for (int i = 0; i < loreLineList.size(); i++) {
				itemLore.addLine(loreLineList.get(i));
			}
		}

		result = result + ",";

		result = result + itemLore.linesToLore();

		// end display tag
		result = result + "}";

		// If the item is a consumable, display customPotionColor
		if (basic.type.getSelectedItem().equals("Consumable"))
			result = result + ",CustomPotionColor:" + consumable.potionColor.getColor().getRGB();

		return result;

	}

}
