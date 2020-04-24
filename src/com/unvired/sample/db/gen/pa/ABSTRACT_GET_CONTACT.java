//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.gen.pa;

import com.unvired.sample.db.gen.utils.BEUtility;
import com.unvired.ump.agent.IBusinessProcess;

public abstract class ABSTRACT_GET_CONTACT extends AppService {
	protected com.unvired.sample.db.gen.be.CONTACT inputCONTACT;

	public void init(IBusinessProcess process) {
		super.init(process);

		inputCONTACT = BEUtility.getCONTACT(process.getBusinessEntityInput()).get(0);

	}

	/*
	 * This generated utility function enables the DB entity {@link  com.unvired.sample.db.gen.jdbcproxy.type.CONTACT} to be mapped into the header of the entity com.unvired.sample.db.gen.be.CONTACT  
	 *
	 * @param  entity	DB entity to be mapped
	 * @return			Object representing the equivalent BusinessEntity
	 */
	public com.unvired.sample.db.gen.be.CONTACT mapJDBCToPojo(com.unvired.sample.db.gen.jdbcproxy.type.CONTACT entity) {
		com.unvired.sample.db.gen.be.CONTACT pojo = new com.unvired.sample.db.gen.be.CONTACT();
		com.unvired.sample.db.gen.be.CONTACT.CONTACT_HEADER header = (com.unvired.sample.db.gen.be.CONTACT.CONTACT_HEADER) pojo
				.getHeader();

		header.setContactId(entity.getCONTACTID());
		header.setContactName(entity.getCONTACTNAME());
		header.setPhone(entity.getPHONE());
		header.setEmail(entity.getEMAIL());

		return pojo;
	}/*
		* This generated utility function enables the DB entity {@link  com.unvired.sample.db.gen.jdbcproxy.type.CONTACT} to be mapped into the entity com.unvired.sample.db.gen.be.CONTACT  
		*
		* @return	Object representing the equivalent BusinessEntity
		*/

	public com.unvired.sample.db.gen.be.CONTACT mapJDBCToBE(com.unvired.sample.db.gen.jdbcproxy.type.CONTACT header) {
		com.unvired.sample.db.gen.be.CONTACT be = mapJDBCToPojo(header);

		return be;
	}/*
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
