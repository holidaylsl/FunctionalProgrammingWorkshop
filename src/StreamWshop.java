import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamWshop {

	public static void main(String[] args) {
		List<Staff> sList = new ArrayList<>();
	      sList.add(new Staff("6c0231c1", "John", 5, 4293));
	      sList.add(new Staff("270d0145", "Mike", 6, 6530));
	      sList.add(new Staff("e75a1d7e", "Jean", 3, 2220));
	      sList.add(new Staff("c1c0a83a", "Kim", 4, 3390));
	      
	      // Exercise 1: Using streams' forEach(), 
	      // print the name of every staff
	      System.out.println("[Exercise 1: ForEach]");
	      sList.stream().forEach(x->System.out.println(x.getName()));

	      // Exercise 2: Using streams, 
	      // compute the total salary of all staff
	      System.out.println("\n[Exercise 2: Sum]");
	      float totalSalary = sList.stream().map(x->x.getSalary()).reduce((float)0, (x1,x2)->x1+x2);
	      System.out.println("Total Salary is: " + totalSalary);
	      
	      // Exercise 3: Using streams' filter(), 
	      // retrieve all salary that are more than 
	      // 3500 into a List, then print each of the 
	      // object within the List
	      System.out.println("\n[Exercise 3: Filter]");
	      sList.stream().map(x->x.getSalary()).filter(x->x>3500).forEach(x->System.out.println(x));
	      
	      // Exercise 4: Using streams' map(), print 
	      // the list of increments that are less 
	      // than 200; given a staff's increment is 
	      // such that a grade of 5 and above 
	      // will yield a 8% increment (of the staff's 
	      // current salary), while any other grades
	      // will only yield a 4% increment.
	      System.out.println("\n[Exercise 4: Map]");
	      sList.stream().map(x->x.getGrade()>4?x.getSalary()*0.08:x.getSalary()*0.04).filter(x->x<200).forEach(x->System.out.println(x));
	      
	      // Exercise 5: Using streams' sort(), sort 
	      // the staff by salary in ascending 
	      // order (least salary first) and print out
	      // each staff object
	      // You may need to add necessary methods
	      // to Staff class
	      System.out.println("\n[Exercise 5: Sort]");
	      sList.stream().sorted((s1,s2)->((Float)(s1.getSalary())).compareTo((Float)(s2.getSalary()))).forEach(x->System.out.println(x));
	      
	      // Exercise 6: Using streams' max(), display 
	      // the highest salary among the staff
	      System.out.println("\n[Exercise 6: Max]");
	      float hs = sList.stream().map(x->x.getSalary()).max((x1,x2)->(int)(x1-x2)).get();
	      System.out.println(hs);
	      // Exercise 7: Using streams' reduce(), 
	      // implement your own "max" function 
	      // to display the highest salary among the staff
	      System.out.println("\n[Exercise 7: Reduce");
	      float hiS = sList.stream().map(x->x.getSalary()).reduce((float)0, (x1,x2)->x1>x2?x1:x2);
	      System.out.print(hiS);

	}

}
