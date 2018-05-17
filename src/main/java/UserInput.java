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

    public String getTimeZone() {
        return timeZone;
    }

    public void getCityInput(){
        System.out.println("Enter the city name in English: ");
        this.city = getUserInput();
        logger.info ("Receiving data from a user");
    }

    public void getTimeZoneInput(){
        System.out.println("Enter the time zone ID (use +02:00 format): ");
        String userInput = getUserInput();
        if (userInput != "" && isValidTimeZoneInput(userInput)){
            this.timeZone = userInput;
            logger.info ("Receiving data from a user");
        }
    }

    private boolean isValidTimeZoneInput(String timeZoneInput){
        boolean isValid = false;
        final Pattern pattern = Pattern.compile("^(?:Z|[+-](?:2[0-3]|[01][0-9]):[0-5][0-9])$");
        if (!pattern.matcher(timeZoneInput).matches()) {
            logger.info ("strange message...");
            System.out.println("Wrong Time Zone Input!");
        }
        else {
            isValid = true;
        }

        return isValid;
    }

    private String getUserInput(){
        Scanner in = new Scanner (System.in);
        String input = in.nextLine();
        if (input.trim().equalsIgnoreCase("quit")){
            System.out.println("Bye!");
            System.exit(0);
        }
        return input.trim();
    }


    public void proccessInput(){

        Greetings greeting = new Greetings();

        Instant timeStamp = Instant.now();
        ZonedDateTime usersDateTime = timeStamp.atZone(ZoneId.of("GMT"));

        if (!this.timeZone.equals("")){
            System.out.println();
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

        logger.info ("Displaying the date and time of the user");
        System.out.println(usersDateTime);
    }
}
