public class Main {
	public static void main(String[] args) {
		int i = 0;

		try {
			while (i < 10) {
				System.out.println("i = " + i++);
				Thread.sleep(1500);
			}
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}

	}
}