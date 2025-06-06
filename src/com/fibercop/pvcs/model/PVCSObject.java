package com.fibercop.pvcs.model;

import com.serena.dmclient.api.DimensionsObjectFactory;

public class PVCSObject {

	protected String name;
	protected DimensionsObjectFactory factory;

	public PVCSObject(String name, DimensionsObjectFactory factory) {
		super();
		this.name = name;
		this.factory = factory;
	}

	public PVCSObject(DimensionsObjectFactory factory) {
		super();
		this.factory = factory;
	}

	public DimensionsObjectFactory getFactory() {
		return factory;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PVCSObject [name=" + name + "]";
	}

}