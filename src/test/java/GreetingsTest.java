import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class GreetingsTest {

    /**
     * Test of getGreeetingDependOntime method, of class Greetings.
     */
    @Test
    public void testGetGreeetingDependOntimeNight() {
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 5, 5, 3, 0), ZoneId.systemDefault());
        Greetings instance = new Greetings();
        String expResult = "night";
        String result = instance.getGreeetingDependOntime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGreeetingDependOntime method, of class Greetings.
     */
    @Test
    public void testGetGreeetingDependOntimeMorning() {
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 5, 5, 8, 0), ZoneId.systemDefault());
        Greetings instance = new Greetings();
        String expResult = "morning";
        String result = instance.getGreeetingDependOntime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGreeetingDependOntime method, of class Greetings.
     */
    @Test
    public void testGetGreeetingDependOntimeAfternoon() {
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 5, 5, 12, 0), ZoneId.systemDefault());
        Greetings instance = new Greetings();
        String expResult = "afternoon";
        String result = instance.getGreeetingDependOntime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGreeetingDependOntime method, of class Greetings.
     */
    @Test
    public void testGetGreeetingDependOntimeEvening() {
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2018, 5, 5, 20, 0), ZoneId.systemDefault());
        Greetings instance = new Greetings();
        String expResult = "evening";
        String result = instance.getGreeetingDependOntime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of viewString method, of class Greetings.
     */
    @Test
    public void testViewString() {
        String keyTimeOfDay = "morning";
        Greetings instance = new Greetings();
        String expResult = "Доброе утро";
        String result = instance.viewString(keyTimeOfDay);
        assertEquals(expResult, result);

    }

}

