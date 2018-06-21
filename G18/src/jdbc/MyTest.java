package jdbc;
import java.sql.*;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
public class MyTest {
	public Connection getConnection() throws SQLException
	{
		SQLiteConfig config = new SQLiteConfig();
		// config.setReadOnly(true);   
		config.setSharedCache(true);
		config.enableRecursiveTriggers(true);
	
			
		SQLiteDataSource ds = new SQLiteDataSource(config); 
		ds.setUrl("jdbc:sqlite:sample.db");
		return ds.getConnection();
		//ds.setServerName("sample.db");

		
	}
	//create Table
	public void createTable(Connection con )throws SQLException{
		String sql = "DROP TABLE IF EXISTS test ;create table test (amount integer, depex string, balance integer); ";
		Statement stat = null;
		stat = con.createStatement();
		stat.executeUpdate(sql);
		
	}
	//drop table
	public void dropTable(Connection con)throws SQLException{
		String sql = "drop table test ";
		Statement stat = null;
		stat = con.createStatement();
		stat.executeUpdate(sql);
	}
	
	//新增
	public void insert(Connection con,int amount,String depex,int balance)throws SQLException{
		String sql = "insert into test (amount,depex,balance) values(?,?,?)";
		PreparedStatement pst = null;
		pst = con.prepareStatement(sql);
		int idx = 1 ; 
		pst.setInt(idx++, amount);
		pst.setString(idx++, depex);
		pst.setInt(idx++,balance);
		pst.executeUpdate();
		
	}
	
	public void selectAll(Connection con)throws SQLException{
		String sql = "select * from test";
		Statement stat = null;
		ResultSet rs = null;
		stat = con.createStatement();
		rs = stat.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getInt("amount")+"\t"+rs.getString("depex")+"\t"+rs.getInt("balance"));
		}
	}
	public static void main(String args[]) throws SQLException{
		MyTest test = new MyTest();
		Connection con = test.getConnection();
		//建立table
        test.createTable(con);
        //新增資料
        test.insert(con, 2000, "存", 2000);
        test.insert(con, 1500, "取", 500);
        test.insert(con, 3500, "存", 4000);
        
        //查詢顯示資料
        System.out.println("金額:  存/取:    餘額:");
        test.selectAll(con);
        
        //刪除table
        test.dropTable(con);
        
        con.close();
	}
}
