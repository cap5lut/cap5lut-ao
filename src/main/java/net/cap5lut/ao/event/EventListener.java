package net.cap5lut.ao.event;

public interface EventListener<E> {
    void onEvent(E event, EventSubscription subscription);
}
