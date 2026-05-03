public class BrowserNode {
    private Report data;
    private BrowserNode next;
    private BrowserNode prev;


    public BrowserNode(Report data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


    public Report getData() {
        return this.data;
    }

    public void setData(Report data) {
        this.data = data;
    }


    public BrowserNode getNext() {
        return this.next;
    }

    public void setNext(BrowserNode next) {
        this.next = next;
    }


    public BrowserNode getPrev() {
        return this.prev;
    }

    public void setPrev(BrowserNode prev) {
        this.prev = prev;
    }


    public String toString() {
        if (this.data == null) return "BrowserNode[empty]";
        return "BrowserNode[" + this.data.getTitle() + "]";
    }
}