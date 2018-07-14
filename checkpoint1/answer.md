//Question: What is the time complexity of the following code
int j = 0;
for (i = 0; i < n; ++i) {
    while (j < n && arr[i] < arr[j]) {
       j++;
    }
}

My answer is D O(n)
Explaination:
At first, The i loop's complexity is n. For the inner loop, since j is always increasing if it matches the condition and there is no reset code, and from the condition, it is the fact that j is never greater than i since it will stop when i equals to j because arr[i] equals to arr[j] so arr[i] < arr[j] will be false. Thus, whatever the value of arr is, the number of times the while loop runs in the entire code is in the range of 0..n.

Then, my answer is O(n)

Ex: With arr:
1 2 3 4 5 6 7 8 9

While loop is never valid to run, the time complexity is O(n) due to the for loop.

With arr:
9 8 7 6 5 4 3 2 1

While loop runs once for each i in the for loop when i >= 1, the time complexity is still O(n) since the while loop in this case is like a statement.

With arr:
10 10 10 10 10 1 10

The while loop runs when arr[i] = 1, the total number of times the loop runs is still n - 2, thus the complexity is O(n)
