package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelAcceptPacket(long channelId) implements AoClientPacket {
    public static final int TYPE = 52;

    @Override
    public int type() {
        return TYPE;
    }
}
