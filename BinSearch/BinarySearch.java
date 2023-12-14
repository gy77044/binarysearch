// import java.util.*;

// public class BinarySearch {

//   public static int binSearch(int numbers[], int key) {
//     int start = 0, end = numbers.length - 1;
//     while (start <= end) {
//       int mid = (start + end) / 2;
//       if (numbers[mid] == key) {
//         return mid;
//       }
//       if (numbers[mid] < key) {
//         start = mid + 1;
//       } else {
//         end = mid - 1;
//       }
//     }
//     return -1;

//   }

//   public static void main(String args[]) {
//     int numbers[] = { 2, 4, 5, 6, 8, 10, 12, 14, 16 };
//     int key = 28;
//     System.out.println("index for key is : " + binSearch(numbers, key));
//   }
// }

//Reverse Array
// import java.util.*;

// public class BinarySearch {

//   public static void ReverseArray(int numbers[]) {
//     int first = 0, last = numbers.length - 1;
//     while (first < last) {
//       int temp = numbers[last];
//       numbers[last] = numbers[first];
//       numbers[first] = temp;

//       first++;
//       last--;
//     }

//   }

//   public static void main(String args[]) {
//     int numbers[] = { 2, 4, 5, 6, 8, 10, 12, 14, 16 };
//     ReverseArray(numbers);
//     for (int i = 0; i < numbers.length; i++) {
//       System.out.print(numbers[i] + " ");
//     }

//     System.out.println();
//   }
// }

// import java.util.*;

// public class BinarySearch {
//   public static void printPairs(int numbers[]) {
//     for (int i = 0; i < numbers.length - 1; i++) {
//       int curr = numbers[i];
//       for (int j = i + 1; j < numbers.length; j++) {
//         System.out.print("(" + curr + "," + numbers[j] + ") ");
//       }
//       System.out.println();
//     }
//   }

//   public static void main(String args[]) {
//     int numbers[] = { 2, 4, 6, 8, 10 };
//     printPairs(numbers);

//   }
// }

// import java.util.*;
// public class BinarySearch{
//   public static void printSubArray(int numbers[]){
//     for(int i=0;i<numbers.length;i++){
//       int start = i;
//       for(int j = i;j<numbers.length;j++){
//        int end = j;
//        for(int k = start;k<=end;k++){
//         System.out.print(numbers[k] + " ");
//        }
//        System.out.println();
//       }
//       System.out.println();
//     }
//   }
//   public static void main(String args[]){
//     int numbers[] = {2,4,6,8,10};
//     printSubArray(numbers);
//   }
// }

// // maximum subarray sum  --- by brute force

// import java.util.*;

// public class BinarySearch {
//   public static void maxSubArraySum(int numbers[]) {
//     int currSum = 0;
//     int maxSum = Integer.MIN_VALUE;
//     for (int i = 0; i < numbers.length; i++) {
//       int start = i;
//       for (int j = i; j < numbers.length; j++) {
//         int end = j;
//         currSum = 0;
//         for (int k = start; k <= end; k++) {
//           // System.out.print(numbers[k] + " ");
//           // Subarray sum
//           currSum = currSum + numbers[k];
//         }
//         System.out.println("curr sum = " + currSum);
//         if (maxSum < currSum) {
//           maxSum = currSum;
//         }
//       }
//     }
//     System.out.println("max sum = " + maxSum);
//   }

//   public static void main(String args[]) {
//     int numbers[] = { 1, -2, 6, -1, 3 };
//     maxSubArraySum(numbers);
//   }
// }

// maximum subarray sum  --- by prefix method

// import java.util.*;

// public class BinarySearch {
//   public static void maxSubArraySum(int numbers[]) {
//     int currSum = 0;
//     int maxSum = Integer.MIN_VALUE;  
//     int prefix[] = new int[numbers.length];

//     prefix[0] = numbers[0];
//     //calculate prefix array
//     for(int i=1;i<prefix.length;i++){
//       prefix[i]= prefix[i-1]+numbers[i];
//     }
//     for (int i = 0; i < numbers.length; i++) {
//       int start = i;
//       for (int j = i; j < numbers.length; j++) {
//         int end = j;
//         currSum = 0;

//         currSum= start==0? prefix[end]: prefix[end] - prefix[start-1];

//         if (maxSum < currSum) {
//           maxSum = currSum;
//         }
//       }
//     }
//     System.out.println("max sum = " + maxSum);
//   }

//   public static void main(String args[]) {
//     int numbers[] = { 1, -2, 6, -1, 3 };
//     maxSubArraySum(numbers);
//   }
// }

// //maximum subarray sum  --- by kadane's methods or kadan

// import java.util.*;

// public class BinarySearch {
//   public static void kadane(int numbers[]) {
//     int cs = 0;
//     int ms = Integer.MIN_VALUE;

//     for (int i = 0; i < numbers.length; i++) {
//       cs = cs + numbers[i];
//       if (cs < 0) {
//         cs = 0;
//       }
//       ms = Math.max(cs, ms);
//     }
//     System.out.println("our max subarray sum is : " + ms);
//   }

//   public static void main(String args[]) {
//     int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
//     kadane(numbers);
//   }
// }

// //trappedRainWater

// import java.util.*;

// public class BinarySearch {
//   public static int trappedRainWater(int height[]) {
//     int n = height.length;
//     // calculate left max boundary -array
//     int leftMax[] = new int[n];
//     leftMax[0] = height[0];
//     for (int i = 1; i < n; i++) {
//       leftMax[i] = Math.max(height[i], leftMax[i - 1]);
//     }
//     // calculate right max boundary -array
//     int rightMax[] = new int[n];
//     rightMax[n - 1] = height[n - 1];
//     for (int i = n - 2; i >= 0; i--) {
//       rightMax[i] = Math.max(height[i], rightMax[i + 1]);
//     }
//     int trappedWater = 0;
//     // loop
//     for (int i = 0; i < n; i++) {
//       // waterLevel = min(leftmax bound, rightmax bound)
//       int waterLavel = Math.min(leftMax[i], rightMax[i]);
//       // trapped water = waterLevel-height[i]
//       trappedWater += waterLavel - height[i];
//     }
//     return trappedWater;
//   }

//   public static void main(String args[]) {
//     int height[] = { 4, 2, 0, 6, 3, 2, 5 };
//     System.out.println(trappedRainWater(height));
//   }
// }

//buysell for max profit

import java.util.*;

public class BinarySearch {
  public static int buyAndSellStocks(int prices[]) {

    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (buyPrice < prices[i]) {
        int profit = prices[i] - buyPrice;
        maxProfit = Math.max(maxProfit, profit);
      } else {
        buyPrice = prices[i];
      }
    }
    return maxProfit;
  }

  public static void main(String args[]) {
    int prices[] = { 7, 1, 5, 3, 6, 4 };
    System.out.println(buyAndSellStocks(prices));
  }
}