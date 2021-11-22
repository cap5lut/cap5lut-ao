package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateChannelKickAllPacket() implements AoClientPacket {
    public static final int TYPE = 54;

    @Override
    public int type() {
        return TYPE;
    }
}
