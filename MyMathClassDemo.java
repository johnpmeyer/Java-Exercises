import java.util.ArrayList;

public class MyMathClassDemo{
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Double> doubleList = new ArrayList<Double>();
		ArrayList<String> stringList = new ArrayList<String>();

		System.out.println("Integer List Contents:");
		for(int i=1; i<10 ; i++) {
			intList.add(i*2);
			System.out.print(intList.get(i-1) + " ");
		}
		System.out.println("\n");

		System.out.println("Double List Contents:");
		for(int i=1; i<10; i++) {
			doubleList.add(i*1.5);
			System.out.print(doubleList.get(i-1) + " ");
		}
		System.out.println("\n");

		System.out.println("String List Contents:");
		for(int i=1; i<10; i++) {
			stringList.add("Eyyy");
			System.out.print(stringList.get(i-1) + " ");
		}
		System.out.println("\n");

		System.out.println("Calculating Standard Deviation Of Integer Class");
		System.out.println(MyMathClass.stddev(intList));

		System.out.println("\nCalculating Standard Deviation Of Double Class");
		System.out.println(MyMathClass.stddev(doubleList));

		System.out.println("\nCalculating Standard Deviation Of String Class");
		System.out.println(MyMathClass.stddev(stringList));



		 double [] d = new double[10];
		 for(int i = 1; i <=10; i++)
		 d[i-1]=i;
		 double total = 0;
		 for(int i=0;i<d.length;i++)
		 	System.out.print(d[i] + " ");
		 System.out.println("\n");
		 double average = 0;
		 for(int i = 0; i < 10; i++)
		 total += d[i];
		 average = total/10;
		 System.out.println("average "+average);
		 total = 0;
		 for(int i = 0; i < 10; i++)
		 total += (d[i] - average)*(d[i]-average);
		 total /= 9;
		 double std = Math.sqrt(total);
		 System.out.println("Stdev = " + std);

	}
}