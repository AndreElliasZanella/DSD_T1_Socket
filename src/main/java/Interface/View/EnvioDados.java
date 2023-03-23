/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface.View;

import Client.ClientStart;
import Interface.Controller.ControllerEnvioDados;
import Model.Jogador;
import Model.Message;
import Model.Tecnico;
import Model.TimeFutebol;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andreellias18
 */
public class EnvioDados extends javax.swing.JFrame {
    
    private ControllerEnvioDados controle;
    String[] args;
    String ipConexao;
    
    Gson gson = new Gson();
    
    /**
     * Creates new form EnvioDados
     */
    public EnvioDados(String[] args, Login tela, String ip) {
        
        this.args = args;
        this.ipConexao = ip;
        controle = new ControllerEnvioDados();
        initComponents();
        tela.FecharTela();
        exibirTela();
        
        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String retorno = gson.toJson(carregarMessage(), Message.class);
                controle.setMessage(retorno);
                try {
                    startCliente();
                } catch (IOException ex) {
                    Logger.getLogger(EnvioDados.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparTela();
            }
        });
        
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FecharTela();
                tela.exibirTela();
            }
        });
    }
    
    public String retDados(){
        return controle.getDados();
    }
    
    public void startCliente() throws IOException{
        ClientStart.main(args, retDados(), this, ipConexao);
    }
    
    public Message carregarMessage(){
        
        Message message = new Message();
        message.setMetodo(metodo.getSelectedItem().toString());
        message.setTipo(tipo.getSelectedItem().toString());
        if (metodo.getSelectedItem().toString().equals((String)"LIST")) {
            switch (tipo.getSelectedItem().toString()) {
                case "JOGADOR":
                    Jogador jogador = new Jogador(0, 0, "listarJog", "", "", "", 0);
                    message.setJogador(jogador);
                    break;
                case "TECNICO":
                    Tecnico tecnico = new Tecnico(0, 0, "listar", "", "", "", 0);
                    message.setTecnico(tecnico);
                    break;
                case "TIME":
                    TimeFutebol time = new TimeFutebol();
                    message.setTime(time);
                    break;
            }
        }else{
            if (!(cbCPF.getText().equals("") && tipo.getSelectedItem().toString().equals("JOGADOR"))){
                Jogador jogador = new Jogador(Integer.parseInt(cbCamisaJ.getText()), Integer.parseInt(cbPosicaoJ.getText()), cbCPF.getText(), cbNome.getText(), cbEndereco.getText(), cbContato.getText(), Integer.parseInt(cbIdade.getText()));
                message.setJogador(jogador);
            }
            if (!cbCPF.getText().equals("") && tipo.getSelectedItem().toString().equals("TECNICO")){
                Tecnico tecnico = new Tecnico(Integer.parseInt(cbExpT.getText()), Integer.parseInt(cbLicensaT.getText()), cbCPF.getText(), cbNome.getText(), cbEndereco.getText(), cbContato.getText(), Integer.parseInt(cbIdade.getText()));
                message.setTecnico(tecnico);
            }
            if (!cbNomeTime.getText().equals("") && tipo.getSelectedItem().toString().equals("TIME")){
                TimeFutebol time = new TimeFutebol(cbNomeTime.getText(),Integer.parseInt(cbCategoriaTime.getText()),cbEstadioTime.getText());
                message.setTime(time);
            }
        }
        return message;
    }
    
    public void exibirTela(){
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void FecharTela(){
        setVisible(false);
        this.dispose();
    }
    
    public void exibirMensagem(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public void limparTela(){
        cbNome.setText("");
        cbCPF.setText("");
        cbContato.setText("");
        cbEndereco.setText("");
        cbIdade.setText("0");

        cbCamisaJ.setText("0");
        cbPosicaoJ.setText("0");
        cbExpT.setText("0");
        cbLicensaT.setText("0");
        
        cbNomeTime.setText("");
        cbCategoriaTime.setText("0");
        cbEstadioTime.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        metodo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNome = new javax.swing.JTextField();
        cbCPF = new javax.swing.JTextField();
        cbEndereco = new javax.swing.JTextField();
        cbContato = new javax.swing.JTextField();
        cbIdade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCamisaJ = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbPosicaoJ = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbExpT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbLicensaT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbNomeTime = new javax.swing.JTextField();
        cbCategoriaTime = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbEstadioTime = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        btSair = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        metodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INSERT", "UPDATE", "GET", "DELETE", "LIST", "ADD_JOGADOR_AO_TIME", "ADD_TECNICO_AO_TIME" }));

        jLabel1.setText("Método");

        jLabel2.setText("TIME DE FUTEBOL");

        jLabel3.setText("JOGADOR");

        jLabel4.setText("TÉCNICO");

        cbIdade.setText("0");

        jLabel5.setText("CPF");

        jLabel6.setText("Nome");

        jLabel7.setText("Endereço");

        jLabel8.setText("Contato");

        jLabel9.setText("Idade");

        cbCamisaJ.setText("0");

        jLabel10.setText("N camisa");

        cbPosicaoJ.setText("0");

        jLabel11.setText("Posicao");

        jLabel17.setText("Anos Experiência");

        cbExpT.setText("0");

        jLabel18.setText("Licença");

        cbLicensaT.setText("0");

        jLabel19.setText("Nome");

        cbCategoriaTime.setText("0");

        jLabel20.setText("Categoria");

        jLabel21.setText("Estadio");

        btEnviar.setText("Enviar");

        jLabel22.setText("Tipo");

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JOGADOR", "TECNICO", "TIME", " " }));

        btSair.setText("Sair");

        jLabel23.setText("PESSOA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(299, 299, 299)
                                            .addComponent(jLabel22)
                                            .addGap(18, 18, 18)
                                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbContato, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(58, 58, 58)
                                            .addComponent(jLabel23)))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(78, 78, 78)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbExpT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbLicensaT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbCamisaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbPosicaoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(jLabel4)))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(121, 121, 121))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbCategoriaTime, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbEstadioTime, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(326, 326, 326)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btSair)
                                .addGap(111, 111, 111)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(61, 61, 61)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCamisaJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPosicaoJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbExpT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLicensaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoriaTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstadioTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnvioDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnvioDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnvioDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnvioDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EnvioDados().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField cbCPF;
    private javax.swing.JTextField cbCamisaJ;
    private javax.swing.JTextField cbCategoriaTime;
    private javax.swing.JTextField cbContato;
    private javax.swing.JTextField cbEndereco;
    private javax.swing.JTextField cbEstadioTime;
    private javax.swing.JTextField cbExpT;
    private javax.swing.JTextField cbIdade;
    private javax.swing.JTextField cbLicensaT;
    private javax.swing.JTextField cbNome;
    private javax.swing.JTextField cbNomeTime;
    private javax.swing.JTextField cbPosicaoJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> metodo;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
