package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao{
	
	 public void create(Usuario u) throws Exception{
		 open();
		  stmt = con.
  prepareStatement("insert into usuario values (null,?,?,"
+ " md5(concat('cotiinformatica.com.br@mysecret1=1+1#', ?)))");
		  stmt.setString(1, u.getNome());
		  stmt.setString(2, u.getEmail());
		  stmt.setString(3, u.getSenha());
		  stmt.execute();
		 close();
	 }
   public List<Usuario> findAll() throws Exception{
    open();
	stmt = con.prepareStatement("select * from usuario");
	rs = stmt.executeQuery();
	List<Usuario> lista = new ArrayList<Usuario>();
	while(rs.next()) {   
	    Usuario u = new Usuario();
	      u.setIdUsuario(rs.getInt(1));
	      u.setNome(rs.getString(2));
	      u.setEmail(rs.getString(3));
		  u.setSenha(rs.getString(4));
      lista.add(u);
	} 
	   close();
	   return lista;
   }
   
   //teste de software Automatizado(Teste está aprendendo)
   //Programação
   //Test 
   //teste automatizado essencial (programacao) _ 400
   //javascript essencial _ 300
	 public static void main(String[] args) {
		try {
 Usuario u=new Usuario(null,"glauce","glauce@gmail.com","123");
		new UsuarioDao().create(u);
	 System.out.println("Dados gravados ...");
		}catch(Exception ex) {
			 ex.printStackTrace();
		}
	 
		 
	}
	 
	 
	 
	 

}
