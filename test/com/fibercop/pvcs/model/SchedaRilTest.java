package com.fibercop.pvcs.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fibercop.pvcs.PvcsConnection;
import com.fibercop.pvcs.PvcsConnectionTest;

class SchedaRilTest {

	@Test
	void test() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		SchedaRil scheda = new SchedaRil("UNICAC_RIL_1845",connection.getFactory());
		List<SchedaRu> rus= scheda.getRUAssociate();
		assertEquals(rus.size(),1);
		assertEquals(rus.get(0).name,"UNICAC_RU_839");
	}

}
