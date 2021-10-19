package utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RulesHelper {

    Logger logger = Logger.getLogger(RulesHelper.class.getName());

    public Boolean isValid(String sentence) {
        if (checkStartsCapital(sentence)
                && checkQuotationMarks(sentence)
                && checkLastCharacterValid(sentence)
                && checkSinglePeriodCharacter(sentence)
                && checkNumberStructure(sentence)) {
            return true;
        }
        return false;
    }

    private void setUpValidPeriodCharacters(Set<Character> validPeriodCharacters) {
        validPeriodCharacters.add('.');
        validPeriodCharacters.add('!');
        validPeriodCharacters.add('?');
    }


    //Rule1 - String starts with Capital Letter
    public Boolean checkStartsCapital(String sentence) {
        if (Character.isLetter(sentence.charAt(0))) {
            if (sentence.charAt(0) == sentence.toUpperCase().charAt(0)) {
                logger.info("Rule 1 - Capital Validation Successful.");
                return true;
            } else {
                logger.warning("Rule 1 - Capital Validation Failed.");
                return false;
            }
        }
        logger.warning("Rule 1 - Sentence did not start with a letter.");
        return false;
    }

    //Rule 2 - Even Number of Quotation Marks
    public Boolean checkQuotationMarks(String sentence) {
        int quoteCount = 0;
        Character quote = '"';

        for (char c : sentence.toCharArray()) {
            if (c == quote)
                quoteCount++;
        }
        if (quoteCount % 2 == 0) {
            logger.info("Rule 2 - Quotation Validation Successful.");
            return true;
        } else
            logger.warning("Rule 2 - Quotation Validation Failed.");
            return false;

    }

    //Rule 3 - Ends with Valid Character
    public Boolean checkLastCharacterValid(String sentence) {
        int charCount = sentence.length();

        Set<Character> validPeriodCharacters = new HashSet<>();
        setUpValidPeriodCharacters(validPeriodCharacters);

        if (validPeriodCharacters.contains(sentence.charAt(charCount - 1))) {
            logger.info("Rule 3 - Period Character Validation Successful.");
            return true;
        } else {
            logger.warning("Rule 3 - Period Character Validation Failed.");
            return false;
        }
    }

    //Rule 4 - Only one period Character in Sentence
    public Boolean checkSinglePeriodCharacter(String sentence) {
        Set<Character> validPeriodCharacters = new HashSet<>();
        setUpValidPeriodCharacters(validPeriodCharacters);

        int periodCount = 0;
        for (char c : sentence.toCharArray()) {
            if (validPeriodCharacters.contains(c))
                periodCount++;
        }
        if(periodCount == 1){
            logger.info("Rule 4 - Single Period Character Validation Successful.");
            return true;
        }
        else{
            logger.warning("Rule 4 - Single Period Character Validation Failed.");
            return false;
        }

    }

    //Rule 5 - Check Number structure
    public Boolean checkNumberStructure(String sentence) {
        logger.info("Rule 5 - Validating Number Structure");
        String regex = "[0-9]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        List<Integer> matchedIntNumbers = new ArrayList<>();

        while (matcher.find()) {
            matchedIntNumbers.add(Integer.parseInt(matcher.group(0)));
        }
        if(anyNumberGreaterThan13(matchedIntNumbers)){
            logger.info("Rule 5 - Single Period Character Validation Successful.");
            return true;
        }else {
            logger.info("Rule 5 - Single Period Character Validation Failed.");
            return false;
        }
    }

    private boolean anyNumberGreaterThan13(List<Integer> matchedIntNumbers) {
        for (int number : matchedIntNumbers) {
            if (number < 13) {
                return false;
            }
        }
        return true;
    }

}
