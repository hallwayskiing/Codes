package hot100;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        int len=len1+len2;
        if(len%2==1){
            return getKthElement(nums1,nums2,len/2+1);
        }
        else {
            return (getKthElement(nums1,nums2,len/2)+getKthElement(nums1,nums2,len/2+1))/2.0;
        }
    }

    public int getKthElement(int[]nums1,int[]nums2,int k){
        int len1=nums1.length,len2=nums2.length;
        int index1=0,index2=0;
        int kth=0;

        while (true){
            if(index1==len1)
                return nums2[index2+k-1];
            if(index2==len2)
                return nums1[index1+k-1];
            if(k==1)
                return Math.min(nums1[index1],nums2[index2]);

            int mid=k/2;
            int newIndex1=Math.min(index1+mid,len1)-1;
            int newIndex2=Math.min(index2+mid,len2)-1;
            int pivot1=nums1[newIndex1],pivot2=nums2[newIndex2];
            if(pivot1<=pivot2){
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }
            else {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
        }
    }
}
