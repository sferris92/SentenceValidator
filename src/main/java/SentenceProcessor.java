import utils.RulesHelper;

import java.util.Scanner;

public class SentenceProcessor {


        public static void main(String[] args) {

                boolean repeatflag = true;
                Scanner scanner = new Scanner(System.in);
                RulesHelper rulesUtil = new RulesHelper();

                while(repeatflag){
                        System.out.println("Please enter a sentence to validate");
                        String sentence = scanner.nextLine();

                        if(rulesUtil.isValid(sentence)){
                                System.out.println("Validation Complete - Sentence is valid");
                                System.out.println("Do you want to enter another Sentence? Y/N?");
                                String response = scanner.next();
                                repeatflag = responseCheck(response);
                        }
                        else{
                                System.out.println("Validation Complete - Sentence is NOT valid.");
                                System.out.println("Do you want to enter another Sentence? Y/N?");
                                String response = scanner.next();
                                repeatflag = responseCheck(response);
                        }
                }
        }

        public static Boolean responseCheck(String response){
                return(response.charAt(0) == 'y');
        }
}

