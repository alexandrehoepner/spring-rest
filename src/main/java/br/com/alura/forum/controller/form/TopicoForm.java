package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class TopicoForm {
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 60)
    private String titulo;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 300)
    private String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        return new Topico(titulo, mensagem, cursoRepository.findByNome(nomeCurso));
    }

}
