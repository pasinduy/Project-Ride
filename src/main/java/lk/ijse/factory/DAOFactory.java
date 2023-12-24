package lk.ijse.factory;

import lk.ijse.dao.SuperDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return daoFactory == null? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS, QUERY
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return null;
            case ITEM:
                return null;
            case ORDER:
                return null;
            case ORDER_DETAILS:
                return null;
            case QUERY:
                return null;
            default:
                return null;
        }
    }
}
