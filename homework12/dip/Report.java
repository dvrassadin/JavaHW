package homework12.dip;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<ReportItem> items; // Отчетные данные
    private ReportOutputter outputter;

    public Report(ReportOutputter outputter) {
        this.outputter = outputter;
    }

    // расчет отчетных данных
    public void calculate() {
        items = new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float) 5));
        items.add(new ReportItem("Second", (float) 6));
    }

    public void output() {
        this.outputter.output(items);
    }

}
