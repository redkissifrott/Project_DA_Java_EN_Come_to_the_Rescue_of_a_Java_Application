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
		System.out.println(symptomsOccurrences);

		// next generate output
//		try (FileWriter writer = new FileWriter("result.out")) {
//			writer.write("headache: " + headacheCount + "\n");
//			writer.write("rash: " + rashCount + "\n");
//			writer.write("dialated pupils: " + pupilCount + "\n");
//			writer.close();
//		} catch (IOException e) {
//			System.out.println("an exception occured while writing file");
//			e.printStackTrace();
//		}
	}
}
