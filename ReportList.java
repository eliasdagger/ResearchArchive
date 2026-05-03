/**
 * SLL
 */
public class ReportList {
	private ReportNode head;
	private int size;
	
	
	public void addFront(Report r) {
		ReportNode newNode = new ReportNode(r);
		newNode.setNext(head);
		head = newNode;
		size++;
	}
	
	public void printAll() {
		ReportNode current = head;
		if (current == null) {
			System.out.println("No reports found.");
			return;
		}
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public Report findByTitle(String title) {
    	ReportNode current = head;
    	while (current != null) {
        	if (current.getData().getTitle().equals(title)) {
            	return current.getData();
        	}
        	current = current.getNext();
    	}
    	return null;
	}

	public void filterByCategory(String category){
		ReportNode current = head;
		boolean found = false;
		while (current != null){
			if (current.getData().getCategory().equals(category)){
				System.out.println(current.getData());
				found = true;
			}
			current = current.getNext();
		}
        if (!found) System.out.println("No reports found for category: " + category);
	}
	public void filterByTag(String tag) {
        ReportNode current = head;
        boolean found = false;
        while (current != null) {
            for (String t : current.getData().getTags()) {
                if (t.equals(tag)) {
                    System.out.println(current.getData());
                    found = true;
                    break;
                }
            }
            current = current.getNext();
        }
        if (!found) System.out.println("No reports found for tag: " + tag);
    }


    public void filterByAuthor(String author) {
        ReportNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.getData().getAuthor().equals(author)) {
                System.out.println(current.getData());
                found = true;
            }
            current = current.getNext();
        }
        if (!found) System.out.println("No reports found for author: " + author);
    }
	
	public ReportNode getHead() {
		return head;
	}
	
	public int size() {
    	return size;
	}

}
