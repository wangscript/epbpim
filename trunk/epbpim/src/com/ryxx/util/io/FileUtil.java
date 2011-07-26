/**
 * Copyright (c) coship 2007
 * @author: ives
 * @date: 2007-8-28 ����02:51:13
 * @version: 1.0
 */
package com.ryxx.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ives
 * 
 */
public class FileUtil {
	private static final int BUFFER_SIZE = 16 * 1024;

	public static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(File file) {
		try {
			if (file.exists()) {
				System.out.println(file.getAbsolutePath());
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(String filename) {
		File file = new File(filename);
		delete(file);
	}
}