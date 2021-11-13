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

    ///** Maximum ID a Robot will have */
    //public static final int MAX_ROBOT_ID = 32000;   Cannot be guaranteed in Battlecode 2021.

    // *********************************
    // ****** COOLDOWNS ****************
    // *********************************

    // NEED TO CHANGE: what is the actual cooldown value for the following values:

    public static final int BUILDING_UPGRADE_COOLDOWN = 500;
    public static final float FRESH_ROBOT_ARCHON_COOLDOWN = 10;
    // turret to portable, or portable to turret
    public static final int BUILDING_CONVERSION_COOLDOWN = 10000;


    // *********************************
    // ****** LEVEL MULTIPLIERS ********
    // *********************************


    public static final float PLACEHOLDER_LEVEL_MULTIPLIER = 1.2;

    public static final float DPS_1_TO_2 = PLACEHOLDER_LEVEL_MULTIPLIER;
    public static final float HP_1_TO_2 = PLACEHOLDER_LEVEL_MULTIPLIER;

    public static final float DPS_2_TO_3 = PLACEHOLDER_LEVEL_MULTIPLIER;
    public static final float HP_2_TO_3 = PLACEHOLDER_LEVEL_MULTIPLIER;

    public static final float DPS_UNIT_TO_TURRET = PLACEHOLDER_LEVEL_MULTIPLIER;
    public static final float HP_UNIT_TO_TURRET = PLACEHOLDER_LEVEL_MULTIPLIER;

    // NEED TO CHANGE:
    // turret vision = unit vision + ???
    // building portable mode move cooldown = ???

    
    public static final float BUILDING_UPGRADE_COST_MULTIPLER = 0.5;


    // *********************************
    // ****** GAME MECHANICS ***********
    // *********************************

    public static final float PROTOTYPE_HP_PERCENTAGE = 0.1;
    public static final float AUTOMATIC_ARCHON_HEAL_AMOUNT = 10;
    public static final float AUTOMATIC_BUILDER_HEAL_AMOUNT = 10;

    public static final float PER_ALCHEMIST_DECREASE_RATE = 0.1;

    public static final int LEAD_TO_GOLD_RATE = 20;
    public static final int INITIAL_LEAD = 200;
    

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
