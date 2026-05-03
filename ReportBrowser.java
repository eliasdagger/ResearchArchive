public class ReportBrowser{
    private BrowserNode head, tail, curr;

    public void buildFromList(ReportList list){
        ReportNode sllCurr = list.getHead();
        head = null;
        tail = null;
        
        while (sllCurr != null){
            BrowserNode nnode = new BrowserNode(sllCurr.getData());
            if (head == null){
                head = nnode;
                tail = nnode;
            } else {
                tail.setNext(nnode);
                nnode.setPrev(tail);
                tail = nnode;
            }
            sllCurr = sllCurr.getNext();
        }
    }

    public Report curr(){
        return curr.getData();
    }

    public Report next(){
        if (curr.getNext() == null) return null;
        curr = curr.getNext();
        return curr.getData();
    }

    public Report previous(){
        if (curr.getPrev() == null) return null;
        curr = curr.getPrev();
        return curr.getData();
    }

}