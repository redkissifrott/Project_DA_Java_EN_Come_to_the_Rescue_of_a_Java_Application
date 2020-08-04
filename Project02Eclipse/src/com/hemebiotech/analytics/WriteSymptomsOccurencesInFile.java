package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Writer for output each symptom and his occurrence in a file .out, one per
 * line
 */
public class WriteSymptomsOccurencesInFile implements ISymptomsOccurrencesOutput {

	public String filepath;

	/**
	 * @param filepath name of a file .out where the symptoms and their occurrences
	 *                 will be written
	 */
	public WriteSymptomsOccurencesInFile(String filepath) {
		this.setFilepath(filepath);
	}

	/**
	 * test if the name of the output file is indicated and if it's a .out file; if
	 * not, throw exception
	 * 
	 * @param filepath
	 */
	public void setFilepath(String filepath) {
		if (filepath == null) {
			throw new RuntimeException("Output file is required");
		} else if (!(filepath.endsWith(".out"))) {
			throw new RuntimeException("Output file must be .out");
		} else {
			this.filepath = filepath;
		}
	}

	@Override
	public void outputSymptomsOccurrences(Map<String, Integer> symptomsOccurrences) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (Entry<String, Integer> symptomOccurence : symptomsOccurrences.entrySet()) {
				writer.write(symptomOccurence.getKey() + " : " + symptomOccurence.getValue());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("an exception occured while writing file");
			e.printStackTrace();
		}
	}

}