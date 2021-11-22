package net.cap5lut.ao.netty.ao.packet.server;

public record SystemMessagePacket(int clientId, int windowId, int messageId,
                                  String messageArguments) implements AoServerPacket {
    public static final int TYPE = 37;

    @Override
    public int type() {
        return TYPE;
    }
}
