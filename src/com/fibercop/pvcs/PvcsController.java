package com.fibercop.pvcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.fibercop.pvcs.model.SchedaRil;
import com.fibercop.pvcs.model.SchedaRu;
import com.fibercop.pvcs.report.RelationshipReport;
import com.fibercop.pvcs.report.ReportBean;
import com.fibercop.pvcs.report.ReportBeanOut;
import com.fibercop.pvcs.report.RequestDocBatch;
import com.fibercop.pvcs.report.RequestReport;

public class PvcsController {

	final static Function<String,Boolean> filtro = el -> el.substring(1,8).equals("UNICAC_");

	/* parametri: file, user, password, sistema
	 * esempio unica.csv TL001023 password UNICAC
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		String fileInput = args[0];
		String user = args[1];
		String password = args[2];
		String dbName = args[3];
		RequestReport report = new RequestReport(fileInput);
		ArrayList<ReportBean> lista = report.parseFile(filtro);
		System.out.println("Lette " + lista.size() + " schede");
		ArrayList<ReportBeanOut> listaOut = new ArrayList<ReportBeanOut>();
		lista.stream().filter(el->el.isRequest()).forEach(el -> {
			try {
				PvcsConnection connection = new PvcsConnection(user, password, dbName);
				SchedaRu scheda = new SchedaRu(el.getId(),connection.getFactory());
				System.out.println("Sto elaborando: " + el.getId());
				System.out.println("Stato conessione: " + connection.getStatus());
				List<SchedaRil> listaRil = scheda.getRILAssociate();
				for (SchedaRil ril:listaRil) {
					ReportBeanOut out = new ReportBeanOut(el);
					out.setRelated(ril.getName());
					listaOut.add(out);
				}
				connection.close();
			}
			catch (Exception e) {
				System.out.println("Non elaborata: " + el.getId());
			}
		});
		System.out.println("Trovate " + listaOut.size() + " relazioni");
		RelationshipReport output = new RelationshipReport("out" +fileInput);
		int scritti = output.scrivi(listaOut);
		System.out.println("Scritti: " + scritti);
		RequestDocBatch batch = new RequestDocBatch("cmd" +fileInput);
		scritti = batch.scrivi(lista);
		System.out.println("Record da processare batch: " + scritti);
	}

}
