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

    @Test
    public void newStylist_getsSecondName_doe()
    {
        Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertEquals("doe", newStyList.getSecondName());
    }

    @Test
    public void newStylist_getsEmail_johndoe()
    {
        Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertEquals("johndoe@gmail.com", newStyList.getEmail());
    }

    @Test
    public void newStylist_getsAge_30()
    {
        Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertEquals(30, newStyList.getAge());
    }

    @Test
    public void newStylist_getsId_1()
    {
        Stylist newStyList = new Stylist("john","doe" ,"johndoe@gmail.com",30,1);
        assertEquals(1, newStyList.getId());
    }
}