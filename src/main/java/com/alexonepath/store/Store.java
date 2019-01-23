package com.alexonepath.store;

public interface Store<K, V> {
    void put(K key, V value);

    void delete(K key);

    <V> V get(K key);
}
