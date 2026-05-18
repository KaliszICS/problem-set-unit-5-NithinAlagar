import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class ProblemSet {

	public static void main(String args[]) {
		System.out.println("Welcome to the Text Scrutinizor!");
		Scanner s = new Scanner(System.in);
		System.out.print("Please input a sentence or paragraph: ");
		String userInput = s.nextLine().toLowerCase();
		s.close();
		int vowelCount = 0;
		int spacesCount = 0;
		for (int i = 0; i < userInput.length(); i++){
			if ("aeiouy".contains(userInput.substring(i, i + 1))){
				vowelCount++;
			}

			else if (userInput.substring(i, i + 1).indexOf(" ") > -1){
				spacesCount++;
			}
		}
		ArrayList<String> userInputArrL = userInputSplit(userInput);
		HashMap <String, Integer> balls = wordFrequency(userInputArrL);
		System.out.println("Total Characters: " + userInput.length() + 
						 "\nTotal Words: " + userInputArrL.size() + 
						 "\nTotal Vowels: " + vowelCount + 
						 "\nTotal Spaces: " + spacesCount);
		System.out.println("\nWord Frequency: \n");
		for (String ball: balls.keySet()){
			System.out.println(ball + " - " + balls.get(ball));
		}
		
		System.out.println("\nLongest Word: " + longestWord(userInputArrL)
					   + "\nShortest Word: " + shortestWord(userInputArrL)
				       + "\nAverage Word Length: " + avgWordLength(userInputArrL)
					   + "\nNumber of Sentences: " + sentenceCounter(userInput).size()
						+"\nUnique Words: " + balls.size());
		

	}

	public static ArrayList<String> userInputSplit(String rawUserInput){
		String[] rawUserInputArr = rawUserInput.split("[.!,? :;]");
		ArrayList<String> userInputArrL = new ArrayList<String>();
		for (int i = 0; i < rawUserInputArr.length; i++){
			if (!rawUserInputArr[i].equals("")){
				userInputArrL.add(rawUserInputArr[i]);
			}
		}
		return userInputArrL;
		}
	

	public static HashMap <String, Integer> wordFrequency(ArrayList<String> userInputArrL){
		HashMap <String, Integer> balls = new HashMap<String, Integer>();
		for (int i = 0; i < userInputArrL.size(); i++){
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

	public static ArrayList<String> longestWord(ArrayList<String> userInputArrL){
		ArrayList<String> longest = new ArrayList<String>();
		if (userInputArrL.size() == 0){
			return longest;
		}
		longest.add(userInputArrL.get(0));
		for (int i = 0; i < userInputArrL.size(); i++){
			if (longest.get(0).length() < userInputArrL.get(i).length() 
			 && !userInputArrL.get(i).equals("is") 
			 && !userInputArrL.get(i).equals("the")
			 && !userInputArrL.get(i).equals("a")
			 && !userInputArrL.get(i).equals("an")
			 && !userInputArrL.get(i).equals("and")){
				longest.clear();
				longest.add(userInputArrL.get(i));
			}
			else if (longest.get(0).length() == userInputArrL.get(i).length() && !longest.contains(userInputArrL.get(i))){
				longest.add(userInputArrL.get(i));
			}
		}
		return longest;
	}
	
	public static ArrayList<String> shortestWord(ArrayList<String> userInputArrL){
		ArrayList<String> shortest = new ArrayList<String>();
		if (userInputArrL.size() == 0){
			return shortest;
		}
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
			else if (shortest.get(0).length() == userInputArrL.get(i).length() && !shortest.contains(userInputArrL.get(i))){
				shortest.add(userInputArrL.get(i));
			}

		}
		return shortest;
	}

	public static double avgWordLength(ArrayList<String> userInputArrL){
		double avgWordLength = 0;
		if (userInputArrL.size() == 0){
			return 0;
		}
		for (int i = 0; i < userInputArrL.size(); i++){
			avgWordLength += userInputArrL.get(i).length();
		}
		return avgWordLength/userInputArrL.size();
	}

	public static ArrayList<String> sentenceCounter(String rawUserInput){
		String[] rawUserInputArr = rawUserInput.split("[.!?]");
		ArrayList<String> userInputArrL = new ArrayList<String>();
		for (int i = 0; i < rawUserInputArr.length; i++){
			if (!rawUserInputArr[i].equals("")){
				userInputArrL.add(rawUserInputArr[i]);
			}
		}
		return userInputArrL;
		}



	}


