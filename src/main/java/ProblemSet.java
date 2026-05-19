/**

        * File: problemset unit 5

        * Author: Nithin.A

        * Date Created: May 16th, 2026

        * Date Last Modified: May 19th, 2026

        */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {
        System.out.println("Welcome to the Text Scrutinizor!");
		Scanner s = new Scanner(System.in);
		System.out.print("Please input a sentence or paragraph: ");
		String userInput = s.nextLine().toLowerCase();
		s.close();
		// Counting number spaces and vowels.
		int vowelCount = 0;
		int spacesCount = 0;
		for (int i = 0; i < userInput.length(); i++){
			if ("aeiouy".contains(userInput.substring(i, i + 1))){
				vowelCount++;
			} else if (userInput.substring(i, i + 1).indexOf(" ") > -1){
				spacesCount++;
			}
		}
		ArrayList<String> userInputArrL = userInputSplit(userInput);
		// printing output
		System.out.println("Total Characters: " + userInput.length() + 
						 "\nTotal Words: " + userInputArrL.size() + 
						 "\nTotal Vowels: " + vowelCount + 
						 "\nTotal Spaces: " + spacesCount);
		System.out.println("\nWord Frequency: \n");
		// Outputting wordFrequency HashMap with a for loop.
		// Hashmap format is [Word, number of times it appears]
		HashMap <String, Integer> wordFrequency = wordFrequency(userInputArrL);
		for (String key: wordFrequency.keySet()){
			System.out.println(key + " - " + wordFrequency.get(key));
		}
		System.out.println("\nLongest Word: " + longestWord(userInputArrL)
					   + "\nShortest Word: " + shortestWord(userInputArrL)
				       + "\nAverage Word Length: " + avgWordLength(userInputArrL)
					   + "\nNumber of Sentences: " + sentenceCounter(userInput) 
						+"\nUnique Words: " + uniqueWords(userInputArrL));
	}
	
    // function for splitting the user input into words
	public static ArrayList<String> userInputSplit(String rawUserInput){
		String[] rawUserInputArr = rawUserInput.split("[.!,? :;]");
		ArrayList<String> userInputArrL = new ArrayList<String>();
		// removing empty index in the list
		for (int i = 0; i < rawUserInputArr.length; i++){
			if (!rawUserInputArr[i].equals("")){
				userInputArrL.add(rawUserInputArr[i]);
			}
			
		}
		// checking if theres letters in the words in userInputArrL
		for (int i = 0; i < userInputArrL.size(); i++){
		    if (userInputArrL.get(i).replaceAll("[a-z]", "").length() == userInputArrL.get(i).length()){
		        userInputArrL.remove(i);
		        i--;
		    }
		}
		
		return userInputArrL;
		}
	
    // function for finding frequency of words
	public static HashMap <String, Integer> wordFrequency(ArrayList<String> userInputArrL){
		HashMap <String, Integer> balls = new HashMap<String, Integer>();
		for (int i = 0; i < userInputArrL.size(); i++){
		    // ignoring the words "is", "the", "a", "an", and "and"
			if (!userInputArrL.get(i).equals("is")
			 && !userInputArrL.get(i).equals("the")
			 && !userInputArrL.get(i).equals("a")
			 && !userInputArrL.get(i).equals("an")
			 && !userInputArrL.get(i).equals("and")){
				balls.put(userInputArrL.get(i), balls.getOrDefault(userInputArrL.get(i), 0)+1);
			 }
		}
		return balls;
	}
    // function for finding the longest word
	public static String longestWord(ArrayList<String> userInputArrL){
		ArrayList<String> longest = new ArrayList<String>();
		String output = "";
		// checking for edge case where input is empty
		if (userInputArrL.size() == 0){
			return output;
		}
		longest.add(userInputArrL.get(0));
		for (int i = 0; i < userInputArrL.size(); i++){
		    // comparing if word in list is longer than userInputArrL at index i while ignoring "is", "the", "a", "an", and "and"
			if (longest.get(0).length() < userInputArrL.get(i).length() 
			 && !userInputArrL.get(i).equals("is") 
			 && !userInputArrL.get(i).equals("the")
			 && !userInputArrL.get(i).equals("a")
			 && !userInputArrL.get(i).equals("an")
			 && !userInputArrL.get(i).equals("and")){
				longest.clear();
				longest.add(userInputArrL.get(i));
			}
			// checks if word at userInputArrL at index i is same length as word in the longest list
			else if (longest.get(0).length() == userInputArrL.get(i).length() && !longest.contains(userInputArrL.get(i))){
				longest.add(userInputArrL.get(i));
			}
		}
		// formatting output to have commas 
		for (int i = 0; i < longest.size(); i++){
			output +=  ", " + longest.get(i);
		}
		// returning output without the first ", "
		return output.substring(1);
	}
	
	public static String shortestWord(ArrayList<String> userInputArrL){
		ArrayList<String> shortest = new ArrayList<String>();
		String output = "";
		// checking for edge case where input is empty
		if (userInputArrL.size() == 0){
			return output;
		}
		// comparing if word in list is shorter than userInputArrL at index i while ignoring "is", "the", "a", "an", and "and"
		shortest.add(userInputArrL.get(0));
		for (int i = 0; i < userInputArrL.size(); i++){
			if (shortest.get(0).length() > userInputArrL.get(i).length()
			 && !userInputArrL.get(i).equals("is") 
			 && !userInputArrL.get(i).equals("the")
			 && !userInputArrL.get(i).equals("a")
			 && !userInputArrL.get(i).equals("an")
			 && !userInputArrL.get(i).equals("and")){
				shortest.clear();
				shortest.add(userInputArrL.get(i));
			}
			// checks if word at userInputArrL at index i is same length as word in the shortest list                                                       mmmmmmmmmmmmmmmmmmm 
			else if (shortest.get(0).length() == userInputArrL.get(i).length() && !shortest.contains(userInputArrL.get(i))){
				shortest.add(userInputArrL.get(i));
			}
		}
		// formatting list for output
		for (int i = 0; i < shortest.size(); i++){
			output += ", " + shortest.get(i);
		}
		// removing the first ", "
		return output.substring(1);
	}
    // Function to find avg word length
	public static double avgWordLength(ArrayList<String> userInputArrL){
		double avgWordLength = 0;
		// checking for edge case where input is 0
		if (userInputArrL.size() == 0){
			return 0;
		}
		for (int i = 0; i < userInputArrL.size(); i++){
			avgWordLength += userInputArrL.get(i).length();
		}
		return avgWordLength/userInputArrL.size();
	}
    // function to find number of sentences
	public static int sentenceCounter(String rawUserInput){
		String[] rawUserInputArr = rawUserInput.split("[.!?]");
		ArrayList<String> userInputArrL = new ArrayList<String>();
		for (int i = 0; i < rawUserInputArr.length; i++){
		    // removing empty strings
			if (!rawUserInputArr[i].equals("")){
				userInputArrL.add(rawUserInputArr[i]);
			}
		}
	    // Removing sentences with no letters in them
		for (int i = 0; i < userInputArrL.size(); i++){
		    if (userInputArrL.get(i).replaceAll("[a-z]", "").length() == userInputArrL.get(i).length()){
		        userInputArrL.remove(i);
		        i--;
		    }
		}
		return userInputArrL.size();
		}
    // Function to find number of unique words
	public static int uniqueWords(ArrayList<String> userInputArrL){
		ArrayList<String> uniqueWords = new ArrayList<String>();
		for (int i = 0; i < userInputArrL.size(); i++){
		    // checking if words in uniqueWords Array list are the same as the word in userInputArrL
			if (!uniqueWords.contains(userInputArrL.get(i))){
				uniqueWords.add(userInputArrL.get(i));
			}
		}
		return uniqueWords.size();
	}
}