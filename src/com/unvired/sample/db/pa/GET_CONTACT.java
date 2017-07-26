//	Generated using Unvired Modeller - Build R-4.000.0039
package com.unvired.sample.db.pa;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.unvired.jdbc.proxy.Row;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;
import com.unvired.sample.db.gen.jdbcproxy.type.CONTACT;
import com.unvired.sample.db.gen.pa.ABSTRACT_GET_CONTACT;


public class GET_CONTACT extends ABSTRACT_GET_CONTACT {

	boolean success = false;
	
	private String contactId;
	private String contactName;
	private Vector<CONTACT> contactList = null;
	
	public void execute() {

		try {
			
			contactList = new Vector<CONTACT>();
			contactId = String.valueOf(inputCONTACT.getCONTACT_HEADER().getContactId());
			contactName = inputCONTACT.getCONTACT_HEADER().getContactName();
			
			contactList = getContactDetailsFromDB(contactId, contactName);
			if (contactList != null && contactList.size() > 0) {
				for (int i = 0; i < contactList.size(); i++) {
					CONTACT contact = contactList.elementAt(i);
					com.unvired.sample.db.gen.be.CONTACT contactBE = new com.unvired.sample.db.gen.be.CONTACT();
					contactBE.getCONTACT_HEADER().setContactId(Integer.valueOf(contact.getCONTACTID()));
					contactBE.getCONTACT_HEADER().setContactName(contact.getCONTACTNAME());
					contactBE.getCONTACT_HEADER().setPhone(contact.getPHONE());
					contactBE.getCONTACT_HEADER().setEmail(contact.getEMAIL());
					beList.add(contactBE);
				}
			} else {
				infoMessages.add(new InfoMessage("Contact doesn't exist.", InfoMessageType.APPLICATION,	InfoMessageCategory.FAILURE));
			}
		} catch (Exception e) {
			infoMessages.add(new InfoMessage(e.getMessage(), InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));
		}
	}
	
	private Vector<CONTACT> getContactDetailsFromDB(String contactId, String contactName){
		
		String query = "";
		
		if(contactId != null && !contactId.isEmpty() && !contactId.equals("null") && contactName != null && !contactName.isEmpty()){
			query = "SELECT * FROM contact WHERE ContactId = '" + contactId + "' AND ContactName LIKE '%" + contactName + "%'";
		} else if(contactId != null && !contactId.isEmpty() && !contactId.equals("null")) {
			query = "SELECT * FROM contact WHERE ContactId = '" + contactId + "'";
		} else if(contactName != null && !contactName.isEmpty()) {
			query = "SELECT * FROM contact WHERE ContactName LIKE '%" + contactName + "%'";
		} else {
			query = "SELECT * FROM contact";
		}
		
		Iterator<List<Row>> rowIterator = jdbcQueryNativeUNVIRED_DB_SAMPLE(query);

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
					contactList.add(contact);
				}
	        }
		}
		return contactList;
	}	
}