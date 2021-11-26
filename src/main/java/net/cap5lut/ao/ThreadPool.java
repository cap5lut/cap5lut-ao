package net.cap5lut.ao;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ThreadPool {
    public static CompletableFuture<Void> runAsync(RunnableThrowing runnable) {
        return CompletableFuture.runAsync(runnable);
    }

    public static CompletableFuture<Void> runAsync(RunnableThrowing runnable, Executor executor) {
        return CompletableFuture.runAsync(runnable, executor);
    }

    public static <T> CompletableFuture<T> supplyAsync(SupplierThrowing<T> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }

    public static <T> CompletableFuture<T> supplyAsync(SupplierThrowing<T> supplier, Executor executor) {
        return CompletableFuture.supplyAsync(supplier, executor);
    }

    public static CompletableFuture<?> schedule(RunnableThrowing task, long delay, TimeUnit unit) {
        throw new AssertionError();
    }



    @FunctionalInterface
    public interface RunnableThrowing extends Runnable {
        void runThrowing() throws Throwable;

        default void run() {
            try {
                runThrowing();
            } catch (RuntimeException e) {
                throw e;
            } catch (Throwable e) {
                throw new CompletionException(e);
            }
        }
    }

    @FunctionalInterface
    public interface SupplierThrowing<T> extends Supplier<T> {
        T getThrowing() throws Throwable;

        @Override
        default T get() {
            try {
                return getThrowing();
            } catch (RuntimeException e) {
                throw e;
            } catch (Throwable e) {
                throw new CompletionException(e);
            }
        }
    }
}
