package org.example.dao.impl;

import org.example.dao.PersonDAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Zhou Xinyang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDAOImplement implements PersonDAO {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;

    @Override
    public void eat() {
        System.out.println("我爱吃小笼包.");
    }
}
