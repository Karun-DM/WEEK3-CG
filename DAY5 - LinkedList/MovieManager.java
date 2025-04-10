class MovieDLL { 
private MovieNode head; 
private MovieNode tail; 
private int size; 
public MovieDLL() { 
this.size = 0; 
} 
public void addFirst(String title, String director, int year, double 
rating) { 
MovieNode node = new MovieNode(title, director, year, rating); 
node.next = head; 
if (head != null) head.prev = node; 
head = node; 
if (tail == null) tail = head; 
size++; 
} 
public void addLast(String title, String director, int year, double 
rating) { 
if (tail == null) { 
addFirst(title, director, year, rating); 
return; 
} 
MovieNode node = new MovieNode(title, director, year, rating); 
tail.next = node; 
node.prev = tail; 
tail = node; 
size++; 
} 
public void add(String title, String director, int year, double rating, 
int index) { 
if (index == 0) { 
addFirst(title, director, year, rating); 
return; 
} 
if (index == size) { 
addLast(title, director, year, rating); 
return; 
} 
MovieNode temp = head; 
for (int i = 1; i < index; i++) { 
temp = temp.next; 
} 
MovieNode node = new MovieNode(title, director, year, rating); 
node.next = temp.next; 
node.prev = temp; 
temp.next.prev = node; 
temp.next = node; 
size++; 
} 
public void removeByTitle(String title) { 
MovieNode temp = head; 
while (temp != null) { 
if (temp.title.equals(title)) { 
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
public void searchByDirector(String director) { 
MovieNode temp = head; 
while (temp != null) { 
if (temp.director.equals(director)) { 
printMovie(temp); 
} 
temp = temp.next; 
} 
} 
public void searchByRating(double rating) { 
MovieNode temp = head; 
while (temp != null) { 
if (temp.rating == rating) { 
printMovie(temp); 
} 
temp = temp.next; 
} 
} 
public void updateRating(String title, double newRating) { 
MovieNode temp = head; 
while (temp != null) { 
if (temp.title.equals(title)) { 
temp.rating = newRating; 
printMovie(temp); 
return; 
} 
temp = temp.next; 
} 
} 
public void displayForward() { 
MovieNode temp = head; 
while (temp != null) { 
System.out.print(temp.title + " <-> "); 
temp = temp.next; 
} 
System.out.println("END"); 
} 
public void displayReverse() { 
MovieNode temp = tail; 
while (temp != null) { 
System.out.print(temp.title + " <-> "); 
temp = temp.prev; 
} 
System.out.println("START"); 
} 
private void printMovie(MovieNode movie) { 
System.out.println("Title: " + movie.title); 
System.out.println("Director: " + movie.director); 
System.out.println("Year: " + movie.year); 
System.out.println("Rating: " + movie.rating); 
System.out.println("---------------------"); 
} 
private class MovieNode { 
String title; 
String director; 
int year; 
double rating; 
MovieNode next; 
MovieNode prev; 
MovieNode(String title, String director, int year, double rating) { 
this.title = title; 
this.director = director; 
this.year = year; 
this.rating = rating; 
} 
} 
} 
public class MovieManager { 
public static void main(String[] args) { 
MovieDLL movies = new MovieDLL(); 
movies.addFirst("Inception", "Nolan", 2010, 9.0); 
movies.addLast("Interstellar", "Nolan", 2014, 8.6); 
movies.add("The Prestige", "Nolan", 2006, 8.5, 1); 
movies.displayForward(); 
movies.displayReverse(); 
movies.searchByDirector("Nolan"); 
movies.updateRating("Inception", 9.5); 
movies.removeByTitle("Interstellar"); 
movies.displayForward(); 
} 
}