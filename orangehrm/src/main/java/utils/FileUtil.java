package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Reporter;

import common.SeleniumTest;

public class FileUtil {

	/**
	 * To delete the directory
	 * @param test
	 * @param folderPath
	 */
	
	public static void deleteDirectory(SeleniumTest test, String folderPath) {

		File file = new File(folderPath);
		try {

			FileUtils.deleteDirectory(file);
			Reporter.log("Deleted the folder");

		} catch (Exception e) {
			Reporter.log("Unable to delete the fodler");
		}

	}
	
	/**
	 * To create the directory
	 * @param test
	 * @param folderPath
	 */

	public static void createDirectory(SeleniumTest test, String folderPath) {

		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdir();
		} else {
			try {
				FileUtils.cleanDirectory(file);
			} catch (IOException e) {
				ReportUtil.fail(test, "Unable to create the folder " + folderPath);
			}
		}
	}
}
