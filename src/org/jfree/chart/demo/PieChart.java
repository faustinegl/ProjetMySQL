package org.jfree.chart.demo;

import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;



    public class PieChart extends ApplicationFrame {



        public PieChart(String title) {
            super(title);
            final PieDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            setContentPane(chartPanel);
        }




        private static PieDataset createDataset() {
            DefaultPieDataset dataset1 = new DefaultPieDataset();
            dataset1.setValue("Mathematiques", new Double(23.2));
            dataset1.setValue("Physique", new Double(20.0));
            dataset1.setValue("C++", new Double(21.5));
            dataset1.setValue("Java", new Double(17.5));
            dataset1.setValue("Electronique", new Double(11.0));
            dataset1.setValue("Geometrie", new Double(19.4));
            return dataset1;
        }


        private static JFreeChart createChart(PieDataset dataset) {

            JFreeChart chart = ChartFactory.createPieChart(
                    "Répartition des Cours",  // chart title
                     dataset,             // data
                    true,               // include legend
                    true,
                    false
            );

            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
            plot.setNoDataMessage("No data available");
            plot.setCircular(false);
            plot.setLabelGap(0.02);
            return chart;

        }






        public static void main(String[] args) {

            org.jfree.chart.demo.PieChart demo = new org.jfree.chart.demo.PieChart("Répartition des Cours");
            demo.pack();
           UIUtils.centerFrameOnScreen(demo);
            demo.setVisible(true);

        }

    }
