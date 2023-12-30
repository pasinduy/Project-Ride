package lk.ijse.entity;

import java.time.LocalDate;
import java.util.Date;

public class Attendance {
    private String attId;
    private String empId;
    private String month;
    private String date;
    private String status;

    @Override
    public String toString() {
        return "Attendance{" +
                "attId='" + attId + '\'' +
                ", empId='" + empId + '\'' +
                ", month='" + month + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    public Attendance() {
    }

    public Attendance(String attId, String empId, String month, String date, String status) {
        this.attId = attId;
        this.empId = empId;
        this.month = month;
        this.date = date;
        this.status = status;
    }

    public String getAttId() {
        return attId;
    }

    public void setAttId(String attId) {
        this.attId = attId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
