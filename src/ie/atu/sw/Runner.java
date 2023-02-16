package ie.atu.sw;

import static java.lang.System.out;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class Runner uses class Menu
 *
 */

public class Runner {

	/**
	 * Executes the application
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		Menu m = new Menu();
		m.start();

	}
}