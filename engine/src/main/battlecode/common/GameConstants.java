package battlecode.common;

/**
 * Defines constants that affect gameplay.
 */
@SuppressWarnings("unused")
public class GameConstants {

    /**
     * The current spec version the server compiles with.
     */
     
    public static final String SPEC_VERSION = "1.0";

    // *********************************
    // ****** MAP CONSTANTS ************
    // *********************************

    /** The minimum possible map height. */
    public static final int MAP_MIN_HEIGHT = 32;

    /** The maximum possible map height. */
    public static final int MAP_MAX_HEIGHT = 64;

    /** The minimum possible map width. */
    public static final int MAP_MIN_WIDTH = 32;

    /** The maximum possible map width. */
    public static final int MAP_MAX_WIDTH = 64;

    // *********************************
    // ****** GAME PARAMETERS **********
    // *********************************

    /** The number of indicator strings that a player can associate with a robot. */
    public static final int NUMBER_OF_INDICATOR_STRINGS = 3;

    /** The bytecode penalty that is imposed each time an exception is thrown. */
    public static final int EXCEPTION_BYTECODE_PENALTY = 500;
    
    // *********************************
    // ****** COOLDOWNS ****************
    // *********************************


    // turret to portable, or portable to turret
    public static final int BUILDING_CONVERSION_COOLDOWN = 10;

    // *********************************
    // ****** GAME MECHANICS ***********
    // *********************************

    public static final float PROTOTYPE_HP_PERCENTAGE = 0.9;

    // Older constants below, maintaining them for now.

    /** The minimum allowable flag value. */
    public static final int MIN_FLAG_VALUE = 0;

    /** The maximum allowable flag value. */
    public static final int MAX_FLAG_VALUE = 16777215;

    // *********************************
    // ****** GAMEPLAY PROPERTIES ******
    // *********************************

    /** The default game seed. **/
    public static final int GAME_DEFAULT_SEED = 6370;

    /** The maximum number of rounds in a game.  **/
    public static final int GAME_MAX_NUMBER_OF_ROUNDS = 1500;
}
