package josehomenhuck.backend.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import josehomenhuck.backend.entity.Transacao;
import josehomenhuck.backend.entity.TransacaoReport;
import josehomenhuck.backend.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
  private final TransacaoService transacaoService;

  public TransacaoController (TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @GetMapping
  Iterable<Transacao> findAll() {
    return transacaoService.findAll();
  }

  @GetMapping("nome-asc-id-desc")
  List<TransacaoReport> findAllByOrderByNomeDaLojaAscIdDesc() {
    return transacaoService.findAllByOrderByNomeDaLojaAscIdDesc();
  }
}
