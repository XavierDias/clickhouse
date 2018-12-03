package com.xavierdias.clickhouse.report;

import java.util.List;

public abstract class AbstractReport {

    public static final String HEADER = "header";
    public static final String BODY = "body";
    public static final String FOOTER = "footer";

    public String generateReport(final List itens, final List<String> ordem) {
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
                default:
                    report = report + detail(itens);
                    break;
            }
        }

        return report;
    }

    abstract protected String header();

    abstract protected String detail(final List<ToMapInterface> itens);

    abstract protected String footer();
}
