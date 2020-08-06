package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will output symptoms and occurrences data. The important part
 * is that the parameter is a TreeMap which contains in each entry a symptom and
 * his occurrence.
 */
public interface ISymptomsOccurrencesOutput {
	/**
	 * 
	 * @param symptomsOccurrences a TreeMap which contains in each entry a symptom
	 *                            and his occurrence
	 */
	void outputSymptomsOccurrences(Map<String, Integer> symptomsOccurrences);
}
