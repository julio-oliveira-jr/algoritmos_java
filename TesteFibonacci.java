import java.util.Scanner;

public class TesteFibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a posição do termo desejado: ");
		System.out.println("O termo desejado é: " + Fibonacci.calcular(Integer.parseInt(input.next())));	
	}

}