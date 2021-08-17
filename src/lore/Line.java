package lore;

import java.util.ArrayList;

import tools.Keyword;

public class Line {

	ArrayList<String> colorList;
	ArrayList<String> segmentList;
	ArrayList<Boolean> keybindList;
	
	boolean isFlavor;
	boolean isKeybind;

	public Line(String color, String segment) {
		colorList = new ArrayList<String>();
		segmentList = new ArrayList<String>();
		keybindList = new ArrayList<Boolean>();
		isFlavor = false;
		isKeybind = false;

		addColor(color);
		addSegment(segment);
	}

	public Line(String color, String segment, boolean flavor) {
		colorList = new ArrayList<String>();
		segmentList = new ArrayList<String>();
		keybindList = new ArrayList<Boolean>();
		this.isFlavor = flavor;
		
		addColor(color);
		addSegment(segment);
		
	}

	public Line() {
		colorList = new ArrayList<String>();
		segmentList = new ArrayList<String>();
		keybindList = new ArrayList<Boolean>();
		isFlavor = false;
	}

	public ArrayList<String> parse(String input) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '@') {
				int startIndex = i;
				int endIndex = input.indexOf('@', startIndex + 1);
				//System.out.println(startIndex + ", " + endIndex);

				String splice = input.substring(startIndex, endIndex + 1);
				splice = splice.replace("@", "");

				result.add(input.substring(0, startIndex));
				result.add(splice);
				input = input.substring(endIndex + 1);
				i=0;
			}
		}

		result.add(input);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		return result;
	}

	public void addColor(String color) {
		colorList.add(color);
	}

	public void addSegment(String input) {
		segmentList.add(input);
		
		// Add this so we never have an error with keybind listing.
		keybindList.add(false);
	}

	public void addKeybind(boolean check) {
		keybindList.add(check);
	}

	
	public void addSet(String color, String input) {

		colorList.add(color);
		segmentList.add(input);
		keybindList.add(false);
	}

	public void addSetKeywords(String color, String input) {

		ArrayList<String> splicedString = parse(input);
		ArrayList<Segment> splicedSegments = Keyword.addIcons(splicedString, color);

		for(int i = 0; i < splicedSegments.size(); i++) {
			colorList.add(splicedSegments.get(i).color);
			segmentList.add(splicedSegments.get(i).text);
			keybindList.add(splicedSegments.get(i).isKeybind);
		}
	}

	public void addSetNoParse(String color, String input) {
		colorList.add(color);
		segmentList.add(input);
		keybindList.add(false);

	}

	public String createNameString(boolean needsBold, boolean needsUnderline) {
		String result = "'";

		if (segmentList.size() > 1) {
			result = result + "[";
		}

		for (int i = 0; i < segmentList.size(); i++) {
			result = result + "{";

			// {"text":"When in Main Hand:","color":"#FFFFFF","italic":false}

			result = result + "\"text\":\"";
			result = result + segmentList.get(i);

			result = result + "\",\"color\":\"";

			result = result + colorList.get(i);

			result = result + "\",\"italic\":false";

			if (needsBold)
				result = result + ",\"bold\":true";
			if (needsUnderline)
				result = result + ",\"underlined\":true";

			result = result + "}";

			if (i < segmentList.size() - 1) {
				result = result + ",";
			}
		}

		if (segmentList.size() > 1) {
			result = result + "]";
		}

		result = result + "'";

		return result;
	}

	public String createLoreString() {
		String result = "'";

		if (segmentList.size() > 1) {
			result = result + "[";
		}

		for (int i = 0; i < segmentList.size(); i++) {
			result = result + "{";

			// {"text":"When in Main Hand:","color":"#FFFFFF","italic":false}

			if (keybindList.get(i) == true)
				result = result + "\"keybind\":\"";
			else
				result = result + "\"text\":\"";
			
			result = result + segmentList.get(i);

			result = result + "\",\"color\":\"";

			result = result + colorList.get(i);

			if (isFlavor)
				result = result + "\",\"italic\":true";
			if (!isFlavor)
				result = result + "\",\"italic\":false";

			result = result + "}";

			if (i < segmentList.size() - 1) {
				result = result + ",";
			}
		}

		if (segmentList.size() > 1) {
			result = result + "]";
		}

		result = result + "'";

		return result;
	}

	public void printLine() {
		System.out.println(createLoreString());
	}

}
