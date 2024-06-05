package NounFinderGame;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NounFinderGame {
    public static void main(String[] args)  throws Exception {
        List<String> inputFile = Files.readAllLines(Path.of("/home/msuser1/GitHub/SentanceFinderGame/src/NounFinderGame/inputFile.txt"));
        List<String> exceptedOutputFile = Files.readAllLines(Path.of("/home/msuser1/GitHub/SentanceFinderGame/src/NounFinderGame/exceptedOutputFile.txt"));
        List<String> values = new ArrayList<>();
       if (!inputFile.isEmpty()) {
           for (String input : inputFile) {
               if (input.isEmpty()) {
                   values.add("Line is empty");
               } else if (input.matches("[0-9a-zA-Z\\s]+")) {
                   values.add("Invalid Input");
               }
               NounAndProNounFindMethod(input, values);
           }
       }else {
           values.add("The File is empty");
       }
        for (int i = 0; i < exceptedOutputFile.size(); i++) {
            if (values.get(i).equals(exceptedOutputFile.get(i))) {
                System.out.println("Pass->" + exceptedOutputFile.get(i));
                System.out.println("|*-------------------------*|");
            } else {
                System.out.println("Fail->" + exceptedOutputFile.get(i));
                System.out.println("|*-------------------------*|");
            }
            Files.write(Path.of("/home/msuser1/GitHub/SentanceFinderGame/src/NounFinderGame/outputFile.txt"), values);
        }
        System.out.println("-----|-----|-----|-----|-----|");
        System.out.println("File is Written");
    }

    private static void NounAndProNounFindMethod(String input, List<String> values) {
        if (input.matches("[a-zA-Z\\s]+.")) {
            String[] splitTheEachSentence = input.split("\\.");
            for (String sentence : splitTheEachSentence) {
                String[] splitTheWords = sentence.split(" ");
                List<String> remainingWords = new ArrayList<>();
                for (String words : splitTheWords) {
                    String lowerCaseWords = words.toLowerCase();
                    if (lowerCaseWords.startsWith("her") || lowerCaseWords.startsWith("she")) {
                        values.add("This Words are pronoun" +" "+ " "+ "--->"+" "+ " "+" "+lowerCaseWords);
                    } else {
                        remainingWords.add(lowerCaseWords);
                    }
                }
                if (remainingWords.get(0).equals("the")){
                    values.add("This Words are Noun"+" "+" "+"--->"+" "+remainingWords.get(1));
                }
            }
        }
    }
}