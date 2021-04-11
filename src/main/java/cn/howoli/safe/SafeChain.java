package cn.howoli.safe;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class SafeChain<T> {
    private final T instance;

    private SafeChain(T instance) {
        this.instance = instance;
    }

    public static <T> SafeChain<T> of(T instance) {
        return new SafeChain<>(instance);
    }

    public <R> SafeChain<R> process(Function<T, R> function) {
        return new SafeChain<>(getObject(function));
    }

    public void get(Consumer<T> consumer) {
        if (instance != null) consumer.accept(instance);
    }

    public int getInt(Function<T, Integer> function) {
        return getIntOrElse(function, 0);
    }

    public int getIntOrElse(Function<T, Integer> function, int orElse) {
        return getObjectOrElse(function, orElse);
    }

    public long getLong(Function<T, Long> function) {
        return getLongOrElse(function, 0L);
    }

    public long getLongOrElse(Function<T, Long> function, long orElse) {
        return getObjectOrElse(function, orElse);
    }

    public double getDouble(Function<T, Double> function) {
        return getDoubleOrElse(function, 0.0);
    }

    public double getDoubleOrElse(Function<T, Double> function, double orElse) {
        return getObjectOrElse(function, orElse);
    }

    public float getFloat(Function<T, Float> function) {
        return getFloatOrElse(function, 0.0F);
    }

    public float getFloatOrElse(Function<T, Float> function, float orElse) {
        return getObjectOrElse(function, orElse);
    }

    public boolean getBoolean(Function<T, Boolean> function) {
        return getBooleanOrElse(function, false);
    }

    public boolean getBooleanOrElse(Function<T, Boolean> function, boolean orElse) {
        return getObjectOrElse(function, orElse);
    }

    public short getShort(Function<T, Short> function) {
        return getShortOrElse(function, (short) 0);
    }

    public short getShortOrElse(Function<T, Short> function, short orElse) {
        return getObjectOrElse(function, orElse);
    }

    public byte getByte(Function<T, Byte> function) {
        return getByteOrElse(function, (byte) 0);
    }

    public byte getByteOrElse(Function<T, Byte> function, byte orElse) {
        return getObjectOrElse(function, orElse);
    }

    public char getChar(Function<T, Character> function) {
        return getCharOrElse(function, (char) 0);
    }

    public char getCharOrElse(Function<T, Character> function, char orElse) {
        return getObjectOrElse(function, orElse);
    }

    public String getString(Function<T, String> function) {
        return getStringOrElse(function, "");
    }

    public String getStringOrElse(Function<T, String> function, String orElse) {
        return getObjectOrElse(function, orElse);
    }

    public List getList(Function<T, List> function) {
        return getListOrElse(function, Collections.EMPTY_LIST);
    }

    public List getListOrElse(Function<T, List> function, List orElse) {
        return getObjectOrElse(function, orElse);
    }

    public Map getMap(Function<T, Map> function) {
        return getMapOrElse(function, Collections.EMPTY_MAP);
    }

    public Map getMapOrElse(Function<T, Map> function, Map orElse) {
        return getObjectOrElse(function, orElse);
    }

    public Set getSet(Function<T, Set> function) {
        return getSetOrElse(function, Collections.EMPTY_SET);
    }

    public Set getSetOrElse(Function<T, Set> function, Set orElse) {
        return getObjectOrElse(function, orElse);
    }

    public <R> R getObject(Function<T, R> function) {
        return getObjectOrElse(function, null);
    }

    public <R> R getObjectOrElse(Function<T, R> function, R orElse) {
        return instance != null ? function.apply(instance) : orElse;
    }
}
