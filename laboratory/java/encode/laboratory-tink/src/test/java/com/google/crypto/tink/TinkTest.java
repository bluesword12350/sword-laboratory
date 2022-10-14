package com.google.crypto.tink;

import com.google.crypto.tink.hybrid.HybridConfig;
import com.google.crypto.tink.subtle.Hex;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

class TinkTest {

    private final byte[] plaintext = "1245".getBytes();
    private final byte[] aad = "1".getBytes();
    private final byte[] data = "1212424".getBytes();
    private final byte[] contextInfo = data;

    static {
        try {
            HybridConfig.register();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    @Test
    void aes128Test() throws GeneralSecurityException {

        KeysetHandle keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("AES128_GCM"));
        Aead aead = keysetHandle.getPrimitive(Aead.class);
        byte[] cipherText = aead.encrypt(plaintext, aad);
        System.out.println(Hex.encode(cipherText));
        byte[] decrypted = aead.decrypt(cipherText, aad);
        System.out.println(new String(decrypted));
    }

    @Test
    void aes256Test() throws GeneralSecurityException {
        KeysetHandle keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("AES256_SIV"));
        DeterministicAead deterministicAead = keysetHandle.getPrimitive(DeterministicAead.class);
        byte[] cipherText = deterministicAead.encryptDeterministically(plaintext, aad);
        System.out.println(Hex.encode(cipherText));
        byte[] decrypted = deterministicAead.decryptDeterministically(cipherText, aad);
        System.out.println(new String(decrypted));
    }

    @Test
    void macTest() throws GeneralSecurityException {
        KeysetHandle keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("HMAC_SHA256_128BITTAG"));
        Mac mac = keysetHandle.getPrimitive(Mac.class);
        byte[] tag = mac.computeMac(data);
        System.out.println(Hex.encode(tag));
        try {
            mac.verifyMac(tag, plaintext);
            System.out.println("plaintext:验证成功");
        }catch (Exception e){
            System.out.println("plaintext:验证失败");
        }
        try {
            mac.verifyMac(tag, data);
            System.out.println("data:验证成功");
        }catch (Exception e){
            System.out.println("data:验证失败");
        }
    }

    @Test
    void ecdsaSignTest() throws GeneralSecurityException, IOException {
        String publicKeyFileName = ".publicKey";

        KeysetHandle privateKeySetHandle = KeysetHandle.generateNew(KeyTemplates.get("ECDSA_P256"));
        PublicKeySign signer = privateKeySetHandle.getPrimitive(PublicKeySign.class);
        byte[] signature = signer.sign(data);
        System.out.println(Hex.encode(signature));
        KeysetHandle publicKeySetHandle =
                privateKeySetHandle.getPublicKeysetHandle();
        try (FileOutputStream outputStream =
                     new FileOutputStream(publicKeyFileName)){
            BinaryKeysetWriter.withOutputStream(outputStream)
                    .write(publicKeySetHandle.getKeyset());
        }

        KeysetHandle publicKeySetHandleFromFile = KeysetHandle.fromKeyset(
                BinaryKeysetReader.withFile(new File(publicKeyFileName)).read()
        );
        String sign = "";
        byte[] signature1 = Hex.decode(sign);
        PublicKeyVerify verifier = publicKeySetHandleFromFile.getPrimitive(PublicKeyVerify.class);
        try {
            verifier.verify(signature1, data);
            System.out.println("data:验证成功");
        }catch (Exception e){
            System.out.println("data:验证失败");
        }
    }

    @Test
    void hybridEncryptTest() throws GeneralSecurityException, IOException {
        String fileName = ".privateKey";

        KeysetHandle privateKeySetHandle = KeysetHandle.generateNew(KeyTemplates.get("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM"));
        KeysetHandle publicKeySetHandle =
                privateKeySetHandle.getPublicKeysetHandle();
        HybridEncrypt hybridEncrypt = publicKeySetHandle.getPrimitive(HybridEncrypt.class);

        byte[] cipherText = hybridEncrypt.encrypt(plaintext, contextInfo);
        System.out.println(Hex.encode(cipherText));
        try (FileOutputStream outputStream =
                     new FileOutputStream(fileName)){
            JsonKeysetWriter.withOutputStream(outputStream)
                    .write(privateKeySetHandle.getKeyset());
        }

        KeysetHandle privateKeySetHandleByFile = KeysetHandle.fromKeyset(
                JsonKeysetReader.withFile(new File(fileName)).read());
        HybridDecrypt hybridDecrypt = privateKeySetHandleByFile.getPrimitive(HybridDecrypt.class);
        System.out.println(new String(hybridDecrypt.decrypt(cipherText, contextInfo)));
    }

    @Test
    void streamingAeadTest () throws GeneralSecurityException, IOException {
        String encryptedFile = "pom加密.encrypted";

        KeysetHandle keysetHandle = KeysetHandle.generateNew(KeyTemplates.get("AES128_CTR_HMAC_SHA256_4KB"));
        StreamingAead streamingAead = keysetHandle.getPrimitive(StreamingAead.class);
        try (FileOutputStream fileOutputStream = new FileOutputStream(encryptedFile)){
            FileChannel cipherTextDestination = fileOutputStream.getChannel();
            FileInputStream fileInputStream = new FileInputStream("pom.xml");
            WritableByteChannel encryptingChannel = streamingAead.newEncryptingChannel(cipherTextDestination, aad);
            try (encryptingChannel;fileInputStream){
                byte[] bytes = fileInputStream.readAllBytes();
                ByteBuffer buffer = ByteBuffer.wrap(bytes);
                encryptingChannel.write(buffer);
            }
        }
        FileInputStream cipherTextSource = new FileInputStream(encryptedFile);
        InputStream inputStream1 = streamingAead.newDecryptingStream(cipherTextSource, aad);
        new FileOutputStream("pom.iml").write(inputStream1.readAllBytes());
    }

}