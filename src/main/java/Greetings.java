import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Greetings {

    final private static String NIGHT = "night";
    final private static String MORNING = "morning";
    final private static String AFTERNOON = "afternoon";
    final private static String EVENING = "evening";

    public String getGreeetingDependOntime(ZonedDateTime time){

        int hours = time.getHour();

        if (hours < 6){
            return NIGHT;
        }
        else if (hours < 9) {
            return MORNING;
        }
        else if (hours < 19) {
            return AFTERNOON;
        }
        return EVENING;
    }

    public String viewString(String keyTimeOfDay) {
        return getGreetingFromResource(getLocaleResourceBundle(), keyTimeOfDay);
    }

    private String getGreetingFromResource(ResourceBundle bundle, String key){
        return bundle.getString(key);
    }

    private ResourceBundle getLocaleResourceBundle(){
        Locale defaultLocale = Locale.getDefault();
        return ResourceBundle.getBundle("msg", defaultLocale);
    }
}

