package com.thoughtworks.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 提供计算SubmitDate与购买日期的间隔，报废与否判断，日期保养与否判断等util函数
 * @param:
 * @retuan:
 * @Created by xiaoqiang on 2017/10/14.
 */
public class UtilTools {

    //计算两个日期之间的间隔天数
    public int getBetweenDays(Date submitDate, Date buyDate){
        int ans = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try{
            submitDate = simpleDateFormat.parse(simpleDateFormat.format(submitDate));
            buyDate = simpleDateFormat.parse(simpleDateFormat.format(buyDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(submitDate);
            Long subTime = calendar.getTimeInMillis();
            calendar.setTime(buyDate);
            Long buyTime = buyDate.getTime();
            long betweenDays=(subTime-buyTime)/(1000*3600*24)+1;
            ans = (int)betweenDays;
        }catch (ParseException e){
            e.printStackTrace();
        }

        return ans;
    }

    //判断当前车辆是否已经报废
    public boolean hasWroteOff(Date submitDate, Date buyDate,boolean problem){
        boolean key = false;
        int maxDate = problem ? 3*365:6*365; //若有大修期限为3年
        int betweenDays = getBetweenDays(submitDate,buyDate);
        if(betweenDays>maxDate){
            key = true;
        }
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try{
            submitDate = simpleDateFormat.parse(simpleDateFormat.format(submitDate));
            buyDate = simpleDateFormat.parse(simpleDateFormat.format(buyDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(submitDate);
            Long subTime = calendar.getTimeInMillis();
            calendar.setTime(buyDate);
            Long buyTime = buyDate.getTime();
            Long betweenDays=(subTime-buyTime)/(1000*3600*24)+1;

            if(betweenDays>maxDate){
                key = true;
            }
        }catch (ParseException e){
            e.printStackTrace();
        }*/

        return key;
    }

    //判断当前车辆是否具备报废提醒条件
    public boolean isTimeCloseToOff(Date submitDate, Date buyDate,boolean problem){
        boolean key = false;
        int maxYear = problem ? 3:6;

        int buyYear = buyDate.getYear()+1900;
        int buyMonth = buyDate.getMonth()+1;

        int subYear = submitDate.getYear()+1900;
        int subMonth = submitDate.getMonth()+1;

        //已到第三年
        if(buyYear+maxYear==subYear){
            if(subMonth-buyMonth<=1){
                key = true;
            }
        }
        if(buyYear+maxYear+1==subYear){
            if(subMonth+12-buyMonth==1){
                key=true;
            }
        }

        return key;
    }

    //判断当前车龄是否超过3年
    public boolean isOldCars(Date submitDate, Date buyDate){
        boolean key = false;
        int threeYearsDays = 3*365;

        int betweenDays = getBetweenDays(submitDate,buyDate);
        if(betweenDays>=threeYearsDays){
            key = true;
            System.out.println("over three years");
        }

        return key;
    }

    //针对未大修的youngCar每12个月的定期保养
    public boolean youngCarTimerelated(Date submitDate, Date buyDate) {
        boolean key = false;
        int buyMonth = buyDate.getMonth()+1;
        int buyDay = buyDate.getDay();

        int subMonth = submitDate.getMonth()+1;
        int subDay = submitDate.getDay();

        int months = Math.abs(buyMonth-subMonth);//月份间隔绝对值
        int monthTemp = months%12;
        if(monthTemp==0){ //当前月为检查月
            key = true;
            System.out.println("time related car");


        }else if(monthTemp==11){//下一月为检查月
            key = true;
            System.out.println("time related car");
        }

        return key;
    }

    //针对未大修的oldCar每6个月的定期保养
    public boolean oldCarTimeRelated(Date submitDate, Date buyDate){
        boolean key = false;
        int buyMonth = buyDate.getMonth()+1;
        int buyDay = buyDate.getDay();

        int subMonth = submitDate.getMonth()+1;
        int subDay = submitDate.getDay();

        int months = Math.abs(buyMonth-subMonth);//月份间隔绝对值
        int monthTemp = months%6;
        if(monthTemp==0){ //当前月为检查月
            key = true;


        }else if(monthTemp==5){//下一月为检查月
            key = true;
        }
        return key;
    }

    //针对大修车辆每3个月的定期保养
    public boolean problemCar(Date submitDate, Date buyDate){
        boolean key = false;

        int buyMonth = buyDate.getMonth()+1;
        int buyDay = buyDate.getDay();

        int subMonth = submitDate.getMonth()+1;
        int subDay = submitDate.getDay();

        int months = Math.abs(buyMonth-subMonth);//月份间隔绝对值
        int monthTemp = months%3;
        if(monthTemp==0){ //当前月为检查月
            key = true;

        }else if(monthTemp==2){//下一月为检查月
            key = true;
        }

        return key;
    }

    //每1万公里保养提醒
    public boolean isDistanceRelated(int submitDistance){
        boolean key = false;
        int distance = 10000-submitDistance%10000;

        if(distance<=500||distance==10000){
            key = true;
        }

        return key;
    }

    public int classify(Date submitDate,CarInfo carInfo) throws ParseException{

        //初始值为0,默认无需任何提醒，且车辆正常
        int ans = 0;

        //若已经报废，返回 1
        if(hasWroteOff( submitDate,carInfo.getBuyDate(),carInfo.isProblem())) ans = 1;

        //若达到报废提醒规则 ans = 2
        else if(isTimeCloseToOff(submitDate,carInfo.getBuyDate(),carInfo.isProblem())) ans = 2;

        //若达到距离保养规则,ans = 3
        else if(isDistanceRelated(carInfo.getDistanse())) ans = 3;

        //若以上都不满足，判断定期保养，分大修与未大修，未大修分3年上下
        //若符合保养规则，返回 ans = 4
        else {
            //大修过
            if(carInfo.isProblem()){
                if(problemCar(submitDate,carInfo.getBuyDate())) ans = 4;
            }
            //未大修过
            else{
                //3年车龄及以上的车
                if(isOldCars(submitDate,carInfo.getBuyDate())){
                    if(oldCarTimeRelated(submitDate,carInfo.getBuyDate())) ans = 4;
                }
                //3年内的车龄
                else{
                    if(youngCarTimerelated(submitDate,carInfo.getBuyDate())) ans = 4;
                }
            }
        }

        return ans;
    }

    //对已经排好序的车辆进行统计
    public Map<String,Integer> countCarsNumbers(ArrayList<CarInfo> list){
        Map<String,Integer> map = new HashMap<>();
        int size = list.size();
        String currentBrand = null;
        int number = 1;
        for(int i=0;i<size;i++){

            CarInfo currentCar = list.get(i);
            if(i==0){
                //对获取到的第一个车辆
                map.put(currentCar.getBrand(),number);
                currentBrand = currentCar.getBrand();
            }
            else{
                //如果与上一俩车品牌相同
                if(currentCar.getBrand().equals(currentBrand)){
                    number++;
                    map.put(currentCar.getBrand(),number);
                }

                //品牌不同
                else{
                    number = 1; //number重新置1
                    map.put(currentCar.getBrand(),number);
                }
            }
        }

        return map;
    }

    //统计列表中一共有多少种不同品牌
    public int countDifferentCarBrands(ArrayList<CarInfo> list){
        int ans = 0;
        String currentBrand = null;
        for(int i=0;i<list.size();i++){
            CarInfo currentCar = list.get(i);
            if(i==0){
                ans++;
                currentBrand = currentCar.getBrand();
            }else{

                if(!currentCar.getBrand().equals(currentBrand)){
                    ans++;
                    continue;
                }
                else{
                    continue;
                }
            }
        }

        return ans;
    }
}
