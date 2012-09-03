package org.eredlab.g4.arm.service.impl;

import org.eredlab.g4.arm.service.MonitorService;
import org.eredlab.g4.arm.util.idgenerator.IDHelper;
import org.eredlab.g4.arm.vo.UserInfoVo;
import org.eredlab.g4.bmf.base.BizServiceImpl;
import org.eredlab.g4.ccl.datastructure.Dto;
import org.eredlab.g4.ccl.datastructure.impl.BaseDto;
import org.eredlab.g4.ccl.util.G4Constants;

/**
 * 系统监控业务接口
 * 
 * @author XiongChun
 * @since 2010-09-13
 */
public class MonitorServiceImpl extends BizServiceImpl implements MonitorService {

	/**
	 * 保存一个HTTP会话
	 * 
	 * @param userInfo
	 */
	public void saveHttpSession(UserInfoVo userInfo) {
		g4Dao.insert("Monitor.saveHttpSession", userInfo);
	}

	/**
	 * 删除一个托管的会话连接
	 * 
	 * @param pSessionID
	 */
	public void deleteHttpSession(Dto dto) {
		g4Dao.delete("Monitor.deleteHttpSession", dto);
	}

	/**
	 * 创建一个事件
	 * 
	 * @param inDto
	 */
	public void saveEvent(Dto dto) {
		String eventid = IDHelper.getEventID();
		dto.put("eventid", eventid);
		g4Dao.insert("Monitor.saveEvent", dto);
	}

	/**
	 * 删除事件
	 * 
	 * @param inDto
	 */
	public Dto deleteEvent(Dto inDto) {
		if (inDto.getAsString("type").equalsIgnoreCase("reset")) {
			g4Dao.delete("Monitor.deleteEvent");
		} else {
			String[] checked = inDto.getAsString("strChecked").split(",");
			Dto dto = new BaseDto();
			for (int i = 0; i < checked.length; i++) {
				dto.put("eventid", checked[i]);
				g4Dao.delete("Monitor.deleteEvent", dto);
			}
		}
		return null;
	}

	/**
	 * 删除SpringBean监控记录
	 * 
	 * @param inDto
	 */
	public Dto deleteMonitorData(Dto inDto) {
		if (inDto.getAsString("type").equalsIgnoreCase("reset")) {
			g4Dao.delete("Monitor.deleteExceptionRecord");
		} else {
			String[] checked = inDto.getAsString("strChecked").split(",");
			Dto dto = new BaseDto();
			for (int i = 0; i < checked.length; i++) {
				dto.put("exceptionid", checked[i]);
				g4Dao.delete("Monitor.deleteExceptionRecord", dto);
			}
		}
		return null;
	}
	
	/**
	 * 删除JDBC监控记录
	 * 
	 * @param inDto
	 */
	public Dto deleteJDBCMonitorData(Dto inDto) {
		if (inDto.getAsString("type").equalsIgnoreCase("reset")) {
			g4Dao.delete("Monitor.deleteJdbcMonitorData");
		} else {
			String[] checked = inDto.getAsString("strChecked").split(",");
			Dto dto = new BaseDto();
			for (int i = 0; i < checked.length; i++) {
				dto.put("monitorid", checked[i]);
				g4Dao.delete("Monitor.deleteJdbcMonitorData", dto);
			}
		}
		return null;
	}

}
