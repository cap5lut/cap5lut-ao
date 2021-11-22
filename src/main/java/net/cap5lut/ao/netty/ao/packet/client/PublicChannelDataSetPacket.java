package net.cap5lut.ao.netty.ao.packet.client;

public record PublicChannelDataSetPacket(long channelId, int flags, String mute) implements AoClientPacket {
    public static final int TYPE = 64;

    @Override
    public int type() {
        return TYPE;
    }
}
