package com.fibercop.pvcs;

import com.serena.dmclient.api.DimensionsConnection;
import com.serena.dmclient.api.DimensionsConnectionDetails;
import com.serena.dmclient.api.DimensionsConnectionManager;
import com.serena.dmclient.api.DimensionsObjectFactory;

public class PvcsConnection {
	
	private String dbName;
	private String user;
	private String password;
	DimensionsConnection connection;

	public PvcsConnection(String user, String password, String dbName) {
		super();
		this.dbName = dbName;
		this.user = user;
		this.password = password;
	}
	
	public DimensionsObjectFactory getFactory() {
		DimensionsConnectionDetails details = new DimensionsConnectionDetails();
		details.setDbName(dbName);
		details.setDbConn("pcms");
		details.setUsername(user);
		details.setPassword(password);
		details.setServer("pvcsnew.telecomitalia.local:1055");
		connection = DimensionsConnectionManager.getConnection(details);
		return connection.getObjectFactory();
	}

	public void close() {
		connection.close();
	}

	public int getStatus() {
		return connection.getConnectionState(true);
	}

}
