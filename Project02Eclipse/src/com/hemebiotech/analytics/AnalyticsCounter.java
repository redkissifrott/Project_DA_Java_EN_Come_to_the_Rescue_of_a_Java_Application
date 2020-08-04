package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsList = reader.getSymptoms();

		// count occurrences
		CountSymptomsOccurences counter = new CountSymptomsOccurences(symptomsList);
		Map<String, Integer> symptomsOccurrences = counter.countOccurrences();

		// next generate output
		ISymptomsOccurrencesOutput writer = new WriteSymptomsOccurencesInFile("result.out");
		writer.outputSymptomsOccurrences(symptomsOccurrences);
	}
}
