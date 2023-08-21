package limpaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LimpaBaseRun {

    private String url;
    private String userName;
    private String passWord;
    private String cpf;

    private void limpa_base(String massa) throws SQLException {

        try(Connection connection = DriverManager.getConnection(
                url,
                userName,
                passWord
        );
        ){
                limpa_base(connection, cpf);
        }
    }
    public void limpa_base(Connection connection, String massa) throws SQLException{
        for(String delete : deleteStatements){

            try(PreparedStatement deleteStatement = connection.prepareStatement(delete)){
                deleteStatement.setString(1, massa);
                int deleted = deleteStatement.executeUpdate();
            }
        }}

         public String[] deleteStatements = {
                "delete from BD.tabela where coluna = ?",
                 "delete from BD.tabelaA where comunaB = ?",
                 "delete from BD.tabelaC where colunaC In (" +
                         "select colina1 from BD.tabela2 where colunaX = ?)"
        };


}
