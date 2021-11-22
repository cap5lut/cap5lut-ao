package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelInvitePacket(long characterId) implements AoClientPacket {
    public static final int TYPE = 50;

    @Override
    public int type() {
        return TYPE;
    }
}
