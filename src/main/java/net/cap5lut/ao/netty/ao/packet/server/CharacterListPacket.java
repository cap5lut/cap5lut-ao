package net.cap5lut.ao.netty.ao.packet.server;

public record CharacterListPacket(long[] characterIds, String[] characterNames, int[] characterLevels,
                                  int[] onlineStates) implements AoServerPacket {
    public static final int TYPE = 7;

    @Override
    public int type() {
        return TYPE;
    }
}
