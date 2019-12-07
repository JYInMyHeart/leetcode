(function main() {
    const partition = (nums,lo,hi) => {


        let midd = Math.floor((hi - lo) / 2 + lo);
        let mid = nums[midd];

        let i = lo;
        let j = hi;
        while(i <= j){
            while( nums[i] < nums[mid]){
                i++;
            }
            while( nums[j] > nums[mid]){
                j--;
            }
            if(i <= j){
                let temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }

        }

        return i;

    } ;
    const quickSort = (items,left,right) => {
        let index;

        if (left < right ) {
            index = partition(items, left, right);
            quickSort(items, left, index - 1 );
            quickSort(items, index   , right);
        }

        return items;

    }
    let array = [2,1,3,5,4,7,8,6,0];
    quickSort(array,0,array.length - 1)
    console.log(array)
}());