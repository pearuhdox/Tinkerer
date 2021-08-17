package item;

public class Item {

	BasicItemData basic = new BasicItemData();
	EnchantData enchant = new EnchantData();
	AttributeData attribute = new AttributeData();
	SetBonusData set = new SetBonusData();
	SpecialData special = new SpecialData();
	ConsumableData consumable = new ConsumableData();
	CustomShieldData shield = new CustomShieldData();
	
	public Item() {
		basic = null;
		enchant = null;
		attribute = null;
		set = null;
		special = null;
		consumable = null;
		shield = null;
	}

	public Item(BasicItemData basic, EnchantData enchant, AttributeData attribute, SetBonusData set,
			SpecialData special, ConsumableData consumable, CustomShieldData shield) {
		super();
		this.basic = basic;
		this.enchant = enchant;
		this.attribute = attribute;
		this.set = set;
		this.special = special;
		this.consumable = consumable;
		this.shield = shield;
	}
	
	
	
}
