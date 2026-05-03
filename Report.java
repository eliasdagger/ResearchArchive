//**
// Report object - holds information */
public class Report {
	private String title;
	private String author;
	private String category;
	private String[] tags;
	private String date;
	private String excerpt;
	private int readTimeMinutes;
	
	public Report(String title, String Author, String category, String[] tags, String date, String excerpt, int readTimeMinutes) {
		this.title = title;
		this.author = Author;
		this.category = category;
		this.tags = tags;
		this.date = date;
		this.excerpt = excerpt;
		this.readTimeMinutes = readTimeMinutes;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String[] getTags() {
		return tags;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getExcerpt() {
		return excerpt;
	}
	
	public int getReadTimeMinutes() {
		return readTimeMinutes;
	}
	
	public String toString() {
		return "[" + date + "] " + title + " — " + author + " (" + category + ") " + readTimeMinutes + " min";
	}
	
	public int compareByDate(Report other) {
		return (this.date.compareTo(other.date));
	}
}
