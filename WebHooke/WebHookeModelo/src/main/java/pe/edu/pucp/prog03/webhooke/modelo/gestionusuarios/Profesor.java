/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios;

import pe.edu.pucp.prog03.webhooke.modelo.programacioncursos.Curso;


public class Profesor extends Usuario {
    
    private Curso curso;
    /**
     * @return the curso
     */
    
    public Profesor(){
        this.setTipoUsuario('P');
    }
    
    public Curso getCurso() {
        
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
