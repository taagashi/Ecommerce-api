package br.com.thaua.Ecommerce.pagination;

import br.com.thaua.Ecommerce.mappers.Converter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class Pagina<T>{
    private List<T> conteudo;
    private int paginaAtual;
    private int totalPaginas;
    private int itensPorPagina;
    private Long totalItens;

    public Pagina(Page<T> page)
    {
        conteudo = page.getContent();
        paginaAtual = page.getNumber();
        totalPaginas = page.getTotalPages();
        itensPorPagina = page.getSize();
        totalItens = page.getTotalElements();
    }
}
