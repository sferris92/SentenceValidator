package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RulesHelper {

    public Boolean isValid(String sentence){
        if(checkStartsCapital(sentence)
            && checkQuotationMarks(sentence)
                && checkLastCharacterValid(sentence)
                    && checkSinglePeriodCharacter(sentence)
                        && checkNumberStructure(sentence)){
            System.out.println("Sentence is valid");
            return true;
        }
        return false;
    }

    //Rule1 - String starts with Capital Letter
    public Boolean checkStartsCapital(String sentence){
        if(Character.isLetter(sentence.charAt(0))){
            return sentence.charAt(0) == sentence.toUpperCase().charAt(0);
        }
        return false;
    }

    //Rule 2 - Even Number of Quotation Marks
    public Boolean checkQuotationMarks(String sentence){
        int quoteCount = 0;
        Character quote = '"';

       for(char c :sentence.toCharArray()){
           if(c == quote)
               quoteCount++;
        }
        return quoteCount % 2 == 0;

    }

    //Rule 3 - Ends with Valid Character
    public Boolean checkLastCharacterValid(String sentence){
        int charCount = sentence.length();

        Set<Character> validPeriodCharacters = new HashSet<>();
        validPeriodCharacters.add('.');
        validPeriodCharacters.add('!');
        validPeriodCharacters.add('?');

        return (validPeriodCharacters.contains(sentence.charAt(charCount -1)));
    }

    //Rule 4 - Only one period Character in Sentence
    public Boolean checkSinglePeriodCharacter(String sentence){

        Set<Character> validPeriodCharacters = new HashSet<>();
        validPeriodCharacters.add('.');
        validPeriodCharacters.add('!');
        validPeriodCharacters.add('?');

        int periodCount = 0;
        for(char c : sentence.toCharArray()){
            if(validPeriodCharacters.contains(c))
                periodCount++;
        }
        return periodCount == 1 ;
    }

    //Rule 5 - Check Number structure
    public Boolean checkNumberStructure(String sentence){
        String regex = "[0-9]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        List<Integer> matchedIntNumbers = new ArrayList<>();

        while(matcher.find()){
            matchedIntNumbers.add(Integer.parseInt(matcher.group(0)));
        }
        return anyNumberGreaterThan13(matchedIntNumbers);
    }

    private boolean anyNumberGreaterThan13(List<Integer> matchedIntNumbers) {
        for (int number : matchedIntNumbers) {
            if(number < 13){
                return false;
            }
        }
        return true;
    }

}
