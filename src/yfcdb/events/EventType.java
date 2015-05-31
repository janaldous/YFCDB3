package yfcdb.events;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public enum EventType {
    CHAPTER_ASSEMBLY, PASTORAL_FORMATION, YOUTH_CAMP, HOUSEHOLD, CONFERENCE, KASSANGA, SERVICE_MEETING;

    @Override
    public String toString() {
        switch (this) {
            case CHAPTER_ASSEMBLY: return "CA";
            case PASTORAL_FORMATION: return "PF";
            case YOUTH_CAMP: return "YC";
            case HOUSEHOLD: return "HH";
            case CONFERENCE: return "Cf";
            case KASSANGA: return "Ka";
            case SERVICE_MEETING: return "SM";
            default: return null;
        }
    }

    public static String[] getEventTypes() {
        EventType[] eventTypes = values();
        String[] names = new String[eventTypes.length];

        for (int i = 0; i < eventTypes.length; i++) {
            names[i] = eventTypes[i].toString();
        }

        return names;
    }
}
