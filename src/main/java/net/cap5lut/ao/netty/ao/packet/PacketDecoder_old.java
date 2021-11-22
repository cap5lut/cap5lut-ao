package net.cap5lut.ao.netty.ao.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public abstract class PacketDecoder_old<T extends AoPacket> extends ReplayingDecoder<T> {
    protected static final Charset ENCODING = StandardCharsets.ISO_8859_1;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        final var type = readShort(in);
        final var length = readShort(in);
        final var packet = readPacket(in, type, length);
        out.add(packet);

    }

    protected abstract T readPacket(ByteBuf in, int type, int length);

    protected byte[] readBytes(ByteBuf in, int length) {
        final var bytes = new byte[length];
        in.readBytes(bytes);
        return bytes;
    }

    protected int readInt(ByteBuf in, int length) {
        var value = 0;
        for (int i = 0; i < length; i++) {
            int tmp = in.readByte();
            if (tmp < 0) {
                tmp += 256;
            }
            value += (tmp << ((length - i - 1) * 8));
        }
        return value;
    }

    protected int readInt(ByteBuf in) {
        return readInt(in, Integer.BYTES);
    }

    protected int[] readIntArray(ByteBuf in, int length) {
        final var size = in.readUnsignedShort();
        final var data = new int[size];
        for (var i = 0; i < size; i++) {
            data[i] = readInt(in, length);
        }
        return data;
    }

    protected int[] readIntArray(ByteBuf in) {
        return readIntArray(in, Integer.BYTES);
    }

    protected long readLong(ByteBuf in) {
        throw new AssertionError();
    }

    protected long[] readLongArray(ByteBuf in) {
        final var size = in.readUnsignedShort();
        final var data = new long[size];
        for (var i = 0; i < size; i++) {
            data[i] = readLong(in);
        }
        return data;
    }

    protected short readShort(ByteBuf in) {
        return in.readShort();
    }

    protected String readString(ByteBuf in) {
        final var size = in.readUnsignedShort();
        final var data = new byte[size];
        in.readBytes(data);
        return new String(data, ENCODING);
    }

    protected String[] readStringArray(ByteBuf in) {
        final var size = in.readUnsignedShort();
        final var data = new String[size];
        for (var i = 0; i < size; i++) {
            data[i] = readString(in);
        }
        return data;
    }

    protected String readTextBlob(ByteBuf in) {
        in.skipBytes(14);
        final var size = readInt(in);
        final var data = new byte[size];
        in.readBytes(data);
        return new String(data, ENCODING);
    }
}
