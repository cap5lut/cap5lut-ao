package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelKickPacket(long characterId) implements AoClientPacket {
    public static final int TYPE = 51;

    @Override
    public int type() {
        return TYPE;
    }
}
