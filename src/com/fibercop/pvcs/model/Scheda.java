package com.fibercop.pvcs.model;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.serena.dmclient.api.ActionHistoryRec;
import com.serena.dmclient.api.DimensionsObjectFactory;
import com.serena.dmclient.api.Request;
import com.serena.dmclient.api.SystemAttributes;
import com.serena.dmclient.objects.AttributeDefinition;

public class Scheda extends PVCSObject {
	
	private List<ActionHistoryRec> history;
	private Request request;
	private String stato;
	private String fornitore;
	private Vector<?> codiceRichiesta;
	private String kitOrigine;
	private Vector<?> agesp;
	private String fornitoreFactory;

	private int[] attributes = new int[] {17,136,90,12,89,203,58,202};


	public Scheda(String name, DimensionsObjectFactory factory) {
		super(name,factory );
	}
	
	public Scheda(Request request, DimensionsObjectFactory factory) {
		super(factory );
		this.request = request;
		this.name = request.getName();
	}
	
	public Request getRequest() {
		request = factory.findRequest(name);
		request.queryAttribute(attributes);
		stato = request.getLcState();
		fornitore=(String)request.getAttribute(17);
		fornitoreFactory=(String)request.getAttribute(136);
//		agesp=(Vector<?>)request.getAttribute(89);
//		codiceRichiesta=(Vector<?>)request.getAttribute(202);
		kitOrigine=(String)request.getAttribute(58);
		return request;
	}

	public void printHistory() {
		history = request.getActionHistory();
		history.stream().forEach(el -> {
			System.out.println(el.getComment());
		});
	}
	
	public void listAttributesAvailable() {
		List<?> attrdefs = request.getAttributesForRoleSection((String) request.getAttribute(SystemAttributes.STATUS),
				"$ALL");
		Iterator<?> it = attrdefs.iterator();
		while (it.hasNext()) {
			AttributeDefinition ad = (AttributeDefinition) it.next();
			System.out.println("attr#" + ad.getNumber() + ", name=\"" + ad.getName() + "\", prompt=\""
					+ ad.getUserPrompt() + "\", display-width=" + ad.getDisplayWidth() + ", display-length="
					+ ad.getDisplayLength());
		}
	}

	public String getStato() {
		return stato;
	}

	public String getFornitore() {
		return fornitore;
	}

	public int[] getAttributes() {
		return attributes;
	}

	public void setAttributes(int[] attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "Scheda [name=" + name + ", stato=" + stato + ", fornitore=" + fornitore + ", codiceRichiesta="
				+ codiceRichiesta + ", kitOrigine=" + kitOrigine + ", agesp=" + agesp + ", fornitoreFactory="
				+ fornitoreFactory + "]";
	}


}
