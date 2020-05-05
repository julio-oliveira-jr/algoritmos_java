import java.util.Scanner;

public class JogoVelha {
	String[][] posicoes = new String [3][3];
	String jogador;
	String jogador1;
	String jogador2;
	int turno = 1;
	
	Scanner input = new Scanner(System.in);
	
	void inicializarJogo() {
		System.out.println(O jogo da velha está começando);
		escolherJogador();
		inicializarTabuleiro();
		mostrarTabuleiro();
		selecionarJogada();
		
		while(!finalizarJogo()) {
			mostrarTabuleiro();
			alternarJogador(turno);
			selecionarJogada();
		} 
		
		mostrarTabuleiro();
		
		if (turno = 9) {
			System.out.println(O jogo está encerrado com empate );
		}
		else if(jogador == jogador1) {
			System.out.println(O jogador 1 venceu!);
		} else {
			System.out.println(O jogador 2 venceu!);
		}
	}
	
	void inicializarTabuleiro() {
		int elemento = 1;
		
		for(int i = 0; i  posicoes.length; i++) {
			for(int j = 0; j  posicoes[i].length; j++){
				posicoes[i][j] =  + elemento;
				elemento++;
			}
		}
	}
	
	void escolherJogador() {
		System.out.println(Escolha o seu jogador X ou O);
		jogador1 = input.next();
		jogador = jogador1;
		
		if(jogador1.contentEquals(X)) {
			jogador2 = O;
		} else {
			jogador2 = X;
		}
	}
	
	void alternarJogador(int turno) {
		if( (turno % 2) != 0) {
			System.out.println(Turno do jogador 1 );
			jogador = jogador1;
		} else {
			System.out.println(Turno do jogador2 );
			jogador = jogador2;
		}
	}
	
	void selecionarJogada() {
		System.out.println(Por favor selecione a linha e coluna );
		int linha = input.nextInt();
		int coluna = input.nextInt();
		validarPosicao(linha,coluna);
	}
	
	void validarPosicao(int linha, int coluna){
		if(posicoes[linha][coluna].contentEquals(X)  posicoes[linha][coluna].contentEquals(O)){
			System.out.println(Posicao invalida!);
			System.out.println(Escolha outra posicao!);
			
			selecionarJogada();
		} else {
			System.out.println(Posicao valida! Realizando jogada...);
			realizarJogada(linha,coluna);
		}
	}
	
	void realizarJogada (int linha, int coluna) {
		posicoes[linha][coluna] = jogador;
		turno++;
	}
	
	void mostrarTabuleiro() {
		for(int i = 0; i  posicoes.length; i++) {
			System.out.println();

			for(int j = 0; j  posicoes[i].length; j++) {
				System.out.printf(  + posicoes[i][j]);
			}
		}
		System.out.println();
	}
	
	 boolean finalizarJogo() {
		 int linhaIdentica = 0;
		 int colunaIdentica = 0;
		 int aux = 0;
		 
		 for(int i = 0; i  posicoes.length - 1; i++) {
			 	linhaIdentica = 0;
				for(int j = 0; j  posicoes[i].length - 1; j++) {
					colunaIdentica = 0;
					
					if( posicoes[i][j].equals(posicoes[i][j+1])) {
						linhaIdentica++;
						if(linhaIdentica == 2) {
							aux = linhaIdentica;
						}
					} 
					if( posicoes[i][j].equals(posicoes[i][j]) ) {
						colunaIdentica++;
						if(colunaIdentica == 2) {
							aux = colunaIdentica;
						}
					}
				}
		 }
		 
		 if(( posicoes[0][0].equals(posicoes[1][1]) && posicoes[1][1].equals(posicoes[2][2]) )   
				 ( posicoes[2][0].equals(posicoes[1][1]) && posicoes[1][2].equals(posicoes[0][2]) )  
				 (aux = 2)  
				 (turno = 9))
		 {
			 return true;
		 } else {
			 return false;
		
		 }
	 }
}