// automatically generated by the FlatBuffers compiler, do not modify

// package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * Data relevant to a particular team.
 */
public final class TeamData extends Table {
  public static TeamData getRootAsTeamData(ByteBuffer _bb) { return getRootAsTeamData(_bb, new TeamData()); }
  public static TeamData getRootAsTeamData(ByteBuffer _bb, TeamData obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public TeamData __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * The name of the team.
   */
  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  /**
   * The java package the team uses.
   */
  public String packageName() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer packageNameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer packageNameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  /**
   * The ID of the team this data pertains to.
   */
  public byte teamID() { int o = __offset(8); return o != 0 ? bb.get(o + bb_pos) : 0; }

  public static int createTeamData(FlatBufferBuilder builder,
      int nameOffset,
      int packageNameOffset,
      byte teamID) {
    builder.startObject(3);
    TeamData.addPackageName(builder, packageNameOffset);
    TeamData.addName(builder, nameOffset);
    TeamData.addTeamID(builder, teamID);
    return TeamData.endTeamData(builder);
  }

  public static void startTeamData(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addPackageName(FlatBufferBuilder builder, int packageNameOffset) { builder.addOffset(1, packageNameOffset, 0); }
  public static void addTeamID(FlatBufferBuilder builder, byte teamID) { builder.addByte(2, teamID, 0); }
  public static int endTeamData(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

