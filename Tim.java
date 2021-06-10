import java.util.Arrays;
import java.util.Scanner;
public class Tim
{
    public static final int Run =32;
	public static void insertionSort(int[] arr, int left,int right){
		for (int i = left + 1; i <= right; i++){
			int temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] > temp){
				arr[j + 1] = arr[j];
				j--;}
			arr[j + 1] = temp;}
	}
	public static void merge(int[] arr, int p,int m, int r){
		int len1 = m - p + 1, len2 = r - m;
		int[] left = new int[len1];
		int[] right = new int[len2];
		for (int i = 0; i < len1; i++){
			left[i] = arr[p+i];}
		for (int i = 0; i < len2; i++){
                    right[i] = arr[m + 1 + i];
                }
		int i = 0;
		int j = 0;
		int k = p;
		while (i < len1 && j < len2){
			if (left[i] <= right[j]){
				arr[k] = left[i];
				i++;}
			else{
				arr[k] = right[j];
				j++;}
			k++;
                }
		while (i < len1){
			arr[k] = left[i];
			k++;
			i++;}
		while (j < len2){
			arr[k] = right[j];
			k++;
			j++;}
        }
	public static void timSort(int[] arr, int n){
		for (int i = 0; i < n; i += Run){
			insertionSort(arr, i,Math.min((i+31), (n - 1)));
		}
		for (int size = Run; size < n; size =2){
			for (int left = 0; left < n;left += 2 * size){
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1),(n - 1));
				if(mid < right)
					merge(arr, left, mid, right);
                        }
                }
        }
	public static void main(String[] args)
	{
            Scanner s =new Scanner(System.in);           
		int[] arr=new  int[15] ;
                System.out.println("Enter Given Array’s item");
                for (int i=0;i<arr.length;i++){
                    arr[i]=s.nextInt();
                }
		int n = arr.length;
		System.out.println("Given Array is:");
               System.out.println(Arrays.toString(arr));
        	timSort(arr, n);
               System.out.println("Sorted Array is:");
                System.out.println(Arrays.toString(arr));
	}
}