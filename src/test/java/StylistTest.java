import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StylistTest {

    @Test
    public void newStylist_instantiatesCorrectly() {
       Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertTrue(newStyList instanceof Stylist);
    }

    @Test
    public void newStylist_getsFirstName_john()
    {
        Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertEquals("john", newStyList.getFirstName());
    }




}