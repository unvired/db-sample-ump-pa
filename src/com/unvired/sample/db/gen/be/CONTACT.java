//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.gen.be;

import java.util.ArrayList;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class CONTACT extends BusinessEntity {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "CONTACT";
	public CONTACT()
	{
		setName(NAME);
		setHeader(new CONTACT_HEADER());
	}

	public CONTACT_HEADER getCONTACT_HEADER()
	{
		return (CONTACT_HEADER)super.getHeader();
	}

	public static class CONTACT_HEADER extends Structure
	{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "CONTACT_HEADER";

		public static final String FLD_ContactId = "ContactId";
		public static final String FLD_ContactName = "ContactName";
		public static final String FLD_Phone = "Phone";
		public static final String FLD_Email = "Email";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_ContactId);
			FIELDS.add(FLD_ContactName);
			FIELDS.add(FLD_Phone);
			FIELDS.add(FLD_Email);
		}

		public CONTACT_HEADER()
		{
			setName(NAME);
		}

		public Integer getContactId()
		{
			Integer integer = null;
			try
			{
				integer = Integer.valueOf(getField(FLD_ContactId));
			}
			catch(Exception ex)
			{}
			return integer;
		}

		public void setContactId(Integer value)
		{
			if(value != null)
				addField(FLD_ContactId, value.toString());
		}

		public String getContactName()
		{
			return getField(FLD_ContactName);
		}

		public void setContactName(String value)
		{
			if(value != null)
				addField(FLD_ContactName, value);
		}

		public String getPhone()
		{
			return getField(FLD_Phone);
		}

		public void setPhone(String value)
		{
			if(value != null)
				addField(FLD_Phone, value);
		}

		public String getEmail()
		{
			return getField(FLD_Email);
		}

		public void setEmail(String value)
		{
			if(value != null)
				addField(FLD_Email, value);
		}

	}
}