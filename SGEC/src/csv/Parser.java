package csv;

public interface Parser<T> {
	T parse(String nextLine);
}
