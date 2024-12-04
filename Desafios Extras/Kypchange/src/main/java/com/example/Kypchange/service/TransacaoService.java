package com.example.Kypchange.service;

import com.example.Kypchange.model.Transacao;
import com.example.Kypchange.model.Usuario;
import com.example.Kypchange.repository.TransacaoRepository;
import com.example.Kypchange.repository.UsuarioRepository;
import com.example.Kypchange.service.refl.ReflClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Transacao converterInvestimentoParaTransacao(Object request, String tipo, Long usuarioId) throws IllegalAccessException {
        Long id = ReflClass.getFieldValue(request, "idInvestimento", Long.class);
        String descricao = ReflClass.getFieldValue(request, "descricao", String.class);
        Double valor = ReflClass.getFieldValue(request, "valor", Double.class);

        if (descricao != null && valor != null && usuarioId != null) {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            Transacao transacao = new Transacao(valor, descricao, tipo, usuario);
            return transacao;
        } else {
            throw new IllegalArgumentException("Dados insuficientes para converter a transação.");
        }
    }

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTodasTransacoes() {
        return transacaoRepository.findAll();
    }

    public List<Transacao> listarTransacoesPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        return transacaoRepository.findByUsuario_Id(usuarioId);
    }
}
