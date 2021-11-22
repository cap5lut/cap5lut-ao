package net.cap5lut.ao.netty.ao.packet.client;

public record PublicChannelMessagePacket(long channelId, String message, String raw) implements AoClientPacket {
    public static final int TYPE = 65;

    @Override
    public int type() {
        return TYPE;
    }
}
