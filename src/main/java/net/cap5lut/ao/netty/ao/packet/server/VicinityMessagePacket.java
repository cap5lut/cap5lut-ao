package net.cap5lut.ao.netty.ao.packet.server;

public record VicinityMessagePacket(long characterId, String message, String blob) implements AoServerPacket {
    public static final int TYPE = 34;

    @Override
    public int type() {
        return 0;
    }
}
