package org.example.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * 將字串進行MD5加密
     * @param input 要加密的字串
     * @return 加密後的MD5字串
     */
    public static String encrypt(String input) {
        try {
            // 獲取MD5實例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 將輸入字串轉換為位元組數組
            byte[] messageDigest = md.digest(input.getBytes());

            // 將位元組數組轉換為16進位數字串
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            // 補足32位
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 驗證原始字串與加密後的MD5是否匹配
     * @param original 原始字串
     * @param md5 加密後的MD5字串
     * @return 是否匹配
     */
    public static boolean verify(String original, String md5) {
        String calculatedHash = encrypt(original);
        return calculatedHash.equals(md5);
    }
}