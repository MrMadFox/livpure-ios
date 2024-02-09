package com.livpure.safedrink.bolt.service;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class Base64Hex {
    private static final String CipherMode = "AES/ECB/NoPadding";
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String convert(String base64) {
        return toHex(Base64.getDecoder().decode(base64));
    }

    public static final String toHex(byte[] data) {
        StringBuffer stringBuffer = new StringBuffer(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            char[] cArr = DIGITS;
            stringBuffer.append(cArr[(data[i] >>> 4) & 15]);
            stringBuffer.append(cArr[data[i] & Ascii.SI]);
        }
        return stringBuffer.toString();
    }

    public static final String hextobase64(String hexdata) {
        return Base64.getEncoder().encodeToString(hexdata.getBytes());
    }

    public static String asciiToHex(String asciiValue) {
        char[] charArray = asciiValue.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            stringBuffer.append(Integer.toHexString(c));
        }
        return stringBuffer.toString();
    }

    public static byte[] decrypt(byte[] content, String password) {
        try {
            SecretKeySpec createKey = createKey(password);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(2, createKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String content, String password) {
        byte[] bArr;
        try {
            bArr = hex2byte(content);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        byte[] decrypt = decrypt(bArr, password);
        if (decrypt == null) {
            return null;
        }
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    public static SecretKeySpec createKey(String password) {
        if (password == null) {
            password = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(password);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
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

    public static String base64toHex(String base64) {
        return toHex(Base64.getDecoder().decode(base64));
    }

    public static String hexToAscii(String hexStr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < hexStr.length()) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(hexStr.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }
}
