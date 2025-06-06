package com.fibercop.pvcs.report;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.function.Function;

public class RequestReport {

	private String nomeFile;

	public RequestReport(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public ArrayList<ReportBean> parseFile(Function<String,Boolean> filter) {
		String linea;
		ArrayList<ReportBean> lista = new ArrayList<ReportBean>();
		try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
			while ((linea = reader.readLine()) != null) {
				if(filter.apply(linea)) {
					lista.add(new ReportBean(linea));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
