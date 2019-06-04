import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;

public class MonteCarloAnalysis{

	Random rand = new Random();

	public boolean testEquality(int numberOfPeople) {
		HashSet s = new HashSet(10);
		Iterator i = s.iterator();

		for(int j=0; j<numberOfPeople; j++) {
				Integer randomNumber = rand.nextInt(365)+1;
				s.add(randomNumber);
		}
		System.out.println("Size= " + s.size());
		if(s.size()<numberOfPeople) {
			return true;
		} else {
			return false;
		}
	}

	public int testTotalCollisions(int numberOfTests, int numberOfPeople) {
		int totalCollisions = 0;

		for(int i=0; i<numberOfTests; i++) {
			boolean collision = testEquality(numberOfPeople);
			if(collision)
				totalCollisions++;
		}

		return totalCollisions;
	}
}