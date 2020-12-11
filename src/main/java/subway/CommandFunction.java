package subway;

@FunctionalInterface
public interface CommandFunction<T, U, V> {
    public void apply(T t, U u, V v);
}
