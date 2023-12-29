import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubStringTest {
    private final SubStringService service = new SubStringService();

    @Test
    public void noSuchSubstring() {
        Assertions.assertEquals(-1, service.findSubString("HelLoW WorLd!", "dorm"));
    }

    @Test
    public void equalStrings() {
        Assertions.assertEquals(0, service.findSubString("hello", "hello"));
    }

    @Test
    void upperCaseCheck() {
        Assertions.assertEquals(0, service.findSubString("hello", "HELLO"));
        Assertions.assertEquals(0, service.findSubString("HELLO", "hello"));
    }

    @Test
    public void biggerSubString() {
        Assertions.assertEquals(-1, service.findSubString("Best technology", "Best technology i have ever met"));
    }

    @Test
    public void trimSpacesStrings() {
        Assertions.assertNotEquals(3, service.findSubString("   Hello!", "Hello!"));
        Assertions.assertNotEquals(6, service.findSubString("      s      ", "s"));
    }

    @Test
    public void nullStrings() {
        Assertions.assertEquals(-1, service.findSubString(null, "hello"));
        Assertions.assertEquals(-1, service.findSubString("hello", null));
    }
    @Test
    public void emptyStrings(){
        Assertions.assertEquals(-1, service.findSubString("", "hello"));
        Assertions.assertEquals(-1, service.findSubString("hello", ""));
    }
    @Test
    public void manySubStrings(){
        Assertions.assertEquals(0, service.findSubString("hello hello hello hello", "hello"));
    }
}
