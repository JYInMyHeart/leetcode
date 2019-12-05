/**
 * @param {number[]} nums
 * @return {number[]}
 */
const sortArray = function(nums) {
    const merge = (l,r) => {
        let temp = []
        let i = 0
        let j = 0
        while(i < l.length && j < r.length){
            if(l[i] > r[j]){
                temp.push(r[j])
                j++
            }else if(l[i] < r[j]){
                temp.push(l[i])
                i++
            }else{
                temp.push(r[j])
                temp.push(r[j])
                i++
                j++
            }
        }
        while(i < l.length){
            temp.push(l[i])
            i++
        }
        while(j < r.length){
            temp.push(r[j])
            j++
        }
        return temp
    }
    if(nums.length <= 1) return nums
    let n = nums.length / 2

    let left = sortArray(nums.slice(0,n))
    let right = sortArray(nums.slice(n))
    return merge(left, right)
};
let nums = [2,1,3,54]
nums = sortArray(nums)
console.log(nums)
