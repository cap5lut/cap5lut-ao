package net.cap5lut.ao.netty.ao.packet.client;

public record PingPacket(String raw) implements AoClientPacket {
    public static final int TYPE = 100;

    @Override
    public int type() {
        return TYPE;
    }
}
