package net.cap5lut.ao.netty.ao.packet.client;

public record ChatCommandPacket(String[] command) implements AoClientPacket {
    public static final int TYPE = 120;

    @Override
    public int type() {
        return TYPE;
    }
}
