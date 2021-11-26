package net.cap5lut.ao.netty.ao.protocol;

import io.netty.channel.ChannelHandlerContext;
import net.cap5lut.ao.netty.ao.packet.server.AoServerPacket;
import net.cap5lut.ao.netty.ao.packet.server.BroadcastPacket;
import net.cap5lut.ao.netty.ao.packet.server.BuddyAddedPacket;
import net.cap5lut.ao.netty.ao.packet.server.BuddyRemovedPacket;
import net.cap5lut.ao.netty.ao.packet.server.CharacterListPacket;
import net.cap5lut.ao.netty.ao.packet.server.CharacterReplyPacket;
import net.cap5lut.ao.netty.ao.packet.server.CharacterUnknownPacket;
import net.cap5lut.ao.netty.ao.packet.server.CharacterUpdatePacket;
import net.cap5lut.ao.netty.ao.packet.server.LoginFailurePacket;
import net.cap5lut.ao.netty.ao.packet.server.LoginSeedPacket;
import net.cap5lut.ao.netty.ao.packet.server.LoginSuccessPacket;
import net.cap5lut.ao.netty.ao.packet.server.PongPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelCharacterJoinedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelCharacterLeftPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelInviteRefusedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelInvitedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelKickedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelLeftPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateMessageReceivedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelJoinedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelLeftPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.SimpleSystemMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.SystemMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.VicinityMessagePacket;
import net.cap5lut.ao.netty.ao.protocol.AoDataBuf;
import net.cap5lut.ao.netty.ao.protocol.AoPacketEncoder;

public class AoServerPacketEncoder extends AoPacketEncoder<AoServerPacket> {
    @Override
    protected AoDataBuf encode(ChannelHandlerContext ctx, AoServerPacket packet, AoDataBuf out) {
        if (packet instanceof BroadcastPacket p) {
            out
                    .writeString(p.text())
                    .writeString(p.message())
                    .writeString(p.raw());
        } else if (packet instanceof BuddyAddedPacket p) {
            out
                    .writeLong(p.characterId())
                    .writeInt(p.online())
                    .writeString(p.status());
        } else if (packet instanceof BuddyRemovedPacket p) {
            out
                    .writeLong(p.characterId());
        } else if (packet instanceof CharacterListPacket p) {
            out
                    .writeLongArray(p.characterIds())
                    .writeStringArray(p.characterNames())
                    .writeIntArray(p.characterLevels())
                    .writeIntArray(p.onlineStates());
        } else if (packet instanceof CharacterReplyPacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.characterName());
        } else if (packet instanceof CharacterUnknownPacket p) {
            out
                    .writeInt(p.unknownInt());
        } else if (packet instanceof CharacterUpdatePacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.characterName());
        } else if (packet instanceof LoginFailurePacket p) {
            out
                    .writeString(p.message());
        } else if (packet instanceof LoginSeedPacket p) {
            out
                    .writeString(p.seed());
        } else if (packet instanceof LoginSuccessPacket) {
            // do nothing
        } else if (packet instanceof PongPacket p) {
            out
                    .writeString(p.raw());
        } else if (packet instanceof PrivateChannelCharacterJoinedPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeLong(p.characterId());
        } else if (packet instanceof PrivateChannelCharacterLeftPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeLong(p.characterId());
        } else if (packet instanceof PrivateChannelInvitedPacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PrivateChannelInviteRefusedPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeLong(p.characterId());

        } else if (packet instanceof PrivateChannelKickedPacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PrivateChannelLeftPacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PrivateChannelMessagePacket p) {
            out
                    .writeLong(p.channelId())
                    .writeLong(p.characterId())
                    .writeString(p.message())
                    .writeString(p.raw());
        } else if (packet instanceof PrivateMessageReceivedPacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.message())
                    .writeString(p.raw());
        } else if (packet instanceof PublicChannelJoinedPacket p) {
            out
                    .writeLong(p.channelId())
                    .writeString(p.channelName())
                    .writeInt(p.unknownInt())
                    .writeString(p.flags());
        } else if (packet instanceof PublicChannelLeftPacket p) {
            out
                    .writeLong(p.channelId());
        } else if (packet instanceof PublicChannelMessagePacket p) {
            out
                    .writeLong(p.channelId())
                    .writeLong(p.characterId())
                    .writeString(p.message())
                    .writeString(p.raw());
        } else if (packet instanceof SimpleSystemMessagePacket p) {
            out
                    .writeString(p.message());
        } else if (packet instanceof SystemMessagePacket p) {
            out
                    .writeInt(p.clientId())
                    .writeInt(p.windowId())
                    .writeInt(p.messageId())
                    .writeString(p.messageArguments());
        } else if (packet instanceof VicinityMessagePacket p) {
            out
                    .writeLong(p.characterId())
                    .writeString(p.message())
                    .writeTextBlob(p.blob());
        }
        return out;
    }
}
