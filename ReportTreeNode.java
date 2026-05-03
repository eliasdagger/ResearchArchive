public class ReportTreeNode {
	private Report data;
	private ReportTreeNode left, right;

	
	public ReportTreeNode(Report dataR) {
		data = dataR;
		right = null;
		left = null;	
	}

	public Report getData(){
		return data;
	}

	public ReportTreeNode getLeft(){
		return left;
	}

	public ReportTreeNode getRight(){
		return right;
	}

	public void setLeft(ReportTreeNode left){
		this.left = left;
	}

	public void setRight(ReportTreeNode right){
		this.right = right;
	}
	
}
