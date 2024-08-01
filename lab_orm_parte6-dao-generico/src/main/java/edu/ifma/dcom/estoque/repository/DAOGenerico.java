package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.EntidadeBase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

class DAOGenerico<T extends EntidadeBase> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        // ...
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
             this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
    public List<T> consultar(String nomeConsulta, Class<T> clazz, Object... params) {
        TypedQuery<T> query = manager.createNamedQuery(nomeConsulta, clazz );

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public T consultarUm(String nomeConsulta, Class<T> clazz, Object... params) {
        List<T> lista = consultar(nomeConsulta, clazz, params);
        return lista.isEmpty() ? null : (T) lista.get(0);
    }

}