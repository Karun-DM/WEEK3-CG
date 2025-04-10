class LibraryDLL { 
private BookNode head; 
private BookNode tail; 
private int size; 
public LibraryDLL() { 
this.size = 0; 
} 
public void addFirst(String title, String author, String genre, int 
bookId, boolean available) { 
BookNode node = new BookNode(title, author, genre, bookId, 
available); 
node.next = head; 
if (head != null) { 
head.prev = node; 
} 
head = node; 
if (tail == null) { 
tail = head; 
} 
size++; 
} 
public void addLast(String title, String author, String genre, int 
bookId, boolean available) { 
if (tail == null) { 
addFirst(title, author, genre, bookId, available); 
return; 
} 
BookNode node = new BookNode(title, author, genre, bookId, 
available); 
tail.next = node; 
node.prev = tail; 
tail = node; 
size++; 
} 
public void add(String title, String author, String genre, int bookId, 
boolean available, int index) { 
if (index == 0) { 
addFirst(title, author, genre, bookId, available); 
return; 
} 
if (index == size) { 
addLast(title, author, genre, bookId, available); 
return; 
} 
BookNode temp = head; 
for (int i = 1; i < index; i++) { 
temp = temp.next; 
} 
BookNode node = new BookNode(title, author, genre, bookId, 
available); 
node.next = temp.next; 
temp.next.prev = node; 
node.prev = temp; 
temp.next = node; 
size++; 
} 
public void removeByBookId(int bookId) { 
BookNode temp = head; 
while (temp != null) { 
if (temp.bookId == bookId) { 
if (temp == head) { 
head = head.next; 
if (head != null) head.prev = null; 
} else if (temp == tail) { 
tail = tail.prev; 
if (tail != null) tail.next = null; 
} else { 
temp.prev.next = temp.next; 
temp.next.prev = temp.prev; 
} 
size--; 
return; 
} 
temp = temp.next; 
} 
} 
public void searchByTitle(String title) { 
BookNode temp = head; 
while (temp != null) { 
if (temp.title.equals(title)) { 
System.out.println(temp.title + " - " + temp.author); 
} 
temp = temp.next; 
} 
} 
public void searchByAuthor(String author) { 
BookNode temp = head; 
while (temp != null) { 
if (temp.author.equals(author)) { 
System.out.println(temp.title + " - " + temp.genre); 
} 
temp = temp.next; 
} 
} 
public void updateAvailability(int bookId, boolean status) { 
BookNode temp = head; 
while (temp != null) { 
if (temp.bookId == bookId) { 
temp.available = status; 
return; 
} 
temp = temp.next; 
} 
} 
public void displayForward() { 
BookNode temp = head; 
while (temp != null) { 
System.out.println(temp.title + " -> "); 
temp = temp.next; 
} 
System.out.println("END\nTotal books: " + size); 
} 
public void displayReverse() { 
BookNode temp = tail; 
while (temp != null) { 
System.out.println(temp.title + " <- "); 
temp = temp.prev; 
} 
System.out.println("START\nTotal books: " + size); 
} 
public void countBooks() { 
System.out.println("Total books: " + size); 
} 
private class BookNode { 
String title; 
String author; 
String genre; 
int bookId; 
boolean available; 
BookNode next; 
BookNode prev; 
BookNode(String title, String author, String genre, int bookId, 
boolean available) { 
this.title = title; 
this.author = author; 
this.genre = genre; 
this.bookId = bookId; 
this.available = available; 
} 
} 
} 
public class LibraryMain { 
public static void main(String[] args) { 
LibraryDLL library = new LibraryDLL(); 
library.addFirst("The Alchemist", "Paulo Coelho", "Fiction", 101, 
true); 
library.addFirst("To Kill a Mockingbird", "Harper Lee", "Classic", 
102, true); 
library.addLast("1984", "George Orwell", "Dystopian", 103, true); 
library.add("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 
104, true, 2); 
library.addLast("Moby Dick", "Herman Melville", "Adventure", 105, 
false); 
library.displayForward(); 
library.displayReverse(); 
library.searchByTitle("1984"); 
library.searchByAuthor("Harper Lee"); 
library.updateAvailability(105, true); 
library.removeByBookId(102); 
library.countBooks(); 
} 
}