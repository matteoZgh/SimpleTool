package cn.howoli.safe;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        return new Safe<>(getObject(function));
    }

    public int getInt(Function<T, Integer> function) {
        return getObjectOrElse(function, 0);
    }

    public long getLong(Function<T, Long> function) {
        return getObjectOrElse(function, 0L);
    }

    public double getDouble(Function<T, Double> function) {
        return getObjectOrElse(function, 0.0);
    }

    public float getFloat(Function<T, Float> function) {
        return getObjectOrElse(function, 0.0F);
    }

    public boolean getBoolean(Function<T, Boolean> function) {
        return getObjectOrElse(function, false);
    }

    public short getShort(Function<T, Short> function) {
        return getObjectOrElse(function, (short) 0);
    }

    public byte getByte(Function<T, Byte> function) {
        return getObjectOrElse(function, (byte) 0);
    }

    public char getChar(Function<T, Character> function) {
        return getObjectOrElse(function, (char) 0);
    }

    public String getString(Function<T, String> function) {
        return getObjectOrElse(function, "");
    }

    public List getList(Function<T, List> function) {
        return getObjectOrElse(function, Collections.EMPTY_LIST);
    }

    public Map getMap(Function<T, Map> function) {
        return getObjectOrElse(function, Collections.EMPTY_MAP);
    }

    public Set getSet(Function<T, Set> function) {
        return getObjectOrElse(function, Collections.EMPTY_SET);
    }

    public <R> R getObject(Function<T, R> function) {
        return getObjectOrElse(function, null);
    }

    public <R> R getObjectOrElse(Function<T, R> function, R orElse) {
        return instance != null ? function.apply(instance) : orElse;
    }
}
