package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

	public static void main(String args[]) {
		// symptoms counters
		int headacheCount = 0;
		int rashCount = 0;
		int pupilCount = 0;
		// first get input
		try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine(); // get another symptom
			}
		} catch (IOException e) {
			System.out.println("an exception occured while reading file");
			e.printStackTrace();
		}

		// next generate output
		try (FileWriter writer = new FileWriter("result.out")) {
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("an exception occured while writing file");
			e.printStackTrace();
		}
	}
}
