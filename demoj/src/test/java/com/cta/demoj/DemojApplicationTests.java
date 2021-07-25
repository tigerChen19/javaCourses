package com.cta.demoj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class DemojApplicationTests {

    @Autowired
    AreaService areaService;
    @Autowired
    HikariService hikariService;

    @Test
    void contextLoads() throws SQLException, ClassNotFoundException {
//        areaService.query();
//        areaService.query2();
//        areaService.save();
        hikariService.query();
    }

}
