package com.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamConcept {
	/*
	 * Stream: 
	 * 		stream 
	 * 		filter
	 * 		map 
	 * 		collect 
	 * 		count 
	 * 		sorted : default order -> ASC
	 * 		sorted(Comparator value) : used for DESC order sorting
	 */
	public static void main(String[] args ) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(10);
		marks.add(11);
		marks.add(12);
		marks.add(14);
		marks.add(15);
		marks.add(16);
		
		/*
		 * Stream->Filter : filter will filter-out element based on condition provided.
		 */
		List<Integer> evenMarks = new LinkedList<Integer>();
		evenMarks = marks.stream().filter(mark -> (mark%2 == 0)).collect(Collectors.toList());
		
		/*
		 * Stream->map : 
		 * map is basically used to perform operation on the individual element of the Collection.
		 */
		List<Integer> passingCriteria = new LinkedList<Integer>();
		passingCriteria = evenMarks.stream()
				.map(mark -> mark/2)
				.filter(mark -> mark>5)
				.collect(Collectors.toList());
		System.out.println("students with 'mark>5' :"+passingCriteria);
		
		System.out.println("Students with even-marks "+evenMarks.size()+"\n"+"Student who passed exam and had mark greater than 5 are "+ passingCriteria.size());
		
		List<Integer> passingCriteria2 = new LinkedList<Integer>();
		passingCriteria2 = marks.stream().filter(mark -> (mark%2 == 0)).map(mark -> mark/2).filter(mark -> mark>5).collect(Collectors.toList());
		
		System.out.println("Students with even-marks "+evenMarks.size()+"\n"+"Student who passed exam and had mark greater than 5 are "+ passingCriteria2.size());
		
		
		ArrayList<String> firstName = new ArrayList<String>();
		firstName.add("tejas");
		List<String> fullName = new ArrayList<String>();
		fullName = firstName.stream().map(name -> name.concat(" porwal")).collect(Collectors.toList());
		System.out.println(fullName);

		ArrayList<String> firstName2 = new ArrayList<String>();
		firstName2.add("tejas");
		List<String> fullName2 = new ArrayList<String>();
		fullName2 = firstName2.stream().filter(name2 -> name2.equals("tejas")).map(name2 -> name2.concat(" porwal")).collect(Collectors.toList());
		System.out.println(fullName2);
		
		System.out.println("Understanding sorting!");
		List<Integer> sortedASC = marks.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedASC);
		
		List<Integer> sortedDESC = marks.stream().sorted((c1,c2) -> c2.compareTo(c1)).collect(Collectors.toList());
		System.out.println(sortedDESC);
		
		}

}
