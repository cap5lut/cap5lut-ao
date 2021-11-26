package net.cap5lut.ao.netty.ao.n;

import net.cap5lut.ao.entities.Credentials;
import net.cap5lut.ao.entities.Server;
import net.cap5lut.ao.event.EventBus;
import net.cap5lut.ao.netty.ao.packet.AoPacket;

import java.util.concurrent.CompletableFuture;

public interface AoClient2 {
    CompletableFuture<?> connect();
    CompletableFuture<?> sendPacket(AoPacket packet);
    CompletableFuture<?> disconnect();
    EventBus<Object> onConnect();
    EventBus<Object> onDisconnect();
    EventBus<Object> onError();
    EventBus<Object> onPacket();
    EventBus<Object> onIncomingPacket();
    EventBus<Object> onOutgoingPacket();
}
