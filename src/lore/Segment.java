package lore;

public class Segment {

	public String text;
	public String color;
	
	public boolean isKeybind;
	
	public Segment(String color, String text) {
		super();
		this.text = text;
		this.color = color;
		isKeybind = false;
	}
	
	public Segment(String color, String text, boolean keybind) {
		super();
		this.text = text;
		this.color = color;
		this.isKeybind = keybind;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
