package com.fibercop.pvcs.model;

import com.serena.dmclient.api.DimensionsObjectFactory;
import com.serena.dmclient.api.Project;
import com.serena.dmclient.objects.Product;

public class Progetto extends PVCSObject {

	protected Project project;
	private Product product;
	private String prodotto;

	public Progetto(String name, DimensionsObjectFactory factory) {
		super(name, factory);
	}
	
	public Project getProject() {
		project = factory.getProject(name);
		product = project.getProduct();
		prodotto = product.getName();
		return project;
	}

	@Override
	public String toString() {
		return "Progetto [prodotto=" + prodotto + ", name=" + name + "]";
	}

}
