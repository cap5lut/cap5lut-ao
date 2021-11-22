package net.cap5lut.ao.netty.ao.packet.client;

public record CharacterLookupPacket(String name) implements AoClientPacket {
    public static final int TYPE = 21;

    @Override
    public int type() {
        return TYPE;
    }
}
