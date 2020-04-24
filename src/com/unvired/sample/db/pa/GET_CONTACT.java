//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.pa;

import java.util.Iterator;
import java.util.List;

import com.unvired.jdbc.proxy.Row;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;
import com.unvired.sample.db.gen.jdbcproxy.type.CONTACT;
import com.unvired.sample.db.gen.pa.ABSTRACT_GET_CONTACT;


public class GET_CONTACT extends ABSTRACT_GET_CONTACT {

	boolean success = false;
	private String contactName;
	
	public void execute() {
		
		try {	
			contactName = inputCONTACT.getCONTACT_HEADER().getContactName();
			CONTACT contact = getContactDetailsFromDB(contactName);
			if(contact != null) {
				com.unvired.sample.db.gen.be.CONTACT contactBE = new com.unvired.sample.db.gen.be.CONTACT();
				contactBE.getCONTACT_HEADER().setContactId(Integer.valueOf(contact.getCONTACTID()));
				contactBE.getCONTACT_HEADER().setContactName(contact.getCONTACTNAME());
				contactBE.getCONTACT_HEADER().setPhone(contact.getPHONE());
				contactBE.getCONTACT_HEADER().setEmail(contact.getEMAIL());
				beList.add(contactBE);	
			}else{
				infoMessages.add(new InfoMessage("Contact doesn't exist.", InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));				
			}
		} catch (Exception e) {
			infoMessages.add(new InfoMessage(e.getMessage(), InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));
		}
	}
	
	private CONTACT getContactDetailsFromDB(String contactName){	
		
		String query = "SELECT * FROM contact WHERE ContactName LIKE '%" + contactName + "%'";
		Iterator<List<Row>> rowIterator = jdbcQueryNativeUNVIRED_DB_SAMPLE_SYSTEM(query);

		List<Row> rows = null;
		CONTACT contact = null;
		if (rowIterator != null && rowIterator.hasNext()) {
			rows = rowIterator.next();
		}
		
		if (rows != null && !rows.isEmpty()) {
			for (Row row : rows) {	        
	        	String id = (String.valueOf(row.getValue(1)));	
	        	String name = (String.valueOf(row.getValue(2)));	
	        	String phone =(String.valueOf(row.getValue(3)));	
	        	String email = (String.valueOf(row.getValue(4)));
				if(id != null && !id.isEmpty()){					
					contact = new CONTACT();
					contact.setCONTACTID(Integer.valueOf(id));
					contact.setCONTACTNAME(name);
					contact.setPHONE(phone);
					contact.setEMAIL(email);					
				}
	        }
		}
		return contact;
	}	
}