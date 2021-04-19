package com.dong.sort;

public class Sorts {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{1,2,3,4 ,10,3,9,7,8,5};
        Sorts sorts = new Sorts();
        //sorts.BubbleSort(nums);
        //sorts.SelectSort(nums);
        //sorts.InsertSort(nums);
        //sorts.MergeSort(nums);
        //sorts.QuickSort(nums);
        sorts.HeapSort(nums);

        for(int num:nums){
            System.out.println(num);
        }
        Thread.sleep(10000);
    }
    private void BubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
    private void swap(int[] nums ,int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }
    private void SelectSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int min = i;
            for(int j = i+1;j<len;j++){
                if(nums[min]>nums[j]){
                    swap(nums,min,j);
                }
            }
        }
    }
    private void InsertSort(int[] nums){
        int len = nums.length;
        int preindex = 0;
        for(int i =  1;i<len;i++){
            int cur = nums[i];
            preindex = i-1;
            while(preindex>=0&&nums[preindex]>cur) {
                nums[preindex + 1] = nums[preindex];
                preindex--;
            }
            nums[preindex+1] = cur;
        }
    }
    private void MergeSort(int[] nums){
        int len = nums.length;
        int[] temp = new int[len];
        if(len<2){
            return;
        }
        sort(0,len-1,nums,temp);
    }
    private void sort(int i , int j,int[] nums,int[] temp){
        if (i<j){
           int mid = (i+j)>>1;
            sort(i,mid,nums,temp);
            sort(mid+1,j,nums,temp);
            merge(i,mid,j,nums,temp);
        }

    }
    private void merge(int  i,int mid ,int j,int[] nums,int[] temp){
        int low = i;
        int index = 0;
        int high = mid+1;
        while(low<=mid&&high<=j){
            if(nums[low]<=nums[high]){
                temp[index] = nums[low];
                low++;
                index++;
            }else {
                temp[index++] = nums[high++];
            }
        }
        while(low<=mid){
            temp[index++] = nums[low++];
        }
        while(high<=j){
            temp[index++] = nums[high++];
        }
        for(int  k = 0;k<index;k++){
            nums[i+k] = temp[k];
        }
    }
    private void QuickSort(int[] nums){
        int len = nums.length;
        partition(nums,0,len-1);
    }
    private void partition(int[] nums,int left,int right){
        if(left > right){   //==?
                return;
        }
        int i = left;
        int j = right;
        int temp = nums[left];
        while(i<j){
            while(i<j&&nums[j]>=temp){    //从右开始！！
                j--;
            }
            while(i<j&&nums[i]<=temp){
                i++;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        partition(nums,left,i-1);
        partition(nums,i+1,right);
    }
    private void HeapSort(int[] nums){
        for(int i = (nums.length-1)/2;i>=0;i--){
            heapify(nums,nums.length,i);
        }
        for(int i = nums.length-1;i>=1;i--){

            swap(nums,i,0);
            heapify(nums,i,0);
        }
    }
    private void heapify(int[] nums,int len, int i){
        int k = i;
        int temp = nums[i];
        int index = 2*k+1;
        while(index<len){
            if(index+1<len){
                if(nums[index]<nums[index+1]){
                    index = index+1;
                }
            }
            if(nums[index]>temp){
                nums[k]  = nums[index];
                 k = index;
                 index = k*2+1;
            }else {
                break;
            }
        }
        nums[k] = temp;
//        int k = i, temp = list[i], index = 2 * k + 1;
//        while (index < len) {
//            if (index + 1 < len) {
//                if (list[index] < list[index + 1]) {
//                    index = index + 1;
//                }
//            }
//            if (list[index] > temp) {
//                list[k] = list[index];
//                k = index;
//                index = 2 * k + 1;
//            } else {
//                break;
//            }
//        }
//        list[k] = temp;
    }



}
