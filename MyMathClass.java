import java.util.ArrayList;

public class MyMathClass<T extends Number> {

	public static <T extends Number> double stddev(ArrayList<T> list) {
		double firstSum = 0;
		double average = 0;
		double finalSum = 0;
		double finalDev = 0;

		for(int i=0; i<list.size(); i++) {
			firstSum = firstSum + list.get(i).doubleValue(); //needs .doubleValue() to compile. Works since <T> is always a decendent of Number
		}

		average = (firstSum)/list.size();

		for(int i=0; i<list.size(); i++) {
			finalSum = finalSum + (Math.pow((list.get(i).doubleValue() - average), 2));
		}

		finalDev = (finalSum)/(list.size() - 1);
		finalDev = Math.sqrt(finalDev);
		return finalDev;

	}

}