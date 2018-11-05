package com.xavierdias.clickhouse.report;

import java.util.List;
import java.util.Map;

public abstract class AbstractReport {

    public static final String HEADER = "header";
    public static final String BODY = "body";
    public static final String FOOTER = "footer";

    public String generateReport(List itens, List<String> ordem) {
        String report = "";

        for (String element : ordem) {
            switch (element) {
                case HEADER:
                    report = report + header();
                    break;
                case BODY:
                    report = report + detail(itens);
                    break;
                case FOOTER:
                    report = report + footer();
                    break;
            }
        }

        return report;
    }

    abstract protected String header();

    abstract protected String detail(List<ToMapInterface> itens);

    abstract protected String footer();
}
