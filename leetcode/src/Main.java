import java.util.*;

public class Main {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else if (target == nums[mid]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]) {
                if (target == nums[mid]) {
                    return mid;
                } else {
                    left++;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else if (target == nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // [3,1], 1
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
    }
}
