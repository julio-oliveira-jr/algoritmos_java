pupublic class Fibonacci {
	static int calcular(int num){
		if(num == 0) {
			return 0;
		} else if(num == 1) {
			return 1;
		}
		
		return (calcular(num-1) + calcular(num-2));
	}
}
