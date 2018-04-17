package com.cefalo.school.generic;

import java.util.List;

/**
 * Created by jobaer on Apr-17-2018.
 */
public interface Node<T> {
    T getData();
    List<Node<T>> getChildren();
    void addChild(Node<T> child);
    void removeChild(Node<T> child);
    boolean isLeaf();
}
