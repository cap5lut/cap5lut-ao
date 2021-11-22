package net.cap5lut.ao.netty.ao.packet.client;

public record ClientModeGetPacket(int unknownInt, long channelId) implements AoClientPacket {
    public static final int TYPE = 70;

    @Override
    public int type() {
        return TYPE;
    }
}
