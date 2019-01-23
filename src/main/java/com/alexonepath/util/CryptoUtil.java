package com.alexonepath.util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jcajce.provider.digest.SHA3;


public class CryptoUtil {
    public static byte[] sha3(byte[] data) {
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        return digestSHA3.digest(data);
    }

    public static String encodeBase64(String val) {
        return new String(Base64.encodeBase64(val.getBytes()));
    }

    public static String encodeBase64(byte[] val) {
        return new String(Base64.encodeBase64(val));
    }
}
