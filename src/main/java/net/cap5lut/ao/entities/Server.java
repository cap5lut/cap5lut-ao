package net.cap5lut.ao.entities;

import java.net.InetSocketAddress;

public record Server(String name, int dimension, String hostname, int port) {
    public static final Server RK5 = new Server("RK5", 5, "chat.d1.funcom.com", 7105);

    public InetSocketAddress address() {
        return new InetSocketAddress(hostname, port);
    }
}
