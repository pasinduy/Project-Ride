package lk.ijse.entity;

import java.time.LocalDate;

public class Payroll {
    private String empId;
    private String salaryId;
    private LocalDate date;
    private String month;
    private String status;
    private String amount;

    public Payroll() {
    }

    public Payroll(String empId, String salaryId, LocalDate date, String month, String status, String amount) {
        this.empId = empId;
        this.salaryId = salaryId;
        this.date = date;
        this.month = month;
        this.status = status;
        this.amount = amount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "empId='" + empId + '\'' +
                ", salaryId='" + salaryId + '\'' +
                ", date=" + date +
                ", month='" + month + '\'' +
                ", status='" + status + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
