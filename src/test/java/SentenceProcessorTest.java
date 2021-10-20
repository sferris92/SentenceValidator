import org.junit.jupiter.api.Test;
import utils.RulesHelper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SentenceProcessorTest {

    RulesHelper rulesHelper = new RulesHelper();
    SentenceProcessor sentenceProcessor = new SentenceProcessor();

    @Test
    void whenUserInputValid_thenReturnSuccessful() {

        String input = "This is a test sentence.";
        InputStream sentenceIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(sentenceIn);

        sentenceProcessor.sentenceValidator();
        assertTrue(rulesHelper.isValid(input));
    }

    @Test
    void whenUserInputInValid_thenReturnFailure() {

        String input = "This is a test sentence";
        InputStream sentenceIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(sentenceIn);

        sentenceProcessor.sentenceValidator();
        assertFalse(rulesHelper.isValid(input));
    }

    @Test
    void whenUserInputsSentence_thenReturnString(){
        String input = "This is a test sentence.";
        InputStream sentenceIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(sentenceIn);
        assertEquals(input,sentenceProcessor.getSentenceInput());
    }


}