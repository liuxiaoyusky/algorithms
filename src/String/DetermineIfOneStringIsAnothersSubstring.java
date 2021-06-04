package String;

public class DetermineIfOneStringIsAnothersSubstring {
/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0
Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
 */
//time: O(large.length()+small.length()) : hash 1 time (O(1)) for each char, and on average time complexity of double check answer is O(1)
//space: O(1): only several new int which is a constant number
    public int determineIfOneStringIsAnothersSubstring(String large, String small){
        //RabinKarp
        //assume 1: we could use arbitrary charset
        //2: take care a overflow case, by taking the module operation on a very large number
        if(large.length()<small.length()){
            return -1;
        }
        if(small.length() == 0){
            return 0;
        }
        int largePrime = 101;//to module
        int prime = 31;//to hash
        //hash = (s0*prime^k + s1*prime^(k-1)+...+sk*prime^0) % largePrime

        //find the hash value of String small and the unit hash value(seed) which is 1*prime^k % largePrime
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for(int i = 1; i < small.length();i++){//no start from i = 0 because when i = 0 seed = 1, and we cannot initial seed in loop
            seed = moduleHash(seed, 0 , prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i),prime,largePrime);
        }

        //find and check whether the first substring of large matches small
        int hash = 0;
        for(int i = 0; i < small.length(); i++){
            hash = moduleHash(hash, large.charAt(i),prime,largePrime);
        }
        if(hash == targetHash && check(large, 0 , small)){
            return 0;
        }

        //check the remaining substring by minus the hash value of the seed*large.charAt(i-1)
        // and add the hash of large.charAt(small.length()+i-1); -1 because left shift 1 in all array
        for(int i = 1; i <= large.length()-small.length();i++){
            hash = nonNegative(hash - seed * large.charAt(i-1) % largePrime,largePrime);
            hash = moduleHash(hash,large.charAt(small.length()+i),prime,largePrime);
            //double check hash value and letters since the largePrime is not large enough to promise unique substring with unique hash
            if(hash == targetHash && check(large,i,small)){
                return i;
            }
        }
        return -1;
    }

    private int moduleHash(int hash, int addition, int prime, int largePrime){
        return (hash * prime % largePrime + addition) % largePrime;
    }

    private int nonNegative( int value, int largePrime){
        if(value < 0){
            value += largePrime;
        }
        return value;
    }
//-------------------------------------------------------------------------------------------------------
//naive solution
    //time: O((large.length()-samll.length())*small.length())
    //space: O(1)
//input two string; output: index
//assume large and small not null
//iterate large string
//assume large.length = m, small.length = n. Time: O(mn)
//a faster way is using hash function. assume the strings are only 26 lower letters. Let long code = letter*26^n+letter2*26^n-1+.......
public int determineIfOneStringIsAnothersSubstringII(String large, String small) {
    //corner case
    if (large.length() < small.length()) {
        return -1;
    }

    if(small.length() == 0) {
        return 0;
    }

    for (int i = 0; i < large.length() - small.length() + 1; i++) {
        if(check(large,i,small)){
            return i;
        }
    }

    return -1;
}

    private boolean check(String large, int index, String small){
        for(int j = 0 ; j < small.length(); j++) {
            if(large.charAt(index + j) != small.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
