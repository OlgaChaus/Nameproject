import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class UserInput {
    final static Logger logger = Logger.getLogger(UserInput.class.getName());

    private String city;
    private String timeZone = "";

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void proccessInput(){

        Greetings greeting = new Greetings();

        Instant timeStamp = Instant.now();
        ZonedDateTime usersDateTime = timeStamp.atZone(ZoneId.of("GMT"));

        if (!this.timeZone.equals("")){
            usersDateTime = timeStamp.atZone(ZoneId.of(this.getTimeZone()));
        }
        else{
            String predefinedZone = ZoneIdsHelper.getZoneId(this.getCity());

            if (predefinedZone != null) {
                usersDateTime = timeStamp.atZone(ZoneId.of(predefinedZone));
            }
        }

        System.out.print(greeting.viewString(greeting.getGreeetingDependOntime(usersDateTime))
                + ", " + this.getCity() + "!" + "\n");

        logger.info ("Displaying the date and time depending on the user's locale");
        System.out.println(usersDateTime);

        logger.info("Displaying the zone ID");
    }
}
