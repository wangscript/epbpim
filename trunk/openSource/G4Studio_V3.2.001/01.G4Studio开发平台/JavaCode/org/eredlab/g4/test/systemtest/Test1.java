package org.eredlab.g4.test.systemtest;

import java.util.List;

import org.eredlab.g4.bmf.base.Reader;
import org.eredlab.g4.bmf.util.SpringBeanLoader;
import org.eredlab.g4.ccl.datastructure.Dto;
import org.eredlab.g4.ccl.datastructure.impl.BaseDto;
import org.eredlab.g4.ccl.json.JsonHelper;
import org.eredlab.g4.ccl.util.G4Constants;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reader g4Reader = (Reader) SpringBeanLoader.getSpringBean("g4Reader");
		Dto qDto = new BaseDto();
		qDto.put("ksrq", "20120815000000");
		List list = g4Reader.queryForList("Monitor.queryExceptionRecordsByDto", qDto);
		Integer totalCount = (Integer)g4Reader.queryForObject("Monitor.queryExceptionRecordsByDtoForPageCount", qDto);
		for (int i = 0; i < list.size(); i++) {
			Dto dto = (BaseDto)list.get(i);
			System.out.println(dto);
		}
		System.out.println("****************************************");
		String jsonString = JsonHelper.encodeList2PageJson(list, totalCount, G4Constants.FORMAT_DateTime);
		System.out.println(jsonString);
	}
}
