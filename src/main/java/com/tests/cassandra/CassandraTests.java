package com.tests.cassandra;

import java.util.Date;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;
import com.datastax.driver.core.utils.Bytes;

public class CassandraTests {

	public static void main(String[] args) {
		try (
			 Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
			 Session session = cluster.connect("test");) {
			
//			delete(session);
//			insertBlob(session);
			insertTimestamp(session);
			selectTimestamp(session);
//			update(session);
//			selectBigInt(session);
		}
	}
	
	private static void update(Session session) {
		Update update = QueryBuilder.update("testing_3");
		
		update.with(QueryBuilder.set("t", new Date()));
		
		update.where(QueryBuilder.eq("id", 11L));
		
		session.execute(update);
	}

	private static void delete(Session session) {
		Delete delete = QueryBuilder.delete().from("testing_2");
		delete.where(QueryBuilder.eq("id1", 1));
		delete.where(QueryBuilder.eq("id2", 1));
		
		ResultSet rs = session.execute(delete);
		
		System.out.println(rs);
	}
	
	private static void insertBlob(Session session) {
		Insert insert = QueryBuilder.insertInto("testing_blob");
		
		insert.value("id1", 2L)
			  .value("content", Bytes.toHexString(new byte[] {0, 1, 2, 3, 4}));
		
		ResultSet rs = session.execute(insert);
		
		System.out.println(rs);
	}

	private static void insertTimestamp(Session session) {
		Insert insert = QueryBuilder.insertInto("testing_3");
		
		insert.value("id", 11L)
			  .value("t", new Date());
		
		ResultSet rs = session.execute(insert);
		
		System.out.println(rs);
	}
	
	private static void selectTimestamp(Session session) {
		Select select = QueryBuilder.select("id", "t").from("testing_3");
		
		select.where(QueryBuilder.eq("id", 1));
		
		System.out.println(select);
		
		ResultSet rs = session.execute(select);
		
		for(Row row: rs) {
			System.out.println(row);
		}
	}

	private static void selectBigInt(Session session) {
		Select select = QueryBuilder.select("id", "xxx").from("test_type");
		
		select.where(QueryBuilder.eq("id", 1));
		
		System.out.println(select);
		
		ResultSet rs = session.execute(select);
		
		for(Row row: rs) {
			System.out.println(row);
		}
	}
}
