import java.util.concurrent. * ;

class Philosopher extends Thread {
	int id;
	Chopstick leftChopstick;
	Chopstick rightChopstick;
	int thinkTime,
	eatTime;

	Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, int ttime, int etime) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.thinkTime = ttime;
		this.eatTime = etime;

	}

	public void run() {
		startEating();
	}

	void startEating() {

		if (id % 2 == 0) {
			while (!leftChopstick.hold());
			while (!rightChopstick.hold());

		} else {
			while (!rightChopstick.hold());
			while (!leftChopstick.hold());

		}
		System.out.println("Philosopher " + id + " hold both chop sticks and started eating");

		try {
			Thread.sleep(eatTime);
		} catch (Exception e) {

			System.out.println("some error");
		}
		startThinking();
	}

	void startThinking() {
		System.out.println("Philosopher " + id + " Started Thinking");
		rightChopstick.release();
		leftChopstick.release();
		try {
			Thread.sleep(thinkTime);
		} catch (Exception e) {
			System.out.println("some error");
		}
		startEating();
	}
}
