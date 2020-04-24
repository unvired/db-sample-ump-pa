//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.gen.pa;

import com.unvired.sample.db.gen.utils.BEUtility;
import com.unvired.ump.agent.IBusinessProcess;

public abstract class ABSTRACT_CREATE_CONTACT extends AppService {
	protected com.unvired.sample.db.gen.be.CONTACT inputCONTACT;

	public void init(IBusinessProcess process) {
		super.init(process);

		inputCONTACT = BEUtility.getCONTACT(process.getBusinessEntityInput()).get(0);

	}

	/*
	 * This generated utility function enables the Business Entity {@link com.unvired.sample.db.gen.be.CONTACT} to be mapped into the DB entity {@link  com.unvired.sample.db.gen.jdbcproxy.type.CONTACT}
	 *
	 * @param  pojo		Business Entity to be mapped
	 * @return			Object representing the equivalent DB entity
	 */
	public com.unvired.sample.db.gen.jdbcproxy.type.CONTACT mapPojoToJDBC(com.unvired.sample.db.gen.be.CONTACT pojo) {
		com.unvired.sample.db.gen.jdbcproxy.type.CONTACT entity = new com.unvired.sample.db.gen.jdbcproxy.type.CONTACT();
		com.unvired.sample.db.gen.be.CONTACT.CONTACT_HEADER header = (com.unvired.sample.db.gen.be.CONTACT.CONTACT_HEADER) pojo
				.getHeader();

		entity.setCONTACTID(header.getContactId());
		entity.setCONTACTNAME(header.getContactName());
		entity.setPHONE(header.getPhone());
		entity.setEMAIL(header.getEmail());

		return entity;
	}

}
