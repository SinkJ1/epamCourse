package dao;

import auto.Nissan;
import entity.Auto;
import entity.BodyType2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AutoParkDaoTest {

    @Test
    public void countSumAutoInAutoParkTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1234,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1234,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);

        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos()),369.0,0);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void findAutoBySpeedRangeTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",123.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan);
        AutoParkDao.getInstance().addInAutopark(nissan2);
        AutoParkDao.getInstance().addInAutopark(nissan3);

        List<Auto> checkTestListAuto = new ArrayList();

        checkTestListAuto.add(nissan2);

        Assert.assertEquals(AutoParkDao.getInstance().findAutoBySpeedRange(AutoParkDao.getInstance().getAutos(),1234,1222),checkTestListAuto);
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void sortByFuelConsumptionTest(){
        BodyType2 nissan = new Nissan(1,"nissan",123.2,1235,123);
        BodyType2 nissan2 = new Nissan(1,"nissan1",126.2,1233,123);
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

            AutoParkDao.getInstance().addInAutopark(nissan);
            AutoParkDao.getInstance().addInAutopark(nissan2);
            AutoParkDao.getInstance().addInAutopark(nissan3);

            List<Auto> checkTestListAuto = new ArrayList();

            checkTestListAuto.add(nissan3);
            checkTestListAuto.add(nissan);
            checkTestListAuto.add(nissan2);

            Assert.assertEquals(AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos()), checkTestListAuto);

            AutoParkDao.getInstance().getAutos().clear();

    }

    @Test
    public void addAutoInListTest(){
        BodyType2 nissan3 = new Nissan(1,"nissan2",122.2,1235,123);

        AutoParkDao.getInstance().addInAutopark(nissan3);
        Assert.assertFalse(AutoParkDao.getInstance().getAutos().isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void sortByFuelConsumptionTest_NullPointer()  {
        AutoParkDao.getInstance().addInAutopark(null);
        Assert.assertTrue(AutoParkDao.getInstance().sortByFuelConsumption(AutoParkDao.getInstance().getAutos()).isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void countSumAutoInAutoParkTest_NullPointer(){
        AutoParkDao.getInstance().addInAutopark(null);
        Assert.assertEquals(AutoParkDao.getInstance().countSumCostAuto(AutoParkDao.getInstance().getAutos()),0,0);
        AutoParkDao.getInstance().getAutos().clear();
    }
    @Test
    public void findAutoBySpeedRangeTest_NullPointer(){
        AutoParkDao.getInstance().addInAutopark(null);
        Assert.assertTrue(AutoParkDao.getInstance().findAutoBySpeedRange(AutoParkDao.getInstance().getAutos(),500,300).isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

    @Test
    public void addAutoInListTest_NullValue(){
        AutoParkDao.getInstance().addInAutopark(null);
        Assert.assertTrue(AutoParkDao.getInstance().getAutos().isEmpty());
        AutoParkDao.getInstance().getAutos().clear();
    }

}