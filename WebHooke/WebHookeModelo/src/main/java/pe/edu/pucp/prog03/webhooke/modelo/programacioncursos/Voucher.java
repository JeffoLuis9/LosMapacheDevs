/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.modelo.programacioncursos;

import java.util.Date;
import jakarta.json.bind.annotation.JsonbDateFormat;
/**
 *
 * @author ASUS
 */
public class Voucher {

    /**
     * @return the idSesion
     */
    
    private int id;
    private String codigoOperacion;
    private double monto;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private Date fecha;
    private int idSesion;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigoOperacion
     */
    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    /**
     * @param codigoOperacion the codigoOperacion to set
     */
    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

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
    
    public int getIdSesion() {
        return idSesion;
    }

    /**
     * @param idSesion the idSesion to set
     */
    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }
}
