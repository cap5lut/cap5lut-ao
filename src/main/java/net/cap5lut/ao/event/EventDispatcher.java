package net.cap5lut.ao.event;

@FunctionalInterface
public interface EventDispatcher<E, R> {
    R dispatch(E event);
}
