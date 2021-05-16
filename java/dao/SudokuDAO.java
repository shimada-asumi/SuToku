package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * データベースから数独の問題を読み込む 
 */
public class SudokuDAO {
	
	public String[] test(String testNum) {
		
		// PostgreSQLへの接続情報
		Connection conn = null;
		
		// 結果を保存する配列
		String[] sudoku = new String[81];
		
		try {
			// JDBCドライバの定義
			Class.forName("org.mariadb.jdbc.Driver");
			
			// データベースへ接続
			String url = "jdbc:mariadb://HOST:PORT/TABLE?user=USERNAME&password=PASSWORD"
					+ "&useUnicode=true&characterEncoding=utf8&useServerPrepStmts=true";
			conn = DriverManager.getConnection(url);
			
			// SELECT文を準備
			String sql = "SELECT * FROM sudoku WHERE name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, testNum);
			
			// SELECT文を実行し、結果表を取得
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			// 結果表に格納されたレコードの中身を配列に格納
			int count = 0;
			for (int i = 0; i < 9; i++) {
				String[] row = new String[9];
				row = rs.getString("row" + (i + 1)).split(",");
				
				for (int j = 0; j < 9; j++) {
					// 0なら空のままで、0じゃなければその数字を入れる
					if (row[j].equals("0")) {
						sudoku[count] = "";
					} else {
						sudoku[count] = row[j];
					}
					count++;
				}
			}
		} catch(SQLException e) {
			// 例外処理
			e.printStackTrace();
			return null;
			
		} 	catch (ClassNotFoundException e) {
			// 例外処理
			e.printStackTrace();
			return null;
			
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// 例外処理
					e.printStackTrace();
					return null;
				}
			}
		}
	return sudoku;
	}
}
