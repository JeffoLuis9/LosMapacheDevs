/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionusuarios.dao;

/**
 *
 * @author ASUS
 */
public interface ICRUD<T> {
    int insertar(T modelo);
    boolean modificar(T modelo);
    boolean eliminar(int id);
    T buscar(int id);
}
