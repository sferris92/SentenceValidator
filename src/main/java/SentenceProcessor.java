import utils.RulesHelper;

import java.util.Scanner;

public class SentenceProcessor {


        public static void main(String[] args) {

                boolean repeatflag = true;

                while(repeatflag){
                        System.out.println("Please enter a sentence to validate");
                        Scanner scanner = new Scanner(System.in);
                        String sentence = scanner.nextLine();

                        RulesHelper rulesUtil = new RulesHelper();
                        if(rulesUtil.isValid(sentence)){
                                System.out.println("Sentence is valid");
                                System.out.println("Do you want to enter another Sentence? Y/N?");
                                String response = scanner.next();
                                repeatflag = responseCheck(response);
                        }
                        else{
                                System.out.println("Sentence is NOT valid");
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

