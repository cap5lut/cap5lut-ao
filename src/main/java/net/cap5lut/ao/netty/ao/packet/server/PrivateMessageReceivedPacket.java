package net.cap5lut.ao.netty.ao.packet.server;

public record PrivateMessageReceivedPacket(long characterId, String message, String raw) implements AoServerPacket {
    public static final int TYPE = 30;

    @Override
    public int type() {
        return TYPE;
    }
}
