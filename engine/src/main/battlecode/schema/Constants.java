// automatically generated by the FlatBuffers compiler, do not modify

package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Constants extends Table {
  public static Constants getRootAsConstants(ByteBuffer _bb) { return getRootAsConstants(_bb, new Constants()); }
  public static Constants getRootAsConstants(ByteBuffer _bb, Constants obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public Constants __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int increasePeriod() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int leadAdditiveIncease() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createConstants(FlatBufferBuilder builder,
      int increasePeriod,
      int leadAdditiveIncease) {
    builder.startObject(2);
    Constants.addLeadAdditiveIncease(builder, leadAdditiveIncease);
    Constants.addIncreasePeriod(builder, increasePeriod);
    return Constants.endConstants(builder);
  }

  public static void startConstants(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addIncreasePeriod(FlatBufferBuilder builder, int increasePeriod) { builder.addInt(0, increasePeriod, 0); }
  public static void addLeadAdditiveIncease(FlatBufferBuilder builder, int leadAdditiveIncease) { builder.addInt(1, leadAdditiveIncease, 0); }
  public static int endConstants(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

