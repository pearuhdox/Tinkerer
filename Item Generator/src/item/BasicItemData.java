package item;

import java.awt.Color;

public class BasicItemData {

	ItemType type;
	ItemTier tier;
	
	String id;
	int count;
	
	double attackDamage;
	double attackSpeed;
	
	double armor;
	double armorToughness;
	
	int durabilityDamage;
	
	Color nameColor;
	
	String name;
	String lore;
	
	public BasicItemData() {
		type = null;
		tier = null;
		id = null;
		count = 0;
		attackDamage = 0;
		attackSpeed = 0;
		armor = 0;
		armorToughness = 0;
		durabilityDamage = 0;
		nameColor = null;
		name = null;
		lore = null;
	}
	
	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public ItemTier getTier() {
		return tier;
	}

	public void setTier(ItemTier tier) {
		this.tier = tier;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public double getArmorToughness() {
		return armorToughness;
	}

	public void setArmorToughness(double armorToughness) {
		this.armorToughness = armorToughness;
	}

	public int getDurabilityDamage() {
		return durabilityDamage;
	}

	public void setDurabilityDamage(int durabilityDamage) {
		this.durabilityDamage = durabilityDamage;
	}

	public Color getNameColor() {
		return nameColor;
	}

	public void setNameColor(Color nameColor) {
		this.nameColor = nameColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

	public BasicItemData(ItemType type, ItemTier tier, String id, int count, double attackDamage, double attackSpeed,
			double armor, double armorToughness, int durabilityDamage, Color nameColor, String name, String lore) {
		super();
		this.type = type;
		this.tier = tier;
		this.id = id;
		this.count = count;
		this.attackDamage = attackDamage;
		this.attackSpeed = attackSpeed;
		this.armor = armor;
		this.armorToughness = armorToughness;
		this.durabilityDamage = durabilityDamage;
		this.nameColor = nameColor;
		this.name = name;
		this.lore = lore;
	}

	

	
	
}
