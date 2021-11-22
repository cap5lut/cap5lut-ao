package net.cap5lut.ao.netty.ao.packet.server;

public record PublicChannelJoinedPacket(long channelId, String channelName, int unknownInt,
                                        String flags) implements AoServerPacket {
    public static final int TYPE = 60;

    @Override
    public int type() {
        return TYPE;
    }
}
