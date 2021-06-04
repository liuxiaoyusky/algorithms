package OA.Tiktok;
/*
Real Programmer Game(RPG) is about having a hero swinging sticks at a monster.

The monster has N health Points(HP). It is killed when HP drops to 0 or negative.
Each swing of the hero reduces monster's HP by a (evenly distributed) random number in [0,M].

What's the probability for the hero to kill the monster in K swings?
Write a function, input N,M,K, return such probability (in [0,1]).

Constraints
0<=N<=1000
0<M<=1000
0<=K<=1000

Hints

There are 10 test cases for this problem. A non-perfect solution could still earn partial credit by getting some
of them correct.
Feel free to try out closes from math formula, simulation, brute forced enumeration, etc.
The following information could be helpful too.

1. Scores are earned iff abs(you_output - real_answer) < 5e-6.
2.Some test cases have M == 1.
3.Some test cases have M<=7 && K <=8.

Example
N = 2, M = 1, K = 3

Each swing deals damage 0 or 1. It's random, hence each with 50% chance.
All damage sequence with probability:
12.5% 0,0,0 fail
12.5% 0,0,1 fail
12.5% 0,1,0 fail
12.5% 0,1,1 win
12.5% 1,0,0 fail
12.5% 1,0,1 win
25% 1,1, win

win = 50%, aka 0.5
 */


public class RealProgrammerGameDP {
    // input: ints N, M, K
    //output: float: probability that damage equal or exceed N within K steps
    //DP: find the p that at k-1 step, we deal N - m damage, find the probability that M>m at each m.
    //iteratively do that,go iterate steps, find p with all damage can made at this step
    //starting point: p(0,0) = 1

    //at step k, find the probability that we dealt N-m at k-1 step, and sum them up
    //P(n,k) = p(n-0,k - 1)P(0) + p(n-1,k - 1)P(1) + p(n-2,k - 1)P(2)+ ... + p(n-m,k - 1)P(m)
    //since p(0) = p(1) = ..... = p(m) = 1/(m+1), we have
    // p(n,k) = (p(n-0,k - 1) + p(n-1,k - 1) + p(n-2,k - 1)+ ... + p(n-m,k - 1))/(m+1)
    // p(n,k) = (accumulated_prob[k-1][n] - accumulated_prob[k-1, n-m-)/(m+1)

    public float realProgrammerGameDP (int health, int damageCeiling, int steps) {
        //by given constains, skip the corner case for now
        //if all step made full damage still cannot reach health, return 0
        if (health > damageCeiling * steps){
            return 0;
        }
        //each row is one step, each column is summed damage made
        //outbounded check on map return 0
        //for easy-cal, do perfix sum on each row from left to cur
        float [] [] accumulatedProb = new float[steps + 1][health + 1];
        accumulatedProb[0][0] = 1;


        int curStep = 1;
        while(curStep <= steps) {
            //find the upper and lower bound of damage dealt
            int min = 0 * curStep;
            int max = Math.min(health,damageCeiling * curStep);

            //find probability of each damage dealt
            for (int i = min; i <= max; i++) {
                float curProb= (getP(curStep - 1, i, accumulatedProb, max - damageCeiling)
                - getP(curStep - 1, i - damageCeiling - 1, accumulatedProb, max - damageCeiling))
                        /(damageCeiling+1);
                //prefix sum
                accumulatedProb [curStep] [i] = getP(curStep,  i - 1, accumulatedProb, max - damageCeiling) + curProb;
            }

            curStep ++;
        }

        //we want to find 1 - accumulatedProb [steps] [health - 1] to remove all damage dealt that not enough
        return 1 - getP(steps,health - 1,accumulatedProb,health);
    }


    //helper function to get probability
    private float getP(int step, int health, float [][] accumaltedProb , int max) {
        //corner case
        //since we used prefix sum, all exceeding points on left return 0, on right return 1.
        if (health < 0) {
            return 0;
        } else if (health > max) {
            return 1;
        }

        return accumaltedProb[step][health];
    }

    public static void main(String [] args) {
        RealProgrammerGameDP rpg = new RealProgrammerGameDP();
        System.out.println(rpg.realProgrammerGameDP(2,1,3));
    }
}
