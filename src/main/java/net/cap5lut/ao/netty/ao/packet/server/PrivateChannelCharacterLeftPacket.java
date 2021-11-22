package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateChannelCharacterLeftPacket(long channelId, long characterId) implements AoServerPacket {
    public static final int TYPE = 56;

    @Override
    public int type() {
        return TYPE;
    }
}
