package Bbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		// ��ʽ  jdbc:mysql://����Ip:�˿ں�/���ݿ���
				String url="jdbc:mysql://192.168.80.250:3306/da1";
				String user="root";
				String password="123456";
				Connection con =null;
				PreparedStatement pre =null;
				ResultSet res=null;
		try {
			//ѡ��Ҫ���������ݿ�����---��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����ip �˿ں�  �û���   ����      //ѡ��Ҫ���������ݿ�
			 con = DriverManager.getConnection(url, user, password);
			//��������ڣ�дsql��䣩
			 pre = con.prepareStatement("select * from student");
			//����sql��䲢�鿴���  �������ɾ�ģ��򷵻���Ӱ�������   ����ǲ�ѯ�򷵻ص��ǲ�ѯ���
			// ���е�ʱ��ע�� �������ɾ�������executeUpdate ����int  �����ѯ �����executeQuery ����ResultSet
			 res=pre.executeQuery();
			res.next();
			System.out.println(res.getInt("id")+"   "+res.getString("name"));
			//�鿴�����
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