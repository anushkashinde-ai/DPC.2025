class Day7 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0; // edge case: less than 3 bars can't trap water

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Day7 sol = new Day7();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(height1)); // 6

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(sol.trap(height2)); // 9

        int[] height3 = {1,1,1};
        System.out.println(sol.trap(height3)); // 0

        int[] height4 = {5};
        System.out.println(sol.trap(height4)); // 0

        int[] height5 = {2,0,2};
        System.out.println(sol.trap(height5)); // 2
    }
}