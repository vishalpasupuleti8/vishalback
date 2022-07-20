package com.reg.registration_new_user._service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;

@Service
public class BlobStorageService {

	@Autowired
	BlobServiceClient blobServiceClient;

	public void uploadFiles(MultipartFile file) throws IOException {
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("vishalcontainer");
		BlobClient blobClient = containerClient.getBlobClient(file.getOriginalFilename());
		blobClient.upload(file.getInputStream(), file.getSize());
	}

} 