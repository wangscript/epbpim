package bpim;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * author Delgado
 */
public class ThreadImport{

	private static final int version2003 = 2003;
	private static final int version2007 = 2007;
	private static int version = version2003;
	private String msg = "";

	public void run(String fileName, String level1, String type) {

		Row row;
		int projectNumIndex = 1;
		String projectNumContent = "";
		String projectNameContent = "";
		String projectNameFeatureContent = "";
		String unitContent = "";
		Double amountContent = 0.00;
		String detailContent = "";
		String commentsContent = "";
		int level2Index = fileName.lastIndexOf("/");
		String level2 = fileName.substring(level2Index+1,level2Index+5);
		File excelFile = new File(fileName);
		System.out.println(fileName);
		Sheet sheet = null;
		try {
			sheet = getWb(excelFile, fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int count_row = sheet.getLastRowNum();
		String className = "";
		String classNum = "";
		List<GovernmentInventory> list = new ArrayList<GovernmentInventory>();
		for (int j = 0; j <= count_row; j++) {
			try {
				row = sheet.getRow(j);
				if (row.getCell(projectNumIndex)==null||"项目编码".equals(row.getCell(projectNumIndex)
						.getStringCellValue())) {
					continue;
				}
				if ("".equals(row.getCell(9).getStringCellValue())
						&& (!isBlank(row.getCell(1)))
						&& (!isBlank(row.getCell(2)))) {
					classNum = row.getCell(1).getStringCellValue();
					className = row.getCell(2).getStringCellValue();
					continue;
				}
				if (isBlank(row.getCell(9))) {
					continue;
				}
				GovernmentInventory data = new GovernmentInventory();
				projectNumContent = row.getCell(1).getStringCellValue();
				projectNameContent = row.getCell(2).getStringCellValue();
				projectNameFeatureContent = row.getCell(3).getStringCellValue();
				unitContent = row.getCell(5).getStringCellValue();
				amountContent = Double.valueOf(row.getCell(7)
						.getStringCellValue());
				detailContent = row.getCell(9).getStringCellValue();
				commentsContent = row.getCell(10).getStringCellValue();
				data.setType(type);
				data.setProjectClass1Num(level1);
				data.setProjectClass2Num(level2);
				data.setProjectName(className);
				data.setProjectNum(classNum);
				data.setAmount(amountContent);
				data.setComments(commentsContent);
				data.setDetail(detailContent);
				data.setProjectName(projectNameContent);
				data.setProjectNameFeature(projectNameFeatureContent);
				data.setProjectNum(projectNumContent.substring(0, projectNumContent.length()-3));
				data.setUnit(unitContent);
				list.add(data);
			} catch (Exception e) {
				msg = "文件" + fileName + "第" + (j + 1) + "行出错";
				System.out.println(msg);
			}
		}
		int i=0;
		if (list.size() > 0) {
			try {
				DBConnUtil.getConnection();
				DBConnUtil.startTransaction(false);
				PreparedStatement stat = DBConnUtil
				.getPrepareStatement("INSERT INTO GOVERNMENT_INVENTORY(GOVERNMENT_INVENTORY_TYPE,PROJECT_NUM,"
						+ "PROJECT_NAME,PROJECT_NAME_FEATURE,UNIT,AMOUNT,DETAIL,COMMENTS,PROJECT_CLASS_LEVEL_1_NUM," +
								"PROJECT_CLASS_LEVEL_2_NUM) " +
								"VALUES(?,?,?,?,?,?,?,?,?,?)");
				for (GovernmentInventory data : list) {
					stat.setString(1, data.getType());
					stat.setString(2, data.getProjectNum());
					stat.setString(3, data.getProjectName());
					stat.setString(4, data.getProjectNameFeature());
					stat.setString(5, data.getUnit());
					stat.setDouble(6, data.getAmount());
					stat.setString(7, data.getDetail());
					stat.setString(8, data.getComments());
					stat.setString(9, data.getProjectClass1Num());
					stat.setString(10, data.getProjectClass2Num());
					stat.execute();
					i++;
					System.out.println(i);
				}
				DBConnUtil.close();
			} catch (SQLException e) {
				System.out.println(fileName+i+e);
			}

		}

	}
	
	
	public void run2008(String fileName, String level1, String type) {

		Row row;
		int projectNumIndex = 1;
		String projectNumContent = "";
		String projectNameContent = "";
		String projectNameFeatureContent = "";
		String unitContent = "";
		Double amountContent = 0.00;
		String detailContent = "";
		String commentsContent = "";
		int level2Index = fileName.lastIndexOf("/");
		String level2 = fileName.substring(level2Index+1,level2Index+5);
		File excelFile = new File(fileName);
		System.out.println(fileName);
		Sheet sheet = null;
		try {
			sheet = getWb(excelFile, fileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int count_row = sheet.getLastRowNum();
		String className = "";
		List<GovernmentInventory> list = new ArrayList<GovernmentInventory>();
		for (int j = 0; j <= count_row; j++) {
			try {
				row = sheet.getRow(j);
				if (row.getCell(projectNumIndex)==null||"项目编码".equals(row.getCell(projectNumIndex)
						.getStringCellValue())||"".equals(row.getCell(projectNumIndex)
								.getStringCellValue())) {
					continue;
				}
				if ("".equals(row.getCell(0).getStringCellValue())
						&& (!isBlank(row.getCell(1)))) {
					className = row.getCell(1).getStringCellValue();
					continue;
				}
				if (isBlank(row.getCell(9))) {
					continue;
				}
				GovernmentInventory data = new GovernmentInventory();
				projectNumContent = row.getCell(1).getStringCellValue();
				projectNameContent = row.getCell(2).getStringCellValue();
				projectNameFeatureContent = row.getCell(3).getStringCellValue();
				unitContent = row.getCell(6).getStringCellValue();
				amountContent = 0.00;
				detailContent = row.getCell(4).getStringCellValue();
				commentsContent = "";
				data.setType(type);
				data.setProjectClass1Num(level1);
				data.setProjectClass2Num(level2);
				data.setProjectName(className);
				data.setProjectNum(level2);
				data.setAmount(amountContent);
				data.setComments(commentsContent);
				data.setDetail(detailContent);
				data.setProjectName(projectNameContent);
				data.setProjectNameFeature(projectNameFeatureContent);
				data.setProjectNum(projectNumContent.substring(0, projectNumContent.length()-3));
				data.setUnit(unitContent);
				list.add(data);
			} catch (Exception e) {
				msg = "文件" + fileName + "第" + (j + 1) + "行出错";
				System.out.println(msg);
			}
		}
		int i=0;
		if (list.size() > 0) {
			try {
				DBConnUtil.getConnection();
				DBConnUtil.startTransaction(false);
				PreparedStatement stat = DBConnUtil
				.getPrepareStatement("INSERT INTO GOVERNMENT_INVENTORY(GOVERNMENT_INVENTORY_TYPE,PROJECT_NUM,"
						+ "PROJECT_NAME,PROJECT_NAME_FEATURE,UNIT,AMOUNT,DETAIL,COMMENTS,PROJECT_CLASS_LEVEL_1_NUM," +
								"PROJECT_CLASS_LEVEL_2_NUM) " +
								"VALUES(?,?,?,?,?,?,?,?,?,?)");
				for (GovernmentInventory data : list) {
					stat.setString(1, data.getType());
					stat.setString(2, data.getProjectNum());
					stat.setString(3, data.getProjectName());
					stat.setString(4, data.getProjectNameFeature());
					stat.setString(5, data.getUnit());
					stat.setDouble(6, data.getAmount());
					stat.setString(7, data.getDetail());
					stat.setString(8, data.getComments());
					stat.setString(9, data.getProjectClass1Num());
					stat.setString(10, data.getProjectClass2Num());
					stat.execute();
					i++;
					System.out.println(i);
				}
				DBConnUtil.close();
			} catch (SQLException e) {
				System.out.println(fileName+i+e);
			}

		}

	}

	private Hashtable<String, Integer> getTableTitle(Sheet sheet,
			Set<String> set) {
		Row row;
		Cell cell;
		String title = "";
		Hashtable<String, Integer> titleMappings = new Hashtable<String, Integer>();
		try {
			row = sheet.getRow(3);
			int cellCount = row.getLastCellNum();
			for (int i = 0; i <= cellCount; i++) {
				cell = row.getCell(i);
				if (null != cell && cell.getCellType() == cell.CELL_TYPE_STRING) {
					title = trim(cell.getStringCellValue());
					if (set.contains(title)) {
						titleMappings.put(title, i);
					}
				}
			}
		} catch (Exception e) {
			msg = "解析表头失败，请检查第四行是否是表头";
		}
		return titleMappings;
	}

	private String getClassFromName(String fileName) {
		int index1 = fileName.indexOf("/");
		int index2 = fileName.indexOf("(");
		return fileName.substring(index1 + 1, index2);
	}

	private Sheet getWb(File peopleData, String fileName) throws IOException {
		Workbook wb = null;
		if (fileName.endsWith(".xls"))
			version = version2003;
		else if (fileName.endsWith(".xlsx"))
			version = version2007;
		InputStream stream = null;
		if (version == version2003) {
			stream = new FileInputStream(peopleData);
			wb = (Workbook) new HSSFWorkbook(stream);
		} else if (version == version2007) {
			wb = (Workbook) new XSSFWorkbook(peopleData.getAbsolutePath());
		}
		return wb.getSheetAt(0);
	}

	public static String trim(String Str) {
		String newstr = Str.replaceAll("　", "  ");
		newstr = newstr.trim();
		newstr = newstr.replaceAll("  ", "　");
		return newstr;
	}

	private Boolean isBlank(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_BLANK;
	}

	private Boolean isString(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_STRING;
	}

	private Boolean isNumber(Cell cell) {
		return cell.getCellType() == cell.CELL_TYPE_NUMERIC;
	}
}
