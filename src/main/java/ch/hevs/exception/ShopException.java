package ch.hevs.exception;

public class ShopException extends RuntimeException {

	public ShopException() {
		super();
	}

	public ShopException(String arg0) {
		super(arg0);
	}

	public ShopException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ShopException(Throwable arg0) {
		super(arg0);
	}

}
