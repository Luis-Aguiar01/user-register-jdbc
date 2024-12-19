package br.edu.ifsp.dsw1.model.strategy;

public class FactoryEncryptStrategy {
	
	private EncryptType type;
	
	public FactoryEncryptStrategy() {
		this.type = EncryptType.SHA_256;
	}
	
	public FactoryEncryptStrategy(EncryptType type) {
		this.type = type;
	}
	
	public EncryptStategy factory() {
		switch(type) {
		case SHA_256:
			return new EncryptSHA256();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public enum EncryptType {
		SHA_256
	}
}
