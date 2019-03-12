package top.bluesword.java.util;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			double b = scanner.nextDouble();
			int c = scanner.nextInt();
			System.out.print(b%c==0?"YES":"NO");
		}
	}

}