import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubStringTest {
    private final SubStringService service = new SubStringService();

    @Test
    public void noSuchSubstring() {
        assertEquals(-1, service.findSubString("HelLoW WorLd!", "dorm"));
    }
    @Test
    public void equalStrings() {
        assertEquals(0, service.findSubString("hello", "hello"));
    }
    @Test
    void upperCaseCheck() {
        assertAll(
                "Grouped checking strings ignoring case",
                () -> assertEquals(0, service.findSubString("hello", "HELLO")),
                () -> assertEquals(0, service.findSubString("HELLO", "hello"))
        );
    }
    @Test
    public void biggerSubString() {
        assertEquals(-1, service.findSubString("Best technology", "Best technology i have ever met"));
    }
    @Test
    public void trimSpacesStrings() {
        assertAll(
                "Grouped checking strings with spaces",
                () -> assertNotEquals(3, service.findSubString("   Hello!", "Hello!")),
                () -> assertNotEquals(6, service.findSubString("      s      ", "s"))
        );
    }
    @Test
    public void nullStrings() {
        assertAll(
                "Grouped checking strings with null",
                () -> assertEquals(-1, service.findSubString(null, "hello")),
                () -> assertEquals(-1, service.findSubString("hello", null))
        );
    }
    @Test
    public void emptyStrings() {
        assertAll(
                "Grouped checking string with empty values",
                () -> assertEquals(-1, service.findSubString("", "hello")),
                () -> assertEquals(-1, service.findSubString("hello", ""))
        );
    }
    @Test
    public void manySubStrings() {
        assertEquals(0, service.findSubString("hello hello hello hello", "hello"));
    }
}
