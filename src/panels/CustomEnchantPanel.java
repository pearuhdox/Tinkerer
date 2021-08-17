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

public class CustomEnchantPanel extends JPanel {

	// Array List for all buttons
	public ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();
	public ArrayList<JSpinner> spinnerList = new ArrayList<JSpinner>();
	
	// Create all buttons
	JCheckBox cAdrenaline = new JCheckBox("Adrenaline");
	JSpinner sAdrenaline = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

	JCheckBox cAgility = new JCheckBox("Agility");
	JSpinner sAgility = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cAquadynamic = new JCheckBox("Aquadynamic");
	JSpinner sAquadynamic = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cConcealed = new JCheckBox("Concealed");
	JSpinner sConcealed = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cFatigueCleansing = new JCheckBox("F. Cleanse");
	JSpinner sFatigueCleansing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cSlownessCleansing = new JCheckBox("S. Cleanse");
	JSpinner sSlownessCleansing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cWeaknessCleansing = new JCheckBox("W. Cleanse");
	JSpinner sWeaknessCleansing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cPoisonCleansing = new JCheckBox("P. Cleanse");
	JSpinner sPoisonCleansing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cWitherCleansing = new JCheckBox("Wi. Cleanse");
	JSpinner sWitherCleansing = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cEnergetic = new JCheckBox("Energetic");
	JSpinner sEnergetic = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

	JCheckBox cEvasion = new JCheckBox("Evasion");
	JSpinner sEvasion = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));

	JCheckBox cFrenzy = new JCheckBox("Frenzy");
	JSpinner sFrenzy = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

	JCheckBox cLifesteal = new JCheckBox("Lifesteal");
	JSpinner sLifesteal = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));

	JCheckBox cRally = new JCheckBox("Rally");
	JSpinner sRally = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	JCheckBox cRegeneration = new JCheckBox("Regeneration");
	JSpinner sRegeneration = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	JCheckBox cSatiation = new JCheckBox("Satiation");
	JSpinner sSatiation = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cSecondWind = new JCheckBox("Second Wind");
	JSpinner sSecondWind = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cSoulbound = new JCheckBox("Soulbound");
	JSpinner sSoulbound = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cSpurs = new JCheckBox("Spurs");
	JSpinner sSpurs = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cBleeding = new JCheckBox("Bleeding");
	JSpinner sBleeding = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cDuelist = new JCheckBox("Duelist");
	JSpinner sDuelist = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cEcho = new JCheckBox("Echo");
	JSpinner sEcho = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cElectrocute = new JCheckBox("Electrocute");
	JSpinner sElectrocute = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cEvocation = new JCheckBox("Evocation");
	JSpinner sEvocation = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cExecutioner = new JCheckBox("Executioner");
	JSpinner sExecutioner = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cExposing = new JCheckBox("Exposing");
	JSpinner sExposing = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cFrostbite = new JCheckBox("Frostbite");
	JSpinner sFrostbite = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cHunter = new JCheckBox("Hunter");
	JSpinner sHunter = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cInfecting = new JCheckBox("Infecting");
	JSpinner sInfecting = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cStunning = new JCheckBox("Stunning");
	JSpinner sStunning = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cSurgingStrike = new JCheckBox("SurgingStrike");
	JSpinner sSurgingStrike = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cTransfiguration = new JCheckBox("Transfiguration");
	JSpinner sTransfiguration = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cVanquisher = new JCheckBox("Vanquisher");
	JSpinner sVanquisher = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cAutoCharge = new JCheckBox("Auto Charge");
	JSpinner sAutoCharge = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cBleed = new JCheckBox("Bleed");
	JSpinner sBleed = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurrent = new JCheckBox("Current");
	JSpinner sCurrent = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cDeadeye = new JCheckBox("Deadeye");
	JSpinner sDeadeye = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cElectrode = new JCheckBox("Electrode");
	JSpinner sElectrode = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cExpose = new JCheckBox("Expose");
	JSpinner sExpose = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cFrost = new JCheckBox("Frost");
	JSpinner sFrost = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cHydraulic = new JCheckBox("Hydraulic");
	JSpinner sHydraulic = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cFlash = new JCheckBox("Flash");
	JSpinner sFlash = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cFleetfoot = new JCheckBox("Fleetfoot");
	JSpinner sFleetfoot = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cInfect = new JCheckBox("Infect");
	JSpinner sInfect = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cOvercharge = new JCheckBox("Overcharge");
	JSpinner sOvercharge = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cPointBlank = new JCheckBox("Point Blank");
	JSpinner sPointBlank = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cRepeating = new JCheckBox("Repeating");
	JSpinner sRepeating = new JSpinner(new SpinnerNumberModel(1, 1, 7, 1));

	JCheckBox cRicochet = new JCheckBox("Ricochet");
	JSpinner sRicochet = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cSharpshot = new JCheckBox("Sharpshot");
	JSpinner sSharpshot = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cTempest = new JCheckBox("Tempest");
	JSpinner sTempest = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cTempoTheft = new JCheckBox("Tempo Theft");
	JSpinner sTempoTheft = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));

	JCheckBox cTrueshot = new JCheckBox("Trueshot");
	JSpinner sTrueshot = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cVolatile = new JCheckBox("Volatile");
	JSpinner sVolatile = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cEruption = new JCheckBox("Eruption");
	JSpinner sEruption = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cSapper = new JCheckBox("Sapper");
	JSpinner sSapper = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

	JCheckBox cSplintering = new JCheckBox("Splintering");
	JSpinner sSplintering = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurseEncumbering = new JCheckBox("Curse of Encumbering");
	JSpinner sCurseEncumbering = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurseIrreparability = new JCheckBox("Curse of Irreparability");
	JSpinner sCurseIrreparability = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurseMalevolence = new JCheckBox("Curse of Malevolence");
	JSpinner sCurseMalevolence = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurseRegret = new JCheckBox("Curse of Regret");
	JSpinner sCurseRegret = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));

	JCheckBox cCurseShattering = new JCheckBox("Curse of Shattering");
	JSpinner sCurseShattering = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCurseTwoHanded = new JCheckBox("Two Handed");
	JSpinner sCurseTwoHanded = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cCInfinity = new JCheckBox("Infinity (Consumable)");
	JSpinner sCInfinity = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cUnbreakable = new JCheckBox("Unbreakable");
	JSpinner sUnbreakable = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cLoyalty2 = new JCheckBox("Loyalty 2.0");
	JSpinner sLoyalty2 = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	JCheckBox cThorns2 = new JCheckBox("Thorns 2.0");
	JSpinner sThorns2 = new JSpinner(new SpinnerNumberModel(1, 1, 1, 1));

	public CustomEnchantPanel() {

		JPanel passiveCEnchants = new JPanel();
		passiveCEnchants.setBorder(BorderFactory.createTitledBorder("Passive"));

		passiveCEnchants.setLayout(new GridLayout(7, 2));

		// Add all buttons and add them to lists.
		passiveCEnchants.add(sAdrenaline);
		passiveCEnchants.add(cAdrenaline);
		boxList.add(cAdrenaline);
		spinnerList.add(sAdrenaline);
		
		passiveCEnchants.add(sAgility);
		passiveCEnchants.add(cAgility);
		boxList.add(cAgility);
		spinnerList.add(sAgility);
		
		passiveCEnchants.add(sAquadynamic);
		passiveCEnchants.add(cAquadynamic);
		boxList.add(cAquadynamic);
		spinnerList.add(sAquadynamic);
		
		passiveCEnchants.add(sConcealed);
		passiveCEnchants.add(cConcealed);
		boxList.add(cConcealed);
		spinnerList.add(sConcealed);
		
		passiveCEnchants.add(sFatigueCleansing);
		passiveCEnchants.add(cFatigueCleansing);
		boxList.add(cFatigueCleansing);
		spinnerList.add(sFatigueCleansing);
		
		passiveCEnchants.add(sSlownessCleansing);
		passiveCEnchants.add(cSlownessCleansing);
		boxList.add(cSlownessCleansing);
		spinnerList.add(sSlownessCleansing);
		
		passiveCEnchants.add(sWeaknessCleansing);
		passiveCEnchants.add(cWeaknessCleansing);
		boxList.add(cWeaknessCleansing);
		spinnerList.add(sWeaknessCleansing);
		
		passiveCEnchants.add(sPoisonCleansing);
		passiveCEnchants.add(cPoisonCleansing);
		boxList.add(cPoisonCleansing);
		spinnerList.add(sPoisonCleansing);
		
		passiveCEnchants.add(sWitherCleansing);
		passiveCEnchants.add(cWitherCleansing);
		boxList.add(cWitherCleansing);
		spinnerList.add(sWitherCleansing);
		
		passiveCEnchants.add(sEnergetic);
		passiveCEnchants.add(cEnergetic);
		boxList.add(cEnergetic);
		spinnerList.add(sEnergetic);
		
		passiveCEnchants.add(sEvasion);
		passiveCEnchants.add(cEvasion);
		boxList.add(cEvasion);
		spinnerList.add(sEvasion);
		
		passiveCEnchants.add(sFrenzy);
		passiveCEnchants.add(cFrenzy);
		boxList.add(cFrenzy);
		spinnerList.add(sFrenzy);
		
		passiveCEnchants.add(sLifesteal);
		passiveCEnchants.add(cLifesteal);
		boxList.add(cLifesteal);
		spinnerList.add(sLifesteal);
		
		passiveCEnchants.add(sRally);
		passiveCEnchants.add(cRally);
		boxList.add(cRally);
		spinnerList.add(sRally);
		
		passiveCEnchants.add(sRegeneration);
		passiveCEnchants.add(cRegeneration);
		boxList.add(cRegeneration);
		spinnerList.add(sRegeneration);
		
		passiveCEnchants.add(sSatiation);
		passiveCEnchants.add(cSatiation);
		boxList.add(cSatiation);
		spinnerList.add(sSatiation);
		
		passiveCEnchants.add(sSecondWind);
		passiveCEnchants.add(cSecondWind);
		boxList.add(cSecondWind);
		spinnerList.add(sSecondWind);
		
		passiveCEnchants.add(sSpurs);
		passiveCEnchants.add(cSpurs);
		boxList.add(cSpurs);
		spinnerList.add(sSpurs);
		
		passiveCEnchants.add(sSoulbound);
		passiveCEnchants.add(cSoulbound);
		boxList.add(cSoulbound);
		spinnerList.add(sSoulbound);
		
		JPanel meleeCEnchants = new JPanel();
		meleeCEnchants.setBorder(BorderFactory.createTitledBorder("Melee"));

		meleeCEnchants.setLayout(new GridLayout(7, 2));

		// Add all buttons
		meleeCEnchants.add(sBleeding);
		meleeCEnchants.add(cBleeding);
		boxList.add(cBleeding);
		spinnerList.add(sBleeding);
		
		meleeCEnchants.add(sDuelist);
		meleeCEnchants.add(cDuelist);
		boxList.add(cDuelist);
		spinnerList.add(sDuelist);
		
		meleeCEnchants.add(sEcho);
		meleeCEnchants.add(cEcho);
		boxList.add(cEcho);
		spinnerList.add(sEcho);
		
		meleeCEnchants.add(sElectrocute);
		meleeCEnchants.add(cElectrocute);
		boxList.add(cElectrocute);
		spinnerList.add(sElectrocute);
		
		meleeCEnchants.add(sEvocation);
		meleeCEnchants.add(cEvocation);
		boxList.add(cEvocation);
		spinnerList.add(sEvocation);
		
		meleeCEnchants.add(sExecutioner);
		meleeCEnchants.add(cExecutioner);
		boxList.add(cExecutioner);
		spinnerList.add(sExecutioner);
		
		meleeCEnchants.add(sExposing);
		meleeCEnchants.add(cExposing);
		boxList.add(cExposing);
		spinnerList.add(sExposing);
		
		meleeCEnchants.add(sFrostbite);
		meleeCEnchants.add(cFrostbite);
		boxList.add(cFrostbite);
		spinnerList.add(sFrostbite);
		
		meleeCEnchants.add(sHunter);
		meleeCEnchants.add(cHunter);
		boxList.add(cHunter);
		spinnerList.add(sHunter);
		
		meleeCEnchants.add(sInfecting);
		meleeCEnchants.add(cInfecting);
		boxList.add(cInfecting);
		spinnerList.add(sInfecting);
		
		meleeCEnchants.add(sStunning);
		meleeCEnchants.add(cStunning);
		boxList.add(cStunning);
		spinnerList.add(sStunning);
		
		meleeCEnchants.add(sSurgingStrike);
		meleeCEnchants.add(cSurgingStrike);
		boxList.add(cSurgingStrike);
		spinnerList.add(sSurgingStrike);
		
		meleeCEnchants.add(sTransfiguration);
		meleeCEnchants.add(cTransfiguration);
		boxList.add(cTransfiguration);
		spinnerList.add(sTransfiguration);
		
		meleeCEnchants.add(sVanquisher);
		meleeCEnchants.add(cVanquisher);
		boxList.add(cVanquisher);
		spinnerList.add(sVanquisher);
		
		JPanel rangedCEnchants = new JPanel();
		rangedCEnchants.setBorder(BorderFactory.createTitledBorder("Ranged"));

		rangedCEnchants.setLayout(new GridLayout(5, 2));

		// Add all buttons
		rangedCEnchants.add(sAutoCharge);
		rangedCEnchants.add(cAutoCharge);
		boxList.add(cAutoCharge);
		spinnerList.add(sAutoCharge);
		
		rangedCEnchants.add(sBleed);
		rangedCEnchants.add(cBleed);
		boxList.add(cBleed);
		spinnerList.add(sBleed);
		
		rangedCEnchants.add(sCurrent);
		rangedCEnchants.add(cCurrent);
		boxList.add(cCurrent);
		spinnerList.add(sCurrent);
		
		rangedCEnchants.add(sDeadeye);
		rangedCEnchants.add(cDeadeye);
		boxList.add(cDeadeye);
		spinnerList.add(sDeadeye);
		
		rangedCEnchants.add(sElectrode);
		rangedCEnchants.add(cElectrode);
		boxList.add(cElectrode);
		spinnerList.add(sElectrode);
		
		rangedCEnchants.add(sExpose);
		rangedCEnchants.add(cExpose);
		boxList.add(cExpose);
		spinnerList.add(sExpose);
		
		rangedCEnchants.add(sFrost);
		rangedCEnchants.add(cFrost);
		boxList.add(cFrost);
		spinnerList.add(sFrost);
		
		rangedCEnchants.add(sHydraulic);
		rangedCEnchants.add(cHydraulic);
		boxList.add(cHydraulic);
		spinnerList.add(sHydraulic);
		
		rangedCEnchants.add(sFlash);
		rangedCEnchants.add(cFlash);
		boxList.add(cFlash);
		spinnerList.add(sFlash);
		
		rangedCEnchants.add(sFleetfoot);
		rangedCEnchants.add(cFleetfoot);
		boxList.add(cFleetfoot);
		spinnerList.add(sFleetfoot);
		
		rangedCEnchants.add(sInfect);
		rangedCEnchants.add(cInfect);
		boxList.add(cInfect);
		spinnerList.add(sInfect);
		
		rangedCEnchants.add(sOvercharge);
		rangedCEnchants.add(cOvercharge);
		boxList.add(cOvercharge);
		spinnerList.add(sOvercharge);
		
		rangedCEnchants.add(sPointBlank);
		rangedCEnchants.add(cPointBlank);
		boxList.add(cPointBlank);
		spinnerList.add(sPointBlank);
		
		rangedCEnchants.add(sRepeating);
		rangedCEnchants.add(cRepeating);
		boxList.add(cRepeating);
		spinnerList.add(sRepeating);
		
		rangedCEnchants.add(sRicochet);
		rangedCEnchants.add(cRicochet);
		boxList.add(cRicochet);
		spinnerList.add(sRicochet);
		
		rangedCEnchants.add(sSharpshot);
		rangedCEnchants.add(cSharpshot);
		boxList.add(cSharpshot);
		spinnerList.add(sSharpshot);
		
		rangedCEnchants.add(sTempest);
		rangedCEnchants.add(cTempest);
		boxList.add(cTempest);
		spinnerList.add(sTempest);
		
		rangedCEnchants.add(sTempoTheft);
		rangedCEnchants.add(cTempoTheft);
		boxList.add(cTempoTheft);
		spinnerList.add(sTempoTheft);
		
		rangedCEnchants.add(sTrueshot);
		rangedCEnchants.add(cTrueshot);
		boxList.add(cTempoTheft);
		spinnerList.add(sTempoTheft);
		
		rangedCEnchants.add(sVolatile);
		rangedCEnchants.add(cVolatile);
		boxList.add(cVolatile);
		spinnerList.add(sVolatile);
		
		JPanel toolCEnchants = new JPanel();
		toolCEnchants.setBorder(BorderFactory.createTitledBorder("Tools"));

		toolCEnchants.setLayout(new GridLayout(3, 2));

		// Add all buttons
		toolCEnchants.add(sEruption);
		toolCEnchants.add(cEruption);
		boxList.add(cEruption);
		spinnerList.add(sEruption);
		
		toolCEnchants.add(sSapper);
		toolCEnchants.add(cSapper);
		boxList.add(cSapper);
		spinnerList.add(sSapper);
		
		toolCEnchants.add(sSplintering);
		toolCEnchants.add(cSplintering);
		boxList.add(cSplintering);
		spinnerList.add(sSplintering);
		
		JPanel otherCEnchants = new JPanel();
		otherCEnchants.setBorder(BorderFactory.createTitledBorder("Other and Curses"));

		otherCEnchants.setLayout(new GridLayout(5, 2));

		// Add all buttons
		otherCEnchants.add(sCurseEncumbering);
		otherCEnchants.add(cCurseEncumbering);
		boxList.add(cCurseEncumbering);
		spinnerList.add(sCurseEncumbering);
		
		otherCEnchants.add(sCurseIrreparability);
		otherCEnchants.add(cCurseIrreparability);
		boxList.add(cCurseIrreparability);
		spinnerList.add(sCurseIrreparability);
		
		otherCEnchants.add(sCurseMalevolence);
		otherCEnchants.add(cCurseMalevolence);
		boxList.add(cCurseMalevolence);
		spinnerList.add(sCurseMalevolence);
		
		otherCEnchants.add(sCurseRegret);
		otherCEnchants.add(cCurseRegret);
		boxList.add(cCurseRegret);
		spinnerList.add(sCurseRegret);
		
		otherCEnchants.add(sCurseShattering);
		otherCEnchants.add(cCurseShattering);
		boxList.add(cCurseShattering);
		spinnerList.add(sCurseShattering);
		
		otherCEnchants.add(sCurseTwoHanded);
		otherCEnchants.add(cCurseTwoHanded);
		boxList.add(cCurseTwoHanded);
		spinnerList.add(sCurseTwoHanded);
		
		otherCEnchants.add(sCInfinity);
		otherCEnchants.add(cCInfinity);
		boxList.add(cCInfinity);
		spinnerList.add(sCInfinity);
		
		otherCEnchants.add(sUnbreakable);
		otherCEnchants.add(cUnbreakable);
		boxList.add(cUnbreakable);
		spinnerList.add(sUnbreakable);
		
		otherCEnchants.add(sLoyalty2);
		otherCEnchants.add(cLoyalty2);
		boxList.add(cLoyalty2);
		spinnerList.add(sLoyalty2);
		
		otherCEnchants.add(sThorns2);
		otherCEnchants.add(cThorns2);
		boxList.add(cThorns2);
		spinnerList.add(sThorns2);
		
		setLayout(new GridLayout(5, 1));
		add(passiveCEnchants);
		add(meleeCEnchants);
		add(rangedCEnchants);
		add(toolCEnchants);
		add(otherCEnchants);

		Border cuEnchantsBorder = BorderFactory.createTitledBorder("Custom Enchants");
		setBorder(cuEnchantsBorder);

	}

	public CustomEnchantPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public CustomEnchantPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public CustomEnchantPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
