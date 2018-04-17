package com.cefalo.school.generic;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A generic Tree interface. Can be considered as a Tree of T type objects.
 * <p>
 * Created by jobaer on Apr-17-2018.
 */
public interface Tree<T> {
    T createNode(T node);

    void makeChild(T parent, T child);

    void removeChild(T parent, T child);

    void forEach(T node, Consumer<T> action);

    <U> U fold(T node,
               U initialValue,
               Function<T, U> extractor,
               BiFunction<U, U, U> combiner);

    <B> Tree<B> map(Function<T, B> transform);
}
