package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.Pagamento;
import edu.ifma.dcom.estoque.entity.PagamentoBoleto;
import edu.ifma.dcom.estoque.entity.PagamentoCartao;
import edu.ifma.dcom.estoque.entity.Pedido;
import edu.ifma.dcom.estoque.entity.enums.EstadoPedido;

import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class PedidoRepository {

    private final EntityManager manager;
    private final DAOGenerico<Pedido> daoGenerico;

    public PedidoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Pedido>(manager);
    }

    public Pedido porId(Integer id) {
        return daoGenerico.buscaPorId(Pedido.class, id);
    }

    public Pedido salvaOuAtualiza(Pedido pedido) {
        return daoGenerico.salvaOuAtualiza(pedido );
    }

    public List<Pedido> finalizados() {
        return manager
                .createQuery("from Pedido p where p.estadoPedido = :status", Pedido.class)
                .setParameter("status", EstadoPedido.FINALIZADO)
                .getResultList();
    }

    public List<Pedido> comPagamentoCartao() {
        return comPagametosDoTipo(PagamentoCartao.class );
                /*manager
                .createQuery("Select p From Pedido p join p.pagamento pg where TYPE(pg) = PagamentoCartao",
                        Pedido.class)
                .getResultList();
*/    }

    public List<Pedido> comPagamentoBoleto() {
        return comPagametosDoTipo(PagamentoBoleto.class );
    }

    private List<Pedido> comPagametosDoTipo(Class<?> clazz) {
        return manager
                .createQuery("Select p From Pedido p where TYPE(p.pagamento) IN (:tipoPagamento)",
                        Pedido.class)
                .setParameter("tipoPagamento", List.of(clazz) )
                .getResultList();
    }


}