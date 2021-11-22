package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelMessagePacket(long characterId, String message, String raw) implements AoClientPacket {
    public static final int TYPE = 57;

    @Override
    public int type() {
        return TYPE;
    }
}
