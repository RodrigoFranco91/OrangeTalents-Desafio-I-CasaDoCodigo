package br.com.zupacademy.rodrigo.autor;

import br.com.zupacademy.rodrigo.annotations.UniqueValue;
import br.com.zupacademy.rodrigo.autor.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor convertAutorFormParaAutor(){
        return new Autor(this.nome, this.email, this.descricao );
    }

    /*
     * Essse metodo foi utilizado na validacao
     * que verifica se e-maiul já foi utilizado
     */
    public String getEmail() {
        return email;
    }
}
