package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.SuplayDAO;
import entity.Suplay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplayDAOImpl implements SuplayDAO {
    @Override
    public boolean add(Suplay ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into supplier values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getSuplayerID(), ID.getSuplayerName(), ID.getSuplayerAddress(), ID.getSuplayerPhone(), ID.getSuplayerEmail());
    }

    @Override
    public boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM supplier WHERE supplierID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Suplay ID) throws ClassNotFoundException, SQLException {
        String sql = "update supplier set supplierName =?,supplierAddress=?,supplierPhone=?,supplierEmail=? where supplierID=?";
        return CrudUtil.executeUpdate(sql, ID.getSuplayerName(), ID.getSuplayerAddress(), ID.getSuplayerPhone(), ID.getSuplayerEmail(), ID.getSuplayerID());
    }

    @Override
    public Suplay search(String ID) throws ClassNotFoundException, SQLException {

        String sql = "select * from Supplier where supplierID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);

        if (rst.next()) {

            return new Suplay(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));

        }

        return null;

    }

    @Override
    public ObservableList<Suplay> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Supplier";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Suplay> allSupplier = FXCollections.observableArrayList();
        while (rst.next()) {
            allSupplier.add(new Suplay(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return allSupplier;
    }

    @Override
    public String getSupplierLastId() throws Exception {
        return null;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(supplierID) FROM Supplier";
        ResultSet rst = CrudUtil.executeQuery(SQL, new Object[0]);
        return rst.next() ? rst.getInt(1) : -1;
    }
}
