package io.minio;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MinioClientTest {

    private static MinioClient minioClient;

    @BeforeAll
    static void before(){
        String endpoint = "";
        String accessKey = "";
        String secretKey = "";
        minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    @Test
    void uploadObject() throws Exception {
        String bucketName = "";
        String objectName = "";
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder().bucket(bucketName).object(objectName).build();
        minioClient.uploadObject(uploadObjectArgs);
    }
}
