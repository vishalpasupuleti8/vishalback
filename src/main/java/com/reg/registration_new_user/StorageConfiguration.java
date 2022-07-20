package com.reg.registration_new_user;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;


@Configuration
public class StorageConfiguration {


    @Bean
    public BlobServiceClient blobServiceClient() {
        return new BlobServiceClientBuilder()
                .connectionString("DefaultEndpointsProtocol=https;AccountName=evalstgacc;AccountKey=ycj0aYXflNQjNm9UxEX72zTCDmfbznhJJlWoR1wB4kmDgHUaoJhqFRe16GLvg9romGHhm1JX8gf5+AStVFASug==;EndpointSuffix=core.windows.net")
                .buildClient();
    }

}