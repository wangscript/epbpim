package org.eredlab.g4.arm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.eredlab.g4.arm.service.MonitorService;
import org.eredlab.g4.ccl.datastructure.Dto;
import org.eredlab.g4.ccl.datastructure.impl.BaseDto;
import org.eredlab.g4.ccl.util.G4Constants;
import org.eredlab.g4.ccl.util.G4Utils;
import org.eredlab.g4.rif.web.BaseAction;
import org.eredlab.g4.rif.web.CommonActionForm;

/**
 * 事件跟踪Action
 * 
 * @author XiongChun
 * @since 2010-09-12
 * @see BaseAction
 */
public class EventTrackAction extends BaseAction {
	
	private MonitorService monitorService = (MonitorService)super.getService("monitorService");
	
	/**
	 * 事件跟踪页面初始化
	 * 
	 * @param
	 * @return
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("eventTrackView");
	}
	
	/**
	 * 查询事件列表
	 * 
	 * @param
	 * @return
	 */
	public ActionForward queryEvents(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CommonActionForm aForm = (CommonActionForm)form;
		Dto dto = aForm.getParamAsDto(request);
		dto.put("ksrq", G4Utils.Date2String(dto.getAsDate("ksrq"), "yyyyMMdd000000"));
		dto.put("jsrq", G4Utils.Date2String(dto.getAsDate("jsrq"), "yyyyMMdd235959"));
		List eventList = g4Reader.queryForPage("Monitor.queryEventsByDto", dto);
		for (int i = 0; i < eventList.size(); i++) {
			Dto dto2 = (BaseDto)eventList.get(i);
			dto2.put("activetime", G4Utils.stringToDate(dto2.getAsString("activetime"), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"));
		}
		Integer totalCount = (Integer) g4Reader.queryForObject("Monitor.queryEventsByDtoForPageCount", dto);
		String jsonString = encodeList2PageJson(eventList, totalCount, G4Constants.FORMAT_DateTime);
		write(jsonString, response);
		return mapping.findForward(null);
	}
	
	/**
	 * 删除事件
	 * 
	 * @param
	 * @return
	 */
	public ActionForward deleteEvents(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CommonActionForm aForm = (CommonActionForm)form;
		Dto dto = aForm.getParamAsDto(request);
		monitorService.deleteEvent(dto);
		if (dto.getAsString("type").equalsIgnoreCase("reset"))
			setOkTipMsg("清空成功,所有事件已被清除!", response);
		else
			setOkTipMsg("数据删除成功!", response);
		return mapping.findForward(null);
	}
}
