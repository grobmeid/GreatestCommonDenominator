package GCD;
import java.util.Scanner;
import java.util.ArrayList;

public class Math {

	public static void main(String arr[]) {
		
		System.out.print("Enter your first number for GCD: ");
		Scanner input = new Scanner(System.in);
		int number1 = input.nextInt();
		System.out.print("Enter your second number for GCD: ");
		Scanner input2 = new Scanner(System.in);
		int number2 = input2.nextInt();

		System.out.println("Higher number is: " + number1);
		System.out.println("Lower number is: " + number2);
		
		greatestCommonDenom(number1, number2);
		
	}
	
	
	public static void greatestCommonDenom(int num1, int num2) {
		boolean checkRemainder = true;
		int remainder;
		int division;
		int i = 2;
		ArrayList<Integer> firstColumn = new ArrayList<Integer>(100);
		ArrayList<Integer> secondColumn = new ArrayList<Integer>(100);
		ArrayList<Integer> thirdColumn = new ArrayList<Integer>(100);
		while (checkRemainder = true) {
			//Setting first value to new second value
			division = num1/num2;
			
			
			remainder = (num1 - (num2*division));
			
			//defining columns in array list for work, easier to manipulate
			//******************************************
			firstColumn.add(num1);
			secondColumn.add(num1);
			secondColumn.add(1);
			secondColumn.add(0);
			thirdColumn.add(num2);
			thirdColumn.add(0);
			thirdColumn.add(1);
			firstColumn.add(num2);
			firstColumn.add(remainder);
			//******************************************
			int newNum = secondColumn.get(1) - (secondColumn.get(2)*division);
			secondColumn.add(newNum);
			int newNum2 = thirdColumn.get(1) - (thirdColumn.get(2)*division);
			thirdColumn.add(newNum2);
			while (remainder != 0) {
				num1 = num2;
				//Setting second value to remainder value
				num2 = remainder;
				//Performing operation from above
				division = num1/num2;
				remainder = (num1 - (num2*division));
				firstColumn.add(remainder);
			
				
				newNum = secondColumn.get(i) - (secondColumn.get(i+1)*division);
				secondColumn.add(newNum);
			
				newNum2 = thirdColumn.get(i) - (thirdColumn.get(i+1)*division);
				thirdColumn.add(newNum2);
				i++;
				if (i > 6) {
					break;
				}
			}

			System.out.println("Numbers from remainder: " + firstColumn);
			System.out.println("Multiplying division across row and subtracting from above for first number: " + secondColumn);
			System.out.println("Multiplying division across row and subtracting from above for second number: " + thirdColumn);
			
			
			if (remainder == 0) {
				int index = firstColumn.size() -1;
				firstColumn.remove(index);
				int index1 = secondColumn.size() -1;
				secondColumn.remove(index1);
				int index2 = thirdColumn.size() -1;
				thirdColumn.remove(index2);
				//Just printing out to remove zero value, to get numbers needed for GCD
				System.out.println(firstColumn);
				System.out.println(secondColumn);
				System.out.println(thirdColumn);
				int firstHalf = (firstColumn.get(0))*(secondColumn.get(secondColumn.size()-1));
				int secondHalf = (firstColumn.get(1))*(thirdColumn.get(thirdColumn.size()-1));
				int greatestCommonDenominator = firstHalf + secondHalf;
				System.out.println("The Greatest Common Denominator is: " + greatestCommonDenominator);
				checkRemainder = false;
				break;
			}

	}
	}
	
}

