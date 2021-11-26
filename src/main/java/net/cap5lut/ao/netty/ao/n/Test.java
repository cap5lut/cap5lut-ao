package net.cap5lut.ao.netty.ao.n;

import net.cap5lut.ao.entities.Credentials;
import net.cap5lut.ao.entities.Server;

public class Test {
    private static AoClient2 newClient(Server server, Credentials credentials) {
        return null;
    }
    public static void main(String[] args) {
        final var capbot = newClient(
                Server.RK5, new Credentials("acc", "pwd", "char")
        );
        new ReconnectHandler(capbot)
    }
}
