package net.cap5lut.ao.netty.ao.n;

import net.cap5lut.ao.event.EventBus;
import net.cap5lut.ao.netty.ao.n.events.ConnectedEvent;
import net.cap5lut.ao.netty.ao.n.events.DisconnectedEvent;
import net.cap5lut.ao.netty.ao.n.events.ErrorEvent;
import net.cap5lut.ao.netty.ao.packet.AoPacket;

import java.util.concurrent.CompletableFuture;

public class AoClient {
    public CompletableFuture<?> connect() {
        return null;
    }
    public CompletableFuture<?> sendPacket(AoPacket packet) {
        return null;
    }
    public CompletableFuture<?> disconnect() {
        return null;
    }
    public EventBus<ConnectedEvent> onConnect() {
        return null;
    }
    public EventBus<DisconnectedEvent> onDisconnect() {
        return null;
    }
    public EventBus<ErrorEvent> onError() {
        return null;
    }
    public EventBus<Object> onIncomingPacket() {
        return null;
    }
    public EventBus<Object> onOutgoingPacket() {
        return null;
    }
}
