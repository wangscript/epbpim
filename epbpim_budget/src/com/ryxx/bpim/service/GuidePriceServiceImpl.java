package com.ryxx.bpim.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ryxx.bpim.dao.GuidePriceDAO;
import com.ryxx.bpim.entity.GuidePrice;
import com.ryxx.util.page.PageTools;

/**
 * author Delgado
 */
public class GuidePriceServiceImpl extends
		AbstractService<GuidePrice, GuidePriceDAO, Long> implements
		GuidePriceService {
	public String saveGuidePrice(GuidePrice guidePrice, File uploadfile)
			throws ParseException, SQLException, IOException {
		List<GuidePrice> guidePriceList = parseGuidePriceFile(uploadfile);

		for (GuidePrice guidePricee : guidePriceList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date periodicalDate = sdf.parse(guidePrice.getGuidePriceDatePage());
			guidePricee.setGuidePriceDate(new Timestamp(periodicalDate
					.getTime()));

			guidePricee.setUploadDate(new Timestamp(new Date().getTime()));

			getDao().saveGuidePrice(guidePricee);
		}

		return "导入成功";
	}

	public void deleteGuidePrice(GuidePrice guidePrice) throws ParseException,
			SQLException {
		getDao().deleteGuidePrice(guidePrice);
	}

	public List<GuidePrice> listGuidePrice(GuidePrice condition, PageTools page)
			throws SQLException {
		if (page != null) {
			if (page.getRecordCount() == 0) {
				int count = getDao().getRowCount(condition);
				page.setRecordCount(count);
			}
			condition.setStartRow(page.getPageStartRow());
			condition.setPageSize(page.getPageSize());
		}
		return getDao().listGuidePrice(condition);
	}

	/*
	 * 解析信息价文件
	 */
	private List<GuidePrice> parseGuidePriceFile(File uploadfile)
			throws IOException {
		List<GuidePrice> resultList = new ArrayList<GuidePrice>();
		Sheet sheet = getWb(uploadfile, uploadfile.getName());
		Row row = null;
		String value;
		int countRow = sheet.getLastRowNum();
		for (int i = 1; i <= countRow; i++) {
			value = row.getCell(0).getStringCellValue();
			if (null == value && "".equals(value)) {
				break;
			}
			row = sheet.getRow(i);
			GuidePrice data = new GuidePrice();
			data.setCode(row.getCell(0).getStringCellValue());
			data.setName(row.getCell(1).getStringCellValue());
			data.setUnit(row.getCell(2).getStringCellValue());
			data.setPrice(row.getCell(3).getNumericCellValue());
			data.setUnName(row.getCell(4).getStringCellValue());
			data.setTag(row.getCell(5).getStringCellValue());
			resultList.add(data);
		}

		return resultList;
	}

	private static final int version2003 = 2003;
	private static final int version2007 = 2007;
	private static int version = version2003;

	private Sheet getWb(File file, String fileName) throws IOException {
		Workbook wb = null;
		if (fileName.endsWith("xls"))
			version = version2003;
		else if (fileName.endsWith("xlsx"))
			version = version2007;
		InputStream stream = null;
		if (version == version2003) {
			stream = new FileInputStream(file);
			wb = (Workbook) new HSSFWorkbook(stream);
		} else if (version == version2007) {
			wb = (Workbook) new XSSFWorkbook(file.getAbsolutePath());
		}
		return wb.getSheetAt(0);
	}
}
