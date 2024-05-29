import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NounFinderGame {
    public static void main(String[] args)  throws Exception {
        List<String> inputFile = Files.readAllLines(Path.of("/home/msuser1/GitHub/SentanceFinderGame/src/inputFile.txt"));
//        List<String> outputFile = Files.readAllLines(Path.of(""));
       if (!inputFile.isEmpty()) {
           for (String input : inputFile) {
               if (input.isEmpty()) {
//                    System.out.println("Line is empty");
               } else if (input.matches("[0-9a-zA-Z\\s]+")) {
//                    System.out.println("Invalid Input");
               }
               if (input.matches("[a-zA-Z\\s]+.")) {
                   String[] splitTheEachSentence = input.split("\\.");
                   for (String sentence : splitTheEachSentence) {
                       String[] splitTheWords = sentence.split(" ");
                       for (String words : splitTheWords) {
                           List<String> remainingWords = new ArrayList<>();
                           String lowerCaseWords = words.toLowerCase();
                           if (lowerCaseWords.startsWith("her") || lowerCaseWords.startsWith("she")) {
//                               System.out.println("it is pronoun" +" "+ " "+ "--->"+" "+ " "+" "+lowerCaseWords);
                           } else {
                               remainingWords.add(lowerCaseWords);

                           }
                       }
                   }
               }
           }
       }else {
           System.out.println("the file is empty");
       }
    }
}