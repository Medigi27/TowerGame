package models;

public class BackObject {
	private String name;

	public BackObject() {
		this.name = null;
	}

	public BackObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
