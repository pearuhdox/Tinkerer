package item;

import java.util.ArrayList;
import java.util.Random;

public class Attribute {
	
	String name;
	double amount;
	int operation;
	String slot;
	ArrayList<Integer> UUID;
	
	public Attribute() {
		name = null;
		amount = 0;
		operation = 0;
		slot = null;
		UUID = new ArrayList<Integer>();
		setUUID();
	}
	
	public Attribute(String name, double amount, int operation, String slot) {
		this.name = name;
		this.amount = amount;
		this.operation = operation;
		this.slot = slot;
		UUID = new ArrayList<Integer>();
		setUUID();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public void setUUID() {
		Random rand = new Random();
		for(int i = 0; i < 4; i++) {
			int randomInt = rand.nextInt(2147483647);
			UUID.add(randomInt);
		}
	}
	
}
