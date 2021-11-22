package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelLeavePacket(long channelId) implements AoClientPacket {
    public static final int TYPE = 53;

    @Override
    public int type() {
        return TYPE;
    }
}
