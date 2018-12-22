package drew.search;

public class SequenceSearch {
	public static void main(String args[]) {
		//search this array to find the number 100
		int [] a = new int[]{5, 16, 39, 45, 51, 98, 100, 202, 226, 321, 368, 444, 501};
		int [] b = new int[a.length + 1];
		int targetNumber = 100;
		
		b[0] = targetNumber; //из╠Ь
		for(int i = 0 ; i<a.length ; i++) { 
			b[i + 1] = a[i]; 
		}
		System.out.println("hello");
		
		int j ;
		for(j = (b.length - 1) ; b[j] != targetNumber ; j--) {
//			System.out.println(j);
//			break;
		}
		System.out.println(j);
				
	}
}
