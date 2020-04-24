//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.sample.db.gen.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;
import com.unvired.sample.db.gen.be.CONTACT;

public class BEUtility
{
	public static List<CONTACT> getCONTACT(List<BusinessEntity> beList)
	{
		ArrayList<CONTACT> typedBEs = new ArrayList<CONTACT>();

		if(beList != null)
		{
			for (BusinessEntity be : beList)
			{
				if(be.getName().equals(CONTACT.NAME))
				{
					CONTACT typedBE = new CONTACT();
					typedBEs.add(typedBE);
					for (Entry<String, String> field : be.getHeader().getFieldsInOrder().entrySet())
					{
						typedBE.getHeader().addField(field.getKey(), field.getValue());
					}

					//	Process each item individually
					for (Structure item : be.getItems())
					{
					}
				}
			}
		}
		return typedBEs;
	}

}