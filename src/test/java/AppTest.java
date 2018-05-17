import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void shouldReturnEuropeLondon()
    {
        assertEquals( "Check getZoneId method: ",  "Europe/London", ZoneIdsHelper.getZoneId("London"));
    }
}