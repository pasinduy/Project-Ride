package lk.ijse.factory;

import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory(){{return boFactory == null? boFactory = new BOFactory() : boFactory;}
    }

    public enum BOTypes{
        ATTENDANCE, DELIVERY, EMPLOYEE, PASSENGER, PAYROLL, RESERVATION, SCHEDULE, TRAIN, USER
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PASSENGER:
                return new PassengerBOImpl();
            case PAYROLL:
                return new PayrollBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case SCHEDULE:
                return new ScheduleBOImpl();
            case TRAIN:
                return new TrainBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
