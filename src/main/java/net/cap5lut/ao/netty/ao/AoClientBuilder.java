package net.cap5lut.ao.netty.ao;

import net.cap5lut.ao.entities.Credentials;
import net.cap5lut.ao.entities.Server;

import java.util.concurrent.CompletableFuture;

public class AoClientBuilder {
    private Server server;
    private Credentials credentials;

    public AoClientBuilder setServer(Server server) {
        this.server = server;
        return this;
    }

    public AoClientBuilder setCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public CompletableFuture<AoClient2> login() {
        return CompletableFuture.supplyAsync(() -> new AoClient2(server, credentials));
    }
}
