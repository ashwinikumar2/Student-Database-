ASHWINI KUMAR
ASSIGNMENT 3 
COL 106 DATA STRUCTURES AND ALGORITHMS

Two interfaces were given to us. Those were
public interface MyHashTable_<K, T> { 
   // Insert new object with given key 
   public int insert(K key, T obj); 
 
   // Update object for given key 
   public int update(K key, T obj); 
 
   // Delete object for given key 
   public int delete(K key); 
 
   // Does an object with this key exist? 
   public boolean contains(K key); 
 
   // Return the object with given key 
   public T get(K key) throws NotFoundException; 
 
   // ”Address” of object with given key (explained below) 
   public String address(K key) throws NotFoundException; 
}
public interface Student_ { 
   public String fname();      // Return student’s first name 
   public String lname();      // Return student’s last name 
   public String hostel();     // Return student’s hostel name 
   public String department(); // Return student’s department name 
   public String cgpa();       // Return student’s cgpa 
}

We implemented them with the name of the classes as MyHashTableDoubleHashing<K, T> implements MyHashTable_<K, T> ,
MyHashTableSeperateChaining<K, T> implements MyHashTable_<K, T> and Student implements Student_ .

We also defined a class named NotFoundException which extends Exception and prints "E" when required.

Now, we were asked to make hash tables using the approaches as DoubleHashing and Seperate Chaining using Binary Search Tree.

The classes which we defined are listed below: 

Class Pair
{}
The Objects of this class represents a pair of Firstname and Lastname for a particular student.

Class Student implements Student_
{}
The Objects of this class represent all the details about a particular student such as firstname, lastname, hostel, department, cgpa.

Class MyHashTableDoubleHashing<K, T> implements MyHashTable_<K, T>
{}
The objects of this class represent the data structure HashTable with Double Hashing approach.

Class Node<K, T>
{}
The objects of this class represents a single node of the hash table implemented with Double Hashing approach.

Class MyHashTableSeperateChaining<K, T> implements MyHashTable_<K, T>
{}
The objects of this class represent the data structure HashTable implemented using Seperate Chaining with Binary Search Tree approach.

Class NodeBST<K, T>
{}
The objects of this class are a node of the data structure Hash Table implemented using Seperate Chaining with Binary Search Tree approach.

Class BST<Y>
{}
The objects of this class represents a data structure Binary Search Tree which is inside every non-empty node of Hash Table implemented using Seperate Chaining with Binary Search Tree approach.

Class TreeNode<X>
{}
The objects of this class represents a node of the data structure Binary Search Tree.

Class PairTree<K, T>
{}
The objects of this class represents a pair of object of class Pair and object of class Student for a certain student . These objects are inside every object of class TreeNode<X>.

class NotFoundException extends Exception 
{}
It extends Exception and prints "E" when required.

FOR BOTH TYPES OF HASH TABLES:
We defined several functions such as insert, update, delete, contains, get, address.

FOR HASH TABLE IMPLEMENTED USING DOUBLE HASHING APPROACH 
For every node of HashTable , there is a pair and value associated with it.The pair is a object of class Pair
whereas value is an object of class Student.Functions used are:

INSERT: We first checked at the calculated hash value index(hi) using the values of i, h1 and h2;
h1 is a djb2 function whereas h2 is sdbm.i represents the number of iterations carried for finding an empty 
node at value of hi.
If the node is found to be empty, declare the values of pair and value equals to the key and obj supplied respectively.
else increase the number of iterations.

UPDATE:Look at the calculated value of hi as calculated above. If the pair value is same as what we are searching 
for then equalise the old values of student fields to the new field values of the object supplied.
else increase the iterations. If in case hi becomes equal or greater to the size of table then break the loop
with output defining that there is an error.

DELETE:With same procedure look for the node which is required and set it to null.

CONTAINS:With same procedure look for the node which is required on the calculated value of iterated value of 
hi. If in case hi becomes equal or greater to the size of table then break the loop
with output defining that there is an error.

GET:With same procedure look for the node which is required on the calculated value of iterated value of 
hi and return the value at that node. If in case hi becomes equal or greater to the size of table then break the loop
with output defining that there is an error.
 
ADDRESS:With same procedure look for the node which is required on the calculated value of iterated value of 
hi and with each time we iterate, we will increase the value of i.

The average time complexity of the various operations would be  would O(1).
insert()=O(1)
update =O(1)
contains=O(1)
get=O(1)
delete=O(1)
address=O(1)

The worst case time complexity would be O(N).

insert()=O(N)
update =O(N)
contains=O(N)
get=O(N)
delete=O(N)
address=O(N)

FOR HASHTABLE USING SEPERATE CHAINING WITH BINARY SEARCH TREE
For every node of HashTable ,there is an object of class BST inside which there is and object of class TreeNode inside which
 there is an object of class PairTree inside which there is a pair and value associated with it.The pair is a object of class Pair
whereas value is an object of class Student.Functions used are:

INSERT:We look at the calculated value of index. If it is null then make an object of class BST , put new object of class TreeNode
 ,put new object of class PairTree ,put new object of Pair and new object of class Student.else show an error .

UPDATE:We look at the tree in the calculated value of index.Further, find that particular student and update the fields of student.

DELETE:We look at the tree in the calculated value of index.Further, find that particular student and delete that node data value (or
node) from there using various techniques.

CONTAINS:We look at the tree in the calculated value of index.Further, find that particular student and return true.If it is not found 
at the predicted positions then return false.

GET:We look at the tree in the calculated value of index.Further, find that particular student and return value of the node of tree.

ADDRESS:We look at the tree in the calculated value of index.Further, find that particular student in the tree and return the address.

The average time complexity of the various operations would be  would O(log n).
	
insert()=O(log n)
update =O(log n)
contains=O(log n)
get=O(log n)
delete=O(log n)
address=O(log n)

The worst case time complexity would be O(N).
	
insert()=O(N)
update =O(N)
contains=O(N)
get=O(N)
delete=O(N)
address=O(N)
 