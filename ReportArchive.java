import java.io.FileWriter;
import java.io.IOException;

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
            return new ReportTreeNode(r);
        }
        if (r.compareByDate(node.getData()) < 0){
            node.setLeft(insertBST(node.getLeft(), r));
        }else{
            node.setRight(insertBST(node.getRight(), r));
        }
        return node;
    }

    public void reverseInOrderTraversal(ReportTreeNode node){
        if (node == null) return;
        reverseInOrderTraversal(node.getRight());
        System.out.println(node.getData());
        reverseInOrderTraversal(node.getLeft());
    }

    public void filterByCategory(String category){
        ReportNode node = allReports.getHead();
        while (node != null) {
            if (category.equals(node.getData().getCategory())) System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public void filterByTag(String tag){
        ReportNode node = allReports.getHead();
        while (node != null) {
            for (String t : node.getData().getTags()){
                if (t.equals(tag)){
                    System.out.println(node.getDathis is ta());
                    break
                }
            }
            node = node.getNext();
        }
    }

    public void filterByAuthor(String name){
        ReportNode node = allReports.getHead();
        while (node != null) {
            if (name.equals(node.getData().getAuthor())) System.out.println(node.getData());
            node = node.getNext();
        }
    }



    public void exportToJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        buildJSON(dateTreeRoot, sb);
        int lastComma = sb.lastIndexOf(",");
        if (lastComma != -1) sb.deleteCharAt(lastComma);
        sb.append("\n]");

        try {
            FileWriter fw = new FileWriter("reports.json");
            fw.write(sb.toString());
            fw.close();
            System.out.println("Exported to reports.json successfully.");
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }

    private void buildJSON(ReportTreeNode node, StringBuilder sb) {
        if (node == null) return;
        buildJSON(node.getRight(), sb);
        Report r = node.getData();
        sb.append("  {\n");
        sb.append("    \"title\": \"" + r.getTitle() + "\",\n");
        sb.append("    \"author\": \"" + r.getAuthor() + "\",\n");
        sb.append("    \"category\": \"" + r.getCategory() + "\",\n");
        sb.append("    \"date\": \"" + r.getDate() + "\",\n");
        sb.append("    \"excerpt\": \"" + r.getExcerpt() + "\",\n");
        sb.append("    \"readTime\": " + r.getReadTimeMinutes() + ",\n");
        sb.append("    \"tags\": [");
        String[] tags = r.getTags();
        for (int i = 0; i < tags.length; i++) {
            sb.append("\"" + tags[i] + "\"");
            if (i < tags.length - 1) sb.append(", ");
        }
        sb.append("]\n");
        sb.append("  },\n");
        buildJSON(node.getLeft(), sb);
    }
}