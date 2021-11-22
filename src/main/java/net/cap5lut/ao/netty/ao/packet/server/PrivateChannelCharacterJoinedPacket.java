package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelCharacterJoinedPacket(long channelId, long characterId) implements AoServerPacket {
    public static final int TYPE = 55;

    @Override
    public int type() {
        return TYPE;
    }
}
