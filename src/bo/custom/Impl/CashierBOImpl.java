package bo.custom.Impl;

import bo.custom.CashierBO;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import dto.CashierDTO;
import entity.Cashier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CashierBOImpl implements CashierBO {
    CashierDAO CashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASHIER);
    @Override
    public boolean addCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException {
        return CashierDAO.add(new Cashier(cashier.getCastID(),cashier.getCastName(),cashier.getCastBirthDay(),cashier.getCastAddress(), cashier.getCastPhoto(),cashier.getCastlogin(),cashier.getCastPassword()));
    }

    @Override
    public boolean deleteCashier(String id) throws ClassNotFoundException, SQLException {
        return CashierDAO.delete(id);
    }

    @Override
    public boolean updateCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException {
        return CashierDAO.update(new Cashier(cashier.getCastID(),cashier.getCastName(),cashier.getCastBirthDay(),cashier.getCastAddress(), cashier.getCastPhoto(),cashier.getCastlogin(),cashier.getCastPassword()));
    }

    @Override
    public CashierDTO searchCashier(String id) throws ClassNotFoundException, SQLException {
        Cashier search = CashierDAO.search(id);
        return new CashierDTO(search.getCastID(),search.getCastName(),search.getCastBirthDay(),search.getCastAddress(),search.getCastPhoto(),search.getCastlogin(),search.getCastPassword());
    }

    @Override
    public ObservableList<CashierDTO> getAllCashier() throws ClassNotFoundException, SQLException {
        ObservableList<Cashier> all =CashierDAO.getAll();
        ObservableList<CashierDTO> allCashier = FXCollections.observableArrayList();
        for (Cashier ID : all) {
            CashierDTO dto = new CashierDTO(ID.getCastID(),ID.getCastName(),ID.getCastBirthDay(),ID.getCastAddress(),ID.getCastPhoto(),ID.getCastlogin(),ID.getCastPassword());
            allCashier.add(dto);
        }
        return allCashier;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return CashierDAO.getRowCount();
    }


}
