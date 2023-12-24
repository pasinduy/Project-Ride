package lk.ijse.factory;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SuperDAO;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory(){{return boFactory == null? boFactory = new BOFactory() : boFactory;}
    }

    public enum BOTypes{
        CUSTOMER, ITEM, PlaceOrder
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return null;
            case ITEM:
                return null;
            case PlaceOrder:
                return null;
            default:
                return null;
        }
    }
}
