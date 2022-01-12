import {schema} from 'battlecode-schema';

export const UNKNOWN_SPEC_VERSION = "UNKNOWN SPEC";
export const UNKNOWN_TEAM = "UNKNOWN TEAM";
export const UNKNOWN_PACKAGE = "UNKNOWN PACKAGE";

/**
 * Metadata about a game.
 */
export default class Metadata {

  /**
   * The version of the spec this game complies with.
   */
  specVersion: string;

  /**
   * All the body types in a game.
   * Access like: meta.types[schema.BodyType.MINOR].strideRadius
   */
  types: {[key: number]: BodyTypeMetaData};

  buildingTypes: schema.BodyType[] = [schema.BodyType.ARCHON, schema.BodyType.LABORATORY, schema.BodyType.WATCHTOWER];

  /**
   * All the teams in a game.
   */
  teams: {[key: number]: Team};

  constants: schema.Constants;

  constructor() {
    this.specVersion = UNKNOWN_SPEC_VERSION;
    this.types = Object.create(null);
    this.teams = Object.create(null);
  }

  parse(header: schema.GameHeader): Metadata {
    this.specVersion = header.specVersion() as string || UNKNOWN_SPEC_VERSION;
    const teamCount = header.teamsLength();
    for (let i = 0; i < teamCount; i++) {
      const team = header.teams(i);
      this.teams[team.teamID()] = new Team(
        team.teamID(),
        team.packageName() as string || UNKNOWN_PACKAGE,
        team.name() as string || UNKNOWN_TEAM
      );
    }
    const bodyCount = header.bodyTypeMetadataLength();
    for (let i = 0; i < bodyCount; i++) {
      const body = header.bodyTypeMetadata(i);
      this.types[body.type()] = new BodyTypeMetaData(
        body.type(),
        body.buildCostLead(),
        body.buildCostGold(),
        body.level2CostLead(),
        body.level2CostGold(),
        body.level3CostLead(),
        body.level3CostGold(),
        body.actionCooldown(),
        body.movementCooldown(),
        body.health(),
        body.level2Health(),
        body.level3Health(),
        body.damage(),
        body.level2Damage(),
        body.level3Damage(),
        body.actionRadiusSquared(),
        body.visionRadiusSquared(),
        body.bytecodeLimit()
      );
    }
    this.constants = header.constants();
    // SAFE
    Object.freeze(this.types);
    Object.freeze(this.teams);
    Object.freeze(this);
    return this
  }
}

export class Team {
  // schema.TeamData

  /// The name of the team.
  name: string;
  /// The java package the team uses.
  packageName: string;
  /// The ID of the team this data pertains to.
  teamID: number;

  constructor(teamID: number, packageName: string, name: string) {
    this.teamID = teamID;
    this.packageName = packageName;
    this.name = name;
    Object.freeze(this);
  }
}

/**
 * Information about a specific body type.
 */
export class BodyTypeMetaData {
  constructor(public type: schema.BodyType,
    public buildCostLead:number, public buildCostGold: number,
    public level2CostLead: number, public level2CostGold: number,
    public level3CostLead: number, public level3CostGold: number,
    public actionCooldown:number, public movementCooldown:number, 
    public health: number, public level2Health: number, public level3Health: number,
    public damage: number, public level2Damage: number, public level3Damage: number,
    public actionRadiusSquared:number, public visionRadiusSquared:number, 
    public bytecodeLimit:number) {
  }
}
