// automatically generated by the FlatBuffers compiler, do not modify

package battlecode.schema;

/**
 * Actions that can be performed.
 * Purely aesthetic; have no actual effect on simulation.
 * (Although the simulation may want to track the 'parents' of
 * particular robots.)
 * Actions may have 'targets', which are the units on which
 * the actions were performed.
 */
public final class Action {
  private Action() { }
  /**
   * Target: ID of robot attacked
   */
  public static final byte ATTACK = 0;
  /**
   * Target: ID of robot spawned
   */
  public static final byte SPAWN_UNIT = 1;
  /**
   * Target: location mined, x + y * width
   */
  public static final byte MINE_LEAD = 2;
  /**
   * Target: location mined, x + y * width
   */
  public static final byte MINE_GOLD = 3;
  /**
   * Target: none
   */
  public static final byte TRANSMUTE = 4;
  /**
   * Target: none
   */
  public static final byte TRANSFORM = 5;
  /**
   * Target: ID of robot mutated
   */
  public static final byte MUTATE = 6;
  /**
   * Target: ID of robot repaired
   */
  public static final byte REPAIR = 7;
  /**
   * Target: change in health (can be negative)
   */
  public static final byte CHANGE_HEALTH = 8;
  /**
   * When a PROTOTYPE building upgrades to TURRET
   * Target: none
   */
  public static final byte FULLY_REPAIRED = 9;
  /**
   * Target: Sage location, x + y * width
   */
  public static final byte LOCAL_ABYSS = 10;
  /**
   * Target: Sage location, x + y * width
   */
  public static final byte LOCAL_CHARGE = 11;
  /**
   * Target: Sage location, x + y * width
   */
  public static final byte LOCAL_FURY = 12;
  /**
   * Target: none
   */
  public static final byte ABYSS = 13;
  /**
   * Target: none
   */
  public static final byte CHARGE = 14;
  /**
   * Target: none
   */
  public static final byte FURY = 15;
  /**
   * Target: 0 if 90 degrees clockwise, 1 if horizontal, 2 if vertical
   */
  public static final byte VORTEX = 16;
  /**
   * Dies due to an uncaught exception.
   * Target: none
   */
  public static final byte DIE_EXCEPTION = 17;

  public static final String[] names = { "ATTACK", "SPAWN_UNIT", "MINE_LEAD", "MINE_GOLD", "TRANSMUTE", "TRANSFORM", "MUTATE", "REPAIR", "CHANGE_HEALTH", "FULLY_REPAIRED", "LOCAL_ABYSS", "LOCAL_CHARGE", "LOCAL_FURY", "ABYSS", "CHARGE", "FURY", "VORTEX", "DIE_EXCEPTION", };

  public static String name(int e) { return names[e]; }
}

