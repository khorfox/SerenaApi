package com.fibercop.pvcs;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.serena.dmclient.api.DimensionsObjectFactory;
import com.serena.dmclient.api.User;

public class PvcsConnectionTest {
	
	@Test
	void testGetFactory() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		DimensionsObjectFactory factory = connection.getFactory();
		User user = factory.getCurrentUser();
		assertEquals("MIAMATRICOLA",user.getName());
	}
	
	public final static PvcsConnection getConnection() {
		return new PvcsConnection("MIAMATRICOLA","password","UNICA");
	}
	

}
