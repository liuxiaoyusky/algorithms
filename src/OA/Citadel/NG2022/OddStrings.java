package OA.Citadel.NG2022;
/*
We have an array of strings. Consider each string as a zero-indexed array of characters. All of the
characters will be in the range ascii[a-z] which have decimal values in the range [97 - 122].
These decimal values are called ordinal values and will be referred to as ord[a] = 97 for example.

Given an array of strings s = [s[0],s[1],...,s[n-1]], and an integer m,
we calculate a value of each s[i] of length len(s[i]) as:
    value[i] = ord[s[i][0]]^m * ord[s[i][1]]^m * ... * ord[s[i][len(s[i] - 1)]]^m

Perform the calculation on each string, sum them up and print whether their sum is EVEN or ODD.

For example, your array s = ['abc', 'abcd']. It has k = 2 strings. Rewritten as a two-dimensional array of
decimal ordinals, we have s' = [[97,98,99],]97,98,99,100]]. If our exponent m = 2, we perform the following:

c   ord     pwr     value
-------------------------
sum = 0
a   97      9409    9409
b   98      9604    90364036
c   99      9801    885657916836
***
sum = 885657916836
***
a   97      9409    9409
b   98      9604    90364036
c   99      9801    885657916836
c   100     10000   8856579168360000
sum = 8857464826276836
 */
public class OddStrings {
}
