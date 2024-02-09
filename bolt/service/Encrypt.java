package com.livpure.safedrink.bolt.service;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.facebook.appevents.AppEventsConstants;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class Encrypt {
    public static SecretKeySpec createKey(String password) {
        if (password == null) {
            password = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(password);
        return new SecretKeySpec(stringBuffer.toString().getBytes(StandardCharsets.UTF_8), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    private static byte[] hex2byte(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return new byte[0];
        }
        String lowerCase = inputString.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    public static String encrypt(String value, String key) {
        try {
            int length = value.length() % 16 != 0 ? 16 - (value.length() % 16) : 0;
            for (int i = 0; i < length; i++) {
                value = value + AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            SecretKeySpec createKey = createKey(key);
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            cipher.init(1, createKey, cipher.getParameters());
            return byteArrayToHexString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int length = s.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(s.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (byte b2 : b) {
            int i = b2 & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toUpperCase();
    }
}
