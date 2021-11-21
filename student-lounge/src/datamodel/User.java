package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "UserTable")
public class User {
	
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id") // specify the column name. Without it, it will use method name
		private Integer id;
	    
	    @Column(name = "name")
		   private String name;

		   
		   @Column(name = "email")
		   private String email;
		   
		  
		   @Column(name = "password")
		   private String password;
		   
		   @Column(name = "admin")
		   private boolean admin;

		public User(Integer id, String name, String email, String password, boolean admin) {

			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.admin = admin;
		}
		public User(String name, String email, String password, boolean admin) {

			this.name = name;
			this.email = email;
			this.password = password;
			this.admin = admin;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isAdmin() {
			return admin;
		}
		public void setAdmin(boolean admin) {
			this.admin = admin;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", admin="
					+ admin + "]";
		}
		
		   
	}
