package com.acme.testing.junit5.core.file;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TempDirTest {
	
	private String FILE_NAME = "temp.txt";
	private String TEXT_VALUE = "TEST!";
	
	@TempDir
	static Path classTempDir;
	
	@TempDir
	static File classTempDirAsFile;
	
	@Test
	public void shouldBeCreateTempDirWithPath() throws IOException {
		System.out.println("[@Test] : shouldBeCreateTempDirWithPath");
		
		File file = classTempDir.resolve(FILE_NAME).toFile();
		FileUtils.write(file,TEXT_VALUE, StandardCharsets.ISO_8859_1, true);
		
		assertNotNull(file);
		assertEquals(TEXT_VALUE, FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
	
	@Test
	public void shouldBeCreateTempDirWithFile() throws IOException {
		System.out.println("[@Test] : shouldBeCreateTempDirWithFile");
		
		File file = new File(classTempDirAsFile, FILE_NAME);
		FileUtils.write(file, TEXT_VALUE, StandardCharsets.ISO_8859_1, true);
		
		assertNotNull(file);
		assertEquals(TEXT_VALUE, FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
	
	@Test
	public void shouldBeCreateTempDirWithArgumentPath(@TempDir Path argumentTempDir) throws IOException {
		System.out.println("[@Test] : shouldBeCreateTempDirWithArgumentPath");
		
		File file = argumentTempDir.resolve(FILE_NAME).toFile();
		FileUtils.write(file, TEXT_VALUE, StandardCharsets.ISO_8859_1, true);
		
		assertNotNull(file);
		assertEquals(TEXT_VALUE, FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}

}
