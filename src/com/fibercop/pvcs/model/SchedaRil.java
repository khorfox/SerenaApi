package com.fibercop.pvcs.model;

import java.util.ArrayList;
import java.util.List;

import com.serena.dmclient.api.DimensionsObjectFactory;
import com.serena.dmclient.api.DimensionsRelatedObject;
import com.serena.dmclient.api.Request;

public class SchedaRil extends Scheda {

	public SchedaRil(String name, DimensionsObjectFactory factory) {
		super(name, factory);
	}

	public SchedaRil(Request request, DimensionsObjectFactory factory) {
		super(request, factory);
	}

	@SuppressWarnings("unchecked")
	public List<SchedaRu> getRUAssociate() {
		List<SchedaRu> rus = new ArrayList<SchedaRu>();
		List<DimensionsRelatedObject> related = getRequest().getParentRequests(null);
		related.stream().forEach(el -> {
			rus.add(new SchedaRu( (Request)el.getObject(), factory));
		});
		return rus;
	}
}
