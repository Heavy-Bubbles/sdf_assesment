package tan.chelsea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class App 
{
    static Map<String,Double> wordCount = new HashMap<>();
    static Map<String,Double> uniqueWords = new HashMap<>();
    public static void main( String[] args ) throws IOException
    {
       
        String author = args[0];
        File testDirectory = new File("texts" + File.separator + author);
        readAllFiles(testDirectory);
        printProbability();
       
       
    }

    public static ArrayList<String> readTextFileToArray(File file) throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        StringBuilder text = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null){
            text.append(input);
            text.append(" ");
        }

        br.close();
        fr.close();

        String processedText = text.toString();
        processedText = processedText.replaceAll("\\p{Punct}", "").toLowerCase();
        String [] tempList = processedText.split("\\s+");
        ArrayList <String> words = new ArrayList<>();
        Collections.addAll(words, tempList);
        return words;
    }

    public static void count (ArrayList<String> words){

        for (String word : words){

            int wordIndex = words.indexOf(word);

            if (wordIndex == words.size() - 1){
                break;
            }

            String nextWord = word.concat(" ").concat(words.get(wordIndex + 1));

            Double wordExists = wordCount.get(nextWord);

            if (wordExists == null){
                wordCount.put(nextWord, 1d);
                
            } else {
                wordCount.put(nextWord, wordExists + 1);
            }
            
        }

    }

    public static void readAllFiles (File directory){

        File [] files = directory.listFiles();

        for (File f : files) {
            try{
                ArrayList<String> tempArray = readTextFileToArray(f);
                count(tempArray);
                countUniqueWords(tempArray);
            } catch (IOException e){
                e.printStackTrace();
            }
            
        }
    }

    public static void countUniqueWords(ArrayList<String> words){

        for (String word : words){
            Double wordExists = uniqueWords.get(word);
            if (wordExists == null){
                uniqueWords.put(word, 1d);
                
            } else {
                uniqueWords.put(word, wordExists + 1);
            }
        }

    }

    public static void printProbability(){

        uniqueWords.forEach((key1, value1) -> {
        
        System.out.println(key1);
            wordCount.forEach((key2, value2) ->{
                if (key2.startsWith(key1)){
                    double probability = value2 / value1;
                    System.out.println("     " + key2.substring(key1.length()) + " " + probability);
                }

            }

            );
            
        });

    }

}
