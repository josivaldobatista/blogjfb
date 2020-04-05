package com.jfb.blogjfb.utils;

import com.jfb.blogjfb.models.Post;
import com.jfb.blogjfb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    private PostRepository postRepository;

    // @PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Marcelo Beltrano");
        post1.setData(LocalDate.now());
        post1.setTitulo("Acesso a Bancos de dados");
        post1.setTexto("" +
                "Provavelmente até aqui você criou aplicações que, quando encerradas, " +
                "perdiam todos os dados nela inseridos. Mas, por que isso acontece? " +
                "Por um motivo simples: assim como precisamos programar condicionais, " +
                "estruturas de repetição, entre outras coisas para definir o funcionamento do " +
                "nosso sistema, precisamos programar como ele deve armazenar, isto é, persistir os dados");

        Post post2 = new Post();
        post2.setAutor("Natalia Fulana");
        post2.setData(LocalDate.now());
        post2.setTitulo("Validação de dados");
        post2.setTexto("Validar é uma prática extremamente importante em aplicações. " +
                "Esse procedimento impede que dados incorretos sejam salvos no banco " +
                "de dados e, em muitos casos, contribui para a segurança do sistema. " +
                "O objetivo principal da biblioteca Bean Validation é auxiliar os programadores " +
                "nesta tarefa, permitindo a definição das regras de validação por meio de anotações, " +
                "na camada de modelo da aplicação.");

        postList.add(post1);
        postList.add(post2);

        for(Post post: postList){
            Post postSaved = postRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
