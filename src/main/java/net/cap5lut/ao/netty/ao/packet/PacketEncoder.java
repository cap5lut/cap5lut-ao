package net.cap5lut.ao.netty.ao.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import net.cap5lut.ao.netty.ao.AoBuf;

import java.nio.charset.StandardCharsets;

public abstract class PacketEncoder<T extends AoPacket> extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        @SuppressWarnings("unchecked") final var packet = (T) msg;
        final var payload = encode(ctx, packet, new AoBuf(ctx.alloc().buffer()));
        final var headerSize = Short.BYTES * 2;
        final var header = new AoBuf(ctx.alloc().buffer(headerSize, headerSize))
                .writeShort((short) packet.type())
                .writeShort((short) payload.readableBytes());
        ctx.write(header.buf());
        ctx.writeAndFlush(payload.buf());
    }

    protected abstract AoBuf encode(ChannelHandlerContext ctx, T packet, AoBuf out);
}
