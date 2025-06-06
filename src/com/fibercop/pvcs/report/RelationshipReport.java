package com.fibercop.pvcs.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RelationshipReport {
	
	private String nomeFile;

	public RelationshipReport(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public int scrivi(ArrayList<ReportBeanOut> lista) {
		AtomicInteger scritti = new AtomicInteger();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile));
			lista.stream().forEach(el -> {
				try {
					writer.write(el.id + ';' + el.related + '\n');
					scritti.incrementAndGet();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scritti.get();
	}

}
