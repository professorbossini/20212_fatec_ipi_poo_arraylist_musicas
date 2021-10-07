import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class ListaDeMusicas {

    public static void main(String[] args) {
        //generics
        //polimorfismo paramétrico
        List <Musica> musicas = new ArrayList <> ();
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(
                "0-Sair\n1-Inserir Música\n2-Avaliar música\n3-Ver lista de músicas ordenada\n"
            ));
            switch (op){
                case 1:
                    //pegar o título da música
                    String tituloMusicaInserir = JOptionPane.showInputDialog("Qual o título da música?");
                    //construir um objeto do tipo Musica
                    Musica musicaInserir = new Musica (tituloMusicaInserir);
                    //adicionar ao ArrayList
                    // v.adicionar(musicaInserir);
                    musicas.add(musicaInserir);
                    //Confirmar a inserção para o usuário
                    JOptionPane.showMessageDialog(null, String.format("OK, música %s inserida", tituloMusicaInserir));
                    break;
                case 2:
                    String tituloMusicaAvaliar = JOptionPane.showInputDialog("Qual música deseja avaliar?");
                    int nota = Integer.parseInt(JOptionPane.showInputDialog("Qual a nota?"));
                    int i;
                    for (i = 0; i < musicas.size(); i++){
                        Musica m = musicas.get(i);
                        if (tituloMusicaAvaliar.equals(m.getTitulo())){
                            m.setAvaliacao(nota);
                            JOptionPane.showMessageDialog(null, String.format("Ok, música %s avaliada", tituloMusicaAvaliar));
                            break;
                        }
                    }
                    if (i == musicas.size())
                        JOptionPane.showMessageDialog(null, String.format("Música %s não encontrada na coleção", tituloMusicaAvaliar));
                    break;
                case 3:
                    Collections.sort(musicas, Collections.reverseOrder());
                    JOptionPane.showMessageDialog(null, musicas);
                    break;
                case 0:
                        JOptionPane.showMessageDialog(null, "Até logo");
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }

        }while (op != 0);
    }
    
}
