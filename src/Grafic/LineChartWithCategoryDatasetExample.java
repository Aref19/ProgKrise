package Grafic;

import model.Ereignis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class LineChartWithCategoryDatasetExample extends JFrame {
    private List<Ereignis> history;
    private String name;
    JButton schliis;


    public LineChartWithCategoryDatasetExample(List<Ereignis> history, String name) {
        super("Line Chart Example with JFreechart");
        this.history = history;
        this.name = name;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        schliis = new JButton("scliss");
        schliis.setBounds(50, 1000, 300, 300);
        schliis.addActionListener(schliss());
        chartPanel.add(schliis);
    }

    private ActionListener schliss() {
        return e -> {
            this.dispose();
        };

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
        String series1 = name;
        for (Ereignis ereignis : history) {
            Date year = Date.from(ereignis.getDatum());
            if (ereignis.getArtikel().getArtikelBezeichnung().equals(name)) {
                dataset.addValue(ereignis.getArtikel().getArtikelBestand(), series1,
                        date(year));
            }
        }
        return dataset;
    }

    private String date(Date dat1e){
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
         String date= format.format(dat1e);
        return date;
    }


}