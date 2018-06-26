package nanpasun.wod_timer;

import java.util.ArrayList;

public class GBlueMarble {
    enum LandType {
        land, Key;
    }

    class Land {
        LandType land;
        int toll;
        int hotel;
        int hotelCount;
    }

    ArrayList<Land> lands = new ArrayList<Land>();
}
