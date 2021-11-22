package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelInvitedPacket(long channelId) implements AoServerPacket {
    public static final int TYPE = 50;

    @Override
    public int type() {
        return TYPE;
    }
}
