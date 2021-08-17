package panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class ConsumablePanel extends JPanel {

	JTextField eftSpeedDuration = new JTextField(10);
	JSpinner eftSpeedPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftSlownessDuration = new JTextField(10);
	JSpinner eftSlownessPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftHasteDuration = new JTextField(10);
	JSpinner eftHastePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftMiningFatigueDuration = new JTextField(10);
	JSpinner eftMiningFatiguePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftStrengthDuration = new JTextField(10);
	JSpinner eftStrengthPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftHealthDuration = new JTextField(10);
	JSpinner eftHealthPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftDamageDuration = new JTextField(10);
	JSpinner eftDamagePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftJumpBoostDuration = new JTextField(10);
	JSpinner eftJumpBoostPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftNauseaDuration = new JTextField(10);
	JSpinner eftNauseaPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftRegenerationDuration = new JTextField(10);
	JSpinner eftRegenerationPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftResistanceDuration = new JTextField(10);
	JSpinner eftResistancePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftFireResistanceDuration = new JTextField(10);
	JSpinner eftFireResistancePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftWaterBreathingDuration = new JTextField(10);
	JSpinner eftWaterBreathingPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftInvisibilityDuration = new JTextField(10);
	JSpinner eftInvisibilityPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftBlindnessDuration = new JTextField(10);
	JSpinner eftBlindnessPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftNightVisionDuration = new JTextField(10);
	JSpinner eftNightVisionPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftHungerDuration = new JTextField(10);
	JSpinner eftHungerPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftWeaknessDuration = new JTextField(10);
	JSpinner eftWeaknessPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftPoisonDuration = new JTextField(10);
	JSpinner eftPoisonPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftWitherDuration = new JTextField(10);
	JSpinner eftWitherPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftHealthBoostDuration = new JTextField(10);
	JSpinner eftHealthBoostPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftAbsorptionDuration = new JTextField(10);
	JSpinner eftAbsorptionPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftSaturationDuration = new JTextField(10);
	JSpinner eftSaturationPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftGlowingDuration = new JTextField(10);
	JSpinner eftGlowingPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftLevitationDuration = new JTextField(10);
	JSpinner eftLevitationPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftLuckDuration = new JTextField(10);
	JSpinner eftLuckPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftUnluckDuration = new JTextField(10);
	JSpinner eftUnluckPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftSlowFallingDuration = new JTextField(10);
	JSpinner eftSlowFallingPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftConduitPowerDuration = new JTextField(10);
	JSpinner eftConduitPowerPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftDolphinsGraceDuration = new JTextField(10);
	JSpinner eftDolphinsGracePotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftBadOmenDuration = new JTextField(10);
	JSpinner eftBadOmenPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	JTextField eftVillageHeroDuration = new JTextField(10);
	JSpinner eftVillageHeroPotency = new JSpinner(new SpinnerNumberModel(1, 1, 127, 1));
	
	public ArrayList<JTextField> durationList = new ArrayList<JTextField>();
	public ArrayList<JSpinner> potencyList = new ArrayList<JSpinner>();
	
	public JColorChooser potionColor = new JColorChooser();
	
	public ConsumablePanel() {

		super();
		
		JPanel effects = new JPanel();
		
		Border consumeBorder = BorderFactory.createTitledBorder("Consumable Stats");
		effects.setBorder(consumeBorder);
		
		JLabel eftSpeedLabel = new JLabel("Speed");
		JPanel eftSpeed = new JPanel();
		eftSpeed.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftSpeed.add(eftSpeedLabel);
		eftSpeed.add(eftSpeedDuration);
		eftSpeed.add(eftSpeedPotency);

		JLabel eftSlownessLabel = new JLabel("Slowness");
		JPanel eftSlowness = new JPanel();
		eftSlowness.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftSlowness.add(eftSlownessLabel);
		eftSlowness.add(eftSlownessDuration);
		eftSlowness.add(eftSlownessPotency);

		JLabel eftHasteLabel = new JLabel("Haste");
		JPanel eftHaste = new JPanel();
		eftHaste.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftHaste.add(eftHasteLabel);
		eftHaste.add(eftHasteDuration);
		eftHaste.add(eftHastePotency);
		
		JLabel eftMiningFatigueLabel = new JLabel("Mining Fatigue");
		JPanel eftMiningFatigue = new JPanel();
		eftMiningFatigue.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftMiningFatigue.add(eftMiningFatigueLabel);
		eftMiningFatigue.add(eftMiningFatigueDuration);
		eftMiningFatigue.add(eftMiningFatiguePotency);
		
		JLabel eftStrengthLabel = new JLabel("Strength");
		JPanel eftStrength = new JPanel();
		eftStrength.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftStrength.add(eftStrengthLabel);
		eftStrength.add(eftStrengthDuration);
		eftStrength.add(eftStrengthPotency);
		
		JLabel eftHealthLabel = new JLabel("Instant Health");
		JPanel eftHealth = new JPanel();
		eftHealth.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftHealth.add(eftHealthLabel);
		eftHealth.add(eftHealthDuration);
		eftHealth.add(eftHealthPotency);
		
		JLabel eftDamageLabel = new JLabel("Instant Damage");
		JPanel eftDamage = new JPanel();
		eftDamage.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftDamage.add(eftDamageLabel);
		eftDamage.add(eftDamageDuration);
		eftDamage.add(eftDamagePotency);
		
		JLabel eftJumpBoostLabel = new JLabel("Jump Boost");
		JPanel eftJumpBoost = new JPanel();
		eftJumpBoost.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftJumpBoost.add(eftJumpBoostLabel);
		eftJumpBoost.add(eftJumpBoostDuration);
		eftJumpBoost.add(eftJumpBoostPotency);
		
		JLabel eftNauseaLabel = new JLabel("Nausea");
		JPanel eftNausea = new JPanel();
		eftNausea.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftNausea.add(eftNauseaLabel);
		eftNausea.add(eftNauseaDuration);
		eftNausea.add(eftNauseaPotency);
		
		JLabel eftRegenerationLabel = new JLabel("Regeneration");
		JPanel eftRegeneration = new JPanel();
		eftRegeneration.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftRegeneration.add(eftRegenerationLabel);
		eftRegeneration.add(eftRegenerationDuration);
		eftRegeneration.add(eftRegenerationPotency);
		
		JLabel eftResistanceLabel = new JLabel("Resistance");
		JPanel eftResistance = new JPanel();
		eftResistance.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftResistance.add(eftResistanceLabel);
		eftResistance.add(eftResistanceDuration);
		eftResistance.add(eftResistancePotency);
		
		JLabel eftFireResistanceLabel = new JLabel("Fire Resistance");
		JPanel eftFireResistance = new JPanel();
		eftFireResistance.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftFireResistance.add(eftFireResistanceLabel);
		eftFireResistance.add(eftFireResistanceDuration);
		eftFireResistance.add(eftFireResistancePotency);
		
		JLabel eftWaterBreathingLabel = new JLabel("Water Breathing");
		JPanel eftWaterBreathing = new JPanel();
		eftWaterBreathing.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftWaterBreathing.add(eftWaterBreathingLabel);
		eftWaterBreathing.add(eftWaterBreathingDuration);
		eftWaterBreathing.add(eftWaterBreathingPotency);
		
		JLabel eftInvisibilityLabel = new JLabel("Invisibility");
		JPanel eftInvisibility = new JPanel();
		eftInvisibility.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftInvisibility.add(eftInvisibilityLabel);
		eftInvisibility.add(eftInvisibilityDuration);
		eftInvisibility.add(eftInvisibilityPotency);
		
		JLabel eftBlindnessLabel = new JLabel("Blindness");
		JPanel eftBlindness = new JPanel();
		eftBlindness.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftBlindness.add(eftBlindnessLabel);
		eftBlindness.add(eftBlindnessDuration);
		eftBlindness.add(eftBlindnessPotency);
		
		JLabel eftNightVisionLabel = new JLabel("Night Vision");
		JPanel eftNightVision = new JPanel();
		eftNightVision.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftNightVision.add(eftNightVisionLabel);
		eftNightVision.add(eftNightVisionDuration);
		eftNightVision.add(eftNightVisionPotency);
		
		JLabel eftHungerLabel = new JLabel("Hunger");
		JPanel eftHunger = new JPanel();
		eftHunger.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftHunger.add(eftHungerLabel);
		eftHunger.add(eftHungerDuration);
		eftHunger.add(eftHungerPotency);
		
		JLabel eftWeaknessLabel = new JLabel("Weakness");
		JPanel eftWeakness = new JPanel();
		eftWeakness.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftWeakness.add(eftWeaknessLabel);
		eftWeakness.add(eftWeaknessDuration);
		eftWeakness.add(eftWeaknessPotency);
		
		JLabel eftPoisonLabel = new JLabel("Poison");
		JPanel eftPoison = new JPanel();
		eftPoison.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftPoison.add(eftPoisonLabel);
		eftPoison.add(eftPoisonDuration);
		eftPoison.add(eftPoisonPotency);
		
		JLabel eftWitherLabel = new JLabel("Wither");
		JPanel eftWither = new JPanel();
		eftWither.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftWither.add(eftWitherLabel);
		eftWither.add(eftWitherDuration);
		eftWither.add(eftWitherPotency);
		
		JLabel eftHealthBoostLabel = new JLabel("Health Boost");
		JPanel eftHealthBoost = new JPanel();
		eftHealthBoost.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftHealthBoost.add(eftHealthBoostLabel);
		eftHealthBoost.add(eftHealthBoostDuration);
		eftHealthBoost.add(eftHealthBoostPotency);
		
		JLabel eftAbsorptionLabel = new JLabel("Absorption");
		JPanel eftAbsorption = new JPanel();
		eftAbsorption.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftAbsorption.add(eftAbsorptionLabel);
		eftAbsorption.add(eftAbsorptionDuration);
		eftAbsorption.add(eftAbsorptionPotency);
		
		JLabel eftSaturationLabel = new JLabel("Saturation");
		JPanel eftSaturation = new JPanel();
		eftSaturation.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftSaturation.add(eftSaturationLabel);
		eftSaturation.add(eftSaturationDuration);
		eftSaturation.add(eftSaturationPotency);
		
		JLabel eftGlowingLabel = new JLabel("Glowing");
		JPanel eftGlowing = new JPanel();
		eftGlowing.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftGlowing.add(eftGlowingLabel);
		eftGlowing.add(eftGlowingDuration);
		eftGlowing.add(eftGlowingPotency);
		
		JLabel eftLevitationLabel = new JLabel("Levitation");
		JPanel eftLevitation = new JPanel();
		eftLevitation.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftLevitation.add(eftLevitationLabel);
		eftLevitation.add(eftLevitationDuration);
		eftLevitation.add(eftLevitationPotency);
		
		JLabel eftLuckLabel = new JLabel("Luck");
		JPanel eftLuck = new JPanel();
		eftLuck.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftLuck.add(eftLuckLabel);
		eftLuck.add(eftLuckDuration);
		eftLuck.add(eftLuckPotency);
		
		JLabel eftUnluckLabel = new JLabel("Unluck");
		JPanel eftUnluck = new JPanel();
		eftUnluck.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftUnluck.add(eftUnluckLabel);
		eftUnluck.add(eftUnluckDuration);
		eftUnluck.add(eftUnluckPotency);
		
		JLabel eftSlowFallingLabel = new JLabel("Slow Falling");
		JPanel eftSlowFalling = new JPanel();
		eftSlowFalling.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftSlowFalling.add(eftSlowFallingLabel);
		eftSlowFalling.add(eftSlowFallingDuration);
		eftSlowFalling.add(eftSlowFallingPotency);
		
		JLabel eftConduitPowerLabel = new JLabel("Conduit Power");
		JPanel eftConduitPower = new JPanel();
		eftConduitPower.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftConduitPower.add(eftConduitPowerLabel);
		eftConduitPower.add(eftConduitPowerDuration);
		eftConduitPower.add(eftConduitPowerPotency);
		
		JLabel eftDolphinsGraceLabel = new JLabel("Dolphins Grace");
		JPanel eftDolphinsGrace = new JPanel();
		eftDolphinsGrace.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftDolphinsGrace.add(eftDolphinsGraceLabel);
		eftDolphinsGrace.add(eftDolphinsGraceDuration);
		eftDolphinsGrace.add(eftDolphinsGracePotency);
		
		JLabel eftBadOmenLabel = new JLabel("Bad Omen");
		JPanel eftBadOmen = new JPanel();
		eftBadOmen.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftBadOmen.add(eftBadOmenLabel);
		eftBadOmen.add(eftBadOmenDuration);
		eftBadOmen.add(eftBadOmenPotency);
		
		JLabel eftVillageHeroLabel = new JLabel("Village Hero");
		JPanel eftVillageHero = new JPanel();
		eftVillageHero.setLayout(new FlowLayout(FlowLayout.LEFT));
		eftVillageHero.add(eftVillageHeroLabel);
		eftVillageHero.add(eftVillageHeroDuration);
		eftVillageHero.add(eftVillageHeroPotency);
		
		effects.setLayout(new GridLayout(16,2));
		
		effects.add(eftSpeed);
		effects.add(eftSlowness);
		effects.add(eftHaste);
		effects.add(eftMiningFatigue);
		effects.add(eftStrength);
		effects.add(eftHealth);
		effects.add(eftDamage);
		effects.add(eftJumpBoost);
		effects.add(eftNausea);
		effects.add(eftRegeneration);
		effects.add(eftResistance);
		effects.add(eftFireResistance);
		effects.add(eftWaterBreathing);
		effects.add(eftInvisibility);
		effects.add(eftBlindness);
		effects.add(eftNightVision);
		effects.add(eftHunger);
		effects.add(eftWeakness);
		effects.add(eftPoison);
		effects.add(eftWither);
		effects.add(eftHealthBoost);
		effects.add(eftAbsorption);
		effects.add(eftSaturation);
		effects.add(eftGlowing);
		effects.add(eftLevitation);
		effects.add(eftLuck);
		effects.add(eftUnluck);
		effects.add(eftSlowFalling);
		effects.add(eftConduitPower);
		effects.add(eftDolphinsGrace);
		effects.add(eftBadOmen);
		effects.add(eftVillageHero);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(effects);
		add(potionColor);
		
		durationList.add(eftSpeedDuration);
		durationList.add(eftSlownessDuration);
		durationList.add(eftHasteDuration);
		durationList.add(eftMiningFatigueDuration);
		durationList.add(eftStrengthDuration);
		durationList.add(eftHealthDuration);
		durationList.add(eftDamageDuration);
		durationList.add(eftJumpBoostDuration);
		durationList.add(eftNauseaDuration);
		durationList.add(eftRegenerationDuration);
		durationList.add(eftResistanceDuration);
		durationList.add(eftFireResistanceDuration);
		durationList.add(eftWaterBreathingDuration);
		durationList.add(eftInvisibilityDuration);
		durationList.add(eftBlindnessDuration);
		durationList.add(eftNightVisionDuration);
		durationList.add(eftHungerDuration);
		durationList.add(eftWeaknessDuration);
		durationList.add(eftPoisonDuration);
		durationList.add(eftWitherDuration);
		durationList.add(eftHealthBoostDuration);
		durationList.add(eftAbsorptionDuration);
		durationList.add(eftSaturationDuration);
		durationList.add(eftGlowingDuration);
		durationList.add(eftLevitationDuration);
		durationList.add(eftLuckDuration);
		durationList.add(eftUnluckDuration);
		durationList.add(eftSlowFallingDuration);
		durationList.add(eftConduitPowerDuration);
		durationList.add(eftDolphinsGraceDuration);
		durationList.add(eftBadOmenDuration);
		durationList.add(eftVillageHeroDuration);

		potencyList.add(eftSpeedPotency);
		potencyList.add(eftSlownessPotency);
		potencyList.add(eftHastePotency);
		potencyList.add(eftMiningFatiguePotency);
		potencyList.add(eftStrengthPotency);
		potencyList.add(eftHealthPotency);
		potencyList.add(eftDamagePotency);
		potencyList.add(eftJumpBoostPotency);
		potencyList.add(eftNauseaPotency);
		potencyList.add(eftRegenerationPotency);
		potencyList.add(eftResistancePotency);
		potencyList.add(eftFireResistancePotency);
		potencyList.add(eftWaterBreathingPotency);
		potencyList.add(eftInvisibilityPotency);
		potencyList.add(eftBlindnessPotency);
		potencyList.add(eftNightVisionPotency);
		potencyList.add(eftHungerPotency);
		potencyList.add(eftWeaknessPotency);
		potencyList.add(eftPoisonPotency);
		potencyList.add(eftWitherPotency);
		potencyList.add(eftHealthBoostPotency);
		potencyList.add(eftAbsorptionPotency);
		potencyList.add(eftSaturationPotency);
		potencyList.add(eftGlowingPotency);
		potencyList.add(eftLevitationPotency);
		potencyList.add(eftLuckPotency);
		potencyList.add(eftUnluckPotency);
		potencyList.add(eftSlowFallingPotency);
		potencyList.add(eftConduitPowerPotency);
		potencyList.add(eftDolphinsGracePotency);
		potencyList.add(eftBadOmenPotency);
		potencyList.add(eftVillageHeroPotency);

	}

	public ConsumablePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ConsumablePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ConsumablePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
