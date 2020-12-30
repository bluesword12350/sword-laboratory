package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

class QRCodeWriterTest {

    @Test
    void encode() throws WriterException, IOException {
        BitMatrix bitMatrix = new QRCodeWriter().encode("test", BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath("target/test.png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
