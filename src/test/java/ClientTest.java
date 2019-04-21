import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client newClient;

    @BeforeEach
    public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "kosgei", "12345678");
        newClient = new Client("jane","doe","0723320981","janedoe@gmail.com","Kenya","Nairobi",1);
    }
    @AfterEach
    public void tearDown() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM stylists *;";
            con.createQuery(sql).executeUpdate();
        }
    }
    @Test
    public void newClient_instantiatesCorrectly() {
        assertTrue(newClient instanceof Client);
    }

    @Test
    public void newClient_getsFirstName_jane()
    {
        assertEquals("jane", newClient.getFirst_name());
    }

    @Test
    public void newClient_getsLastName_doe()
    {
        assertEquals("doe", newClient.getLast_name());
    }
    @Test
    public void newClient_getsPhone_0723320981()
    {
        assertEquals("0723320981",newClient.getPhone());
    }

    @Test
    public void newClient_getsEmail_janedoe()
    {
        assertEquals("janedoe@gmail.com", newClient.getEmail());
    }

    @Test
    public void newClient_getsCountry_Kenya()
    {
        assertEquals("Kenya", newClient.getCountry());
    }

    @Test
    public void newClient_getsCounty_Nairobi()
    {
        assertEquals("Nairobi", newClient.getCounty());
    }

    @Test
    public void newClient_getsStylistId_1()
    {
        assertEquals(1, newClient.getStylistid());
    }

}