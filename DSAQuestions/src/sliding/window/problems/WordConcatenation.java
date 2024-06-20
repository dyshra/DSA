package sliding.window.problems;

import java.util.*;

public class WordConcatenation {

    public static List<Integer> getWordConcatPermutation(String str, String[] words) {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        Map<String, Integer> wordSeenMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int noOfWords = words.length;
        int lengthOfWord = words[0].length();
        for(String word : words){
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        for(int i  = 0; i <= str.length() - noOfWords * lengthOfWord; i++){
            wordSeenMap.clear();
            for(int j = 0; j < noOfWords; j++){
                int nextWordIndex = i + j*lengthOfWord;
                String subWord = str.substring(nextWordIndex, nextWordIndex + lengthOfWord);
                if(!wordFreqMap.containsKey(subWord)){
                    break;
                }

                wordSeenMap.put(subWord, wordSeenMap.getOrDefault(subWord, 0) + 1);

                if(wordSeenMap.get(subWord) > wordFreqMap.getOrDefault(subWord, 0)){
                    break;
                }

                if (j + 1 == noOfWords){
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> results = getWordConcatPermutation("wordgoodgoodgoodbestword" ,new String[]{"word","good","best","good"});
        System.out.println(results);
    }
}
