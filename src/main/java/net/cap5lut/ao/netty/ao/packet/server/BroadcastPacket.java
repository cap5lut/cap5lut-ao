package net.cap5lut.ao.netty.ao.packet.server;

public record BroadcastPacket(String text, String message, String raw) implements AoServerPacket {
    public static final int TYPE = 35;

    @Override
    public int type() {
        return TYPE;
    }
}
