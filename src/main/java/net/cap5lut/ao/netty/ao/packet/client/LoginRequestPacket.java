package net.cap5lut.ao.netty.ao.packet.client;

public record LoginRequestPacket(int unknownInt, String account, String hash) implements AoClientPacket {
    public static final int TYPE = 2;

    @Override
    public int type() {
        return TYPE;
    }
}
