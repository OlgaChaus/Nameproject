import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZoneIdsHelperTest {

    /**
     * Test of getZoneId method, of class ZoneIdsHelper.
     */
    @Test
    public void testGetZoneId() {
        System.out.println("getZoneId");
        String city = "Kiev";
        String expResult = "Europe/Kiev";
        String result = ZoneIdsHelper.getZoneId(city);
        assertEquals(expResult, result);
    }

}
