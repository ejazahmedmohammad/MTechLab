import java.util.concurrent.*;

class Chopstick {

	boolean isPicked;
	
	synchronized boolean hold() {
		if (!isPicked) {
			isPicked = true;
			return true;
		}
		return false;
	}

	synchronized void release() {
		isPicked = false;
	}

}
