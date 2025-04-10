
class LL { 
private StudentRecordNode head; 
private StudentRecordNode tail; 
private int size; 
public LL(){ 
this.size = 0; 
} 
public void insertFirst(String name, int rollNo, int age, char grade){ 
StudentRecordNode node = new StudentRecordNode(name, rollNo, age, 
grade); 
node.next = head; 
head = node; 
if(tail == null){ 
tail = head; 
} 
size+=1; 
} 
public void insertLast(String name, int rollNo, int age, char grade){ 
if(tail== null){ 
insertFirst(name, rollNo, age, grade); 
return; 
} 
StudentRecordNode node = new StudentRecordNode(name, rollNo, age, 
grade); 
tail.next = node; 
tail = node; 
size ++; 
} 
public void insert(String name, int rollNo, int age, char grade,int 
index){ 
if (index ==0){ 
insertFirst(name, rollNo, age, grade); 
} 
if (index == size){ 
insertLast(name, rollNo, age, grade); 
} 
StudentRecordNode temp = head; 
for(int i = 1; i< index; i++){ 
temp = temp.next; 
} 
StudentRecordNode node = new StudentRecordNode(name, rollNo, age, 
grade, temp.next); 
temp.next = node; 
size++; 
} 
public void deleteFirst(){ 
StudentRecordNode temp = head; 
head = head.next; 
temp.next = null; 
size -=1; 
} 
public void deleteLast(){ 
StudentRecordNode temp = head; 
for(int i = 1; i< size-1; i++){ 
temp = temp.next; 
} 
temp.next = null; 
size -=1; 
tail = temp; 
} 
public void delete(int index){ 
StudentRecordNode temp = head; 
for(int i = 1; i< index; i++){ 
temp = temp.next; 
} 
StudentRecordNode nodeToDelete = temp.next; 
temp.next = nodeToDelete.next; 
nodeToDelete.next = null; 
size -=1; 
} 
public void deleteWithRollNumber(int rollNo){ 
StudentRecordNode temp = head; 
if(head.rollNo == rollNo){ 
System.out.println("Trying to remove first number: "); 
deleteFirst(); 
return; 
} 
if(tail.rollNo == rollNo){ 
System.out.println("Trying to remove Last number: "); 
deleteLast(); 
return; 
} 
for(int i = 1; i< size; i++){ 
if(temp.next.rollNo == rollNo){ 
System.out.println(""); 
StudentRecordNode nodeToDelete = temp.next; 
temp.next = nodeToDelete.next; 
nodeToDelete.next = null; 
size -=1; 
return; 
} 
temp = temp.next; 
} 
} 
public void searchStudent(int rollNo){ 
StudentRecordNode temp = head; 
for(int i=0; i<size; i++){ 
if(temp.rollNo == rollNo){ 
System.out.println("Name: " + temp.name); 
System.out.println("Rollno: " + temp.rollNo); 
System.out.println("Grade: " + temp.grade); 
System.out.println("Age: " + temp.age); 
} 
temp = temp.next; 
} 
} 
public void updateStudent(int rollNo, char grade){ 
StudentRecordNode temp = head; 
for(int i=0; i<size; i++){ 
if(temp.rollNo == rollNo){ 
temp.grade = grade; 
System.out.println("Name: " + temp.name); 
System.out.println("Rollno: " + temp.rollNo); 
System.out.println("Grade: " + temp.grade); 
System.out.println("Age: " + temp.age); 
} 
temp = temp.next; 
} 
} 
public void display(){ 
StudentRecordNode temp = head; 
while(temp != null){ 
System.out.print(temp.name+ " -> "); 
temp = temp.next; 
} 
System.out.println("END \n Size: " + size); 
} 
private class StudentRecordNode{ 
private String name; 
private int rollNo; 
private int age; 
private char grade; 
private StudentRecordNode next; 
StudentRecordNode(String name, int rollNo, int age, char grade){ 
this.name = name; 
this.rollNo = rollNo; 
this.age = age; 
this.grade = grade; 
} 
StudentRecordNode(String name, int rollNo, int age, char grade, 
StudentRecordNode next){ 
this.name = name; 
this.rollNo = rollNo; 
this.age = age; 
this.grade = grade; 
this.next = next; 
} 
} 
} 
public class StudentRecord{ 
public static void main(String args[]) { 
LL list = new LL(); 
list.insertFirst("dinakaran",368,21,'S'); 
list.insertFirst("jawa",367,21,'S'); 
list.insertFirst("buvanesh",366,21,'S'); 
list.insertFirst("Karun",365,21,'S'); 
list.insertFirst("Tharun",364,21,'S'); 
list.insertFirst("Varun",363,21,'S'); 
list.insertFirst("Marun",362,21,'S'); 
list.insertFirst("Karthi",361,21,'S'); 
list.updateStudent(363, 'A'); 
} 
}