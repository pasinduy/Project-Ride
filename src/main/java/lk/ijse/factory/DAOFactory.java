package lk.ijse.factory;

import lk.ijse.bo.custom.impl.*;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return daoFactory == null? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        ATTENDANCE, DELIVERY, DELIVERY_DETAIL, EMPLOYEE, PASSENGER, PAYROLL, RESERVATION, RESERVATION_DETAIL, SCHEDULE, TRAIN, USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case DELIVERY:
                return new DeliveryDAOImpl();
            case DELIVERY_DETAIL:
                return new DeliveryDetailDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case PASSENGER:
                return new PassengerDAOImpl();
            case PAYROLL:
                return new PayrollDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case RESERVATION_DETAIL:
                return new ReservationDetailDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case TRAIN:
                return new TrainDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
