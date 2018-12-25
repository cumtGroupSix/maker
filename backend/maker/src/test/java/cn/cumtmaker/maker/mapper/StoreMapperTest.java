package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Store;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreMapperTest {
    @Autowired
    StoreMapper storeMapper;

    @Test
    public void selectById() {
        Store store = storeMapper.selectById(1);
        Assert.assertEquals(1, java.util.Optional.ofNullable(store.getStoreId()));
    }
}