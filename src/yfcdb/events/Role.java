package yfcdb.events;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public enum Role {
    PRESENT, SPEAKER, SHARER, HOUSEHOLD_LEADER, SERVICE_TEAM, TEAM_LEADER, ASS_TEAM_LEADER,
    HEAD_SERVANT, ASS_HEAD_SERVANT, PRAYER_WARRIOR, FOOD_COMMITTEE, MUSIC_MINISTRY;

    @Override
    public String toString() {
        switch (this) {
            case PRESENT: return "P";
            case SPEAKER: return "Spk";
            case SHARER: return "Shr";
            case HOUSEHOLD_LEADER: return "HHL";
            case SERVICE_TEAM: return "ST";
            case TEAM_LEADER: return "TL";
            case ASS_TEAM_LEADER: return "ATL";
            case HEAD_SERVANT: return "HS";
            case ASS_HEAD_SERVANT: return "AHS";
            case PRAYER_WARRIOR: return "PW";
            case FOOD_COMMITTEE: return "FC";
            case MUSIC_MINISTRY: return "MM";
            default: return null;
        }
    }
}
