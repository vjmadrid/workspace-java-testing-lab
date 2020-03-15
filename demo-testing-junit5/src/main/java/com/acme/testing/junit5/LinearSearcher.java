package com.acme.testing.junit5;

public class LinearSearcher {

	private int[] data;

	public LinearSearcher(int[] value) {
		this.data = value;
	}

	public int getPosition(int value) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == value)
				return i;
		}
		return -1;
	}

}
