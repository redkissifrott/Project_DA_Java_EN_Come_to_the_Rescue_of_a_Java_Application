package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * From a List of symptoms,return a TreeMap which contains in each entry a
 * symptom and his occurrence, in alphabetical order
 */

public class CountSymptomsOccurences {

	private List<String> symptomsList;

	/**
	 * @param symptomsList a raw listing of all Symptoms, duplicates are
	 *                     possible/probable
	 */
	public CountSymptomsOccurences(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	/**
	 * @return a TreeMap which contains in each entry a symptom and his occurrence
	 */
	public TreeMap<String, Integer> countOccurrences() {
		TreeMap<String, Integer> result = new TreeMap<String, Integer>();
		for (String symptom : symptomsList) {
			if (!result.containsKey(symptom)) {
				result.put(symptom, 1);
			} else {
				result.put(symptom, result.get(symptom) + 1);
			}
		}
		return result;
	}

}
