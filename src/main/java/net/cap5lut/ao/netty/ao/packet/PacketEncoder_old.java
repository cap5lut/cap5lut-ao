package net.cap5lut.ao.netty.ao.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.nio.charset.StandardCharsets;

public abstract class PacketEncoder_old<T extends AoPacket> extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        @SuppressWarnings("unchecked") final var packet = (T) msg;
        final var payload = encode(ctx, packet);
        final var out = ctx.alloc().buffer(Short.BYTES * 2);
        writeShort(out, packet.type());
        writeShort(out, payload.readableBytes());
        writeByteArray(out, payload);
        out.release();
    }

    protected abstract ByteBuf encode(ChannelHandlerContext ctx, T packet);

    protected void writeByteArray(ByteBuf out, ByteBuf value) {
        out.writeBytes(value);
    }

    protected void writeInt(ByteBuf out, int value) {
        out.writeInt(value);
    }

    protected void writeLong(ByteBuf out, long value) {
        out.writeLong(value);
    }

    protected void writeShort(ByteBuf out, int value) {
        out.writeShort(value);
    }

    protected void writeString(ByteBuf out, String value) {
        final var payload = value.getBytes(StandardCharsets.ISO_8859_1);
        out.writeShort(payload.length);
        out.writeBytes(payload);
    }

    protected void writeStringArray(ByteBuf out, String... value) {
        out.writeShort(value.length);
        for (var v: value) {
            writeString(out, v);
        }
    }
}
