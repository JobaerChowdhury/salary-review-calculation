package com.cefalo.school.generic;

import com.cefalo.school.calculator.Identity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Concrete implementation of the Tree interface.
 * <p>
 * Created by jobaer on Apr-17-2018.
 */
public class CompositeTree<T extends Identity> implements Tree<T> {
    private Map<Integer, Node<T>> storage = new HashMap<>();

    @Override
    public T createNode(T node) {
        TreeNode<T> tTreeNode = new TreeNode<>(node);
        storage.put(node.getId(), tTreeNode);
        return node;
    }

    @Override
    public void forEach(T node, Consumer<T> action) {
        if (!storage.containsKey(node.getId())) return;

        Node<T> treeNode = storage.get(node.getId());
        T data = treeNode.getData();
        action.accept(data);

        for (Node<T> tNode : treeNode.getChildren()) {
            forEach(tNode.getData(), action);
        }
    }

    @Override
    public void makeChild(T parent, T child) {
        if (storage.containsKey(parent.getId()) && storage.containsKey(child.getId())) {
            Node<T> parentNode = storage.get(parent.getId());
            Node<T> childNode = storage.get(child.getId());
            parentNode.addChild(childNode);
        }
    }
}
