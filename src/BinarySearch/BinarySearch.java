package BinarySearch;

import java.util.ArrayList;

/**
 * Created by annakertesz on 3/28/17.
 */
public class BinarySearch {

    public static int searchWithLoop(ArrayList<Integer> primes, int targetValue) {
        int min = 0;
        int max = primes.size()-1;
        while (min<=max){
            int guess = (min+max)/2;
            if (primes.get(guess)<targetValue) min=guess+1;
            else if (primes.get(guess)>targetValue) max=guess-1;
            else return primes.indexOf(guess);
        }
        return -1;
    }

    public static int searchWithRecursive(ArrayList<Integer> primes, int targetValue, int min, int max) {
        int guess = (min + max) / 2;
        if (min <= max) return -1;
        else if (guess == targetValue) return primes.indexOf(guess);
        else if (primes.get(guess) < targetValue) min = guess + 1;
        else if (primes.get(guess) > targetValue) max = guess - 1;
        return searchWithRecursive(primes, targetValue, min, max);

    }

}
