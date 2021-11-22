package net.cap5lut.ao.netty.ao.packet.server;

public record CharacterUpdatePacket(long characterId, String characterName) implements AoServerPacket {
    public static final int TYPE = 20;

    @Override
    public int type() {
        return TYPE;
    }
}
