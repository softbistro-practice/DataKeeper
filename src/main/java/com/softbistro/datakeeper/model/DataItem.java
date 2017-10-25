package com.softbistro.datakeeper.model;

/**
 * 
 *Represents a single entry in a file
 *
 */
public class DataItem {
	
	private Object value;
	private DataType type;
	
	public DataItem() {
	}

	public DataItem(Object value, DataType type) {
		this.value = value;
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("DataItem [ value = ")
				.append(this.value.toString())
				.append(", type = ")
				.append(this.type)
				.append("]")
				.toString();
	}
	
}
