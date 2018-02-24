package Bbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		// 格式  jdbc:mysql://主机Ip:端口号/数据库名
				String url="jdbc:mysql://192.168.80.250:3306/da1";
				String user="root";
				String password="123456";
				Connection con =null;
				PreparedStatement pre =null;
				ResultSet res=null;
		try {
			//选择要操作的数据库类型---加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 主机ip 端口号  用户名   密码      //选择要操作的数据库
			 con = DriverManager.getConnection(url, user, password);
			//创建命令窗口（写sql语句）
			 pre = con.prepareStatement("select * from student");
			//运行sql语句并查看结果  如果是增删改，则返回受影响的行数   如果是查询则返回的是查询结果
			// 运行的时候注意 如果是增删改则调用executeUpdate 返回int  如果查询 则调用executeQuery 返回ResultSet
			 res=pre.executeQuery();
			res.next();
			System.out.println(res.getInt("id")+"   "+res.getString("name"));
			//查看结果集
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(res!=null)
					res.close();
				if(pre!=null)
					pre.close();
				if(con!=null)
					con.close();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}