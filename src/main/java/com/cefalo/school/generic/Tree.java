package com.cefalo.school.generic;

import com.cefalo.school.calculator.EmployeeInfo;
import com.cefalo.school.composite.Employee;

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
    void forEach(T node, Consumer<T> action);

    void makeChild(T parent, T child);
}
