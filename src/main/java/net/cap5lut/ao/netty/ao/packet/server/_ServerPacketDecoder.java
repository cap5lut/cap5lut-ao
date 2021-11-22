package net.cap5lut.ao.netty.ao.packet.server;

import io.netty.buffer.ByteBuf;
import net.cap5lut.ao.netty.ao.AoBuf;
import net.cap5lut.ao.netty.ao.packet.PacketDecoder;
import net.cap5lut.ao.netty.ao.packet.PacketDecoder_old;
import net.cap5lut.ao.netty.ao.packet.UnknownPacket;

public class _ServerPacketDecoder extends PacketDecoder<AoServerPacket> {
    @Override
    protected AoServerPacket readPacket(AoBuf in, int type, int length) {
        return switch (type) {
            case BroadcastPacket.TYPE -> new BroadcastPacket(in.readString(), in.readString(), in.readString());
            case BuddyAddedPacket.TYPE -> new BuddyAddedPacket(in.readLong(), in.readInt(), in.readString());
            case BuddyRemovedPacket.TYPE -> new BuddyRemovedPacket(in.readLong());
            case CharacterListPacket.TYPE -> new CharacterListPacket(
                    in.readLongArray(), in.readStringArray(), in.readIntArray(), in.readIntArray()
            );
            case CharacterReplyPacket.TYPE -> new CharacterReplyPacket(in.readLong(), in.readString());
            case CharacterUnknownPacket.TYPE -> new CharacterUnknownPacket(in.readInt());
            case CharacterUpdatePacket.TYPE -> new CharacterUpdatePacket(in.readLong(), in.readString());
            case LoginFailurePacket.TYPE -> new LoginFailurePacket(in.readString());
            case LoginSeedPacket.TYPE -> new LoginSeedPacket(in.readString());
            case LoginSuccessPacket.TYPE -> new LoginSuccessPacket();
            case PongPacket.TYPE -> new PongPacket(in.readString());
            case PrivateChannelCharacterJoinedPacket.TYPE -> new PrivateChannelCharacterJoinedPacket(
                    in.readLong(), in.readLong()
            );
            case PrivateChannelCharacterLeftPacket.TYPE -> new PrivateChannelCharacterLeftPacket(
                    in.readLong(), in.readLong()
            );
            case PrivateChannelInvitedPacket.TYPE -> new PrivateChannelInvitedPacket(in.readLong());
            case PrivateChannelKickedPacket.TYPE -> new PrivateChannelKickedPacket(in.readLong());
            case PrivateChannelLeftPacket.TYPE -> new PrivateChannelLeftPacket(in.readLong());
            case PrivateChannelMessagePacket.TYPE -> new PrivateChannelMessagePacket(
                    in.readLong(), in.readLong(), in.readString(), in.readString()
            );
            case PrivateMessageReceivedPacket.TYPE -> new PrivateMessageReceivedPacket(
                    in.readLong(), in.readString(), in.readString()
            );
            case PublicChannelJoinedPacket.TYPE -> new PublicChannelJoinedPacket(
                    in.readLong(), in.readString(), in.readInt(), in.readString()
            );
            case PublicChannelLeftPacket.TYPE -> new PublicChannelLeftPacket(in.readLong());
            case PublicChannelMessagePacket.TYPE -> new PublicChannelMessagePacket(
                    in.readLong(), in.readLong(), in.readString(), in.readString()
            );
            case SimpleSystemMessagePacket.TYPE -> new SimpleSystemMessagePacket(in.readString());
            default -> new UnknownPacket(type, in.readByteArrayRaw(length));
        };
    }
}
