package battlecode.common;

/**
 * RobotInfo stores basic information that was 'sensed' of another Robot. This
 * info is ephemeral and there is no guarantee any of it will remain the same
 * between rounds.
 */
public class RobotInfo {

    /**
     * The unique ID of the robot.
     */
    public final int ID;

    /**
     * The Team that the robot is on.
     */
    public final Team team;

    /**
     * The type of the robot.
     */
    public final RobotType type;

    /**
     * The mode of the robot.
     */
    public final RobotMode mode;

    /**
     * The level of the robot.
     */
    public final int level;

    /**
     * The health of the robot.
     */
    public final int health;

    /**
     * The current location of the robot.
     */
    public final MapLocation location;

    public RobotInfo(int ID, Team team, RobotType type, RobotMode mode, int level, int health, MapLocation location) {
        super();
        this.ID = ID;
        this.team = team;
        this.type = type;
        this.mode = mode;
        this.level = level;
        this.health = health;
        this.location = location;
    }

    /**
     * Returns the ID of this robot.
     *
     * @return the ID of this robot
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Returns the team that this robot is on.
     *
     * @return the team that this robot is on
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Returns the type of this robot.
     *
     * @return the type of this robot
     */
    public RobotType getType() {
        return type;
    }

    /**
     * Returns the mode of this robot.
     *
     * @return the mode of this robot
     */
    public RobotMode getMode() {
        return mode;
    }

    /**
     * Returns the level of this robot.
     *
     * @return the level of this robot
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns the health of this robot.
     *
     * @return the health of this robot
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the location of this robot.
     *
     * @return the location of this robot
     */
    public MapLocation getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotInfo robotInfo = (RobotInfo) o;

        if (ID != robotInfo.ID) return false;
        if (team != robotInfo.team) return false;
        if (type != robotInfo.type) return false;
        if (mode != robotInfo.mode) return false;
        if (level != robotInfo.level) return false;
        if (health != robotInfo.health) return false;
        return location.equals(robotInfo.location);
    }

    @Override
    public int hashCode() {
        int result;
        result = ID;
        result = 31 * result + team.hashCode();
        result = 31 * result + type.ordinal();
        result = 31 * result + mode.ordinal();
        result = 31 * result + level;
        result = 31 * result + health;
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RobotInfo{" +
                "ID=" + ID +
                ", team=" + team +
                ", type=" + type +
                ", mode=" + mode +
                ", level=" + level +
                ", health=" + health +
                ", location=" + location +
                '}';
    }
}
