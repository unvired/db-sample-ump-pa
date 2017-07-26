package com.unvired.sample.db.gen.pa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.ump.agent.IBusinessProcess;
import com.unvired.ump.agent.IBusinessProcess.RequestType;
import com.unvired.ump.agent.IJDBCRequest;
import com.unvired.ump.agent.IJDBCResponse;
import com.unvired.ump.agent.IProcessAgent;
import com.unvired.ump.agent.InvalidOutput;

public abstract class AppService implements IProcessAgent {
	protected Vector<InfoMessage> infoMessages;
	protected Vector<String> bizEntMeta;
	protected Vector<BusinessEntity> beList;

	public IBusinessProcess process;

	public void init(IBusinessProcess process) {
		this.process = process;
		infoMessages = new Vector<InfoMessage>();
		bizEntMeta = new Vector<String>();
		beList = new Vector<BusinessEntity>();
	}

	public void finish() {
		try {
			process.setOutput(beList, null);
			process.getInfoMessageList().addAll(infoMessages);
		} catch (InvalidOutput e) {
			process.getInfoMessageList().add(new InfoMessage(e.getMessage(), InfoMessageCategory.FAILURE));
		}
	}

	/**
	* Returns the metadata of the give table name with columns names, key fields, data types etc
	* @param tableName	Name of the DB table
	* @return Handle to {@link com.unvired.jdbc.meta.TableMeta}
	*/
	public com.unvired.jdbc.meta.TableMeta jdbcTableMetaUNVIRED_DB_SAMPLE(String tableName) {
		com.unvired.jdbc.meta.TableMeta tableMeta = null;
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.TableMeta);
		jdbcRequest.setTableName(tableName);

		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		if (jdbcResponse.isSuccess()) {
			tableMeta = jdbcResponse.getTableMeta();
		}
		return tableMeta;
	}

	/**
	 * This function is used to lock rows in a table matching the provided condition 
	 * @param type			{@link com.unvired.jdbc.proxy.Row} instance describing the table to be processed
	 * @param condClause	Selection criteria to identify rows for locking in the table
	 * @return List of rows that were successfully locked for update
	 */
	public List<com.unvired.jdbc.proxy.Row> jdbcLockRowsUNVIRED_DB_SAMPLE(com.unvired.jdbc.proxy.Row type,
			com.unvired.jdbc.util.ConditionClause condClause) {
		List<com.unvired.jdbc.proxy.Row> lockedRows = null;
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Lock);
		jdbcRequest.setLock(type, condClause);

		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		if (jdbcResponse.isSuccess()) {
			lockedRows = jdbcResponse.getLockOutput();
		}
		return lockedRows;
	}

	/**
	 * This function is used to select rows from a table matching the provided condition 
	 * @param condition		Selection criteria to identify rows for locking in the table
	 * @param columns		List of columns to be fetched from the table
	 * @param type			{@link com.unvired.jdbc.proxy.Row} instance describing the table to be queried
	 * @param limit			Value to limit the number of rows returned
	 * @param offset		Value to indicate the offset in the result set to start the fetch from
	 * @return 				List of rows that match the selection criteria
	 */
	public List<com.unvired.jdbc.proxy.Row> jdbcQueryUNVIRED_DB_SAMPLE(com.unvired.jdbc.util.ConditionClause condition,
			List<String> columns, com.unvired.jdbc.proxy.Row type, int limit, int offset) {

		ArrayList<com.unvired.jdbc.proxy.Row> rowList = new ArrayList<com.unvired.jdbc.proxy.Row>();

		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Query);
		jdbcRequest.setQuery(type, columns, condition, limit, offset);

		//	Call
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);

		if (jdbcResponse.isSuccess()) {
			List<com.unvired.jdbc.proxy.Row> result = jdbcResponse.getQueryOutput();
			for (com.unvired.jdbc.proxy.Row row : result) {
				rowList.add(row);
			}
		} else {
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		}

		return rowList;
	}

	/**
	 * This function is used to select rows from a table matching the provided condition 
	 * @param condition		Selection criteria to identify rows for locking in the table
	 * @param columns		List of columns to be fetched from the table
	 * @param type			{@link com.unvired.jdbc.proxy.Row} instance describing the table to be queried
	 * @return 				List of rows that match the selection criteria
	 */
	public List<com.unvired.jdbc.proxy.Row> jdbcQueryUNVIRED_DB_SAMPLE(com.unvired.jdbc.util.ConditionClause condition,
			List<String> columns, com.unvired.jdbc.proxy.Row type) {
		ArrayList<com.unvired.jdbc.proxy.Row> rowList = new ArrayList<com.unvired.jdbc.proxy.Row>();

		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Query);
		jdbcRequest.setQuery(type, columns, condition);

		//	Call
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);

		if (jdbcResponse.isSuccess()) {
			List<com.unvired.jdbc.proxy.Row> result = jdbcResponse.getQueryOutput();
			for (com.unvired.jdbc.proxy.Row row : result) {
				rowList.add(row);
			}
		} else {
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		}

		return rowList;
	}

	/**
	 * This function is used to select rows from a table using a native query  
	 * @param nativeSQL		Native query that is specific to the DB being used
	 * @return 				List of rows that match the selection criteria
	 */
	public Iterator<List<com.unvired.jdbc.proxy.Row>> jdbcQueryNativeUNVIRED_DB_SAMPLE(String nativeSQL) {
		com.unvired.jdbc.proxy.NativeSQL nativeSQLInput = new com.unvired.jdbc.proxy.NativeSQL(nativeSQL);
		com.unvired.jdbc.proxy.NativeSQL nativeSQLOutput = null;
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Native);
		jdbcRequest.setNativeSQL(nativeSQLInput);

		//	Call
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);

		if (jdbcResponse.isSuccess()) {
			nativeSQLOutput = jdbcResponse.getNativeSQLOutput();
			return nativeSQLOutput.getResultSets();
		} else {
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		}
		return null;
	}

	/**
	 * This function is used to start a JDBC transaction  
	 * @return True if the operation succeeded or false otherwise
	 */
	public boolean jdbcStartTransactionUNVIRED_DB_SAMPLE() {
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.StartTransaction);
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		boolean success = jdbcResponse.isSuccess();
		if (!success)
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		return success;
	}

	/**
	 * This function is used to commit a JDBC transaction  
	 * @return True if the operation succeeded or false otherwise
	 */
	public boolean jdbcCommitTransactionUNVIRED_DB_SAMPLE() {
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Commit);
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		boolean success = jdbcResponse.isSuccess();
		if (!success)
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		return success;
	}

	/**
	 * This function is used to rollback a JDBC transaction  
	 * @return True if the operation succeeded or false otherwise
	 */
	public boolean jdbcRollbackTransactionUNVIRED_DB_SAMPLE() {
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Rollback);
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		boolean success = jdbcResponse.isSuccess();
		if (!success)
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		return success;
	}

	/**
	 * This function is used to perform a JDBC transaction on a table row indicated by {@link IJDBCRequest.Operation}
	 * @param operation Type of operation to perform on the table row
	 * @return True if the operation succeeded or false otherwise
	 */
	public boolean jdbcExecuteUNVIRED_DB_SAMPLE(com.unvired.jdbc.proxy.Row row, IJDBCRequest.Operation operation) {
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.InsUpdDel);
		jdbcRequest.setRow(operation, row);
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		boolean success = jdbcResponse.isSuccess();
		if (!success)
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		return success;
	}

	/**
	 * This function is used to execute a stored procedure in the database 
	 * @param process Handle to the {@link IBusinessProcess} object
	 * @param procedure Handle to the {@link com.unvired.jdbc.proxy.Procedure} object containing the stored procedure to execute
	 * @return Handle to the {@link com.unvired.jdbc.proxy.Procedure} object containing the results from execution
	 */
	public com.unvired.jdbc.proxy.Procedure jdbcExecuteProcedureUNVIRED_DB_SAMPLE(IBusinessProcess process,
			com.unvired.jdbc.proxy.Procedure procedure) {
		com.unvired.jdbc.proxy.Procedure procedureOut = null;
		IJDBCRequest jdbcRequest = (IJDBCRequest) process.createRequest(RequestType.JDBC);
		jdbcRequest.setRequestType(IJDBCRequest.Mode.Procedure);
		jdbcRequest.setProcedure(procedure);
		IJDBCResponse jdbcResponse = (IJDBCResponse) process.getService().submitRequest(jdbcRequest,
				Constant.UNVIREDDBSAMPLE_UNVIRED_DB_SAMPLE_JDBC_EXECUTE);
		boolean success = jdbcResponse.isSuccess();
		if (!success)
			process.getInfoMessageList().addAll(jdbcResponse.getInfoMessages());
		else
			procedureOut = jdbcResponse.getProcedureOutput();
		return procedureOut;
	}

}
