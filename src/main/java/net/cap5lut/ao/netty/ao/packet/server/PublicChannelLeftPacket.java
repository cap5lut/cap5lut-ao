package net.cap5lut.ao.netty.ao.packet.server;

public record PublicChannelLeftPacket(long channelId) implements AoServerPacket {
    public static final int TYPE = 61;

    @Override
    public int type() {
        return TYPE;
    }
}
