package net.cap5lut.ao.netty.ao.packet.server;

public record LoginSeedPacket(String seed) implements AoServerPacket {
    public static final int TYPE = 0;

    @Override
    public int type() {
        return TYPE;
    }
}
