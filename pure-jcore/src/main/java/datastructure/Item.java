package datastructure;

public class Item implements Comparable<Item> {
	
	private String name;
	private int value;
	
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.name+"|"+this.value;
	}
	
	@Override
	public int compareTo(Item target) {
		final int GREATER = 1;
		final int EQUAL = 0;
		final int SMALLER = -1;
		
		if (this == target) return EQUAL;
		if (this.value > target.value)
			return GREATER;
		else if (this.value < target.value)
			return SMALLER;
		else return EQUAL;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof Item))
			return false;

		Item target = (Item) o;
		return this.value == target.value;
	}
	
	/**
	 * use approach from effective java: item 9
	 * @return
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.value;
		return result;
	}
	
}
