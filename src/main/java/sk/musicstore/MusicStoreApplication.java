package sk.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class that can be used to bootstrap and launch a Spring application from a Java main method.
 * */
@SpringBootApplication
public class MusicStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicStoreApplication.class, args);
	}
}
