package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	public Account findByLogin(Login login){
		Connection conn = null;
		Account account = null;
		try{
			//JDBCドライバを読み込む
			Class.forName("com.mysql.jdbc.Driver");
			
			//データベースに接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hellodb", "root", "sql7028");
			
			//SELECT文を準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, login.getPass());
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pstmt.executeQuery();
			
			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if(rs.next()){
				//結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				
				account = new Account(userId, pass, mail, name, age);
			}
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return null;
		} finally{
			//データベースの切断
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		//見つかったユーザー、またはnullを返す。
		return account;
	}

}























