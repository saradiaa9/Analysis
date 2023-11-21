package csen703.main.assignment1;

/**
 * Write your info here
 * 
 * @Team : 4
 * @name : Sarah Diaaeldeen Hussain, Layla Abougabal, Kareem Osama.
 * @id : 52-1678, 52-9702, 52-10614.
 * @TutorialNumber : T11, T11, T11.
 */

//2 2 0 1 2
public class TheBadBatch {
	
	public static boolean TatooineToNabooDivideAndConquer(int[] fuel) {
        // Start the recursive divide and conquer algorithm
		
        return TatooineToNabooDivideAndConquerRec(fuel, 0, fuel.length - 1, 1);

    }

	private static boolean TatooineToNabooDivideAndConquerRec(int[] fuel, int start, int end, int hyperspaceCost) {
        // Base case: If there is only one planet left, check if the remaining fuel is enough
        if (start == end) {
            return fuel[start] >= hyperspaceCost;
        }

        // Divide the problem into two subproblems
        int mid = (start + end) / 2;

        // Check if Naboo can be reached by teleporting to the left and right planets separately
        boolean Left = TatooineToNabooDivideAndConquerRec(fuel, start, mid, hyperspaceCost + 1);
        boolean Right = TatooineToNabooDivideAndConquerRec(fuel, mid + 1, end, hyperspaceCost + 1);

        // Check if Naboo can be reached by teleporting to a planet in the middle
        for (int i = mid; i >= start; i--) {
            int fuelNeeded = (mid - i) + hyperspaceCost;  // Fuel needed to teleport from i to mid
            if (fuel[i] >= fuelNeeded) {
                // If there is enough fuel, check if Naboo can be reached from the middle planet
                boolean Middle = TatooineToNabooDivideAndConquerRec(fuel, i + 1, end, 1);
                if (Middle) {
                    return true;
                }
            }
        }

        // If none of the above conditions are met, return false
        return Left && Right;
    }
	
	public static boolean TatooineToNabooGreedy(int[] fuel) {
        int n = fuel.length;

        // Maximum reachable position
        int maxReachable = 0;

        // Iterate through the planets
        for (int i = 0; i < n; i++) {
            // If the current planet is not reachable, return false
            if (i > maxReachable) {
                return false;
            }

            // Update the maximum reachable position based on the current fuel
            maxReachable = Math.max(maxReachable, i + fuel[i]);

            // If Naboo is reachable, return true
            if (maxReachable >= n - 1) {
                return true;
            }
        }

        // If the loop completes, it means Naboo is not reachable
        return false;
    }

   

	public static void main(String[] args) {
		
		int [] fuel={3,2,1,1,0};
		System.out.println(TatooineToNabooDivideAndConquer(fuel));
		System.out.println(TatooineToNabooGreedy(fuel));
	}

}
