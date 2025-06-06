package com.fibercop.pvcs.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fibercop.pvcs.PvcsConnection;
import com.fibercop.pvcs.PvcsConnectionTest;

class SchedaRuTest {

	@Test
	void test() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		SchedaRu scheda = new SchedaRu("UNICAC_RU_839",connection.getFactory());
		List<SchedaRil> rils= scheda.getRILAssociate();
		assertEquals(rils.size(),1);
		assertEquals(rils.get(0).name,"UNICAC_RIL_1845");
	}

	@Test
	void testFail() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		SchedaRu scheda = new SchedaRu("UNICAC_RU_799",connection.getFactory());
		List<SchedaRil> rils= scheda.getRILAssociate();
		assertEquals(rils.size(),1);
		assertEquals(rils.get(0).name,"UNICAC_RIL_1793");
	}

	@Test
	void testFail2() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		SchedaRu scheda = new SchedaRu("UNICAC_RU_202",connection.getFactory());
		List<SchedaRil> rils= scheda.getRILAssociate();
		rils.stream().forEach(el -> System.out.println(el.name));
		assertEquals(rils.size(),2);
		assertEquals(rils.get(0).name,"UNICAC_RIL_1799");
	}

}
