package net.cap5lut.ao.netty.ao.packet.server;

public record CharacterReplyPacket(long characterId, String characterName) implements AoServerPacket {
    public static final int TYPE = 21;

    @Override
    public int type() {
        return TYPE;
    }
}
