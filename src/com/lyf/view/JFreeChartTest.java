package com.lyf.view;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest
{
    public static void main(String[] args)
    {
        DefaultPieDataset dpd=new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
        JFreeChart chart=ChartFactory.createPieChart("ĳ��˾��Ա��֯����ͼ",dpd,true,true,false); 
        //���Բ�����API�ĵ�,��һ�������Ǳ��⣬�ڶ���������һ�����ݼ���������������ʾ�Ƿ���ʾLegend�����ĸ�������ʾ�Ƿ���ʾ��ʾ�������������ʾͼ���Ƿ����URL
        Font titleFont = new Font("����", Font.BOLD, 20);
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(titleFont);// Ϊ��������������
          
        Font plotFont = new Font("����", Font.PLAIN, 16);  
        PiePlot plot = (PiePlot) chart.getPlot();  
        plot.setLabelFont(plotFont); // Ϊ��ͼԪ������������

        Font LegendFont = new Font("����", Font.PLAIN, 18);
        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(LegendFont);// Ϊͼ��˵����������
        dpd.setValue("����", 25);  //��������
        dpd.setValue("�г���Ա", 25);
        dpd.setValue("������Ա", 45);
        dpd.setValue("������Ա", 10);
        ChartFrame chartFrame=new ChartFrame("ĳ��˾��Ա��֯����ͼ",chart);
        //chartҪ����Java��������У�ChartFrame�̳���java��Jframe�ࡣ�õ�һ�������������Ƿ��ڴ������Ͻǵģ��������м�ı��⡣
        chartFrame.pack(); //�Ժ��ʵĴ�Сչ��ͼ��
        chartFrame.setVisible(true);//ͼ���Ƿ�ɼ�
        
    }
}