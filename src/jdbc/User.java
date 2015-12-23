package jdbc;
//注解的实例化
@Entity("bbs_user")
public class User {
	@Column("u_id")
	private int id;
	@Column(value="u_name",length=20)
	private String name;
	@Column(value="u_pass",length=20)
	private String pass;
	
}
