package com.cefalo.school.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jobaer on Apr-17-2018.
 */
public class TreeNode<T> implements Node<T> {
    private T data;
    private List<Node<T>> children = new ArrayList<>();

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public List<Node<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void addChild(Node<T> child) {
        children.add(child);
    }

    @Override
    public void removeChild(Node<T> child) {
        children.remove(child);
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }
}
