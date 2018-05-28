import java.time.ZoneId;
import java.util.Arrays;
import java.util.Set;
import java.util.TimeZone;

public class ZoneIdsHelper {
    final static Set<String> list = ZoneId.getAvailableZoneIds();

    public static String getZoneId(String city) {
        for (String zone : list) {
            String [] defCity = zone.split("/");
            if (defCity.length >= 1){
                String cityName = defCity[defCity.length-1];
                if (cityName.contains("_")){
                    cityName = cityName.replace('_', ' ');
                }
                if (cityName.equalsIgnoreCase(city)) {
                    return zone;
                }
            }
        }

        return null;
    }

    public static boolean isValidTimeZone(String timezone) {
        return Arrays.asList(TimeZone.getAvailableIDs()).contains(timezone);
    }
}
