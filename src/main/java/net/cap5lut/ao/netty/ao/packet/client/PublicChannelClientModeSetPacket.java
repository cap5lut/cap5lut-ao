package net.cap5lut.ao.netty.ao.packet.client;

public record PublicChannelClientModeSetPacket(long channelId, int unknownInt1, int unknownInt2, int unknownInt3,
                                               int unknownInt4) implements AoClientPacket {
    public static final int TYPE = 66;

    @Override
    public int type() {
        return TYPE;
    }
}
