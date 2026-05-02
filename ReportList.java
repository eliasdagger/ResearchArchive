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
		ReportNode node = head;
		if (node == null) {
			System.out.println("No reports");
		}
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
	
	public boolean titleExists(String title) {
		ReportNode node = head;	
		if (node == null) return false;
		while (node.getNext() != null) {
			if (node.getData().getTitle() == title) {
				return true;
			}
		}
//		While loop stops at last node
		if (node.getData().getTitle() == title) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public Report findByTitle(String title) {
		ReportNode node = head;	
		if (node == null) return null;
		while (node.getNext() != null) {
			if (node.getData().getTitle() == title) {
				return node.getData();
			}
		}
//		While loop stops at last node
		if (node.getData().getTitle() == title) {
			return node.getData();
		}
		
		return null;
	}
	
	public ReportNode getHead() {
		return head;
	}
	
	public int size(ReportNode head) {
		int count = 0;
		while (head.getData() != null) {
			count++;
			head = head.getNext();
		}
		
		return count;
	}

}
