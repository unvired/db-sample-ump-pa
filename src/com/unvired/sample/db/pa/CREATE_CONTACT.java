//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.pa;

import java.util.Random;

import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;
import com.unvired.sample.db.gen.jdbcproxy.type.CONTACT;
import com.unvired.sample.db.gen.pa.ABSTRACT_CREATE_CONTACT;
import com.unvired.ump.agent.IJDBCRequest.Operation;

public class CREATE_CONTACT extends ABSTRACT_CREATE_CONTACT {

	boolean success = false;

	public void execute() {

		try {
			CONTACT contact = createContactAndInsertInDB();
			if (contact != null) {
				com.unvired.sample.db.gen.be.CONTACT contactBE = new com.unvired.sample.db.gen.be.CONTACT();
				contactBE.getCONTACT_HEADER().setContactId(Integer.valueOf(contact.getCONTACTID()));
				contactBE.getCONTACT_HEADER().setContactName(contact.getCONTACTNAME());
				contactBE.getCONTACT_HEADER().setPhone(contact.getPHONE());
				contactBE.getCONTACT_HEADER().setEmail(contact.getEMAIL());
				beList.add(contactBE);
			}
		} catch (Exception e) {
			infoMessages.add(new InfoMessage(e.getMessage(), InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));
		}
	}

	private CONTACT createContactAndInsertInDB() {

		CONTACT contact = new CONTACT();

		int contactId = new Random().nextInt(999);
		contact.setCONTACTID(contactId);
		contact.setCONTACTNAME(inputCONTACT.getCONTACT_HEADER().getContactName());
		contact.setPHONE(inputCONTACT.getCONTACT_HEADER().getPhone());
		contact.setEMAIL(inputCONTACT.getCONTACT_HEADER().getEmail());

		success = jdbcExecuteUNVIRED_DB_SAMPLE_SYSTEM(contact, Operation.Insert);
		if (success)
			return contact;
		else
			return null;
	}
}