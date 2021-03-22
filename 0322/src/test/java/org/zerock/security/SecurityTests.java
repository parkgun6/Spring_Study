package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class SecurityTests {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test1() {
		
		log.info(pwEncoder);
		
	}
	
	@Test
	public void testMember() {
		
		//$2a$10$E3jKOmxg.ml26dPIZ0e4z.YAmisD6rZsHShP/3qUbGtRgSitvWL7.
		//$2a$10$CZCH5e9EqXhvkn9JF1lYqu.7mKvmtNrnl6GwhqZTHouQha1uZ81v6
		//값이 매번 달라진다.
		
		String pw = "member";
		
		String enPw = pwEncoder.encode(pw);
		
		log.info(enPw);
	}
	
	@Test
	public void testMatch() {
		
		String secret = "$2a$10$CZCH5e9EqXhvkn9JF1lYqu.7mKvmtNrnl6GwhqZTHouQha1uZ81v6";
		
		boolean result = pwEncoder.matches("member", secret);
		
		log.info(result);
	
	}
	  
	  @Test
	  public void testInsertMember() {

	    String sql = "insert into tbl_member(userid, userpw, username) values (?,?,?)";
	    
	    for(int i = 0; i < 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	        
	        pstmt.setString(2, pwEncoder.encode("pw" + i));
	        
	        if(i <80) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(3,"일반사용자"+i);
	          
	        }else if (i <90) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(3,"운영자"+i);
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(3,"관리자"+i);
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
	  
	  @Test
	  public void testInsertAuth() {
	    
	    
	    String sql = "insert into tbl_member_auth (userid, auth) values (?,?)";
	    
	    for(int i = 0; i < 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	      
	        
	        if(i <80) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(2,"ROLE_USER");
	          
	        }else if (i <90) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(2,"ROLE_MEMBER");
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(2,"ROLE_ADMIN");
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }

}
