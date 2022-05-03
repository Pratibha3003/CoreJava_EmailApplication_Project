package com.email;

public class LargestElementFromGivingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {2,3,1,4,6};
		int max=0;
		for( int i=0;i<arr.length;i++)
		{
			
				if(arr[i]>max )
				{
					max=arr[i];
					//System.out.println(max);
				}
				//System.out.println(max);
		}
		System.out.println(max);
	}

}
