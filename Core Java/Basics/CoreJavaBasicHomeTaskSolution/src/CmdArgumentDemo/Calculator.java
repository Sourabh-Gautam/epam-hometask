package CmdArgumentDemo;

public class Calculator {
	public static void main(String[] args) {
		double n1 = Double.parseDouble(args[0]);
		double n2 = Double.parseDouble(args[1]);
		String operation = args[2];
		switch(operation) {
			case "+" : System.out.println("Addition is "+(n1+n2));
				break;
			case "-" : System.out.println("Subtraction is "+(n1-n2));
				break;
			case "/" : System.out.println("Division is "+(n1/n2));
				break;
			case "%" : System.out.println("Reminder is "+(n1%n2));
				break;
			case "*" : System.out.println("Multiplication is "+(n1*n2));
				break;
			default : System.out.println("No such operation exist");
		}
		
		System.out.println("Available Operation [ +, -, /, *, % ]");
		System.out.println("Input Pattern : FirstNum SecondNum Operation");
	}
}
