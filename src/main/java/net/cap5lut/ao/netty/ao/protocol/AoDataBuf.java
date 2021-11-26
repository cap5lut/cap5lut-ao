package net.cap5lut.ao.netty.ao.protocol;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public class AoDataBuf {
    private final ByteBuf buf;

    public AoDataBuf(ByteBuf buf) {
        this.buf = buf;
    }

    public ByteBuf buf() {
        return buf;
    }

    public int readableBytes() {
        return buf.readableBytes();
    }

    public boolean release(int decrement) {
        return buf.release(decrement);
    }

    public boolean release() {
        return buf.release();
    }

    public byte[] readByteArrayRaw(int length) {
        final var value = new byte[length];
        buf.readBytes(value);
        return value;
    }

    public AoDataBuf writeByteArrayRaw(byte... value) {
        buf.writeBytes(value);
        return this;
    }

    public int readInt() {
        return buf.readInt();
    }

    public AoDataBuf writeInt(int value) {
        buf.writeInt(value);
        return this;
    }

    public int[] readIntArray() {
        final var size = readShort();
        final var value = new int[size];
        for (var i = 0; i < size; i++) {
            value[i] = readInt();
        }
        return value;
    }

    public AoDataBuf writeIntArray(int... value) {
        writeShort((short) value.length);
        for (var v : value) {
            writeInt(v);
        }
        return this;
    }

    public long readLong() {
        throw new AssertionError();
    }

    public AoDataBuf writeLong(long value) {
        throw new AssertionError();
    }

    public long[] readLongArray() {
        final var size = readShort();
        final var value = new long[size];
        for (var i = 0; i < size; i++) {
            value[i] = readLong();
        }
        return value;
    }

    public AoDataBuf writeLongArray(long... value) {
        writeShort((short) value.length);
        for (var v : value) {
            writeLong(v);
        }
        return this;
    }

    public long readNumber(int bytes) {
        throw new AssertionError();
    }

    public AoDataBuf writeNumber(long value, int bytes) {
        throw new AssertionError();
    }

    public short readShort() {
        return buf.readShort();
    }

    public AoDataBuf writeShort(short value) {
        buf.writeShort(value);
        return this;
    }

    public String readString() {
        final var size = readShort();
        final var encoded = new byte[size];
        buf.readBytes(encoded);
        return new String(encoded, StandardCharsets.ISO_8859_1);
    }

    public AoDataBuf writeString(String value) {
        final var encoded = value.getBytes(StandardCharsets.ISO_8859_1);
        writeShort((short) encoded.length);
        buf.writeBytes(encoded);
        return this;
    }

    public String[] readStringArray() {
        final var size = readShort();
        final var value = new String[size];
        for (var i = 0; i < size; i++) {
            value[i] = readString();
        }
        return value;
    }

    public AoDataBuf writeStringArray(String... value) {
        writeShort((short) value.length);
        for (var v : value) {
            writeString(v);
        }
        return this;
    }

    public String readTextBlob() {
        throw new AssertionError();
    }

    public AoDataBuf writeTextBlob(String blob) {
        throw new AssertionError();
    }
}
