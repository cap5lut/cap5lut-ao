package net.cap5lut.ao.netty.ao.packet.server;

public record CharacterUnknownPacket(int unknownInt) implements AoServerPacket {
    public static final int TYPE = 10;

    @Override
    public int type() {
        return TYPE;
    }
}
