package bpim;

import java.io.File;
import java.io.IOException;

/**
 * author Delgado
 */
public class Main {

	/**
	 * author Delgado
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		String type = "2003";
		main.importGoverment("01建筑清单", "01", type);
		main.importGoverment("02装饰清单", "02", type);
		main.importGoverment("03安装清单", "03", type);
		main.importGoverment("04市政清单", "04", type);
		main.importGoverment("05园林清单", "05", type);
		main.importGoverment("F人防清单", "人防", type);
		main.importGoverment("y冶金清单", "冶金", type);
		type = "2008";
		main.importGoverment("清单08/01建筑清单", "01", type);
		main.importGoverment("清单08/02装饰清单", "02", type);
		main.importGoverment("清单08/03安装清单", "03", type);
		main.importGoverment("清单08/04市政清单", "04", type);
		main.importGoverment("清单08/05园林清单", "05", type);
		main.importGoverment("清单08/06矿山清单", "06", type);
		
	}

	public void importGoverment(String folderIndex, String level1, String type) {
		String folderPath = String.valueOf(folderIndex) + "/";
		File file = new File(folderPath);
		File[] subFile = file.listFiles();
		ThreadImport tr = new ThreadImport();
		for (int i = 0; i < subFile.length; i++) {
			String fileName = subFile[i].getName();
			if("2008".equals(type)){
				tr.run2008(folderPath + fileName, level1, type);
			}else{
				tr.run(folderPath + fileName, level1, type);
			}
			
		}
	}
}
