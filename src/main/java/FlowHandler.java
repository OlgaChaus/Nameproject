import java.util.logging.Logger;

public class FlowHandler {
    final static Logger logger = Logger.getLogger(FlowHandler.class.getName());

    public static void logic(String [] args ){

        UserInput userInput = new UserInput();

        if (args.length == 0) throw new IllegalArgumentException("Arguments are not passed!");
        String timeZoneCandidate = args[args.length - 1];
        String cityName = "";

        if (ZoneIdsHelper.isValidTimeZone(timeZoneCandidate) && args.length != 1){
            userInput.setTimeZone(timeZoneCandidate);
            cityName = "";
            for(int i = 0; i < args.length - 1; i++){
                cityName += args[i] + " ";
            }
        } else {
            for(int i = 0; i < args.length; i++){
                cityName += args[i] + " ";
            }
        }

        userInput.setCity(cityName.trim());
        userInput.proccessInput();
    }
}

