package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import app.Exceptions.DuplicationException;
import app.Queue.Queue;
import app.Until.ScannerSingleton;

public class App {

	public static final int TRACKS = 3;

	//
	// ─── PROGRAM ENTRY POINT ────────────────────────────────────────────────────────
	//
	public static void main(String[] args) throws Exception {

		//
		// ─── GET SCANNER INSTANCE ────────────────────────────────────────
		//
		Scanner scanner = ScannerSingleton.getInstance();

		//
		// ─── INSTANTIATE ALL THE REQUIRED QUEUE ──────────────────────────
		//
		Queue[] queues = new Queue[TRACKS];

		for (int i = 0; i < queues.length; i++) {
			queues[i] = new Queue();
		}

		//
		// ─── GET ALL INPUTS ──────────────────────────────────────────────
		//
		Queue inputs = new Queue();

		while (true) {
			System.out.print("Enter parcel number <enter <= 0 to exit> : ");

			try {
				int tmp = scanner.nextInt();

				if (tmp <= 0) {
					break;
				} else if (inputs.contains(tmp)) {
					throw new DuplicationException(tmp);
				} else {
					inputs.add(tmp);
				}
			} catch (InputMismatchException e) {
				System.out.println("[InputMismatchException catch!]");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}

		//
		// ─── SHOW INFO ───────────────────────────────────────────────────
		//
		System.out.println("Number of Tracks = " + queues.length);
		System.out.println("Number of Parcels = " + inputs.size());

		//
		// ─── START MOVING ────────────────────────────────────────────────
		//
		int current = 1;

		//
		// ─── LOOP THROUGH INPUTS ─────────────────────────────────────────
		//
		while (!inputs.isEmpty()) {

			int tmp = inputs.remove();

			if (tmp == current) {
				System.out.println("Move parcel " + tmp + " from input buffer to output buffer directly.");
				current = recursive(queues, current + 1);
			} else {
				for (int i = 0; i < queues.length; i++) {
					//
					// MAX OF TRACKS
					//
					int max = queues[i].isEmpty() ? 0 : queues[i].top();

					if (tmp > max) {
						queues[i].add(tmp);
						System.out.println("Move parcel " + tmp + " from input buffer to holding track H" + (i + 1));
						break;
					}
				}
			}
		}

		for (int i = 0; i < queues.length; i++) {
			if (!queues[i].isEmpty()) {
				System.out.println("Fail to rearrange the parcels!");
				break;
			}
		}
	}

	//
	// ─── IT WILL RECURSIVE LOOP ALL THE EXISTING TRACKS ─────────────────────────────
	//
	public static int recursive(Queue[] queues, int current) {
		int ret = current;

		for (int i = 0; i < queues.length; i++) {

			if (!queues[i].isEmpty() && queues[i].peek() == current) {
				System.out.println("Move parcel " + queues[i].remove() + " from holding buffer track H" + (i + 1) + " to output buffer");
				ret = recursive(queues, ret + 1);
				break;
			}
		}

		return ret;
	}
}