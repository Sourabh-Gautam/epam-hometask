package com.spring.sorting;

public class SortMyArray {

	private Sorting sorting;

	public void setSorting(Sorting sorting) {
		this.sorting = sorting;
	}
	
	public void sortArray() {
		sorting.sort();
	}

}
