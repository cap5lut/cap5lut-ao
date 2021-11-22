package net.cap5lut.ao.netty.ao.packet.client;

public record OnlineStatusSetPacket(int status) implements AoClientPacket {
    public static final int TYPE = 42;

    @Override
    public int type() {
        return TYPE;
    }
}
