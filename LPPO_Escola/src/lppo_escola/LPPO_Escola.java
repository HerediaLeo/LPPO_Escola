/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lppo_escola;

import static java.awt.Frame.MAXIMIZED_BOTH;
import views.PrincipalView;

/**
 *
 * @author coliv
 */
public class LPPO_Escola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PrincipalView view = new PrincipalView();
        view.setVisible(true);
        view.setTitle("Uniacademia");
        view.setExtendedState(MAXIMIZED_BOTH);
        /*
        AlunoDao alunoDao = new AlunoDao();
        TurmaDao turmaDao = new TurmaDao();
        TurmaDao turmaDao1 = new TurmaDao();
        TurmaDao turmaDao2 = new TurmaDao();
       
        Aluno a = new Aluno();
        Turma t = new Turma();
        Turma t1 = new Turma();
        Turma t2 = new Turma();
        */
        /*
        t.setNome("Primeira série");
        t.setAno(2020);
        t.setTipo(TipoTurma.MEDIO);
        
        
        a.setAnoNascimento(1994);
        a.setNome("Igor");
        a.setPcd(false);
        a.setTurma(t);
        */
        
        //turmaDao.persist(t);
        
        //alunoDao.persist(a);
       /*
        a = alunoDao.findByMatricula(Long.valueOf(1));
        System.out.println(a);
        */
       /*
       alunoDao.removeAluno(Long.valueOf(1));
       */
       /*
       t.setNome("Primeira série");
       t.setAno(2020);
       t.setTipo(TipoTurma.FUNDAMENTAL);
       
       t1.setNome("Segunda série");
       t1.setAno(2020);
       t1.setTipo(TipoTurma.FUNDAMENTAL1);
       
       t2.setNome("Terceira série");
       t2.setAno(2020);
       t2.setTipo(TipoTurma.MEDIO);
       
       turmaDao.cadastraTurma(t2);
       */
       /*
        t = turmaDao.findById(Long.valueOf(1));
        a.setAnoNascimento(1994);
        a.setNome("Rapha");
        a.setPcd(true);
        a.setTurma(t);
        alunoDao.cadastraAluno(a);
       */
       
       
       
        //System.out.println(alunoDao.findAllPcd());
       
    }
    
}
