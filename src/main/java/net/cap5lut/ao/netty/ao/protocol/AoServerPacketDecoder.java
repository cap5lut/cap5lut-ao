package net.cap5lut.ao.netty.ao.protocol;

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
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelInvitedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelKickedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelLeftPacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateChannelMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.PrivateMessageReceivedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelJoinedPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelLeftPacket;
import net.cap5lut.ao.netty.ao.packet.server.PublicChannelMessagePacket;
import net.cap5lut.ao.netty.ao.packet.server.SimpleSystemMessagePacket;
import net.cap5lut.ao.netty.ao.protocol.AoDataBuf;
import net.cap5lut.ao.netty.ao.protocol.AoPacketDecoder;
import net.cap5lut.ao.netty.ao.packet.UnknownPacket;

public class AoServerPacketDecoder extends AoPacketDecoder<AoServerPacket> {
    @Override
    protected AoServerPacket readPacket(AoDataBuf in, int type, int length) {
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
