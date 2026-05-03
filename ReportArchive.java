public class ReportArchive{
    private ReportList allReports;
    private ReportTreeNode dataTreeRoot;
    private ReportBrowser browser;

    public void addReport(Report r){
        this.allReports.addFront(r);
        browser.insertBST(r);
    }

    public void insertBST(ReportTreeNode node, Report r){

    }

    private Comparable<T> compareDate(Report r, Report ){


    }
}