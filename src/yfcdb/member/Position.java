package yfcdb.member;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public enum Position {
    MEMBER, CHAPTER_HEAD, COORDINATOR, HOUSEHOLD_HEAD;

    public String toString() {
        switch (this) {
            case MEMBER: return "Member";
            case CHAPTER_HEAD: return "Chapter head";
            case COORDINATOR: return "Coordinator";
            case HOUSEHOLD_HEAD: return "Household head";
            default: return null;
        }
    }

    public static String[] getPositions() {
        Position[] positions = values();
        String[] names = new String[positions.length];

        for (int i = 0; i < positions.length; i++) {
            names[i] = positions[i].toString();
        }

        return names;
    }

    public static Position convertToPosition(String position) {
        if (position.equals("Member")) return MEMBER;
        else if (position.equals("Chapter head")) return CHAPTER_HEAD;
        else if (position.equals("Coordinator")) return COORDINATOR;
        else if (position.equals("Household head")) return HOUSEHOLD_HEAD;
        else return null;
    }
}
