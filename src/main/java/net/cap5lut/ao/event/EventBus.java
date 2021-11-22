package net.cap5lut.ao.event;

import java.util.function.Consumer;

public interface EventBus<E> {
    <R> R dispatch(E event, EventDispatcher<E, R> dispatcher);

    EventSubscription subscribe(EventListener<? super E> listener);

    default EventSubscription subscribe(Consumer<? super E> listener) {
        return subscribe((event, subscription) -> listener.accept(event));
    }
}
