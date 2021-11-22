package net.cap5lut.ao.netty.ao.packet.client;

public record BuddyRemovePacket(long characterId) implements AoClientPacket {
    public static final int TYPE = 41;

    @Override
    public int type() {
        return TYPE;
    }
}
