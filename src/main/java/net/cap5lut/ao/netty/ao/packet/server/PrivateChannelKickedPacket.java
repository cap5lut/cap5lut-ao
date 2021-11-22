package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelKickedPacket(long channelId) implements AoServerPacket {
    public static final int TYPE = 51;

    @Override
    public int type() {
        return TYPE;
    }
}
