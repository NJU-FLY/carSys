package com.lyf.view;

import java.awt.Font;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;

public class SetFont {
	public SetFont(JFreeChart chart){
	  
		Font titleFont = new Font("����", Font.BOLD, 20);  
      TextTitle textTitle = chart.getTitle();  
      textTitle.setFont(titleFont);// Ϊ��������������  
        
      Font plotFont = new Font("����", Font.PLAIN, 16);  
      PiePlot plot = (PiePlot) chart.getPlot();  
      plot.setLabelFont(plotFont); // Ϊ��ͼԪ������������  
        
      Font LegendFont = new Font("����", Font.PLAIN, 18);  
      LegendTitle legend = chart.getLegend(0);  
      legend.setItemFont(LegendFont);// Ϊͼ��˵���������� 
	}
}
