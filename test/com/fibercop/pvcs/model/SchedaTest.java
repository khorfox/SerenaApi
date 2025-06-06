package com.fibercop.pvcs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fibercop.pvcs.PvcsConnection;
import com.fibercop.pvcs.PvcsConnectionTest;
import com.serena.dmclient.api.Request;
/*
 attr#91, name="TIPO_RIL", prompt="Tipologia scheda RIL", display-width=25, display-length=25
attr#95, name="CHIUSA_DA", prompt="Gruppo chiusura scheda", display-width=25, display-length=25
attr#224, name="FLAG_CHIUSA_TSSC", prompt="Flag chiusura da TSSC", display-width=10, display-length=10
attr#223, name="DATA_INST_RIL", prompt="Data Installazione Effettiva in Esercizio", display-width=25, display-length=25
attr#221, name="DATA_CONS_PREV", prompt="Data consegna prevista del fornitore", display-width=25, display-length=25
attr#203, name="COD_KIT", prompt="Cod KIT Valore automatico", display-width=25, display-length=25
attr#89, name="ID_AGESP", prompt="ID Richiesta Valore automatico", display-width=25, display-length=25
attr#58, name="NOME_KIT", prompt="KIT Origine", display-width=25, display-length=25
attr#202, name="COD_AGESP", prompt="Codice Richiesta", display-width=25, display-length=25
attr#78, name="STATO_TICKET_ESE", prompt="Stato Ticket Esercizio", display-width=80, display-length=80
attr#47, name="MOT_RESPINTA", prompt="Motivo per cui viene respinta", display-width=100, display-length=100
attr#200, name="MOT_CH_ANT", prompt="Motivo chiusura anticipata", display-width=35, display-length=35
attr#13, name="RICHIEDENTE", prompt="Aperta da", display-width=50, display-length=50
attr#43, name="MOT_RIT_RILAS", prompt="Motivo ritorno indietro del rilascio", display-width=240, display-length=240
attr#27, name="REL_CONSEGNA", prompt="Release di consegna", display-width=50, display-length=50
attr#33, name="TIPO_SCHEDA", prompt="Tipo Scheda", display-width=4, display-length=4
attr#34, name="NUM_SCHEDA", prompt="Numero Scheda", display-width=25, display-length=25
attr#14, name="TEL_RICHIEDENTE", prompt="Telefono Richiedente", display-width=15, display-length=15
attr#6, name="FUNZ_PRESTAZ", prompt="Funzione/Prestazione", display-width=25, display-length=25
attr#41, name="NUM_REMEDY_RIL", prompt="Codice TSSC per RIL", display-width=25, display-length=25
attr#28, name="AMB_CONSEGNA", prompt="Ambiente di consegna", display-width=25, display-length=25
attr#84, name="FLAG_PROPAG", prompt="Rilascio di tipo Propagazione?", display-width=10, display-length=10
attr#32, name="DATE_CONS", prompt="Data Creazione/Consegna", display-width=25, display-length=25
attr#20, name="MOT_ANNULLA", prompt="Motivo annullamento", display-width=25, display-length=25
attr#24, name="MODULI_MOD", prompt="Package rilasciati (TAR)", display-width=25, display-length=25
attr#90, name="TIPOLOGIA_RILASCIO", prompt="Tipologia Rilascio", display-width=25, display-length=25
attr#17, name="FORNITORE", prompt="Fornitore", display-width=25, display-length=25
attr#136, name="FORNITORE_FACTORY", prompt="Fornitore Factory", display-width=25, display-length=25
attr#18, name="TEL_FORNITORE", prompt="Telefono fornitore", display-width=15, display-length=15
attr#12, name="DESCRIZIONE", prompt="Descrizione", display-width=200, display-length=200
attr#146, name="RIL_SMCOLLAUDO", prompt="Ril relazionata ad SM di collaudo", display-width=25, display-length=25
attr#37, name="NOTE_PER_INSTAL", prompt="Note per l'installazione", display-width=100, display-length=100
attr#148, name="RIL_REQUISITO", prompt="Ril  relazionata ad RU", display-width=25, display-length=25
attr#147, name="RIL_SMESERCIZIO", prompt="Ril relazionata ad SM di esercizio", display-width=25, display-length=25
attr#50, name="NOTE_PROD", prompt="Note per l'esercizio", display-width=100, display-length=100
attr#174, name="NOTE_REGR", prompt="Note per la regressione", display-width=25, display-length=25
attr#46, name="NOTE_CHIUSURA", prompt="Note di chiusura", display-width=100, display-length=100
 */
class SchedaTest {

	@Test
	void test() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		Scheda scheda = new Scheda("UNICAC_RIL_1845",connection.getFactory());
		Request request = scheda.getRequest();
		scheda.printHistory();
		scheda.listAttributesAvailable();
		System.out.println(scheda);
		assertEquals(request.getName(),"UNICAC_RIL_1845");
		assertEquals(scheda.getStato(),"CHIUSA");
	}

}
