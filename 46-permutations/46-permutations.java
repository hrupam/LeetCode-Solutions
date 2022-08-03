class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        f(0, nums.length, nums, res);
        return res;
    }

    private static void f(int i, int n, int[] nums, List<List<Integer>> list) {
        if (i == n) {
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int l = i; l < n; l++) {
            swap(i, l, nums);
            f(i + 1, n, nums, list);
            swap(i, l, nums);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
