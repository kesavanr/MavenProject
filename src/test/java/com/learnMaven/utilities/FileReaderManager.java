package com.learnMaven.utilities;

import java.io.IOException;

public class FileReaderManager {
	private FileReaderManager() {
		// TODO Auto-generated constructor stub
	}
	public static FileReaderManager getInstance() {
		FileReaderManager frm = new FileReaderManager();
		return frm;
	}
	public ConfigurationReader getCrInstance() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}
}
