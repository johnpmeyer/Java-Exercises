public class MonteCarloAnalysisDemo{
	public static void main(String[] args) {
		MonteCarloAnalysis demo = new MonteCarloAnalysis();

		for(int i=10; i<=100; i+=10) {
			int testNumber=100;
			int collisions = demo.testTotalCollisions(testNumber, i);
			System.out.println("After " +testNumber+" tests, there were " + collisions +
			" instances of shared birthdays in a set of " + i + " people.");
			double probability = (double)collisions/testNumber;
			System.out.println("Probability: " + probability);
		}
	}
}