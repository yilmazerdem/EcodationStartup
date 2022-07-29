package com.erdemyilmaz;

import com.erdemyilmaz.model.Userinfo;
import com.erdemyilmaz.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EcodationStartupApplicationTests implements IUserCont{

    @Autowired
    UserRepo userRepo;

    @Override
    @Test
    public void tstSaveUser() {

        Userinfo userinfo = Userinfo.builder()
                .firstname("TestFirst")
                .lastname("TestLast")
                .email("TestEmail@mail.com")
                .password("t1e1s1t1")
                .build();

        userRepo.save(userinfo);
        assertNotNull(userRepo.findById(1L).get());

    }

    @Override
    @Test
    public void tstSaveUserFailed() {
        Userinfo userinfo = Userinfo.builder()
                .firstname("TestFirst")
                .lastname("TestLast")
                .email("TestEmail@mail.com")
                .password("t1e1s1t1")
                .build();

        //userRepo.save(userinfo);
        assertThrows(AssertionFailedError.class, () ->assertNull(userRepo.findById(100L).get()), "Kayıt Başarısız");
    }

    @Override
    @Test
    public void tstGetAllUser() {
        List<Userinfo> usersList = userRepo.findAll();

        assertThat(usersList).size().isGreaterThan(0);
    }

}
