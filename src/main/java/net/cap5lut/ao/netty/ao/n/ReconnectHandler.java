package net.cap5lut.ao.netty.ao.n;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ReconnectHandler {
    private final ScheduledExecutorService scheduler;
    private final AtomicInteger tries = new AtomicInteger(0);

    public ReconnectHandler(ScheduledExecutorService scheduler, AoClient client) {
        this.scheduler = scheduler;
        client.onConnect().subscribe(this::onConnect);
        client.onDisconnect().subscribe(this::onDisconnect);
    }

    protected void onConnect(Object event) {
        tries.set(0);
    }

    protected void onDisconnect(Object event) {
        scheduler.schedule(
                () -> System.out.println("connect"), this.tries.incrementAndGet() * 100L, TimeUnit.MILLISECONDS
        );
    }
}
