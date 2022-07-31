package com.example.homework4.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    // burada kalıcı eğitmen için sabit yazman lazımdı sonradan fark edip düzenledim
    private double fixedSalary;
    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary);  //oluşturulurken kafama göre hesap yaptım çok mühim değil
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
        setSalary(fixedSalary); //salary'ninde güncellenmesi gerektiği için yazdım, daha iyi bir yöntem vardır elbet şuan çözüm olması için yaptım.
    }
}
