public class ReportNode {
    private Report data;
    private ReportNode next;

    public ReportNode(Report data) {
        this.data = data;
        this.next = null;
    }

    public Report getData() {
        return this.data;
    }

    public void setData(Report data) {
        this.data = data;
    }

    public ReportNode getNext() {
        return this.next;
    }


    public void setNext(ReportNode next) {
        this.next = next;
    }

    public String toString() {
        if (this.data == null) return "ReportNode[empty]";
        return "ReportNode[" + this.data.getTitle() + "]";
    }
}