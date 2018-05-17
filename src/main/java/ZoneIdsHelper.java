import java.time.ZoneId;
import java.util.Set;

public class ZoneIdsHelper {
    final static Set<String> list = ZoneId.getAvailableZoneIds();

    public static String getZoneId(String city) {
        for (String zone : list) {
            String [] defCity = zone.split("/");
            if (defCity.length >= 1){
                if (defCity[defCity.length-1].equalsIgnoreCase(city)) {
                    return zone;
                }
            }
        }

        return null;
    }
}