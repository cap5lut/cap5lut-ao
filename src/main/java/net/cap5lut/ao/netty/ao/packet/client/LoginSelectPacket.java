package net.cap5lut.ao.netty.ao.packet.client;

public record LoginSelectPacket(long characterId) implements AoClientPacket {
    public static final int TYPE = 3;

    @Override
    public int type() {
        return TYPE;
    }
}
