package com.acme.testing.junit.core.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderTest {
	
	private String TEMPORARY_FILE_NAME = "test.txt";
	private String TEXT_VALUE = "TEST!";
	
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	private File temporaryFileTest;
	
	private String temporaryFileTestFullPath;
	private String temporaryFileTestName;
	private String temporaryFileTestPah;
	
	@Test
	public void shouldBeCreateTempDirWithPath() throws IOException {
		System.out.println("[@Test] : shouldBeCreateTempDirWithPath");
		
		temporaryFileTest = temporaryFolder.newFile(TEMPORARY_FILE_NAME);
		
		temporaryFileTestFullPath = temporaryFileTest.getPath();
		temporaryFileTestName = temporaryFileTestFullPath.substring(temporaryFileTestFullPath.lastIndexOf(File.separator)+1);
		temporaryFileTestPah = temporaryFileTestFullPath.substring(0,temporaryFileTestFullPath.lastIndexOf(File.separator)+1);

		FileUtils.write(temporaryFileTest, TEXT_VALUE, StandardCharsets.ISO_8859_1, true);
		
		assertNotNull(temporaryFileTest);
		assertEquals(TEXT_VALUE, FileUtils.readFileToString(temporaryFileTest, StandardCharsets.ISO_8859_1));
	}

}
