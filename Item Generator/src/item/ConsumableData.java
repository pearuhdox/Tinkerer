package item;

import java.util.HashSet;

public class ConsumableData {

	HashSet<PotionEffect> effects;

	public ConsumableData() {
		effects = new HashSet<PotionEffect>();
	}

	public void addPotionEffect(PotionEffect input) {
		effects.add(input);
	}
	
}