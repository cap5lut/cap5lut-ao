package net.cap5lut.ao.netty.ao.protocol;

import io.netty.channel.ChannelHandlerContext;
import net.cap5lut.ao.netty.ao.packet.client.AoClientPacket;
import net.cap5lut.ao.netty.ao.packet.client.BuddyAddPacket;
import net.cap5lut.ao.netty.ao.packet.client.BuddyRemovePacket;
import net.cap5lut.ao.netty.ao.packet.client.CharacterLookupPacket;
import net.cap5lut.ao.netty.ao.packet.client.ChatCommandPacket;
import net.cap5lut.ao.netty.ao.packet.client.ClientModeGetPacket;
import net.cap5lut.ao.netty.ao.packet.client.ClientModeSetPacket;
import net.cap5lut.ao.netty.ao.packet.client.LoginRequestPacket;
import net.cap5lut.ao.netty.ao.packet.client.LoginSelectPacket;
import net.cap5lut.ao.netty.ao.packet.client.OnlineStatusSetPacket;
import net.cap5lut.ao.netty.ao.packet.client.PingPacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelAcceptPacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelInvitePacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelKickAllPacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelKickPacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelLeavePacket;
import net.cap5lut.ao.netty.ao.packet.client.PrivateChannelMessagePacket;
import net.cap5lut.ao.netty.ao.packet.client.PublicChannelClientModeSetPacket;
import net.cap5lut.ao.netty.ao.packet.client.PublicChannelDataSetPacket;
import net.cap5lut.ao.netty.ao.packet.client.PublicChannelMessagePacket;

public class AoClientPacketEncoder extends AoPacketEncoder<AoClientPacket> {
    @Override
    protected AoDataBuf encode(ChannelHandlerContext ctx, AoClientPacket packet, AoDataBuf out) {
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
                    .writeString(p.account())
                    .writeString(p.hash());
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
