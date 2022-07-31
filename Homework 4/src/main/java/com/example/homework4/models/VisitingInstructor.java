package com.example.homework4.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingInstructor extends Instructor {
    private double hourlySalary;
    private static final int HOUR_MULTIPLY_MONTH = 8 * 30;
    public VisitingInstructor(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary* HOUR_MULTIPLY_MONTH); // kafamdan uydurma bir hesap, aylık günde 8 saat çalıştığını varsayarak toplam maaşını göstermesini amaçladım.
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        setSalary(hourlySalary*HOUR_MULTIPLY_MONTH); //salary'ninde güncellenmesi gerektiği için yazdım, daha iyi bir yöntem vardır elbet şuan çözüm olması için yaptım.
    }
}
