package com.alexonepath.util;

import com.alexonepath.dto.Validator;
import org.junit.Test;

public class TestSerializeUtil {
    @Test
    public void serialize() {
        Validator validator = new Validator("1", true);
        byte[] b1 = SerializeUtil.serialize(validator);

        Validator validator2 = new Validator("20", false);
        byte[] b2 = SerializeUtil.serialize(validator2);

        System.out.println(CryptoUtil.encodeBase64(b1));
        System.out.println(CryptoUtil.encodeBase64(b2));
    }
}
