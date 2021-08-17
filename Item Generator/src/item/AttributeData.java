package item;

import java.util.ArrayList;

import javax.management.Attribute;

public class AttributeData {

	ArrayList<Attribute> attributes = new ArrayList<Attribute>();

	public AttributeData() {
		attributes = null;
	}

	public void addAttribute(Attribute input) {
		attributes.add(input);
	}
	
}
	
	