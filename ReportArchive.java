public class ReportArchive{
    private ReportList allReports;
    private ReportTreeNode dateTreeRoot;
    private ReportBrowser browser;

    public void addReport(Report r){
        allReports.addFront(r);
        dateTreeRoot = insertBST(dateTreeRoot, r);
    }

    public ReportTreeNode insertBST(ReportTreeNode node, Report r){
        if (node == null) {
            return ReportTreeNode(r);
        }
        if (r.compareByDate(node.getData()) < 0){
            node.setLeft(insertBST(node.getLeft(), r));
        }else{
            node.setRight(insertBST(node.getRight(), r));
        }
        return node;
    }

    public void reverseInOrderTraversal(ReportTreeNode node){
        node.getRight();
        allReports.addToFront(node.getData());
        node.getLeft();
    }

    public void filterByCategory(String category){
        browser = buildFromList(allReports);
        
    }

    public void filterByTag(String tag){

    }

    public void filterByDateRange(String start, String end){

    }

    public void filterByAuthor(String name){

    }

    public void runMenu(){
        
    }


}