package com.fibercop.pvcs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fibercop.pvcs.PvcsConnection;
import com.fibercop.pvcs.PvcsConnectionTest;
import com.serena.dmclient.api.Project;

class ProgettoTest {

	@Test
	void testGetProject() {
		PvcsConnection connection = PvcsConnectionTest.getConnection();
		Progetto progetto = new Progetto("UNICAC:UNICAC_X0524_SVIL", connection.getFactory());
		Project project = progetto.getProject();
		System.out.println(progetto);
		assertEquals(project.getName(),progetto.getName());
	}

}
