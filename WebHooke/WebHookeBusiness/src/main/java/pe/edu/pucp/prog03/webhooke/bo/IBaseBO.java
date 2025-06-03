package pe.edu.pucp.prog03.webhooke.bo;

import java.util.List;

/**
 *
 * @author eric
 * @param <T>
 */
public interface IBaseBO<T> {
    List<T> listar();
    T obtener(int id);
    void eliminar(int id);
    void guardar(T modelo, Estado estado);
}
