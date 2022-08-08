package Grafic;

import model.Ereignis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class LineChartWithCategoryDatasetExample extends JFrame {
     private List<Ereignis> history;
     private String nameArtikel;
    public LineChartWithCategoryDatasetExample(List<Ereignis> history, String nameArtikel) {
        super("Line Chart Example with JFreechart");
         this.history=history;
         this.nameArtikel=nameArtikel;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public LineChartWithCategoryDatasetExample() {
        super("Line Chart Example with JFreechart");

        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createChartPanel() {
        String chartTitle = "Artikel History";
        String categoryAxisLabel = "Time";
        String valueAxisLabel = "Anzahl";

        CategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);

        return new ChartPanel(chart);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = this.nameArtikel;
        for (Ereignis ereignis:history){
            dataset.addValue(ereignis.getArtikel().getArtikelBestand(), series1, (Date.from(ereignis.getDatum())));
        }
        return dataset;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LineChartWithCategoryDatasetExample().setVisible(true);
            }
        });
    }
}