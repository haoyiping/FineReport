package com.fr.plugin.chart.radar;

import com.fr.chart.chartattr.Plot;
import com.fr.design.beans.BasicBeanPane;
import com.fr.design.chart.fun.impl.AbstractIndependentChartUI;
import com.fr.design.condition.ConditionAttributesPane;
import com.fr.design.gui.frpane.AttributeChangeListener;
import com.fr.design.mainframe.chart.AbstractChartAttrPane;
import com.fr.design.mainframe.chart.gui.ChartDataPane;
import com.fr.design.mainframe.chart.gui.ChartStylePane;
import com.fr.design.mainframe.chart.gui.data.report.AbstractReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.report.CategoryPlotReportDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.AbstractTableDataContentPane;
import com.fr.design.mainframe.chart.gui.data.table.CategoryPlotTableDataContentPane;
import com.fr.design.mainframe.chart.gui.type.AbstractChartTypePane;
import com.fr.plugin.chart.designer.other.VanChartOtherPane;
import com.fr.plugin.chart.designer.style.VanChartStylePane;

/**
 * Created by Mitisky on 15/12/28.
 */
public class RadarIndependentVanChartInterface extends AbstractIndependentChartUI {
    @Override
    public String getIconPath() {
        return "com/fr/design/images/form/toolbar/ChartF-Radar.png";
    }

    @Override
    public AbstractChartTypePane getPlotTypePane() {
        return new VanChartRadarPlotPane();
    }

    public AbstractTableDataContentPane getTableDataSourcePane(Plot plot, ChartDataPane parent){
        return new CategoryPlotTableDataContentPane(parent);
    }

    public AbstractReportDataContentPane getReportDataSourcePane(Plot plot, ChartDataPane parent){
        return new CategoryPlotReportDataContentPane(parent);
    }

    public BasicBeanPane<Plot> getPlotSeriesPane(ChartStylePane parent, Plot plot){
        return new VanChartRadarSeriesPane(parent, plot);
    }

    public ConditionAttributesPane getPlotConditionPane(Plot plot){
        if(plot instanceof VanChartRadarPlot && ((VanChartRadarPlot)plot).isStackChart()){
            return new VanChartStackRadarConditionPane();
        }
        return new VanChartRadarConditionPane();
    }

    /**
     * ͼ�������Խ�������
     * @return ���Խ���
     */
    public AbstractChartAttrPane[] getAttrPaneArray(AttributeChangeListener listener){
        VanChartStylePane stylePane = new VanChartStylePane(listener);
        VanChartOtherPane otherPane = new VanChartOtherPane(listener);
        return new AbstractChartAttrPane[]{stylePane, otherPane};
    }

    /**
     * �Ƿ�ʹ��Ĭ�ϵĽ��棬Ϊ�˱�����������л�
     * @return �Ƿ�ʹ��Ĭ�ϵĽ���
     */
    public boolean isUseDefaultPane(){
        return false;
    }
}