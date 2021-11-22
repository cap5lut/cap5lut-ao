package net.cap5lut.ao.netty.ao.packet;

import net.cap5lut.ao.netty.ao.packet.client.AoClientPacket;
import net.cap5lut.ao.netty.ao.packet.server.AoServerPacket;

public record UnknownPacket(int type, byte[] data) implements AoClientPacket, AoServerPacket {
    public int length() {
        return data.length;
    }
}
