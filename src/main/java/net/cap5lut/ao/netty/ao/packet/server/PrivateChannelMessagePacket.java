package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelMessagePacket(long channelId, long characterId, String message,
                                          String raw) implements AoServerPacket {
    public static final int TYPE = 57;

    @Override
    public int type() {
        return TYPE;
    }
}
