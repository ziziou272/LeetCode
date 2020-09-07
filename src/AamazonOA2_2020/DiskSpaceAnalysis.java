package AamazonOA2_2020;

import java.util.*;

public class DiskSpaceAnalysis {
    public static int get(int computers, List<Integer> hardDisks, int length) {
        int ans = -1;

        Deque<Integer> q = new ArrayDeque<>();
        for (int right=0; right<hardDisks.size(); right++) {
            int current = hardDisks.get(right);
            while (q.size()>0 && current<q.getLast()) {
                q.removeLast();
            }
            q.addLast(current);

            if (right >= length-1) {
                ans = Math.max(ans, q.getFirst());
            }

            if (q.size() >= length) {
                q.removeFirst();
            }
        }

        return ans;
    }
    public static int maxSlidingWindow(int computer, List<Integer> nums, int k) {
        //cc
        if(nums == null || nums.size() == 0 ||nums.size() < k) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = -1;
        for(int i = 0; i < nums.size(); i++){
            //pop out the item that not in sliding item
            if(!stack.isEmpty() && i - k == stack.peekFirst())
                stack.pollFirst();
            while(!stack.isEmpty() && nums.get(i) < nums.get(stack.peekLast())){
                stack.pollLast();
            }
            stack.offerLast(i);
            if(i - k + 1 >= 0) res = Math.max(res, nums.get(stack.peekFirst()));
        }
        return res;
    }

    static int arr[] = {10, 20, 30, 50, 10, 70, 30};
    static void printMaxOfMin(int n)
    {
        // Used to find previous and next smaller
        Stack<Integer> s = new Stack<>();

        // Arrays to store previous and next smaller
        int[] left = new int[n+1];
        int[] right = new int[n+1];

        // Initialize elements of left[] and right[]
        for (int i=0; i<n; i++)
        {
            left[i] = -1;
            right[i] = n;
        }

        // Fill elements of left[] using logic discussed on
        // https://www.geeksforgeeks.org/next-greater-element/
        for (int i=0; i<n; i++)
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if (!s.empty())
                left[i] = s.peek();

            s.push(i);
        }

        // Empty the stack as stack is
// going to be used for right[]
        while (!s.empty())
            s.pop();

        // Fill elements of right[] using same logic
        for (int i = n-1 ; i>=0 ; i-- )
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if(!s.empty())
                right[i] = s.peek();

            s.push(i);
        }

        // Create and initialize answer array
        int ans[] = new int[n+1];
        for (int i=0; i<=n; i++)
            ans[i] = 0;

        // Fill answer array by comparing minimums of all
        // lengths computed using left[] and right[]
        for (int i=0; i<n; i++)
        {
            // length of the interval
            int len = right[i] - left[i] - 1;

            // arr[i] is a possible answer for this length
            // 'len' interval, check if arr[i] is more than
            // max for 'len'
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Some entries in ans[] may not be filled yet. Fill
        // them by taking values from right side of ans[]
        for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);

        // Print the result
        for (int i=1; i<=n; i++)
            System.out.print(ans[i] + " ");
    }

    public static int analyse(int computers, List<Integer> hardDisks, int length) {
        int ans = -1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int right = 0; right < hardDisks.size(); right++) {
            while (!q.isEmpty() && q.peekFirst() <= right-length){
                q.removeFirst();
            }
            int current = hardDisks.get(right);
            while (q.size() > 0 && current < hardDisks.get(q.peekLast())) {
                q.removeLast();
            }
            q.addLast(right);
            if (right >= length - 1) {
                ans = Math.max(ans, hardDisks.get(q.peekFirst()));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(get(3, Arrays.asList(8,2,4), 2));
        System.out.println( analyse(3, Arrays.asList(8,2,4), 2));
        System.out.println( maxSlidingWindow(3, Arrays.asList(8,2,4), 2));
        System.out.println(get(14, Arrays.asList(4,2,4,3,3,4,5,2,3,5,1,2,3,4), 4));
        System.out.println( analyse(14, Arrays.asList(4,2,4,3,3,4,5,2,3,5,1,2,3,4), 4));
        System.out.println( maxSlidingWindow(14, Arrays.asList(4,2,4,3,3,4,5,2,3,5,1,2,3,4), 4));
    }
}
