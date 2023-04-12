package com.userdao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionFactory;
import com.dto.UserDTO;

	public class UserDAO {
		
		public boolean saveDetails(UserDTO dto)throws Exception{
			
			Connection con = ConnectionFactory.getConnection();
			
			String sql = "insert into company (name,empemail,gender,empdept, empexperience) values (?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getDept());
			pstmt.setDouble(5, dto.getExp());
			
			int count = pstmt.executeUpdate();
			
			return count > 0;
		}
		
	public List<UserDTO>  retrieveRecords()throws Exception{
			
			List<UserDTO> lstOfUserDto = new ArrayList<>();
			Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from company");
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setDept(rs.getString(5));
				dto.setExp(rs.getDouble(6));
				lstOfUserDto.add(dto);
			}
			
			return lstOfUserDto;
		}

	public List<UserDTO>  condtionRecords(UserDTO dto)throws Exception{
		List<UserDTO> lstOfUserDto1 = new ArrayList<>();
		Connection con = ConnectionFactory.getConnection();
	StringBuilder sql = new StringBuilder("select * from company Where 1=1");

	if(dto.getDept() != null && !dto.getDept().equals("null")) {
		 sql.append(" And  empdept = ?");
	}

	if(dto.getGender() != null && !dto.getGender().equals("null")) {
		 sql.append(" And  gender = ?");
	}

	if(dto.getExp() != 0.0 && dto.getExp() == 0) {
		 sql.append(" And empexp = ?");
	}

	PreparedStatement pstmt = con.prepareStatement(sql.toString());

	int index = 1;

	if(dto.getDept() != null && !dto.getDept().equals("null")) {
		 pstmt.setString(index, dto.getDept());
		 index++;
	}

	if(dto.getGender() != null && !dto.getGender().equals("null")) {
		 pstmt.setString(index,dto.getGender());
		 index++;
	}

	if(dto.getExp() != 0.0 && dto.getExp() == 0.0) {
		 pstmt.setDouble(index, dto.getExp());
		 index++;
	}

	ResultSet rs = pstmt.executeQuery();

	while (rs.next()) {
		UserDTO dto1 = new UserDTO();
		dto1.setId(rs.getInt(1));
		dto1.setName(rs.getString(2));
		dto1.setEmail(rs.getString(3));
		dto1.setGender(rs.getString(4));
		dto1.setDept(rs.getString(5));
		dto1.setExp(rs.getDouble(6));
		lstOfUserDto1.add(dto1);
	}

	return lstOfUserDto1;


	}
	}


