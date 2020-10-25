package com.folks;

import java.util.Scanner;

public class ClassePrincipal {
	public void Cadastrar() {

	}

	public void CadastrarAdm() {

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws LoginPassInvalidException {
		Administrador adm = new Administrador("adm", "1234");
		int x = 1;
		Scanner leitor = new Scanner(System.in);

		System.out.println("--------------------");
		System.out.println("Bem-vindo ao Folks");
		System.out.println("--------------------");
		System.out.println("Digite seu login: ");

		String login = leitor.nextLine();
		System.out.println("Digite sua senha: ");
		String senha = leitor.nextLine();
		System.out.println("--------------------");

		if ((adm.getLogin().equals(login)) && (adm.getSenha().equals(senha))) {
			System.out.println("Login efetuado com sucesso");
			do {
				System.out.println("--------------------");
				System.out.println("1. Cadastrar Funcion�rio");
				System.out.println("2. Gerar Folha de Pagamento");
				System.out.println("--------------------");
				int opção = leitor.nextInt();
				switch (opção) {
				case (1): {
					System.out.println("Digite o tipo de funcion�rio");
					System.out.println("1. Gerente de Projeto");
					System.out.println("2. Programador");
					System.out.println("3. Departamento Pessoal");
					System.out.println("0. Voltar");
					System.out.println("--------------------");
					int tipo = leitor.nextInt();
					switch (tipo) {
					case (1):
						System.out.println("Digite o nome do gerente");
						String nomegerente = leitor.nextLine();
						leitor.nextLine();
						System.out.println("Digite o CPF do gerente");
						String cpfgerente = leitor.nextLine();
						System.out.println("Digite o sal�rio do gerente");
						double salariogerente = leitor.nextDouble();
						break;
					case (2):
						System.out.println("Digite o nome do programador");
						String nomepro = leitor.nextLine();
						leitor.nextLine();
						System.out.println("Digite o CPF do programador");
						String cpfpro = leitor.nextLine();
						System.out.println("Digite o sal�rio do programador");
						double salariopro = leitor.nextDouble();
						break;
					case (3):
						System.out.println("Digite um login para o funcion�rio");
						String loginfun = leitor.nextLine();
						leitor.nextLine();
						System.out.println("Digite uma senha para o funcion�rio");
						String senhafun = leitor.nextLine();
						System.out.println("Digite o nome do funcion�rio");
						String nomefun = leitor.nextLine();
						System.out.println("Digite o CPF do funcion�rio");
						String cpffun = leitor.nextLine();
						System.out.println("Digite o sal�rio do funcion�rio");
						double salariofun = leitor.nextDouble();
						break;
					case (0):
						x--;
					}
				}
				}
			} while (x < 1);
		} else {
			throw new LoginPassInvalidException("Usu�rio ou senha incorreta");
		}
		leitor.close();
	}
}
