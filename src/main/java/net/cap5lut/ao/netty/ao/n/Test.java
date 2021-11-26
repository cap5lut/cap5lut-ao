package net.cap5lut.ao.netty.ao.n;

import net.cap5lut.ao.entities.Credentials;
import net.cap5lut.ao.entities.Server;

import java.util.concurrent.Executors;

public class Test {
    private static AoClient newClient(Server server, Credentials credentials) {
        return null;
    }
    public static void main(String[] args) {
        final var capbot = newClient(
                Server.RK5, new Credentials("acc", "pwd", "char")
        );

        final var scheduler = Executors.newSingleThreadScheduledExecutor();
        new ReconnectHandler(scheduler, capbot);
    }
}
