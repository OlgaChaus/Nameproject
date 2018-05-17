import java.util.logging.Logger;

public class FlowHandler {
    final static Logger logger = Logger.getLogger(FlowHandler.class.getName());

    public static void logic(){

        UserInput userInput = new UserInput();

        while (true){
            System.out.println("\nEnter quit to leave");
            logger.info("Variant of work of the program");
            userInput.getCityInput();
            userInput.getTimeZoneInput();
            userInput.proccessInput();

        }

    }
}

