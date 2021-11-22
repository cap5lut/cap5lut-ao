package net.cap5lut.ao.netty.ao;

import net.cap5lut.ao.entities.Credentials;
import net.cap5lut.ao.entities.Server;

public class Test {
    public static void main(String[] args) {
        final var bot = new AoClient(Server.RK5);
        final var api = new AoClientBuilder()
                .setServer(Server.RK5)
                .setCredentials(new Credentials("cap5lutbots", "44Liwoldio44", "Capstestbot"))
                .login()
                .join();

    }
}
