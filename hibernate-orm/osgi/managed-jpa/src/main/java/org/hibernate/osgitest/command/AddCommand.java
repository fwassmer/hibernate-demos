package org.hibernate.osgitest.command;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.hibernate.osgitest.DataPointService;
import org.hibernate.osgitest.entity.DataPoint;
import org.broken.datatype.DataTypeEnum;

/**
 * Created by fwassmer on 03.06.2016.
 */
@Command(scope = "dp", name = "add")
@Service
public class AddCommand implements Action {

	@Argument(index=0, name="Name", required=true, description="Name", multiValued=false)
	String name = null;

	@Reference(optional = true)
	private DataPointService dpService;

	@Override
	public Object execute() throws Exception {
		DataPoint dp = new DataPoint();
		dp.setName( name );
		dp.setDataTypeEnum(DataTypeEnum.ONE);
		dpService.add( dp );
		return null;
	}
}
