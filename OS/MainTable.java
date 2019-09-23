import java.util.*;

class MainTable {

	public static void main(String[]args) {
		Random r = new Random();
		Chopstick[] chopstick = new Chopstick[5];

		for (int i = 0; i < 5; i++) {
			chopstick[i] = new Chopstick();
		}

		Philosopher[] philosopher = new Philosopher[5];
		for (int i = 0; i < 5; i++) {

			philosopher[i] = new Philosopher(i, chopstick[i], chopstick[(i + 1) % 5], (r.nextInt(5) + 1) * 1000, (r.nextInt(5) + 1) * 1000);

			philosopher[i].start();
		}

	}

}
