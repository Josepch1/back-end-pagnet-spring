package josehomenhuck.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import josehomenhuck.backend.entity.Transacao;
import josehomenhuck.backend.entity.TransacaoReport;
import josehomenhuck.backend.repository.TransacaoRepository;

@Service
public class TransacaoService {
  private final TransacaoRepository transacaoRepository;

  public TransacaoService(TransacaoRepository transacaoRepository) {
    this.transacaoRepository = transacaoRepository;
  }

  public Iterable<Transacao> findAll() {
    return transacaoRepository.findAll();
  }

  public List<TransacaoReport> findAllByOrderByNomeDaLojaAscIdDesc() {
    var transacoes = transacaoRepository.findAllByOrderByNomeDaLojaAscIdDesc();

    var reportMap = new LinkedHashMap<String, TransacaoReport>();

    transacoes.forEach(transacao -> {
      String nomeDaLoja = transacao.nomeDaLoja();
      var valor = transacao.valor();

      reportMap.compute(nomeDaLoja, (key, existingReport) -> {
        var report = (existingReport != null) ? existingReport
            : new TransacaoReport(key, BigDecimal.ZERO, new ArrayList<>());

        return report.addTotal(valor).addTransacao(transacao);
      });
    });

    return new ArrayList<>(reportMap.values());
  }
}
