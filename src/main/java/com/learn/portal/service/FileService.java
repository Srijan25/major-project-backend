package com.learn.portal.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {

	String uploadImage(MultipartFile file) throws IOException;
	
	InputStream getResource (String fileName) throws FileNotFoundException;
	
	void deleteImage (String fileName);
	
	
	String uploadNote(MultipartFile file) throws IOException;
	InputStream getNote (String fileName) throws FileNotFoundException;
}