package net.cap5lut.ao.netty.ao.packet.server;

public record BuddyRemovedPacket(long characterId) implements AoServerPacket {
    public static final int TYPE = 41;

    @Override
    public int type() {
        return TYPE;
    }
}
