package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesHelperTest {

    RulesHelper rulesHelper;

    @BeforeEach
    void setup(){
        rulesHelper = new RulesHelper();
    }


    @Test
    void check_FirstCharCapital_ReturnsTrue() {
        String example = "Hello my name is Test.";
        assertTrue(rulesHelper.checkStartsCapital(example));

    }

    @Test
    void check_FirstCharIsLetter_ReturnsFalse() {
        String example = " 1 Hello my name is Test.";
        assertFalse(rulesHelper.checkStartsCapital(example));
    }

    @Test
    void check_quotationMarksEven_ReturnsTrue(){
        String example = "They turned around and said \"I have the high ground\"";
        assertTrue(rulesHelper.checkQuotationMarks(example));
    }

    @Test
    void check_quotationMarksEven_ReturnsFalse(){
        String example = "They \" turned around and said \"I have the high ground\"";
        assertFalse(rulesHelper.checkQuotationMarks(example));
    }

    @Test
    void check_endsWithValidChar_ReturnsTrue(){
        String example = "Hello my name is Computer.";
        assertTrue(rulesHelper.checkLastCharacterValid(example));
    }

    @Test
    void check_endsWithInvalidChar_ReturnsFalse(){
        String example = "Hello my name is Computer";
        assertFalse(rulesHelper.checkLastCharacterValid(example));
    }

    @Test
    void check_onePeriodCharacter_ReturnsTrue(){
        String example = "Hello my name is Computer.";
        assertTrue(rulesHelper.checkSinglePeriodCharacter(example));
    }

    @Test
    void check_onePeriodCharacter_ReturnsFalse(){
        String example = "Hello! my name is Computer.";
        assertFalse(rulesHelper.checkSinglePeriodCharacter(example));
    }

    @Test
    void check_numberStructure_ReturnsTrue(){
        String example = "Numbers 3, 6, 9 and 12 are multiples of 3";
        assertTrue(rulesHelper.checkNumberStructure(example));
    }

    @Test
    void check_numberStructure_ReturnsFalse(){
        String example = "Numbers 4, 8, 12 and 16 are multiples of 4";
        assertFalse(rulesHelper.checkNumberStructure(example));
    }

    @Test
    void check_isValid_returnsTrue(){
        String example = "The quick brown fox said “hello Mr lazy dog”.";
        assertFalse(rulesHelper.isValid(example));
    }
}