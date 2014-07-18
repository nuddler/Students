package amg.net.pl.Model;

public class DivisionNotFound extends RuntimeException {
	public DivisionNotFound(String msg) {
		super(msg);
	}

	public DivisionNotFound() {
		super();
	}
}
