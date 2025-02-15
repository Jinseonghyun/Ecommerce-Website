package com.backend.domain.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Aes256UtilTest {

    @Test
    public void testEncryptionDecryption() {
        String originalText = "Hello World";

        // 암호화
        String encryptedText = Aes256Util.encrypt(originalText);

        // 암호화된 값이 null이 아닌지 확인
        assertNotNull(encryptedText);

        // 복호화
        String decryptedText = Aes256Util.decrypt(encryptedText);

        // 원래의 텍스트와 비교
        assertEquals(originalText, decryptedText);
    }

}