package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelLeftPacket(long channelId) implements AoServerPacket {
    public static final int TYPE = 53;

    @Override
    public int type() {
        return TYPE;
    }
}
