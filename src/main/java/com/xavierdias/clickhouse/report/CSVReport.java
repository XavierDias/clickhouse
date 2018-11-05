package com.xavierdias.clickhouse.report;

import java.util.List;
import java.util.Map;

public class CSVReport extends AbstractReport {
    private static final String SAMPLE_CSV_FILE = "./sample.csv";

    public String titulo = "Relatório";

    public CSVReport(String titulo) {
        this.titulo = titulo;
    }

    @Override
    protected String header() {
        return titulo + "\n";
    }

    @Override
    protected String detail(List<ToMapInterface> itens) {
        String report = "";
        Map row;

        for (ToMapInterface item : itens) {
            row = item.toMap();

            for (Object field : row.entrySet()) report += field.toString() + "; ";

            report += "\n";
        }

        return report;
    }

    @Override
    protected String footer() {
        String report = "totais\n";

        return report;
    }
}
