package OA.IdealConcepts;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class charConvert {
    // Infix to postfix notation
//
// Consider that we want to write a function that converts a mathematical expression from an infix notation to postfix notation.
// Example 1:
//   `input`: 1 + 2 * 3
//              +
//             / \
//            1     *
//                 / \
//                2   3
//
//   Output: 1 2 3 * +
//
// Example 2:
//   `input`: 1 + 2 * 3 - 4 * (5 + 6)
//                      -
//                     / \
//              +           *
//             / \         / \
//            1     *     4      +
//                 / \          / \
//                2   3        5   6
//   Output: 1 2 3 * + 4 5 6 + * -
//
// To convert mathematic expression from infix notation to postfix notation we can use the following algorithm. To achieve this
// we need to have input and output queues (first-in first-out) and an operator stack (firts-in last-out).
// - If the next token in the input queue is a number, we push this token to the output queue.
// - If the next token in the input queue is an operator:
//   + Pop operators with higher presedence or equal presedence if the operator is left associative and move them to output queue.
//   + Push current operator to the operator stack.
// - If the next token is a left parenthesis, push it to the operator stack.
// - If the next token is a right parenthesis, pop all operators until a left parenthesis is found and move them to output queue.
//
// After last token was read from input queue, pop all operators and move the to output queue
//
// Assumption: consider only the following types of tokens:
// - Integer numbers (one digit)
// - Plus "+" and Minus "-" operators - Lowest presedence, Left associative
// - Multiply "*" and Divide "/" operators - Left associative
// - Power operator "^" - Highest presenence, Right associative
// - Open "(" and closing ")" patenthesis


//go through char in input 1 by 1, if number, put it directly into output queue, if operator:
//1.empty stack: put in operator
//2.same level operator or higher level operator to input: pop until
//2.1.input op > top of stack or
//2.2.staick is empty
//2.3 if input is left (, put in;
//if input is right ), pop until (

//when reaches the end of input, pop all ops in stack
//input: 1 + 2* 3 / 5 - 4
//stack: -
//output: 1 2 3 5 * /+4-

    public Queue<Character> convert (Queue<Character> input) {
        Queue<Character> output = new LinkedList<>();
        Deque<Character> ops = new LinkedList <>();
        for (Character c : input) {
            //c is a digit
            if (c - '0'>= 0 && c - '0' <= 9) {
                output.offer(c);
            } else {
                if (c == '(') {
                    ops.push(c);
                } else if (c == ')') {
                    //pop until left
                    while (!ops.isEmpty()) {
                        char cur = ops.pop();
                        if (cur == '(') {
                            break;
                        }
                        output.offer(cur);
                    }
                }
                else if (c == '^') {
                    // No need to pop anything
                    Character topC = ops.peek();
                    if (topC == c) {
                        output.offer(c);
                    } else {
                        ops.push(c);
                    }
                }
                else if (c == '/' || c == '*') {
                    // Pop ^, *, /
                    Character topC = ops.peek();
                    while (topC != null &&
                            (topC == '*'||topC == '/'||topC == '^')) {
                        output.offer(ops.pop());
                        topC = ops.peek();
                    }
                    ops.push(c);
                }
                else if (c == '+' || c == '-')
                {
                    // Pop ^, *, /, +, -
                    Character topC = ops.peek();
                    while (topC != null &&
                            (topC == '+'||topC == '-'||topC == '*'||
                                    topC == '/'||topC == '^')){
                    output.offer(ops.pop());
                    topC = ops.peek();
                }
                    ops.push(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            output.offer(ops.pop());
        }
        return output;
    }






















}
