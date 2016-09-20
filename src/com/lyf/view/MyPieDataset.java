package com.lyf.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;

public class MyPieDataset {
	JFreeChart chart;
	public MyPieDataset(Data[] data){
		  {
		    }
	}
	   public MyPieDataset() {
		// TODO Auto-generated constructor stub
	}	
	public PieDataset createDataset(Data[] data) {
		
		   DefaultPieDataset dataset = new DefaultPieDataset();
		   for(int i=0;i<data.length;i++){
			   dataset .setValue(data[i].getName(),new Double(data[i].getData()));
		   }
	        return dataset;        
	    }
	   public JFreeChart createChart(PieDataset dataset) {
	         
	        chart = ChartFactory.createPieChart3D(
	            "",  // chart title
	            dataset,             // data
	            false,               // include legend
	            true,
	            true
	        );
	        
	        chart.setBackgroundPaint(new Color(89,194,230));
	        chart.setBorderVisible(false);
	        
	        PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setSectionOutlinesVisible(true);
//	        plot.setToolTipGenerator(new StandardPieToolTipGenerator());
	        
	        plot.setCircular(true);
	        plot.setBackgroundPaint(new Color(89,194,230));
	        plot.setOutlinePaint(new Color(89,194,230));
	        
	        LegendTitle legendTitle = new LegendTitle(plot);//����ͼ��
	        legendTitle.setPosition(RectangleEdge.RIGHT);  //����ͼ����λ��
	        legendTitle.setBorder(1, 1, 1, 1);
	        legendTitle.setItemFont(new Font("����", Font.PLAIN, 10)); 

//	        plot.setLabelGenerator(null);
	        plot.setLabelFont(new Font("����", Font.PLAIN, 10)); 
//	        plot.setLabelOutlinePaint(null);//��ǩ�߿���ɫ
	        plot.setLabelShadowPaint(null);
	        plot.setLabelBackgroundPaint(null);
	        plot.setForegroundAlpha(Float.parseFloat("0.7")); //ͼƬǰ����͸���ȣ�ͼƬ��ǰ����������ı�״ͼ��͸����Ϊ0.0~1.0
	        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1},{2})",
	        NumberFormat.getNumberInstance(),
	        new DecimalFormat("0.00%"))); //���ù������Ƿ���ʾ���ٷֱȣ�����ͬ��
	        
	        chart.addLegend(legendTitle);
	        
	         
	        return chart;
	         
	    }
	   public static PieDataset getDataset() {
		   
	        return getDataset();        
	    }
}

