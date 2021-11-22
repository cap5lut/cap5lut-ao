package net.cap5lut.ao.netty.ao.packet.server;

public record SimpleSystemMessagePacket(String message) implements AoServerPacket {
    public static final int TYPE = 36;

    @Override
    public int type() {
        return TYPE;
    }
}
