import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import utils.RulesHelper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class SentenceProcessorTest {

    @Mock
            Scanner scanner;

    SentenceProcessor sentenceProcessor = mock(SentenceProcessor.class);
    RulesHelper rulesHelper = mock(RulesHelper.class);

//    @Test
//    void whenUserInputYes_repeatFlagTrue() {
//
//        scanner = new Scanner(System.in);
//        String input = "This is a test sentence.";
//        when(rulesHelper.isValid("testSentence")).thenReturn(true);
//        when(scanner.nextLine()).thenReturn(input);
//        sentenceProcessor.main(new String[]{});
//        verify(rulesHelper,times(1)).isValid("testSentence");
//
//    }


}