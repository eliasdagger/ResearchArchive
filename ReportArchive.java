import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReportArchive{
    private ReportList allReports;
    private ReportTreeNode dateTreeRoot;
    private ReportBrowser browser;

    public ReportArchive() {
        allReports = new ReportList();
        browser = new ReportBrowser();
        dateTreeRoot = null;
    }

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
                    System.out.println(node.getData());
                    break;
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
            FileWriter fw = new FileWriter("reports.json", java.nio.charset.StandardCharsets.UTF_8);            fw.write(sb.toString());
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
    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n=== Dagher Capital Research Archive ===");
            System.out.println("1. View all reports (newest first)");
            System.out.println("2. Filter by category");
            System.out.println("3. Filter by tag");
            System.out.println("4. Filter by author");
            System.out.println("5. Browse one at a time");
            System.out.println("6. Add a new report");
            System.out.println("7. Quit");
            System.out.print("\nEnter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clears the buffer

            if (choice == 1) {
                reverseInOrderTraversal(dateTreeRoot);
            } else if (choice == 2) {
                System.out.print("Enter category: ");
                allReports.filterByCategory(sc.nextLine());
            } else if (choice == 3) {
                System.out.print("Enter tag: ");
                allReports.filterByTag(sc.nextLine());
            } else if (choice == 4) {
                System.out.print("Enter author: ");
                allReports.filterByAuthor(sc.nextLine());
            } else if (choice == 5) {
                // browseMenu(sc);
            } else if (choice == 6) {
                // promp1t for fields, create Report, call addReport()
            }
        }
        System.out.println("Goodbye.");
        sc.close();
    }


    public static void main(String[] args) {

        ReportArchive archive = new ReportArchive();

        // --- LOAD SAMPLE REPORTS ---
        archive.addReport(new Report(
            "The Strait of Hormuz: The World's Most Important Chokepoint",
            "James Dagher",
            "Macro",
            new String[]{"Oil", "Geopolitics", "Energy"},
            "2026-04-18",
            "Roughly 20% of the world's oil supply passes through a 33km channel between Iran and Oman every day.",
            8
        ));

        archive.addReport(new Report(
            "The Fed's Impossible Dilemma: Cut Too Soon or Wait Too Long?",
            "Sara Khoury",
            "Macro",
            new String[]{"Rates", "Inflation", "Fed"},
            "2026-04-12",
            "With inflation sticky above target and the labour market resilient, the Fed faces a genuine fork in the road.",
            6
        ));

        archive.addReport(new Report(
            "NVIDIA — Strong Buy",
            "James Dagher",
            "Investments",
            new String[]{"Tech", "Semiconductors", "AI"},
            "2026-04-10",
            "NVIDIA's data center dominance accelerates as hyperscalers expand AI infrastructure spending.",
            7
        ));

        archive.addReport(new Report(
            "BlackRock — Buy",
            "Sara Khoury",
            "Investments",
            new String[]{"Financials", "Asset Management"},
            "2026-03-28",
            "BlackRock's private markets expansion and GIP integration positions the firm for outsized fee growth.",
            6
        ));

        archive.addReport(new Report(
            "OPEC+ Discipline is Cracking — What Comes Next for Oil",
            "Sara Khoury",
            "Macro",
            new String[]{"Oil", "Energy", "OPEC"},
            "2026-03-22",
            "Saudi Arabia is increasingly frustrated with members cheating on quotas.",
            5
        ));

        archive.addReport(new Report(
            "Pricing Strategy Overhaul for a B2B SaaS Company",
            "Michael Azar",
            "Consulting",
            new String[]{"SaaS", "Strategy", "Pricing"},
            "2026-03-15",
            "A mid-market SaaS firm experiencing high churn despite strong acquisition metrics.",
            4
        ));

        archive.addReport(new Report(
            "Amazon — Buy",
            "Michael Azar",
            "Investments",
            new String[]{"Tech", "E-Commerce", "Cloud"},
            "2026-03-10",
            "AWS re-acceleration combined with improving retail margins creates a powerful earnings inflection story.",
            6
        ));

        archive.addReport(new Report(
            "Dollar Dominance: How Much Longer Can It Last?",
            "Lena Nader",
            "Macro",
            new String[]{"FX", "USD", "Geopolitics"},
            "2026-03-05",
            "The BRICS nations are actively building alternatives to SWIFT and dollar settlement.",
            7
        ));
        

        // --- EXPORT TO JSON ---
        archive.exportToJSON();

        // --- RUN MENU ---
        archive.runMenu();
    }
}