package org.example.dao;

/* 
 * @author Zhou Xinyang
 */
public interface BookDAO {
    void save();

    void update();

    Integer delete();

    void select();

    void testEffciency(String functionName);
}
