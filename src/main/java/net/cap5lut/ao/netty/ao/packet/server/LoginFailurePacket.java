package net.cap5lut.ao.netty.ao.packet.server;

public record LoginFailurePacket(String message) implements AoServerPacket {
    public static final int TYPE = 6;

    @Override
    public int type() {
        return TYPE;
    }
}
