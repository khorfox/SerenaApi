package com.fibercop.pvcs.report;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestDocBatch {
	
	private String nomeFile;
	
	private String linea = "BC %1s /FILENAME=%2s.doc \n";

	public RequestDocBatch(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	//BC UNICAC_RU_841 /FILENAME="C://Temp/UNICAC_RU_841.doc"
	public int scrivi(ArrayList<ReportBean> lista) {
		AtomicInteger scritti = new AtomicInteger();
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(nomeFile));
			lista.stream().forEach(el -> {
				try {
					writer.format(linea,el.getId(),el.getId());
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
