package org.jfree.chart.demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;


    public class BarChart extends ApplicationFrame {

        public BarChart(final String title) {

            super(title);

            final CategoryDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            setContentPane(chartPanel);

        }


        private CategoryDataset createDataset() {

            // row keys...
            final String salle1 = "Salle 1";
            final String salle2 = "Salle 2";


            // column keys...
            final String lyon = "Lyon";
            final String paris = "Paris";
            final String londres = "Londres";


            // create the dataset...
            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(30.0, salle1, lyon);
            dataset.addValue(30.0, salle1, paris);
            dataset.addValue(30.0, salle1, londres);


            dataset.addValue(32.0, salle2, lyon);
            dataset.addValue(32.0, salle2, paris);
            dataset.addValue(32.0, salle2, londres);


            return dataset;

        }


        private JFreeChart createChart(final CategoryDataset dataset) {

            // create the chart...
            final JFreeChart chart = ChartFactory.createBarChart(
                    "Capacité des salles ",         // chart title
                    "Site",               // domain axis label
                    "Capacity",                  // range axis label
                    dataset,                  // data
                    PlotOrientation.VERTICAL, // orientation
                    true,                     // include legend
                    true,                     // tooltips?
                    false                     // URLs?
            );


            chart.setBackgroundPaint(Color.white);


            return chart;

        }



       public static void main(final String[] args) {

           final BarChart capacite_salles = new BarChart("Capacité salles");
           capacite_salles.pack();
           UIUtils.centerFrameOnScreen(capacite_salles);
           capacite_salles.setVisible(true);

        }

    }
