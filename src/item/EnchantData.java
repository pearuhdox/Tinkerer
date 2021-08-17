package item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EnchantData {

	HashMap<String, Integer> enchants = new HashMap<String, Integer>();
	HashMap<String, Integer> customEnchants = new HashMap<String, Integer>();
	
	String[] enchantListArray = {"aqua_affinity","blast_protection","depth_strider","feather_falling","fire_protection","frost_walker","projectile_protection","protection","respiration","soul_speed","bane_of_arthropods","fire_aspect","impaling","knockback","looting","sharpness","smite","sweeping_edge","channeling","flame","infinity","loyalty","multishot","piercing","power","punch","quick_charge","riptide","efficiency","fortune","silk_touch","curse_of_binding","curse_of_vanishing","mending","unbreaking"};
	String[] customEnchantListArray = {"adrenaline","agility","aquadynamic","concealed","fatigue_cleansing","slowness_cleansing","weakness_cleansing","poison_cleansing","wither_cleansing","energetic","evasion","frenzy","lifesteal","rally","regeneration","satiation","second_wind","spurs","soulbound","bleeding","duelist","echo","electrocute","evocation","executioner","exposing","frostbite","hunter","infecting","stunning","surging_strike","transfiguration","vanquisher","auto_charge","bleed","current","deadeye","electrode","expose","frost","hydraulic","flash","fleetfoot","infect","overcharge","point_blank","repeating","ricochet","sharpshot","tempest","tempo_theft","trueshot","volatile","eruption","sapper","splintering","curse_of_encumbering","curse_of_malevolence","curse_of_irreparability","curse_of_regret","curse_of_shattering","two_handed","infinity_2","unbreakable","loyalty_2","thorns_2"};
	
	ArrayList<String> enchantList = (ArrayList<String>) Arrays.asList(enchantListArray);
	ArrayList<String> customEnchantList = (ArrayList<String>) Arrays.asList(customEnchantListArray);

	public EnchantData() {
		enchants = null;
		customEnchants = null;
	}

	public void addEnchant(String enchantID, int level) {
		if(enchantID.equals("infinity_2")) {
			customEnchants.put("infinity", level);
		} else if(enchantID.equals("thorns_2")) {
			customEnchants.put("thorns", level);
		} else if(enchantID.equals("loyalty_2")) {
			customEnchants.put("loyalty", level);
		} else if(enchantList.contains(enchantID)) {
			enchants.put(enchantID, level);
		} else if(customEnchantList.contains(enchantID)) {
			customEnchants.put(enchantID, level);
		} else {
			System.out.println("Error: Unknown Enchantment.");
		}
	}
	
}
	
	