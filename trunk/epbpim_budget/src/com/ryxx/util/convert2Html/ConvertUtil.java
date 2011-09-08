package com.ryxx.util.convert2Html;

import java.io.File;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class ConvertUtil {

	static OpenOfficeConnection connection = null;

	public ConvertUtil() {
			
	}

	public void convert(String inputFilePath, String outputFilePath) {
		File inputFile = new File(inputFilePath);
		File outputFile = new File(outputFilePath);
		DocumentConverter converter = new OpenOfficeDocumentConverter(
				connection);
		converter.convert(inputFile, outputFile);
	}

	public static void main(String args[]) {
		connection = new SocketOpenOfficeConnection(8100);
		try {
			connection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConvertUtil convertUtil = new ConvertUtil();
		convertUtil.convert("C:/testFile/epbpim/咨询公司项目需求说明书.doc", "C:/test.html");
		connection.disconnect();
	}

}
