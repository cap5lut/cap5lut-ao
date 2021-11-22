package net.cap5lut.ao.netty.ao.packet.server;

public record PublicChannelMessagePacket(long channelId, long characterId, String message,
                                         String raw) implements AoServerPacket {
    public static final int TYPE = 65;

    @Override
    public int type() {
        return TYPE;
    }
}
