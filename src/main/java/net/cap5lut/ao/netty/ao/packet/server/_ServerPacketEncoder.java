package net.cap5lut.ao.netty.ao.packet.server;

import io.netty.channel.ChannelHandlerContext;
import net.cap5lut.ao.netty.ao.AoBuf;
import net.cap5lut.ao.netty.ao.packet.PacketEncoder;

public class _ServerPacketEncoder extends PacketEncoder<AoServerPacket> {
    @Override
    protected AoBuf encode(ChannelHandlerContext ctx, AoServerPacket packet, AoBuf out) {
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
