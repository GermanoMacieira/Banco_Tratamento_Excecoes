package model;

import excecoes.BusinessException;

public class Conta {

	private Integer numeroDaConta;
	private String nomeDoTitular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limite) {
		this.numeroDaConta = numero;
		this.nomeDoTitular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limite;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numero) {
		this.numeroDaConta = numero;
	}

	public String getNomeDoTitular() {
		return nomeDoTitular;
	}

	public void setNomeDoTitular(String titular) {
		this.nomeDoTitular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limite) {
		this.limiteDeSaque = limite;
	}
	
	public void deposita(double valor) {
		saldo += valor;
	}
	
	public void limite(double valor) {
		validaLimite(valor);
		saldo -= valor;
	}
	
	private void validaLimite(double valor) {
		if (valor > getLimiteDeSaque()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		} 
		if (valor > getSaldo()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}
}

