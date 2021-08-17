package lore;

import java.util.ArrayList;

public class Lore {

	ArrayList<Line> lineList;
	
	public Lore() {
		lineList = new ArrayList<Line>();
	}
	
	public void addLine(Line input) {
		lineList.add(input);
	}
	
	public String linesToLore() {
		String result = "Lore:[";
		
		for(int i = 0; i < lineList.size(); i++) {
			
			result = result + lineList.get(i).createLoreString();
			
			if(i < lineList.size()-1) {
				result = result + ",";
			}
		}
		
		result = result + "]";
		
		return result;
	}
	
	public void printLore() {
		System.out.println(linesToLore());
	}
	
}
