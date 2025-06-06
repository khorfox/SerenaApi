package com.fibercop.pvcs.model;

import java.util.ArrayList;
import java.util.List;

import com.serena.dmclient.api.DimensionsObjectFactory;
import com.serena.dmclient.api.DimensionsRelatedObject;
import com.serena.dmclient.api.Request;

public class SchedaRu extends Scheda {

	public SchedaRu(Request request, DimensionsObjectFactory factory) {
		super(request, factory);
	}

	public SchedaRu(String name, DimensionsObjectFactory factory) {
		super(name, factory);
	}
	
	@SuppressWarnings("unchecked")
	public List<SchedaRil> getRILAssociate() {
		List<SchedaRil> rus = new ArrayList<SchedaRil>();
		List<DimensionsRelatedObject> related = getRequest().getChildRequests(null);
		related.stream().forEach(el -> {
			rus.add(new SchedaRil( (Request)el.getObject(), factory));
		});
		return rus;
	}


}
