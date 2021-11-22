package net.cap5lut.ao.netty.ao.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import net.cap5lut.ao.netty.ao.AoBuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class PacketDecoder<T extends AoPacket> extends ReplayingDecoder<T> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        final var in = new AoBuf(buf);
        final var type = buf.readUnsignedShort();
        final var length = buf.readUnsignedShort();
        final var packet = readPacket(in, type, length);
        out.add(packet);
    }

    protected abstract T readPacket(AoBuf in, int type, int length);
}
