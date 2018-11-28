/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Alunos.Alunos;
import Conexao.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nupasd-ufpi
 */
public class Testes {

    public Testes() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testeLoginUsuariosSenhaCorretos() {
        Users user = new Users();
        int recebe = user.listarLogin("admsi", "geek", "Sistemas de Informação");

        assertEquals(0, recebe);
    }

    @Test
    public void testeLoginUsuariosIncorreto() {
        Users user = new Users();
        int recebe = user.listarLogin("aaa", "geek", "Sistemas de Informação");

        assertEquals(1, recebe);
    }

    @Test
    public void testeLoginSenhaIncorreta() {
        Users user = new Users();
        int recebe = user.listarLogin("admsi", "senhaerrada", "Sistemas de Informação");

        assertEquals(1, recebe);
    }

    @Test
    public void testeLoginCursoIncorreto() {
        Users user = new Users();
        int recebe = user.listarLogin("admsi", "senhaerrada", "Matemática da Informação");

        assertEquals(1, recebe);
    }

    @Test
    public void testeLoginUsuariosSenhaIncorretos() {
        Users user = new Users();
        int recebe = user.listarLogin("aaa", "senhaerrada", "Sistemas de Informação");

        assertEquals(1, recebe);
    }

    @Test
    public void testeLoginUsuarioSenhaCursoIncorretos() {
        Users user = new Users();
        int recebe = user.listarLogin("adss", "senhaerrada", "Matemática da Biologia");

        assertEquals(1, recebe);
    }

    @Test
    public void testeAdicionarAluno() {
        Alunos aluno = new Alunos();

        aluno.setDataNascimento("10/10/1994");
        aluno.setNome("João Marcos");
        aluno.setCurso("Sistemas de Informação");
        aluno.setMatricula("111111211");
        aluno.setCPF("12345678987");
        aluno.setRG("123416");
        aluno.setSexo("Masculino");

        Users user = new Users();

        int recebe = user.adiciona_AlSI(aluno);

        assertEquals(0, recebe);
    }

    @Test
    public void testeRemoverAluno() {
        Alunos aluno = new Alunos();

        aluno.setDataNascimento("10/10/1994");
        aluno.setNome("João Marcos");
        aluno.setCurso("Sistemas de Informação");
        String matricula = "12120211";
        aluno.setMatricula(matricula);
        aluno.setCPF("123452178987");
        aluno.setRG("123412");
        aluno.setSexo("Masculino");

        Users user = new Users();

        int recebe = user.Excluir_SI(matricula);

        assertEquals(0, recebe);
    }

    @Test
    public void testeAlterarAluno() {
        Alunos aluno = new Alunos();

        aluno.setDataNascimento("10/10/1994");
        aluno.setNome("João Marcos");
        aluno.setCurso("Sistemas de Informação");
        String matricula = "12120211";
        aluno.setMatricula(matricula);
        aluno.setCPF("123452178987");
        aluno.setRG("123412");
        aluno.setSexo("Masculino");

        Users user = new Users();

        int recebe = user.Alterar_SI(aluno, "101010");

        assertEquals(0, recebe);
    }

    @Test
    public void testeLiberarSI() {
    
        Users user = new Users();

        int recebe = user.LiberarSI("101010");

        assertEquals(0, recebe);
    }

}
