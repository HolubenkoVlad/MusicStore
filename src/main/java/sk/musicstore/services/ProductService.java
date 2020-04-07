package sk.musicstore.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.musicstore.models.Product;

@Service
public class ProductService {

	@Autowired
	private DrumService drumService;
	@Autowired
	private GuitarService guitarService;
	@Autowired
	private SynthesizerService synthesizerService;
	
	public List<Product> findAll(){
		List<Product> listProducts=new ArrayList<Product>();
		listProducts.addAll(synthesizerService.findAll());
		listProducts.addAll(guitarService.findAll());
		listProducts.addAll(drumService.findAll());
		return listProducts;
	}
	
}
