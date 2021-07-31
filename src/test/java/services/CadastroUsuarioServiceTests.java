package services;

import com.vactrole.cadastroapi.errors.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroUsuario;
import com.vactrole.cadastroapi.repositories.CadastroUsuarioRepository;
import com.vactrole.cadastroapi.services.CadastroUsuarioService;
import org.assertj.core.matcher.AssertionMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastroUsuarioServiceTests {

    @InjectMocks //fala que a classse recebe os mocks
    private CadastroUsuarioService service;

    @Mock
    private CadastroUsuarioRepository repository;

    @Test
    void shouldFindUserById() {

        CadastroUsuario user = new CadastroUsuario("Felipe Rocha", "08101992", "felipeGostoso@aol.com", "525595522");

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        CadastroUsuario actual = service.find(1L);
        assertThat(actual, notNullValue());
        assertThat(actual.getName(), is("Felipe Rocha"));
    }

    @Test
    void shouldNotFindUserByIdAndThrowAnException() {


        when(repository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(CadastroNotFoundException.class, () -> service.find(1L));
    }


}
