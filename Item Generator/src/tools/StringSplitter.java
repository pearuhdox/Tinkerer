package tools;

import java.util.ArrayList;

public class StringSplitter {

	public static ArrayList<String> splitString(String input, int maxCharacters, boolean smartSplit) {
		
		if(smartSplit == true) {
			int totalChars = input.length();
			
			boolean findingBetterSize = true;
			
			int lineCountTest = 1;
			
			while(findingBetterSize) {
				if((totalChars / lineCountTest) < maxCharacters) {
					maxCharacters = (totalChars / lineCountTest) + 2;
					findingBetterSize = false;
					continue;
				} else {
					lineCountTest++;
				}
			}
		}
		
		ArrayList<String> result = new ArrayList<String>();

		String lineToAdd = "";

		while (!input.isEmpty()) {
			String arr[] = input.split(" ", 2);

			String prospectiveString = lineToAdd + arr[0];
			
			if (prospectiveString.length() <= (maxCharacters)) {
				lineToAdd = lineToAdd + arr[0] + " ";
				if(arr.length > 1) input = arr[1];
				else input = "";
			} else {
				//Oopsie the string too big
				//Remove the extra space.
				//Add the line to the lines to add
				lineToAdd = lineToAdd.substring(0, lineToAdd.length() - 1);
				result.add(lineToAdd);
				lineToAdd = arr[0] + " ";
				if(arr.length > 1) input = arr[1];
				else input = "";

			}
		}
		
		lineToAdd = lineToAdd.substring(0, lineToAdd.length() - 1);
		result.add(lineToAdd);
		
		return result;
	}

}