package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainer {
	
	private List<Product> list=new ArrayList<Product>();
	
	public ProductsContainer() {
		list.add(new Drum());
		list.add(new Guitar());
		list.add(new Synthesizer());
	}
	
	@Override
	public boolean equals(Object obj) {
		   return (this == obj);
		}
	
	public Drum getDrum() {
		return new Drum();
	}
	
	public Guitar getGuitar(){
		return new Guitar();
	}
	
	public Synthesizer getSynthesizer() {
		return new Synthesizer();
	}


}
