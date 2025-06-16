/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.dao.gestionusuarios;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Usuario;
import pe.edu.pucp.prog03.webhooke.dao.ICrud;
/**
 *
 * @author ASUS
 */
public interface UsuarioDAO extends ICrud<Usuario>{
    int buscarUsuarioPorCorreo(String correo);
}
