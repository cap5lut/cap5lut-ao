package net.cap5lut.ao.netty.ao.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import net.cap5lut.ao.netty.ao.packet.AoPacket;

import java.util.List;

public abstract class AoPacketDecoder<T extends AoPacket> extends ReplayingDecoder<T> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        final var in = new AoDataBuf(buf);
        final var type = buf.readUnsignedShort();
        final var length = buf.readUnsignedShort();
        final var packet = readPacket(in, type, length);
        out.add(packet);
    }

    protected abstract T readPacket(AoDataBuf in, int type, int length);
}
