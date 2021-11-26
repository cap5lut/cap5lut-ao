package net.cap5lut.ao.netty.ao.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import net.cap5lut.ao.netty.ao.packet.AoPacket;

public abstract class AoPacketEncoder<T extends AoPacket> extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        @SuppressWarnings("unchecked") final var packet = (T) msg;
        final var payload = encode(ctx, packet, new AoDataBuf(ctx.alloc().buffer()));
        final var headerSize = Short.BYTES * 2;
        final var header = new AoDataBuf(ctx.alloc().buffer(headerSize, headerSize))
                .writeShort((short) packet.type())
                .writeShort((short) payload.readableBytes());
        ctx.write(header.buf());
        ctx.writeAndFlush(payload.buf());
    }

    protected abstract AoDataBuf encode(ChannelHandlerContext ctx, T packet, AoDataBuf out);
}
