# Tricky_Questions

Tricky Questions / Answers :

1. Function Overriding Concept and Tricky :
------------------------------------------

			# Just accessing parent class object.
			
			# It is always happening another class.
			
			# Purpose reuse of this property.
			
			# All the method signature are same.
			
			
			Parent Class:
			------------
			public interface InventoryService {
			
			public Item addItem(Item item);
			
			public Item addItem(List<Item> item);
			
			}
			
			
			Child Class:
			-----------
			
			public class InventoryServiceImpl implements InventoryService{
			
			@Override
			public Item addItem(Item item){
			return null;
			}
			
			@Override
			public Item addItem(List<Item> item){
			return null;
			}
			
            }
			
			
			Example for return type in the function overriding :
			----------------------------------------------------
			
			1. public class A{
			}
			
			2. public class B extends A{
			}
			
			Now let us consider, in the invertory interface class, returning type is super class object.
			
			3.
			
			public interface InventoryService {
			
			public A addItem(Item item);      <- using superclass A.
			
			public Item addItem(List<Item> item);
			
			}
			
			4. 			
			
			public class InventoryServiceImpl implements InventoryService{
			
			@Override
			public A (or) B addItem(Item item){                <--- here i can return A object or B object. Because B is the subclass of A
			return null;
			}
			
			@Override
			public Item addItem(List<Item> item){
			return null;
			}
			
            }
			
			In your interface you can see parent object...in the implmentation it will return child object.
			
			
2.  What is dynamic polimorphism (or) runtime polimorphism..? 

            In the controller class we are not injecting InventoryServiceImpl class, just we are injecting interface.

			
			@RestController
			public class InventoryController{
			
			@Autowired
			private InventoryService inventoryService;
			
			....
			...
			}		
			
			Note:
			
			InventoryService
			InventoryServiceImpl1
			InventoryServiceImpl2....
			
			intead of this ...we are using only interface.[ that is -> InventoryService ].

3. Explain Hierary for inheritance.? throwing exceptions 

			Use case 1:
			Parent Class :
			-------------
			
			public class Parent{
			
			public void m1() throws Exception{                             < ---- if throws exception , child class no need to handle.
			System.out.println("Parent m1()");
			}
			
			public static void m2(){
			System.out.println("Parent static m2()");
			}
			
			}
			
			Child Class :
			-------------
			
			public class Child extends Parent{
			
			@Override
			public void m1() throws Exception or ignore it{               < ---- Even we can handle or will try exception in the child class 
			System.out.println("child m1()");
			}
			
			public static void main(String[] args){
			Parent parent = new Child();
			parent.m1();
			}
			}
			
			
			Use case 2:
			
			Parent Class :
			-------------
			
			public class Parent{
			
			public void m1(){                             
			System.out.println("Parent m1()");
			}
			
			public static void m2(){
			System.out.println("Parent static m2()");
			}
			
			}
			
			Child Class :
			-------------
			
			public class Child extends Parent{
			
			@Override
			public void m1() throws Exception {             < ---- if throws exception , child class will give error.
			System.out.println("child m1()");
			}
			
			public static void main(String[] args){
			Parent parent = new Child();
			parent.m1();
			}
			}
			
4. Parent Child Override Scenario.

 			
			Parent Class :
			-------------
			
			public class Parent{
			
			public void m1(){                             
			System.out.println("Parent m1()");
			}
			
			public static void m2(){
			System.out.println("Parent static m2()");
			}
			
			}
			
			Child Class :
			-------------
			
			public class Child extends Parent{
			
			@Override
			public void m1() throws Exception {             
			System.out.println("child m1()");
			}
			
			public static void main(String[] args){
			Parent parent = new Child();
			parent.m1();
			}
			}
			
			Output :
			--------
			
			child m1()  -> becuase it is overriding parent to child and it is creating object for child and creating parent reference here.[Parent parent = new 
			               Child();]
						   
			
			
			
			Parent Class :
			-------------
			
			public class Parent{
			
			public void m1(){                             
			System.out.println("Parent m1()");
			}
			
			public static void m2(){
			System.out.println("Parent static m2()");
			}
			
			}
			
			Child Class :
			-------------
			
			public class Child extends Parent{
			
			
			public static void main(String[] args){
			Parent parent = new Child();
			parent.m1();
			}
			}
			              
			
			Output:
			
			Parent m1().   Getting output from parent. No compilation error. this is runtime polimorhphising.


5. 			Can we override static and private method?

			No.
			
6. 			What is the difference of java 7 and java 8 interface.

			Java 8 Default method , static method.  Java 7 having abstract method.
			
			Default Method :
			
			Not force to implement this default method for overriding.
			
			Example :
			
			Payment.java
			------------
			
			public interface Payment{
			
			public void doTransaction();
			
			default void addCoupon(){
			System.out.println("add 5Rs cashback");
			}
			
			static void generateTransactionReport(){
			System.out.println("Generate Each transaction");
			}
			}
			
			
			if paytm , googlepay want this coupon they will override. phonepe dont want to override this default method.
			
			GooglePay.java
			--------------
			
			public class GooglePay implements Payment{
			
			@Override
			public void doTransaction(){
			System.out.println("GPay transaction");
			}
			
			/*@Override
			public void addCoupon(){
			super.addCoupon();
			}*/
			
			public static void main(String[] args){
			Payment payment = new GooglePay();
			payment.addCoupon();
			}
			}
		
			if you want give own features for this coupon you can use.
			
			Phonepe.java
			--------------
			
			public class Phonepe implements Payment{
			
			@Override
			public void doTransaction(){
			System.out.println("GPay transaction");
			}
			
			@Override
			public void addCoupon(){
			System.out.println("10% cashback");
			}			
			}
			
			
			Static :
			-------
			
			static void generateTransactionReport(){
			System.out.println("Generate Each transaction");
			}
			
			It is common for the methods , gpay, phonepe, and paytm. If it is common better keep it static in the interface or create utility class and maintain there.
			
7.  Write the custom Exception?

    Note :
	
    	If we extends Exception it behaves like checked exception , it is extends RuntimeException...it behaves like Runtime exception.
    	
    	Checked Exception is compile time exception.
    
        A.
	
	OrderNotFoundException.java :
	---------------------------
	
    	public class OrderNotFoundException extends Exception {
	
	        public OrderNotFoundException(String message){
			  super(message);
			}
	}
	
   B.
   
	Test.java :
	----------
	
	public class Test{
	
	public void getOrder(int orderId) throws OrderNotFoundException{
	    if(orderId==101){
		throw new OrderNotFoundException("Order not found with id"+ orderId)
	    } else {
		 // do some logic
		 }
		 }
		 
    public static void(String args[]){
	   Test test = new Test();
	   test.getOrder(101);
	}
	}
	
	
8.	Tricky questions ...order of the exception.
    
	    public class ExceptionOrder{
	
	      public static void main(String ars[]){
	  
	    try{
		     System.out.println(10/0);
		} catch(Exception e){
		  System.out.println(ex.getMessage());
		} catch(ArithmeticException de){
		  System.out.println(ae.getMessage());
		} finally{
		  System.out.printn("finally");
		  }
	    	}
    	}
			
    
	It will give compile time error.
	
    	Order of the exception is ....
    	
    	1. Exception is the super class of all the exceptions , ArithmeticException is here child class.
    	   Parent class (ie Exception ) it will never be a first statement in the catch block.
	
	2. Just suffled it will work.
  	
  	        public class ExceptionOrder{
  	
  	        public static void main(String ars[]){
	  
    	    try{
    		     System.out.println(10/0);
    		} catch(ArithmeticException e){
    		  System.out.println(ex.getMessage());
    		} catch(Exception de){
    		  System.out.println(ae.getMessage());
    		} finally{
    		  System.out.printn("finally");
    		      }
    	    	}
        	}
	
Note : There is not compilation error. It will work. Parent Exception is always be down.
	
	
9. try, catch and finally return statement scenario questions. & is finally block always will be executed?

    
        public class TryCatchFinallyReturnFlow{
    	
    	public static int m1(){
    	try{
    	     return 1;
    	}catch (Exception ex){
    	     return 2;
    	}finally{
    	   return 3;
    	}
    	}
    	public static void main(String args[]){
    	  System.out.println(m1());
    	}
    	}
    	
    	Output :
    	
    	3
    	
    	What is the flow?
    	
    	There is no exception and it will return and if we have exception or error will entered into catch block and will return catch stmts and finally.
    	
    	finally block will always execute.
    	
    	
    	Now we dont have finally, only try/catch :
    	
    	public class TryCatchFinallyReturnFlow{
    	
    	public static int m1(){
    	try{
    	     return 1;
    	}catch (Exception ex){
    	     return 2;
    	}
    	}
    	public static void main(String args[]){
    	  System.out.println(m1());
    	}
    	}
    	
    	Output :
    	
    	1
    	
    	
    	public class TryCatchFinallyReturnFlow{
    	
    	public static int m1(){
    	try{
    	     System.out.println(10/0);
    	     return 1;
    	}catch (Exception ex){
    	     return 2;
    	}
    	}
    	public static void main(String args[]){
    	  System.out.println(m1());
    	}
    	}
    
        Output 
    	
    	2
    	
    	public class TryCatchFinallyReturnFlow{
    	
    	public static int m1(){
    	try{
    	     System.out.println(10/0);
    	     return 1;
    	}catch (Exception ex){
    	     return 2;
    	}finally{
    	     return 3;
    	}
    	public static void main(String args[]){
    	  System.out.println(m1());
    	}
    	}
    	
     
        Output :
    	
    	3
    	
    	We can break the finally block.
    	
    	
    	public class TryCatchFinallyReturnFlow{
    	
    	public static int m1(){
    	try{
    	    return 1;
    	}catch (Exception ex){
    	     return 2;
    	}finally{
    	System.exit(0);
    	     return 3;
    	}
    	public static void main(String args[]){
    	  System.out.println(m1());
    	}
    	}
    	
    	Output:
    	
    	Nothing will 
    	
    	You wont get the retrun statement output value as 3, because we are exit usig system exit variable.System.exit(0);
	
10. How many ways String object will create?

        public class StringObject{
    	  public static void main(String args[]){
    	  
    	  // How many object created here.
    	  
    	  String s1 = new String("Dowlath");
    	  
    	  // 1.object -> new -> heap
    	  // 2.object -> literal -> SCP ( String constant pool area )
    	  
    	  
    	  String s2 = "Dowlath'; // 1. object
    	  
    	  // Just proof that.2 objects are created.
    	  
    	  System.out.println(s1.intern().hashCode() == s2.hashCode()); // Output is true.
    	  
    	  // intern method used to get reference from SCP
    	  
    	  System.out.println(s1.intern());
    	  System.out.println(s1.intern().hashCode() ==  s2.hashCode());
    	  
    	  // total object count 2.  
    	

11. Why String immutable?

        Immutable simply means unmodifiable or unchangeable.
    		
    	public class TestImmutablString{
    	
    	  public static void main(String args[]){
    	  
    	   String s = "Dowlath";  /// in scp ......1010
    	   s.concat("Basha"); // created another object ....1020 // concat() method appends the string at the end
    	   System.output.println(s); // will print Java because strings are immutable objects
    	 
    	 
    	   String password = "pwd";
    	   password.concat("123");
    	   
    	   // lets say 5 refrence using this password, now if we changed any in same value
    	   // then all 5 references will impacted. for security reasons it is immutable.
    	   
    	   }
    	}

12. How to use mutable class and what is the difference between stringbuffer and stringbuilder?

        Factor/Class					String 							StringBuffer							StringBuilder 
    	
    	Mutability					   Immutable						mutable										mutable
    	
    	Thread Safety				   Not Thread Safety				ThreadSafe									Not Thread Safety
    	
    	Performance						Very high						Moderate									very high
	

13.	How to write your own custom immuatble class?
    
        - Make your class final
    	- Declare all instance variable with private and final
    	- Say no to setter methods. (only setter methods)
    	- Initialize all the variables in constructor
    	- You can initialize variable in constructor
    	- Perform cloning of mutable objects while returning from getter method
    	
    	Important Points :
    	------------------
    	- Do the clone if it is object . Example Date doj.....it is object need to clone like this : (Date)doj.clone();
    	- Return the object. like this -> return new ArrayList<>(mobile); return new Address(address.getCity().address.getZip());
	
	
	
    	Example :
    	-------
    	
    	Employee.java :
    	
    	public final class Employee{
    	
    	private final String name;
    	private final Data doj;  //mutable
    	private final List<String> mobile;
    	
    	private final Address address;  // mutable ...need to make forcefully immutable
    	
    	// usecase : 3 
    	// we have address class, this class is completly mutable class.with setter and getter methods
    	
    	
    	public Employee(String name,Date doj, List<String> mobile, Address address){
    	this.name = namel
    	this.doj = doj;
    	this.mobile = mobile;
    	this.address = address;
    	}
    	
    	public String getName(){
    	//return doj;  // To avoid this issue , rather than direct returning object. Instead of this , clone it.
    	return (Date)doj.clone(); // after this it is not allowed to set new date.
    	}
    	
    	public List<String> getMobile(){
    	//return mobile;
    	//return Collections.unmodifiableList(mobile); // it is throwing exception when we try to add new value into list.[ UnsupportedOperationException ] we dont need //to give any exception.our moto is use should not add numbers in to the list.
    	return new ArrayList<>(mobile); // this is correct approach. Now it wont allow and not throwing exception also.
    	
    	}
    	
    	public Address getAddress(){
    	//return address; // instead of this make a separate copy of this address like new Address(address.getCity().address.getZip()); in that case it wont change it.
    	return new Address(address.getCity(),address.getZip()); // it will work.
    	}
    	
    	@Override
    	public String toString(){
    	return "Employee{"+ "name= '"+name+'\''+",doj ="+doj+",mobile="+mobile+",address= "+ address + 
    	'}';
    	
    	public static void main(String args[]{
    	Address address = new Address("Bangalore","1011");
    	Employee employee = new Employee("Dowlath",new Date(),
    	                    Arrays.stream(new String[]{"1234","5678"})
    						.collect(Collectors.toList()),address);
    	
        //employee.name ="Basha";// it is crying...compile time error. so comment now. It is fulfilling the immuatble rule. Not able to update.	
    	
    	// Use case : 1
    	
    	// We are able to modify doj or not.	
    	employee.getDoj().setDate(10);  <---should not print the date 10. It is updating the date. immutable means should not update or change the date.
    	// for this direct returning , instead of this , clone it.
    	
    	
    	
    	// Use case : 2
        // We are able to modify the list or not.
        employee.getMobile().add("9000"); // it is allowing to update the list.It should not allow.
    	
    	
    	// Use case : 3 
    	// Should not able to modify Bangalore to Pune. it should not allow.
    	employee.getAddress().setCity("Pune");   // Now city is changed how we can resolved , instead of return address , make a separate copy of it.
    	
    	System.out.println(employee);
    	}
    	}
	
	
	Use case : 3
	------------
	
    	We have address class.
    	
        public class Address{
        private String city;
        private String zip;
        
        public 	Address(){
    	}
    	
    	public Address(String city,String zip){
    	  this.city = city;
    	  this.zip = zip;
    	}
    	
    	public String getCity(){
    	return city;
    	}
    	
    	public void setCity(String city){
    	this.city = city;
    	}
    	
    	public String getZip(){
    	return zip;
    	}
    	
    	public void setZip(String zip){
    	this.zip = zip;
    	}
    	
    	// toString method here
    	
    	}	

14. Which one is good to store password in java String or char[] & why?

        Here are a few reasons which make sense to believe that character array is better choice for storing the password in Java than string.
    	
    	- Since Strings are immutable in java if you store the password as plain text it will be available in memory until the garbage collector clears it and also
    	  String literal is stored string pool for reusuability there is a pretty high chance that it will remain in memory for long duration.
    	  
    	- Becuase its difficult to destory literal from SCP as GC unable to perform cleanup activity in SCP only it will destroy once jvm restarted so which may    
    	  leads a high security threat.
    	
    	- Since anyone who has access to memory dump can find the password in clear text and thats another reason you should always use an encrypted password than plain 
    	  text.
    	
    	- Since String are immutable there are no way contents of Strings can be changes because an change will produce new String,while if you char[] you can stillset 
    	  all his elements as blank or zero. So Storing the password in character array clearly mitigates security ris of stealing passwords.
    	  
    	- With String there is always a risk of printing plain text in log file or console but if use Array you won't print contents of arrya instead its memory 
    	  location get printed. though not a real reason but still make sense.
    	
    		String strPwd = "Unknown";
    		char[] chrPwd = new char[]{'U','n','k','n','o','w','n'};
    		System.out.println("String password : "+strPwd);
    		System.out.println("chr password : "+chrPwd);
    		
    		String password : Unknown
    		Character password : [C@110b053...
    		  
    	
    	 - Go with char array.

15. What is Marker interface (tagging interface) ? Can we create our own marker interface?

        - A marker interface is an interface that has no methods or constants inside it. Java has many build-in marker interfaces, such as Serializable, Cloneable and  
    	  Rnnnable.
    	  
    	- It provides run-time type information about objects, so the compiler and JVM have additional information about the object.
    	
    	- Lets take the example of the Cloneable interface. If we try to clone an object that doesnot implement this interface, the JVM throws a 
    	  CloneNotSupportedException. Hence, the Cloneable marker interface is an indicator to the JVM that we can call the Object.clone() method.
	  
	Own Marker Interace :
	--------------------
	
	Step 1 :
	------
	
    	Create interface :  Deletable, no methods and no fields.
	
	  	public interface Deletable{
		  }
	
	Step 2 :
	------
	
	Create class Entity and implement this interface.
	
		public class Entity implements Deletable{
		
		// attributes
		
		}
	
	Step 3 :
	------
	
	Create DaoFramework class.
	
		public class DaoFramework {
		
		public void delete(Object object){
		
			 if (object instanceOf Deletable){
			 
			   // write the DB logic
			 }
		 }
		 }
		 
	
16. What is the difference between List and Set?	
	
    	
    	List																		Set
    	----																		---
    	
    	List allows store duplicate object.											Set dont allows store duplicate object.			
    	
    	List works on index base.													Set works on Hash based.
    	
    	When you want frequently access the elements you can use List.				When you want to use collection of distinct element .
	
	
17. What is the difference between ArrayList and LinkedList?

        ArrayList																	LinkedList
    	---------																	----------
    	
    	Internally uses a dynamic array to store the elements.						Internally uses a doubly linked list to store the elements.
    	
    	Manipulation with ArrayList is slow because it internally					Manipulation with linkedlist is faster than Arraylist because
    	uses an array.If any element is removed from the array,                     it uses a doubly linked list, so no bit shifting is required in memory.
    	all the bits are shifted in memory.
    	
    	ArrayList is better for storing and accessing data.							LinkedList is better for manipluating data.

18. List object creation scenario.

        ArrayList arrayList = new ArrayList<String>(); Tigly coupled.
    	List<String> list = new ArrayList<>();  this one, in future we want to change LinkedList,we can use it. this is what runtime polymorhphism.
    	
    	Parent parent = new Child<>(); // runtime polymorhphism.

19. Declaring a list field with the final keyword?

        public class Test{
    	
    	   public static void main(String args[]){
	   
	     final List<String> list = new ArrayList<>();
		 
		 list.add("a");
		 list.add("b");  // we can modify the list, but we can not re-assign it. 
		 
		 System.out.println(list);  // It will print the list. even if you define final. only the problem is you can not assign this list to another one.
		 
		 list = new ArrayList<>();  --> getting compile time error here.
		 
    	  }
    	}

20. How can i write custom ArrayList where i dont want to allow duplicate?
     
        Example :
        --------
    	
        public class CustomArrayList extends ArrayList{
    
        @Override
        public boolean add(Object o){
           if(this.contains(o)){
               return true;
           } else {
               return super.add(o);
           } 
        }
    
        public static void main(String args[]){
    
          CustomArrayList list1 = new CustomArrayList();
    
          list1.add(1);
          list1.add(1);
          list1.add(1);
          list1.add(2);
          list1.add(2);
    
          System.out.println(list1);  // should not contain duplicate.bcoz we added our own custom method for not allowing duplicate.
     
          }
        }
    	
    	output:
    	
    	[1,2]
	
	
21. Why set does not allow duplicate Element?
    
        Internal implementation of Set add method. It is internally used Map.
    	
    	public boolean add(E e){
    	  return map.put(e,PRESENT) == null;
    	}
    	
    	e -> is key
    	PRESENT -> is dummy object.
    	
    	
        Map key is not allowed duplicates.	
    	 
    	If you are creating custom class Student or Employee you need to contract between equals and hashcode. Because it will print the duplicate.
    	
    	if we override equals and hashcode we can get unique values.
	

22. What is the difference between Comparable and Comparator?  

        Comparable 																							Comparator
    	----------																						    ----------
    	
    	1. Provides a single sorting sequence.In other words, 							Multiple sorting sequences, we can sort the collection on the basis of
    	we can sort the collection on the basis of a single element                     multiple elements such as id, name and price etc.
    	such as id, name and price.
    	
    	2. Afftects the original class, ie. the actual class is 						does not affect the original class , ie the actual class is not modified.
    	modified.
    	
    	3. Provides compareTo() method to sort elements.								Provides compare() method to sort elements.
    	
    	4. present in java.lang															Presents in java.util
    	
    	5. We can sort the list elements of Comparablee type by 						We can sort the list elements of Comparator type by
    	Collections.sort(List) method.													Collections.sort(List,Comparator) method.
	

23. Multi comparing using comparator scenario?
		 
		 
24. What is difference between fail fast and fail safe iterator?

    Fail Fast :
	---------
	
    	- A iterator which will fail fast when we do any modification while iterating a collection is called fail fast iterator Ex: (ArrayList,HashMap and Vector)
    	  Ex: will get concurrent modification exception while modification.
    	  
    	  ArrayList...internal class .
    	  
    	  protected transient int modCount = 0;...
    	  
    	  while doing iteration we can not change the modCount. Because if you add objects in the middle of iterating , modCount value will change instead of 0 , 1. 
    	  
    	  In the code,
    	  
    	  final void checkForComodification(){
    	    if(modCount != exectedModCount){
    		  throw new ConcurrentModificationException();
    		 }
    	  }
    	  
    	  How to avoid this issue, instead of ArrayList, use CopyOnWriteArryList();   // --> fail safe iterator.
    	  
    	  List<String> iterator = list.iterator();
    	  
    	  list.add("a");
    	  list.add("b");
    	  
    	  Iterator<String> iterator = list.iterator();
    	  
    	  while(iterator.hasNext()){
    	    String element = iterator.next();
    		System.out.println(element);  
    		list.add("c");     // --> internally it is clone copy of the iteration object. list is 3  but printing is now only 2.
    		
    	  }
    	  
    	  output:
    	  
    	  a
    	  b
    	  
	
	Fail Safe :
	---------
	 
    	- Iterator who allow us to modify in middle while iterating a collection is called Non-fail Fast Iterator.
    	  Ex: CopyOnWriteArrayList, CopyOnWriteArraySet , ConcurrentHashMap.
	  
	
25. What is need of ConcurrentHashMap and How it is different from HashMap?

        Parameters 							HashMap										ConcurentHashMap
    	
    	Synchronization						Non-synchronized							Synchronzied
    	
    	Thread-safety						Not thread safety							Thread safety
    	
    	Iterator							It is fail fase and throws exception        It is fail-safe and performs iteration by multiple
    	                                    during iteration.
    										
    	Null values							It allows for storing null keys and values.	It does not allow to store null key/values.
    	
    	Performance							faster										slower than hashmap.
	
	
26. If we have Hashtable which is already synchronized they why we need concurrenthashmap.?

        Ans : Locking mechanism still same as per HashMap (lock whole underlaying DS).
    	
    	  Apply lock on HashMap ...whole object.
    	
    	  Apply lock on ConcurrentHashmap it is segment only.
	
27. We can synchronize a HashMap using collections then why can not we use that instead using ConcurrentHashMap?

        Ans :   If we used Collections.synchronizedMap(map) it will act as a synchronized Hashtable only where again locking mechanism is different.
	
28. How HashMap internally works..?

    Ans:
	
	Step 1 :
	
		Map<Employee,String>  map = new HashMap<>();
			
		When we create HashMap , internally 16  buckets are created. 
		
		0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
	
    Step 2:

         Each bucket contains LinkedList, each LinkedList contains n number of nodes.
  
         LinkedList contains node.
             Node ...n no.of nodes.
  		      Each Node contains ->   key value hash next	
    Step 3:
       
         Employee e1 = new Employuee(101,"Dowlath");	   
    	   Employee e2 = new Employuee(102,"Basha");
    	   Employee e3 = new Employuee(103,"Ariz");
    	   Employee e4 = new Employuee(104,"Arsh");
    	
    	   map.put(e1,"Dev");
    	   map.put(e2, "QA");
    	   map.put(e3,"UI");
    	   
    	   Internally put method will be like this.
    	   
    	   put(K k, V v){        6, 9, 6   // <- initially the entry will be in 6th bucket. Now...  e1 Dev 1011 null  <- last entry is null
    	                                   // e2 QA 2345 null
    	        hash(k)
			
			index = hash & (n-1)
	   }		
	   
	Step 4: 
	
	        Same value , for multiple buckets and multiple nodes in the same location it is called hashing collision.
	
	        If both are same hash value, will put into the same bucket. otherwise it will check e1.equals(e3) it will save into the same bucket.
			
			In bucket 6 , there will be 2 entries, it means two nodes.
			
			It will place in 6 only ....e1 Dev 1011 -> e3 UI 7978 null
			
	Step 5:
	
	        map.put(e4, "UI") it will put into 7 th bucket.
			
	Step 6:
	
	        map.put(null,"UI") where it will place , if key is null....the entry will place into 0th bucket. It is fixed.
			
	Step 7:  
	
	       Java 8 what is enhancedment....it is initally used LinkedList...certain threshold it will maintain balanced tree mechanism.Not be linked list.

 	

29. If key is null in hashmap then where that entry will store in map?

        It will store in 0 th bucket. it is fixed.
	
30. How TreeMap internal works?
    
	

    

    
	
	
	
	
