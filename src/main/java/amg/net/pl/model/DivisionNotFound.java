package amg.net.pl.model;

public class DivisionNotFound extends RuntimeException {
	public DivisionNotFound(String msg) {
		super(msg);
	}

	public DivisionNotFound() {
		super();
	}
}
