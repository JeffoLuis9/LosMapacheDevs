/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionacademia.model;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.List;

public class Academia {

    private int id;
    private String nombre;
    private String ruc;
    

    public Academia() {
        sedes = new ArrayList<Sede>();
    }

    public Academia(String nombre, String ruc, int id) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRUC() {
        return ruc;
    }

    public void setRUC(String ruc) {
        this.ruc = ruc;
    }

    public List<Sede> getSede() {
        List<Sede> auxsede = new ArrayList<Sede>();
        for (Sede sed : sedes) {
            Sede auxiliar = new Sede();
            auxiliar.setDireccion(sed.getDireccion());
            auxiliar.setDistrito(sed.getDistrito());
            auxsede.add(auxiliar);
        }
        return auxsede;
    }

    public void IngresarSede(String direccion, String distrito,String Nombre_Academia,int id) {
        Sede sede = new Sede(id,direccion, distrito, Nombre_Academia);
        sedes.add(sede);
    }

    /*
	public void ingresarSede (Sede sede){
		sedes.add(sede);
	}*/
    public void ImprimirInfoAcademia() {
        System.out.println("Nombre de Academia: " + nombre);
        System.out.println("RUC: " + this.ruc);
        System.out.println("Sedes de la Academia " + nombre + " :");
        for (Sede sede : sedes) {
            sede.ImprimirDatosSede();
        }
    }
}
