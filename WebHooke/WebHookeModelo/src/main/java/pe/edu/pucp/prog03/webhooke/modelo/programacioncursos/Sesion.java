/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pe.edu.pucp.prog03.webhooke.modelo.programacioncursos;
import jakarta.json.bind.annotation.JsonbDateFormat;
import pe.edu.pucp.prog03.webhooke.modelo.gestionacademia.Sede;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Alumno;
import pe.edu.pucp.prog03.webhooke.modelo.modalidades.TipoSesion;

import java.util.Date;
import pe.edu.pucp.prog03.webhooke.modelo.gestionusuarios.Profesor;
/**
 *
 * @author ASUS
 */

public class Sesion { 
    private int idHorario;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private Date fecha;
    private String modalidad;
    private boolean estado;
    private Curso curso;
    private Alumno alumno;
    private Profesor profesor;
    private TipoSesion tipoSesion;
    private Sede sede;
    private Voucher voucher;
    
    public Sesion(){
        
    }
    
    public int getIdHorario() {
        return idHorario;
    }

    /**
     * @param idHorario the idHorario to set
     */
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * @return the horaInicio
     */

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the modalidad
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the tipoSesion
     */
    public TipoSesion getTipoSesion() {
        return tipoSesion;
    }

    /**
     * @param tipoSesion the tipoSesion to set
     */
    public void setTipoSesion(TipoSesion tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    /**
     * @return the sede
     */
    public Sede getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
     /**
     * @return the voucher
     */
    public Voucher getVoucher() {
        return voucher;
    }

    /**
     * @param voucher the voucher to set
     */
    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
    
     /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
