package corejava;

import java.util.Timer;
import java.util.TimerTask;
import utils.StringUtilities;

public class TimerTaskTest {
	
	private StringUtilities tool = StringUtilities.getInstance();
	
	public static void main(String[] args) {
		TimerTaskTest ttt = new TimerTaskTest();
		ttt.doScheduling(3);
	}
	
	public void doScheduling(int seconds) {
		Timer timer = new Timer(true);
		timer.schedule(new ReminderTask(), seconds, seconds);
	}
	
	class ReminderTask extends TimerTask {
		@Override
		public void run() {
			tool.println("Timer is up!" + System.currentTimeMillis());
		}
	}
}
