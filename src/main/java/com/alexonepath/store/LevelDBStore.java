package com.alexonepath.store;

import com.alexonepath.exception.CreateStoreException;
import com.alexonepath.util.SerializeUtil;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

import java.io.File;
import java.io.IOException;

public class LevelDBStore<K, V> implements Store<K, V> {
    private DB db;

    public LevelDBStore(String path, Options options) {
        if (options == null) {
            options = new Options();
            options.createIfMissing(true);
        }
        try {
            db = Iq80DBFactory.factory.open(new File(path), options);
        } catch (IOException e) {
            throw new CreateStoreException(e.getCause());
        }
    }

    @Override
    public void put(K key, V value) {
        db.put(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
    }

    @Override
    public void delete(K key) {
        db.delete(SerializeUtil.serialize(key));
    }

    @Override
    public <V> V get(K key) {
        byte[] value = db.get(SerializeUtil.serialize(key));
        V result = null;
        if (value != null) {
            result = (V) SerializeUtil.deserializeBytes(value);
        }
        return result;
    }
}
