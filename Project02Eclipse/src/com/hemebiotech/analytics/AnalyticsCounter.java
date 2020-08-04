package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsList = reader.getSymptoms();
		System.out.println(symptomsList);

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
