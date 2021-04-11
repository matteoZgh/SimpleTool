package cn.howoli.safe;

import java.util.function.Function;

public class Safe<T> {
    private final T instance;

    private Safe(T instance) {
        this.instance = instance;
    }

    public static <T> Safe<T> open(T instance) {
        return new Safe<>(instance);
    }

    public <R> Safe<R> flow(Function<T, R> function) {
        return new Safe<>(instance != null ? function.apply(instance) : null);
    }

    public <R> R close(Function<T, R> function) {
        return instance != null ? function.apply(instance) : null;
    }
}
