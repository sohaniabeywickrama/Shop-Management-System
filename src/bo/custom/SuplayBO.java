package bo.custom;

import bo.SuperBO;
import dto.SuplayDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SuplayBO extends SuperBO {
    boolean addSuplay(SuplayDTO supplier) throws ClassNotFoundException, SQLException;

    boolean deleteSuplay(String id) throws ClassNotFoundException, SQLException;

    boolean updateSuplay(SuplayDTO supplier) throws ClassNotFoundException, SQLException;

    SuplayDTO searchSuplay(String id) throws ClassNotFoundException, SQLException;

    ObservableList<SuplayDTO> getAllSuplay() throws ClassNotFoundException, SQLException;

    int getRowCount() throws ClassNotFoundException, SQLException;
}
