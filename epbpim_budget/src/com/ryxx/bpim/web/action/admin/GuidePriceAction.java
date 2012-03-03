package com.ryxx.bpim.web.action.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.opensymphony.xwork2.ActionContext;
import com.ryxx.bpim.common.Constants;
import com.ryxx.bpim.entity.GuidePrice;
import com.ryxx.bpim.service.GuidePriceService;
import com.ryxx.bpim.web.action.ActionSupportBase;
import com.ryxx.util.page.PageTools;
import com.ryxx.util.request.ParamTools;

public class GuidePriceAction extends ActionSupportBase
{
    private static final long serialVersionUID = -1781372665512868821L;
    
    private static final Log LOG = LogFactory.getLog(GuidePriceAction.class);
    
    private GuidePrice guidePrice;
    
    private File uploadFile;
    
    private String msg = "";
    
    List<GuidePrice> datas = new ArrayList<GuidePrice>();
    
    private PageTools page;
    
    private GuidePriceService service;
    
    private String fileUrl = null;
    
    private String fileName = null;
    
    public String importGuidePrice()
    {
        try
        {
            msg = service.saveGuidePrice(guidePrice, uploadFile);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    public String searchGuidePrice()
    {
        try
        {
            if (null == guidePrice)
            {
                guidePrice = new GuidePrice();
            }
            
            int pageNo = ParamTools.getIntParameter(request, Constants.PARA_PAGE_NO, 1);
            int pageSize = ParamTools.getIntParameter(request, Constants.PARA_PAGE_SIZE, 0);
            PageTools page = new PageTools(pageNo, pageSize);
            guidePrice.setRowCount(pageNo);
            guidePrice.setPageSize(pageSize);
            datas = service.listGuidePrice(guidePrice, page);
            if (datas != null && datas.size() > 0)
            {
                this.page = page;
            }
            else
            {
                super.addNotFoundErrorMsg();
                return SUCCESS;
            }
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        return SUCCESS;
    }
    
    public String analyseGuidePrice(){
    	XYDataset dataset = this.createDateSet();//建立数据集
		//建立JFreeChart
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
			"价格分析曲线图", // title
			"Date", // x-axis label
			"Price", // y-axis label
			dataset, // data
			true, // create legend?
			true, // generate tooltips?
			false // generate URLs?
		);
		//设置JFreeChart的显示属性,对图形外部部分进行调整
		Paint p = new GradientPaint(0, 0, Color.white, 1000, 0, Color.white);
		chart.setBackgroundPaint(p);//设置曲线图背景色
		//设置字体大小，形状
		Font font = new Font("宋体", Font.BOLD, 16);
		TextTitle title = new TextTitle("价格分析曲线图", font);
		chart.setTitle(title);
		//副标题
		if(!StringUtils.isEmpty(guidePrice.getName())){
			TextTitle subtitle =
					new TextTitle(guidePrice.getName(), new Font("黑体", Font.BOLD, 12));
			chart.addSubtitle(subtitle);
		}
		chart.setTitle(title); //标题
		
		//设置图示标题字符
		//TimeSeries s1 = new TimeSeries("历史曲线", Day.class);该中文字符
		LegendTitle legengTitle = chart.getLegend();
		legengTitle.setItemFont(font);
		
		XYPlot plot = (XYPlot) chart.getPlot();//获取图形的画布
		plot.setBackgroundPaint(Color.lightGray);//设置网格背景色
		plot.setDomainGridlinePaint(Color.white);//设置网格竖线(Domain轴)颜色
		plot.setRangeGridlinePaint(Color.white);//设置网格横线颜色
		//plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//设置曲线图与xy轴的距离
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer)
		{
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			renderer.setShapesVisible(true);//设置曲线是否显示数据点
		}
		//设置Y轴
		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
		NumberFormat numFormater = NumberFormat.getNumberInstance();
		numFormater.setMinimumFractionDigits(2);
		numAxis.setNumberFormatOverride(numFormater);
		//设置提示信息
		StandardXYToolTipGenerator tipGenerator = new StandardXYToolTipGenerator(
		"历史信息{1} 16:00,{2})", new SimpleDateFormat("yyyy-MM"),numFormater);
		r.setToolTipGenerator(tipGenerator);
		//设置X轴（日期轴）
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM"));
		try
		{
			fileName = new Date().getTime()+".JPG";
			File file = new File(request.getRealPath("/")+ "temp/" + fileName);
			ChartUtilities.saveChartAsJPEG(file, chart, 900, 400);
			// Write the image map to the PrintWriter
			//ChartUtilities.writeImageMap(pw, fileName, info, false);
			fileUrl =  "../temp/" + fileName;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
    }
    
    /**
	* 建立生成图形所需的数据集
	* @return 返回数据集
	*/
	private XYDataset createDateSet()
	{
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		if(guidePrice!=null&&!StringUtils.isEmpty(guidePrice.getName())){
			dataset = service.getDateSet(guidePrice);
		}
		return dataset;
	}
    
    public String deleteGuidePrice()
    {
        try
        {
            msg = service.deleteGuidePrice(guidePrice);
        }
        catch (Exception e)
        {
            LOG.error(e);
            msg = "false";
        }
        return SUCCESS;
    }
    
    public GuidePrice getGuidePrice()
    {
        return guidePrice;
    }
    
    public void setGuidePrice(GuidePrice guidePrice)
    {
        this.guidePrice = guidePrice;
    }
    
    public File getUploadFile()
    {
        return uploadFile;
    }
    
    public void setUploadFile(File uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    public List<GuidePrice> getDatas()
    {
        return datas;
    }
    
    public void setDatas(List<GuidePrice> datas)
    {
        this.datas = datas;
    }
    
    public PageTools getPage()
    {
        return page;
    }
    
    public void setPage(PageTools page)
    {
        this.page = page;
    }
    
    public GuidePriceService getService()
    {
        return service;
    }
    
    public void setService(GuidePriceService service)
    {
        this.service = service;
    }

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
    
    
}