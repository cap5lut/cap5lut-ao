package net.cap5lut.ao.netty.ao.packet.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.cap5lut.ao.netty.ao.AoBuf;
import net.cap5lut.ao.netty.ao.packet.PacketEncoder;
import net.cap5lut.ao.netty.ao.packet.PacketEncoder_old;

public class _ClientPacketEncoder extends PacketEncoder<AoClientPacket> {
    @Override
    protected AoBuf encode(ChannelHandlerContext ctx, AoClientPacket packet, AoBuf out) {
        if (packet instanceof BuddyAddPacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.status());
        } else if (packet instanceof BuddyRemovePacket p) {
            out
                    .writeLong(p.characterId());
        } else if (packet instanceof CharacterLookupPacket p) {
            out
                    .writeString(p.name());
        } else if (packet instanceof ChatCommandPacket p) {
            out
                    .writeStringArray(p.command());
        } else if (packet instanceof ClientModeGetPacket p) {
            out
                    .writeInt(p.unknownInt())
                    .writeLong(p.channelId());
        } else if (packet instanceof ClientModeSetPacket p) {
            out
                    .writeInt(p.unknownInt1())
                    .writeInt(p.unknownInt2())
                    .writeInt(p.unknownInt3())
                    .writeInt(p.unknownInt4());
        } else if (packet instanceof LoginRequestPacket p) {
            out
                    .writeInt(p.unknownInt())
                    .writeString(p.username())
                    .writeString(p.key());
        } else if (packet instanceof LoginSelectPacket p) {
            out
                    .writeLong(p.characterId());
        } else if (packet instanceof OnlineStatusSetPacket p) {
            out
                    .writeInt(p.status());
        } else if (packet instanceof PingPacket p) {
            out
                    .writeString(p.raw());
        } else if (packet instanceof PrivateChannelAcceptPacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PrivateChannelInvitePacket p) {
            out
                    .writeLong(p.characterId());
        } else if (packet instanceof PrivateChannelKickPacket p) {
            out
                    .writeLong(p.characterId());
        } else if (packet instanceof PrivateChannelKickAllPacket) {
            // do nothing
        } else if (packet instanceof PrivateChannelLeavePacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PrivateChannelMessagePacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.message())
                    .writeString(p.raw());
        } else if (packet instanceof PublicChannelClientModeSetPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeInt(p.unknownInt1())
                    .writeInt(p.unknownInt2())
                    .writeInt(p.unknownInt3())
                    .writeInt(p.unknownInt4());
        } else if (packet instanceof PublicChannelDataSetPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeInt(p.flags())
                    .writeString(p.mute());
        } else if (packet instanceof PublicChannelMessagePacket p) {
            out
                    .writeLong(p.channelId())
                    .writeString(p.message())
                    .writeString(p.raw());
        }
        return out;
    }
}
