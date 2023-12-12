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

import java.util.*;

public class BinarySearch {
  public static void maxSubArraySum(int numbers[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;  
    int prefix[] = new int[numbers.length];
    
    prefix[0] = numbers[0];
    //calculate prefix array
    for(int i=1;i<prefix.length;i++){
      prefix[i]= prefix[i-1]+numbers[i];
    }
    for (int i = 0; i < numbers.length; i++) {
      int start = i;
      for (int j = i; j < numbers.length; j++) {
        int end = j;
        currSum = 0;
        
        currSum= start==0? prefix[end]: prefix[end] - prefix[start-1];
        
        if (maxSum < currSum) {
          maxSum = currSum;
        }
      }
    }
    System.out.println("max sum = " + maxSum);
  }

  public static void main(String args[]) {
    int numbers[] = { 1, -2, 6, -1, 3 };
    maxSubArraySum(numbers);
  }
}