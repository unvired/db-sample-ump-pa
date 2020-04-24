//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.gen.jdbcproxy.type;

import com.unvired.jdbc.meta.ColumnMeta;
import com.unvired.jdbc.meta.TableMeta;
import com.unvired.jdbc.proxy.Row;
import com.unvired.jdbc.util.JDBCConstants.Database;

public class CONTACT extends Row
{
	private static final long serialVersionUID = 1L;
	public static TableMeta METADATA;

	static
	{
		METADATA = new TableMeta(Database.mysql,"unvired_sample","","contact","TABLE","","com.unvired.sample.db.gen.jdbcproxy.type.CONTACT");
		METADATA.addColumn(new ColumnMeta(Database.mysql,1,"ContactId","",4,"INT",10,true,false,""));
		METADATA.addColumn(new ColumnMeta(Database.mysql,2,"ContactName","",12,"VARCHAR",100,false,false,""));
		METADATA.addColumn(new ColumnMeta(Database.mysql,3,"Phone","",12,"VARCHAR",12,false,false,""));
		METADATA.addColumn(new ColumnMeta(Database.mysql,4,"Email","",12,"VARCHAR",200,false,false,""));
	}

	public static String COLUMN_CONTACTID = "ContactId";
	public static String COLUMN_CONTACTNAME = "ContactName";
	public static String COLUMN_PHONE = "Phone";
	public static String COLUMN_EMAIL = "Email";

	public TableMeta getMetaData()
	{
		return METADATA;
	}

	public CONTACT()
	{
	}

	public Integer getCONTACTID(){
		return (Integer)getValue(1);
	}
	public void setCONTACTID(Integer value){
		setValue(1,value);
	}
	public String getCONTACTNAME(){
		return (String)getValue(2);
	}
	public void setCONTACTNAME(String value){
		setValue(2,value);
	}
	public String getPHONE(){
		return (String)getValue(3);
	}
	public void setPHONE(String value){
		setValue(3,value);
	}
	public String getEMAIL(){
		return (String)getValue(4);
	}
	public void setEMAIL(String value){
		setValue(4,value);
	}
}