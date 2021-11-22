package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelInviteRefusedPacket(long channelId, long characterId) implements AoServerPacket {
    public static final int TYPE = 58;

    @Override
    public int type() {
        return TYPE;
    }
}
