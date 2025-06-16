/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.boimpl;



import pe.edu.pucp.prog03.webhooke.bo.IUsuarioBO;
import pe.edu.pucp.prog03.webhooke.dao.gestionusuarios.UsuarioDAO;
import pe.edu.pucp.prog03.webhooke.daoimpl.gestionusuarios.UsuarioDAOImplement;


/**
 *
 * @author ASUS
 */
public class UsuarioBOImpl implements IUsuarioBO{
    
    private final UsuarioDAO usuarioDao;
    
    public UsuarioBOImpl(){
        usuarioDao = new UsuarioDAOImplement();
    }
    
    @Override
    public int buscarCorreoPorUsuario(String correo) {
        return this.usuarioDao.buscarUsuarioPorCorreo(correo);
    }
}
