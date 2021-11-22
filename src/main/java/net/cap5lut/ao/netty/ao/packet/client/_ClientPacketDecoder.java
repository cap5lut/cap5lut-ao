package net.cap5lut.ao.netty.ao.packet.client;

import io.netty.buffer.ByteBuf;
import net.cap5lut.ao.netty.ao.AoBuf;
import net.cap5lut.ao.netty.ao.packet.PacketDecoder;
import net.cap5lut.ao.netty.ao.packet.PacketDecoder_old;
import net.cap5lut.ao.netty.ao.packet.UnknownPacket;

public class _ClientPacketDecoder extends PacketDecoder<AoClientPacket> {
    @Override
    protected AoClientPacket readPacket(AoBuf in, int type, int length) {
        return switch (type) {
            case BuddyAddPacket.TYPE -> new BuddyAddPacket(in.readLong(), in.readString());
            case BuddyRemovePacket.TYPE -> new BuddyRemovePacket(in.readLong());
            case CharacterLookupPacket.TYPE -> new CharacterLookupPacket(in.readString());
            case ChatCommandPacket.TYPE -> new ChatCommandPacket(in.readStringArray());
            case ClientModeGetPacket.TYPE -> new ClientModeGetPacket(in.readInt(), in.readLong());
            case ClientModeSetPacket.TYPE -> new ClientModeSetPacket(
                    in.readInt(), in.readInt(), in.readInt(), in.readInt()
            );
            case LoginRequestPacket.TYPE -> new LoginRequestPacket(in.readInt(), in.readString(), in.readString());
            case LoginSelectPacket.TYPE -> new LoginSelectPacket(in.readLong());
            case OnlineStatusSetPacket.TYPE -> new OnlineStatusSetPacket(in.readInt());
            case PingPacket.TYPE -> new PingPacket(in.readString());
            case PrivateChannelAcceptPacket.TYPE -> new PrivateChannelAcceptPacket(in.readLong());
            case PrivateChannelInvitePacket.TYPE -> new PrivateChannelInvitePacket(in.readLong());
            case PrivateChannelKickPacket.TYPE -> new PrivateChannelKickPacket(in.readLong());
            case PrivateChannelKickAllPacket.TYPE -> new PrivateChannelKickAllPacket();
            case PrivateChannelLeavePacket.TYPE -> new PrivateChannelLeavePacket(in.readLong());
            case PrivateChannelMessagePacket.TYPE -> new PrivateChannelMessagePacket(
                    in.readLong(), in.readString(), in.readString()
            );
            case PrivateMessageSendPacket.TYPE -> new PrivateMessageSendPacket(
                    in.readLong(), in.readString(), in.readString()
            );
            case PublicChannelClientModeSetPacket.TYPE -> new PublicChannelClientModeSetPacket(
                    in.readLong(), in.readInt(), in.readInt(), in.readInt(), in.readInt()
            );
            case PublicChannelDataSetPacket.TYPE -> new PublicChannelDataSetPacket(
                    in.readLong(), in.readInt(), in.readString()
            );
            case PublicChannelMessagePacket.TYPE -> new PublicChannelMessagePacket(
                    in.readLong(), in.readString(), in.readString()
            );
            default -> new UnknownPacket(type, in.readByteArrayRaw(length));
        };
    }
}
