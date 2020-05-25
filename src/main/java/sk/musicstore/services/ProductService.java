package sk.musicstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Product;
import sk.musicstore.models.Synthesizer;
/**
 * Class for returning a complete list of products from the database
 * @see org.springframework.stereotype.Service
 * */
@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private DrumService drumService;
	@Autowired
	private GuitarService guitarService;
	@Autowired
	private SynthesizerService synthesizerService;
	/**
	 * Finds all drums, guitars and synthesizers and combines them into one list.
	 * @return a list of drums from the database
	 * @see org.springframework.scheduling.annotation.Async
	 * @throws java.util.concurrent.ExecutionException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * @throws java.lang.InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * */
	@Async
	public CompletableFuture<List<Product>> findAll() throws InterruptedException, ExecutionException{
		List<Product> listProducts=new ArrayList<Product>();
		CompletableFuture<List<Drum>> drums=drumService.findAll();
		CompletableFuture<List<Guitar>> guitars=guitarService.findAll();
		CompletableFuture<List<Synthesizer>> synthesizers=synthesizerService.findAll();
		//CompletableFuture.allOf(drums, guitars, synthesizers);
		listProducts.addAll(synthesizers.get());
		listProducts.addAll(guitars.get());
		listProducts.addAll(drums.get());
		LOGGER.info("Request to get a list of products");
		return CompletableFuture.completedFuture(listProducts);
	}
	
}
