package nonspring;

public class Catalog {

	public static void main(String[] args) {
		Books books;
	
		   books = new PythonBooks();
		   for (String title : books.getTitles())
			     System.out.println(title);

	}

}
