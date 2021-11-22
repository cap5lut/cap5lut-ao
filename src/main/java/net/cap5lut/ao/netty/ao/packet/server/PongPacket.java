package net.cap5lut.ao.netty.ao.packet.server;

public record PongPacket(String raw) implements AoServerPacket {
    public static final int TYPE = 100;

    @Override
    public int type() {
        return TYPE;
    }
}
