package HashTableAndString;

import HashTableAndString.RemoveSpaces;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveSpacesTest {

    @Test
    void checkOneCharacter() {
        assertEquals("a", RemoveSpaces.removeSpaces(" a"));
    }

    @Test
    void checkOneCharacterNull() {
        assertEquals("", RemoveSpaces.removeSpaces("  "));
    }

    @Test
    void checkLongSentence() {
        assertEquals("I love MTV", RemoveSpaces.removeSpaces("   I     love MTV"));
    }
}