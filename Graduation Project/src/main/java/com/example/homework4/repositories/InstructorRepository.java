package com.example.homework4.repositories;

import com.example.homework4.models.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findByName(String name);
    Iterable<Instructor> findTop3ByOrderBySalaryDesc(); // en çok parayı kazanan 3 eğitmenden birini seçiyor

     void deleteInstructorByName(String name); //bunu arada kırmış olabilirim buna çok takılma :D, ide void dön dedi diye öyle yazdım
}
