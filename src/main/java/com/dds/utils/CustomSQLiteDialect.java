package com.dds.utils;

import org.hibernate.dialect.SQLiteDialect;

public class CustomSQLiteDialect extends SQLiteDialect {
	
	public String getAddColumnString() {
		      return "add column";

	}

}
