package item;

import java.util.ArrayList;

public class SetBonusData {

	String setNBT;
	ArrayList<String> descriptions = new ArrayList<String>();

	public SetBonusData() {
		descriptions = null;
		setNBT = null;
	}

	public String getSetNBT() {
		return setNBT;
	}

	public void setSetNBT(String setNBT) {
		this.setNBT = setNBT;
	}

	public void addDescription(String input) {
		descriptions.add(input);
	}
	
}
	
	