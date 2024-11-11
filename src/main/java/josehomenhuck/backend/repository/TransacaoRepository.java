package josehomenhuck.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import josehomenhuck.backend.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long>{
  List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}
