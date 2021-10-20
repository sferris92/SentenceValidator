import utils.RulesHelper;

import java.util.Scanner;
import java.util.logging.Logger;

public class SentenceProcessor {

    public void sentenceValidator(){

        //Initial Message and Success/Failure Log message
        RulesHelper rulesUtil = new RulesHelper();
        Logger logger = Logger.getLogger(RulesHelper.class.getName());

            System.out.println("Welcome - Please enter a sentence to validate below");
            String sentence = getSentenceInput();

            if(rulesUtil.isValid(sentence)){
                logger.info("Validation Complete - Sentence is valid");
            }
            else{
                logger.warning("Validation Complete - Sentence is NOT valid.");
            }
        }

    // Capture User Input
    public String getSentenceInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
