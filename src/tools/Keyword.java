package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import lore.Segment;

public class Keyword {

	private static HashSet<String> enchantList = new HashSet<String>(Arrays.asList("Aqua_Affinity", "Blast_Protection",
			"Depth_Strider", "Feather_Falling", "Fire_Protection", "Frost_Walker", "Projectile_Protection",
			"Protection", "Respiration", "Soul Speed", "Bane_of_Arthropods", "Fire_Aspect", "Impaling", "Knockback",
			"Looting", "Sharpness", "Smite", "Sweeping_Edge", "Channeling", "Flame", "Infinity", "Loyalty", "Multishot",
			"Piercing", "Power", "Punch", "Quick_Charge", "Riptide", "Efficiency", "Fortune", "Silk_Touch",
			"Curse_of_Binding", "Curse_of_Vanishing", "Mending", "Unbreaking"));
	private static HashSet<String> customEnchantList = new HashSet<String>(Arrays.asList("Adrenaline", "Agility",
			"Aquadynamic", "Concealed", "Fatigue_Cleansing", "Slowness_Cleansing", "Weakness_Cleansing",
			"Poison_Cleansing", "Wither_Cleansing", "Energetic", "Evasion", "Frenzy", "Lifesteal", "Rally",
			"Regeneration", "Satiation", "Second Wind", "Spurs", "Soulbound", "Bleeding", "Duelist", "Echo",
			"Electrocute", "Evocation", "Executioner", "Exposing", "Frostbite", "Hunter", "Infecting", "Stunning",
			"Surging_Strike", "Transfiguration", "Vanquisher", "Auto_Charge", "Bleed", "Current", "Deadeye",
			"Electrode", "Expose", "Frost", "Hydraulic", "Flash", "Fleetfoot", "Infect", "Overcharge", "Point_Blank",
			"Repeating", "Ricochet", "Sharpshot", "Tempest", "Tempo_Theft", "Trueshot", "Volatile", "Eruption",
			"Sapper", "Splintering", "Curse_of_Encumbering", "Curse_of_Irreparability", "Curse_of_Malevolence",
			"Curse_of_Regret", "Curse_of_Shattering", "Two_Handed", "Infinity", "Unbreakable", "Loyalty", "Thorns"));
	private static HashSet<String> attributeList = new HashSet<String>(
			Arrays.asList("Max_HealthAttr", "ArmorAttr", "Armor_ToughnessAttr", "Melee_DamageAttr", "LuckAttr",
					"Attack_SpeedAttr", "SpeedAttr", "Knockback_ResistanceAttr"));
	private static HashSet<String> curseList = new HashSet<String>(
			Arrays.asList("Curse_of_Binding", "Curse_of_Vanishing", "Curse_of_Irreparability", "Curse_of_Encumbering",
					"Curse_of_Malevolence", "Curse_of_Regret", "Curse_of_Shattering", "Two_Handed"));
	private static HashSet<String> positiveEffectList = new HashSet<String>(Arrays.asList("Speed", "Haste", "Strength",
			"Instant_Health", "Jump_Boost", "Resistance", "Regeneration", "Fire_Resistance", "Water_Breathing",
			"Invisibility", "Night_Vision", "Health_Boost", "Absorption", "Saturation", "Glowing", "Luck",
			"Slow_Falling", "Conduit_Power", "Dolphin\'s_Grace", "Hero_of_the_Village"));
	private static HashSet<String> negativeEffectList = new HashSet<String>(
			Arrays.asList("Slowness", "Mining_Fatigue", "Instant_Damage", "Nausea", "Blindness", "Hunger", "Weakness",
					"Poison", "Wither", "Levitation", "Bad_Luck", "Bad_Omen"));
	private static HashSet<String> heartList = new HashSet<String>(Arrays.asList("heart20", "heart10", "heart11",
			"heart12", "heart13", "heart14", "heart15", "heart16", "heart17", "heart18", "heart19", "heart01",
			"heart02", "heart03", "heart04", "heart05", "heart06", "heart07", "heart08", "heart09", "heartneg20",
			"heartneg10", "heartneg11", "heartneg12", "heartneg13", "heartneg14", "heartneg15", "heartneg16",
			"heartneg17", "heartneg18", "heartneg19", "heartneg01", "heartneg02", "heartneg03", "heartneg04",
			"heartneg05", "heartneg06", "heartneg07", "heartneg08", "heartneg09"));
	private static HashSet<String> fractionList = new HashSet<String>(
			Arrays.asList("(1/2)", "(1/3)", "(1/4)", "(2/3)", "(3/4)"));
	private static HashSet<String> keybindList = new HashSet<String>(Arrays.asList("key.sneak", "key.jump", "key.use", "key.swapOffhand"));
	
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
	
	// Active Color
	static String colorActiveStat = "#FCFCB1";

	// Description color
	static String colorDescribe = "#EBEBEB";

	static {

	}

	public static ArrayList<Segment> addIcons(ArrayList<String> input, String defaultColor) {
		ArrayList<Segment> result = new ArrayList<Segment>();

		for (int i = 0; i < input.size(); i++) {

			boolean doNotAdd = false;
			boolean typeEnchant = false;
			boolean typeAttribute = false;
			boolean typeCurse = false;
			boolean typePosEffect = false;
			boolean typeNegEffect = false;
			boolean skipEffects = false;

			Iterator<String> iterator = enchantList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					result.add(new Segment(colorEnchantImgStat, "◆ "));
					typeEnchant = true;
				}
			}
			iterator = customEnchantList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					result.add(new Segment(colorEnchantImgStat, "◆ "));
					typeEnchant = true;
				}
			}
			iterator = attributeList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					String attributeParse = input.get(i);

					skipEffects = true;

					if (attributeParse.startsWith("+")) {
						result.add(new Segment(colorAttributeImgStat, "★ "));
						typeAttribute = true;
					} else if (attributeParse.startsWith("-")) {
						result.add(new Segment(colorCurseImgStat, "☠ "));
						typeCurse = true;
					}
				}
			}
			iterator = curseList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					result.add(new Segment(colorCurseImgStat, "☠ "));
					typeCurse = true;
				}
			}
			if (!skipEffects) {
				iterator = positiveEffectList.iterator();
				while (iterator.hasNext()) {
					if (input.get(i).contains(iterator.next())) {
						result.add(new Segment(colorAttributeImgStat, "🧪 "));
						typePosEffect = true;
					}
				}
			}
			iterator = negativeEffectList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					result.add(new Segment(colorCurseImgStat, "🧪 "));
					typeNegEffect = true;
				}
			}

			iterator = heartList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					// Save the back 2 characters
					String heartType = input.get(i).substring(0, input.get(i).length() - 2);
					String healthString = input.get(i).substring(input.get(i).length() - 2, input.get(i).length());

					int numberHealth = Integer.parseInt(healthString);

					boolean oddNumberHealth = false;

					if (numberHealth % 2 != 0) {
						oddNumberHealth = true;
					}

					numberHealth = numberHealth / 2;

					String heartDisplay = numberHealth + " (❤)";

					if (oddNumberHealth && numberHealth > 1) {
						heartDisplay = heartDisplay + " & (½❤)";
					} else if (oddNumberHealth && numberHealth < 2){
						heartDisplay = "(½❤)";
					}

					if (heartType.equals("heartneg"))
						result.add(new Segment(colorCurseImgStat, heartDisplay));
					else
						result.add(new Segment(colorAttributeImgStat, heartDisplay));

					doNotAdd = true;
				}
			}

			iterator = fractionList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					String fraction = input.get(i);
					if(fraction.contains("(1/2)")) {
						result.add(new Segment(defaultColor, "½"));
					} else if(fraction.contains("(1/3)")) {
						result.add(new Segment(defaultColor, "⅓"));
					} else if(fraction.contains("(1/4)")) {
						result.add(new Segment(defaultColor, "¼"));
					} else if(fraction.contains("(2/3)")) {
						result.add(new Segment(defaultColor, "⅔"));
					} else if(fraction.contains("(3/4)")) {
						result.add(new Segment(defaultColor, "¾"));
					}
					
					doNotAdd = true;
				}
			}
			
			iterator = keybindList.iterator();
			while (iterator.hasNext()) {
				if (input.get(i).contains(iterator.next())) {
					result.add(new Segment(colorDescribe, "["));
					result.add(new Segment(colorActiveStat, input.get(i), true));
					result.add(new Segment(colorDescribe, "]"));
					doNotAdd = true;
				}
			}
			
			// Remove underscores from the input.
			String removedUnder = input.get(i).replace("_", " ");

			if (typeAttribute)
				removedUnder = removedUnder.replace("Attr", "");

			if (!doNotAdd) {
				if (typeEnchant)
					result.add(new Segment(colorEnchantStat, removedUnder));
				else if (typeAttribute)
					result.add(new Segment(colorAttributeStat, removedUnder));
				else if (typeCurse)
					result.add(new Segment(colorCurseStat, removedUnder));
				else if (typePosEffect)
					result.add(new Segment(colorAttributeStat, removedUnder));
				else if (typeNegEffect)
					result.add(new Segment(colorCurseStat, removedUnder));
				else
					result.add(new Segment(defaultColor, removedUnder));
			}
		}

		return result;
	}

}
