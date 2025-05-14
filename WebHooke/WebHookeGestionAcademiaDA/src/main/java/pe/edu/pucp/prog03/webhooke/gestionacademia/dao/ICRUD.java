/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.prog03.webhooke.gestionacademia.dao;

import java.util.List;

/**
 *
 * @author andre
 */
public interface ICRUD<T> {
    int insertar(T modelo);
    boolean modificar(T modelo);
    boolean eliminar(int id);
    List<T>listar();
    T buscar(int id);
}
