package com.google.crypto.tink;

import cn.hutool.core.io.FileUtil;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.daead.DeterministicAeadFactory;
import com.google.crypto.tink.daead.DeterministicAeadKeyTemplates;
import com.google.crypto.tink.hybrid.HybridDecryptFactory;
import com.google.crypto.tink.hybrid.HybridEncryptFactory;
import com.google.crypto.tink.hybrid.HybridKeyTemplates;
import com.google.crypto.tink.mac.MacFactory;
import com.google.crypto.tink.mac.MacKeyTemplates;
import com.google.crypto.tink.signature.PublicKeySignFactory;
import com.google.crypto.tink.signature.PublicKeyVerifyFactory;
import com.google.crypto.tink.signature.SignatureKeyTemplates;
import com.google.crypto.tink.streamingaead.StreamingAeadFactory;
import com.google.crypto.tink.streamingaead.StreamingAeadKeyTemplates;
import com.google.crypto.tink.subtle.Hex;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

class TinkTest {

    private byte[] plaintext = "1245".getBytes();
    private byte[] aad = "1".getBytes();
    private byte[] data = "1212424".getBytes();
    private byte[] contextInfo = data;

    @Test
    void aes128Test() throws GeneralSecurityException {
        TinkConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                AeadKeyTemplates.AES128_GCM);
        Aead aead = AeadFactory.getPrimitive(keysetHandle);

        byte[] cipherText = aead.encrypt(plaintext, aad);
        System.out.println(Hex.encode(cipherText));
        byte[] decrypted = aead.decrypt(cipherText, aad);
        System.out.println(new String(decrypted));
    }

    @Test
    void aes256Test() throws GeneralSecurityException {
        TinkConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                DeterministicAeadKeyTemplates.AES256_SIV);
        DeterministicAead dAead = DeterministicAeadFactory.getPrimitive(keysetHandle);
        byte[] cipherText = dAead.encryptDeterministically(plaintext, aad);
        System.out.println(Hex.encode(cipherText));
        byte[] decrypted = dAead.decryptDeterministically(cipherText, aad);
        System.out.println(new String(decrypted));
    }

    @Test
    void macTest() throws GeneralSecurityException {
        TinkConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                MacKeyTemplates.HMAC_SHA256_128BITTAG);
        Mac mac = MacFactory.getPrimitive(keysetHandle);
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
        TinkConfig.register();
        KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(
                SignatureKeyTemplates.ECDSA_P256);
        PublicKeySign signer = PublicKeySignFactory.getPrimitive(
                privateKeysetHandle);
        byte[] signature = signer.sign(data);
        System.out.println(Hex.encode(signature));
        KeysetHandle publicKeysetHandle =
                privateKeysetHandle.getPublicKeysetHandle();
        try (FileOutputStream outputStream =
                     new FileOutputStream("publicKey")){
            BinaryKeysetWriter.withOutputStream(outputStream)
                    .write(publicKeysetHandle.getKeyset());
        }
    }

    @Test
    void ecdsaVerifierTest() throws GeneralSecurityException, IOException {
        TinkConfig.register();
        KeysetHandle publicKeysetHandle = KeysetHandle.fromKeyset(BinaryKeysetReader.withFile(new File("publicKey"))
                .read());
        String sign = "";
        byte[] signature = Hex.decode(sign);
        PublicKeyVerify verifier = PublicKeyVerifyFactory.getPrimitive(
                publicKeysetHandle);
        try {
            verifier.verify(signature, data);
            System.out.println("data:验证成功");
        }catch (Exception e){
            System.out.println("data:验证失败");
        }
    }

    @Test
    void hybridEncryptTest() throws GeneralSecurityException, IOException {
        TinkConfig.register();
        KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(
                HybridKeyTemplates.ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM);
        KeysetHandle publicKeysetHandle =
                privateKeysetHandle.getPublicKeysetHandle();
        HybridEncrypt hybridEncrypt = HybridEncryptFactory.getPrimitive(
                publicKeysetHandle);

        byte[] cipherText = hybridEncrypt.encrypt(plaintext, contextInfo);
        System.out.println(Hex.encode(cipherText));
        try (FileOutputStream outputStream =
                     new FileOutputStream("publicKey.json")){
            JsonKeysetWriter.withOutputStream(outputStream)
                    .write(privateKeysetHandle.getKeyset());
        }
    }

    @Test
    void hybridDecryptTest() throws GeneralSecurityException, IOException {
        TinkConfig.register();
        KeysetHandle privateKeysetHandle = KeysetHandle.fromKeyset(
                JsonKeysetReader.withFile(new File("publicKey.json")).read());
        HybridDecrypt hybridDecrypt = HybridDecryptFactory.getPrimitive(
                privateKeysetHandle);
        String cipher = "";
        byte[] cipherText = Hex.decode(cipher);
        System.out.println(new String(hybridDecrypt.decrypt(cipherText, contextInfo)));
    }

    @Test
    void streamingAeadTest () throws GeneralSecurityException, IOException {
        TinkConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                StreamingAeadKeyTemplates.AES128_CTR_HMAC_SHA256_4KB);
        StreamingAead streamingAead = StreamingAeadFactory.getPrimitive(keysetHandle);
        try (FileOutputStream fileOutputStream = new FileOutputStream("李白加密")){
            FileChannel cipherTextDestination = fileOutputStream.getChannel();
            try (WritableByteChannel encryptingChannel =
                         streamingAead.newEncryptingChannel(cipherTextDestination, aad)){
                byte[] bytes = FileUtil.readBytes(new File("李白.json"));
                ByteBuffer buffer = ByteBuffer.wrap(bytes);
                encryptingChannel.write(buffer);
            }
        }
        FileInputStream cipherTextSource = new FileInputStream("李白加密");
        InputStream inputStream1 = streamingAead.newDecryptingStream(cipherTextSource, aad);
        FileUtil.writeFromStream(inputStream1,new File("李白2.json"));
    }
}