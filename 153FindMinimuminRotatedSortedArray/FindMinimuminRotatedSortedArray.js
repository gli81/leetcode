

var findMin = function(nums) {
    let l = 0;
    let r = nums.length - 1;
    while (l < r) {
        let mid = l + Math.floor((r - l) / 2);
        if (nums[mid] < nums[r]) r = mid;
        else l = mid + 1;
    }
    return nums[l];
};


function main() {
    console.log(findMin([3, 4, 5, 1, 2]));
}

if (require.main == module) {
    main();
}