class KthLargest {
    private int k;
    private List<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        list=IntStream.of(nums).boxed().collect(Collectors.toList());
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list, Comparator.reverseOrder());
        return list.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */