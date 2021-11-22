package net.cap5lut.ao.netty.ao.packet.server;

public record LoginSuccessPacket() implements AoServerPacket {
    public static final int TYPE = 5;

    @Override
    public int type() {
        return TYPE;
    }
}
