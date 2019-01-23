package com.alexonepath.store;

import com.alexonepath.dto.Account;
import org.iq80.leveldb.util.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigInteger;

public class TestLevelDBStore {
    String storePath = "/tmp/data-store";
    Store<Object, Object> levelDBStore;

    @Before
    public void init() {
        FileUtils.deleteRecursively(new File(storePath));
        levelDBStore = new LevelDBStore(storePath, null);
    }

    @Test
    public void put() {
        Account account = new Account("0x11", new BigInteger("100"));
        levelDBStore.put("1", account);

        Account getA = levelDBStore.get("1");
        System.out.println(getA);
    }

    @Test
    public void get() {
        Account getA = levelDBStore.get("1");
        System.out.println(getA);
    }
}
