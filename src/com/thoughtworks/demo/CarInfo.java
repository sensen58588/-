package com.thoughtworks.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 定义汽车对象
 * @param: String
 * @retuan:
 * @Created by xiaoqiang on 2017/10/14.
 */
public class CarInfo implements Comparable{

    private String carId;
    private Date buyDate;
    private String brand;
    private int distanse;
    private boolean isProblem;

    public CarInfo(String carinfo) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String[] str = carinfo.split("\\|");
        this.carId = str[0];
        this.buyDate = simpleDateFormat.parse(str[1]);
        this.brand = str[2];
        this.distanse = Integer.parseInt(str[3]);
        System.out.println("-------------isProblem :"+str[4]);
        if(str[4].equals("F")) this.isProblem = false;
        else this.isProblem = true;
    }

    public String getCarId() {
        return carId;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public String getBrand() {
        return brand;
    }

    public int getDistanse() {
        return distanse;
    }

    public boolean isProblem() {
        return isProblem;
    }

    @Override
    public int compareTo(Object o) {
        CarInfo carInfo = (CarInfo) o;
        int ans = 0;
        if(this.brand!=carInfo.brand){
            return this.brand.compareTo(carInfo.brand);
        }
        else return ans;
    }
}
