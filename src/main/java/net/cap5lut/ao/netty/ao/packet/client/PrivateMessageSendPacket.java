package net.cap5lut.ao.netty.ao.packet.client;

public record PrivateMessageSendPacket(long characterId, String message, String raw) implements AoClientPacket {
    public static final int TYPE = 30;

    @Override
    public int type() {
        return TYPE;
    }
}
