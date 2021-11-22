package net.cap5lut.ao.netty.ao.packet.server;

public record BuddyAddedPacket(long characterId, int online, String status) implements AoServerPacket {
    public static final int TYPE = 40;

    @Override
    public int type() {
        return TYPE;
    }
}
