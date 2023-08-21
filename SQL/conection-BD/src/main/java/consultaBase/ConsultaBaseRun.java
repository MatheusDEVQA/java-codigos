package consultaBase;

import java.sql.*;

public class ConsultaBaseRun {

    private String url;
    private String userName;
    private String passWord;
    private String cpf;

    public void consulta_base() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                url,
                userName,
                passWord
        );
        ) {
            String dados = consulta_cpf(connection, cpf);
        }
    }

    private String consulta_cpf(Connection connection, String massa) throws SQLException {
        String query = "select coluna1 ,coluna2 from BD.tabela where coluna3 = ?";

        String massaSelect ="";
        try (PreparedStatement conculta = connection.prepareStatement(query)) {
            conculta.setString(1, massa);
            try (ResultSet resultSet = conculta.executeQuery()) {
                if (resultSet.next()) {
                    massaSelect = resultSet.getString(1);
                    System.out.println("CPF " + massaSelect);
                }
            }
                    }
        return massaSelect;
    }
}
