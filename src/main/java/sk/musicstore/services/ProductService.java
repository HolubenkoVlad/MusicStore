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

@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private DrumService drumService;
	@Autowired
	private GuitarService guitarService;
	@Autowired
	private SynthesizerService synthesizerService;
	
	@Async
	public CompletableFuture<List<Product>> findAll() throws InterruptedException, ExecutionException{
		List<Product> listProducts=new ArrayList<Product>();
		CompletableFuture<List<Drum>> drums=drumService.findAll();
		CompletableFuture<List<Guitar>> guitars=guitarService.findAll();
		CompletableFuture<List<Synthesizer>> synthesizers=synthesizerService.findAll();
		CompletableFuture.allOf(drums, guitars, synthesizers);
		listProducts.addAll(synthesizers.get());
		listProducts.addAll(guitars.get());
		listProducts.addAll(drums.get());
		LOGGER.info("Request to get a list of products");
		return CompletableFuture.completedFuture(listProducts);
	}
	
}
