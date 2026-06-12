package projeto;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        Color roxoGotico = new Color(22, 11, 36);
        Color lilasNeon = new Color(205, 130, 255);
        Color roxoMedio = new Color(130, 90, 180);

        UIManager.put("control", roxoGotico);
        UIManager.put("nimbusBase", roxoGotico);
        UIManager.put("nimbusAlertYellow", lilasNeon);
        UIManager.put("nimbusDisabledText", roxoMedio);
        UIManager.put("nimbusFocus", lilasNeon);
        UIManager.put("nimbusLightBackground", roxoGotico);
        UIManager.put("nimbusSelectionBackground", lilasNeon);
        UIManager.put("nimbusSelection", lilasNeon);
        UIManager.put("text", Color.WHITE);
        UIManager.put("Panel.background", roxoGotico);
        UIManager.put("OptionPane.background", roxoGotico);

        UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 12));
        UIManager.put("Button.textForeground", roxoGotico);
        UIManager.put("Button.background", lilasNeon);
        
        List<Pessoa> filaAtendimento = new ArrayList<>();
        List<Medico> medicosPlantao = new ArrayList<>();

        while (true) {
            String menu = "<html><body style='font-family: SansSerif; color: #FFFFFF; width: 290px; text-align: center;'>" +
                          "<h2 style='color: #CD82FF; margin: 0; padding: 0;'>😈 GESTÃO DE FILAS 😈</h2>" +
                          "<p style='font-size: 10px; color: #825AB4; margin: 2px 0 12px 0; letter-spacing: 1px;'>FIM DO DESCONFORTO</p>" +
                          "<div style='background-color: #160B24; padding: 15px; border: 1px solid #CD82FF; border-radius: 12px; text-align: left;'>" +
                          "<p style='font-size: 12px; margin: 6px 0; color: #FFFFFF;'><b style='color: #CD82FF;'>1.</b> Cadastrar Paciente na Fila</p>" +
                          "<p style='font-size: 12px; margin: 6px 0; color: #FFFFFF;'><b style='color: #CD82FF;'>2.</b> Cadastrar Médico de Plantão</p>" +
                          "<p style='font-size: 12px; margin: 6px 0; color: #FFFFFF;'><b style='color: #CD82FF;'>3.</b> Visualizar Próximo da Fila</p>" +
                          "<p style='font-size: 12px; margin: 6px 0; color: #FFFFFF;'><b style='color: #CD82FF;'>4.</b> Listar Todos na Fila</p>" +
                          "<p style='font-size: 12px; margin: 6px 0; color: #FF66AA;'><b style='color: #FF66AA;'>5.</b> Sair do Sistema</p>" +
                          "</div>" +
                          "<p style='font-size: 11px; margin-top: 12px; color: #825AB4;'>Escolha uma opção:</p>" +
                          "</body></html>";
            
            String opcao = JOptionPane.showInputDialog(null, menu, "☠️", JOptionPane.PLAIN_MESSAGE);

            if (opcao == null || opcao.equals("5")) {
                JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF; text-align: center;'><b>Até mais! Bye bye... 🖤☠️</b></body></html>", "☠️", JOptionPane.PLAIN_MESSAGE);
                break;
            }

            try {
                if (opcao.equals("1")) {
                    String nome = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>Nome do Paciente:</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    if (nome == null || nome.trim().isEmpty()) {
                        throw new ValidacaoException("O nome do paciente não pode ser vazio.");
                    }

                    String idStr = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>ID do Paciente (Apenas números):</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        throw new ValidacaoException("ID inválido. Digite apenas números.");
                    }

                    String prioridade = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>Tipo de Prioridade (Alta / Normal):</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    if (prioridade == null || prioridade.trim().isEmpty()) {
                        throw new ValidacaoException("A prioridade deve ser informada.");
                    }

                    Paciente paciente = new Paciente(nome, id, prioridade);
                    filaAtendimento.add(paciente);
                    JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #CD82FF;'>🖤 <b>Paciente adicionado com sucesso!</b></body></html>", "Sucesso", JOptionPane.PLAIN_MESSAGE);

                } else if (opcao.equals("2")) {
                    String nome = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>Nome do Médico:</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    if (nome == null || nome.trim().isEmpty()) {
                        throw new ValidacaoException("O nome do médico não pode ser vazio.");
                    }

                    String idStr = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>CRM/ID do Médico:</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        throw new ValidacaoException("CRM/ID inválido. Digite apenas números.");
                    }

                    String especialidade = JOptionPane.showInputDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><b>Especialidade:</b></body></html>", "Cadastro", JOptionPane.PLAIN_MESSAGE);
                    
                    Medico medico = new Medico(nome, id, especialidade);
                    filaAtendimento.add(medico);
                    medicosPlantao.add(medico);
                    JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #CD82FF;'>🖤 <b>Médico plantonista registrado!</b></body></html>", "Sucesso", JOptionPane.PLAIN_MESSAGE);

                } else if (opcao.equals("3")) {
                    if (filaAtendimento.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #825AB4;'>A fila está vazia no momento.</body></html>", "Fila Vazia", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        Pessoa proximo = filaAtendimento.get(0);
                        JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #FFFFFF;'><h3 style='margin:0 0 5px 0; color: #CD82FF;'>Próximo atendimento:</h3>" + proximo.getDadosIdentificacao() + "</body></html>", "Próximo", JOptionPane.PLAIN_MESSAGE);
                    }

                } else if (opcao.equals("4")) {
                    if (filaAtendimento.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #825AB4;'>Nenhum registro na fila.</body></html>", "Fila Vazia", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        StringBuilder lista = new StringBuilder("<html><body style='font-family: SansSerif; color: #FFFFFF; width: 260px;'>");
                        lista.append("<h3 style='margin: 0 0 8px 0; text-align: center; color: #CD82FF;'>--- FILA ATUAL ---</h3>");
                        lista.append("<div style='background-color: #160B24; padding: 12px; border: 1px solid #825AB4; border-radius: 12px;'>");
                        for (Pessoa p : filaAtendimento) {
                            lista.append("<p style='margin: 5px 0; font-size: 11px; color: #FFFFFF;'>• ").append(p.getDadosIdentificacao()).append("</p>");
                        }
                        lista.append("</div></body></html>");
                        JOptionPane.showMessageDialog(null, lista.toString(), "Lista", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    throw new ValidacaoException("Opção inválida do menu.");
                }

            } catch (ValidacaoException e) {
                JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #FF66AA;'><b>Erro de Validação:</b><br>" + e.getMessage() + "</body></html>", "Aviso", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "<html><body style='font-family: SansSerif; color: #FF66AA;'><b>Ocorreu um erro inesperado.</b></body></html>", "Erro Crítico", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}