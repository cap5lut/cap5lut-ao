package net.cap5lut.ao.netty.ao.packet.client;

public record BuddyAddPacket(long characterId, String status) implements AoClientPacket {
    public static final int TYPE = 40;

    @Override
    public int type() {
        return TYPE;
    }
}
