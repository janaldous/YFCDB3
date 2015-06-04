package yfcdb.events;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public enum EventType {
    CHAPTER_ASSEMBLY, COLLECTIVE_HOUSEHOLD, HLT, KASSANGA_ASSEMBLY, CHAPTER_SERVICE_MEETING, CLUSTER_SERVICE_MEETING,
        PASTORAL_HOUSEHOLD,
    YOUTH_CAMP, YOUTH_CAMP_TRAINING, WORSHIP_WORKSHOP, FAMILY_CULTURE, COVENANT_ORIENTATION, YOUTH_POWER,
        DISCOVERY_CAMP, PARENTS_HONORING, HUNDRED_PERCENT_FREE, STAKE_FOR_THE_NATION,
        VOCATION_RECOLLECTION, BEST_WEEKEND, CHURCH_AND_SACRAMENT, YOUTH_ADVOCATE,
    ILC, SECTOR_CONFERENCE, PROVINCIAL_CONFERENCE, REGIONAL_CONFERENCE,
    PARISH_LINKAGE, OTHERS;

    @Override
    public String toString() {
        switch (this) {
            case CHAPTER_ASSEMBLY: return "Chapter Assembly";
            case COLLECTIVE_HOUSEHOLD: return "Collective Household";
            case KASSANGA_ASSEMBLY: return "Kassanga Assembly";
            case CHAPTER_SERVICE_MEETING: return "Chapter Service Meeting";
            case CLUSTER_SERVICE_MEETING: return "Cluster Service Meeting";
            case PASTORAL_HOUSEHOLD: return "Pastoral Household";
            case YOUTH_CAMP: return "Youth Camp (PF)";
            case WORSHIP_WORKSHOP: return "Worship workshop";
            case YOUTH_CAMP_TRAINING: return "Youth Camp Training";
            case HLT: return "HLT";
            case FAMILY_CULTURE: return "Family Culture (PF)";
            case COVENANT_ORIENTATION: return "Covenant Orientation (PF)";
            case YOUTH_POWER: return "Youth Power (PF)";
            case DISCOVERY_CAMP: return "Discovery Camp (PF)";
            case PARENTS_HONORING: return "Parents Honoring (PF)";
            case HUNDRED_PERCENT_FREE: return "100% Free (PF)";
            case STAKE_FOR_THE_NATION: return "Stake for the nation (PF)";
            case VOCATION_RECOLLECTION: return "Vocation Recollection (PF)";
            case BEST_WEEKEND: return "Best Weekend (PF)";
            case CHURCH_AND_SACRAMENT: return "Church and Sacrament (PF)";
            case YOUTH_ADVOCATE: return "Youth Advocate (PF)";
            case ILC: return "ILC";
            case SECTOR_CONFERENCE: return "Sector Conference";
            case PROVINCIAL_CONFERENCE: return "Provincial Conference";
            case REGIONAL_CONFERENCE: return "Regional Conference";
            case PARISH_LINKAGE: return "Parish Linkage";
            case OTHERS: return "Others";
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
