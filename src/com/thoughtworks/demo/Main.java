package com.thoughtworks.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 主函数入口
 * @param: String
 * @retuan: String
 * @Created by xiaoqiang on 2017/10/14.
 */



public class Main {
    private static Date SubmitDate ; //提交日期
    private static ArrayList<CarInfo> totalCars = new ArrayList<>(); //保存输入车辆信息
    private static ArrayList<CarInfo> timeRelatedCars = new ArrayList<>(); //定期保养提醒名单
    private static ArrayList<CarInfo> distanceRelateCars = new ArrayList<>(); //每1万公里保养提醒名单
    private static ArrayList<CarInfo> writeOffCars = new ArrayList<>(); //快报修提醒名单
    private static ArrayList<CarInfo> hasWorteOffCars = new ArrayList<>(); //已经报修车辆

    public static UtilTools utilTools = new UtilTools();

    //车辆分类 判断优先级：报废 > 报废提醒  > 距离保养 > 定期保养（大修 > 未大修）
    public static void classifyCars (ArrayList<CarInfo> cars) throws ParseException{
        int size = cars.size();

        for(int i=0;i<size;i++){
            CarInfo currentCar = cars.get(i);
            int result = utilTools.classify(SubmitDate,currentCar);

            //车辆正常且无需提醒
            if(result==0) continue;

            //已经报废车俩
            else if(result==1) hasWorteOffCars.add(currentCar);

            //报废提醒车量
            else if(result==2) writeOffCars.add(currentCar);

            //距离保养提醒车辆
            else if(result==3) distanceRelateCars.add(currentCar);

            //定期保养车辆
            else if(result==4) timeRelatedCars.add(currentCar);

            System.out.println();

        }

    }



    //车辆分类品牌数量统计，品牌排序,然后输出处理结果
    public static void printListResult(ArrayList<CarInfo> carList){
        //根据车品牌名称进行排序
        Collections.sort(carList);

        //获取统计结果
        Map<String ,Integer> map = utilTools.countCarsNumbers(carList);

        //不同的品牌数，按行输出次数
        int differentBrandsNumber = utilTools.countDifferentCarBrands(carList);

        int temp = 0;//carList的位置指针

        for(int i=0;i<differentBrandsNumber;i++){
            CarInfo currentCar = carList.get(temp);
            int number = map.get(currentCar.getBrand());
            int j = 1;
            System.out.print(currentCar.getBrand()+":"+number+"(");
            while(j<=number){
                if(j==number){
                    System.out.print(currentCar.getCarId());
                    j++;
                    temp++;

                }else{
                    System.out.print(currentCar.getCarId()+",");
                    temp++;
                    j++;
                    currentCar = carList.get(temp);
                }

            }
            System.out.println(")");
        }
    }

    //对结果的控制输出
    public static void mainPrintResult(){
        System.out.println("Reminder");
        System.out.println("==================");

        //若存在定期保养提醒名单
        if(timeRelatedCars.size()!=0){
            System.out.println();
            System.out.println("* Time-related maintenance coming soon...");
            printListResult(timeRelatedCars);

        }

        //若存在距离保养提醒名单
        if(distanceRelateCars.size()!=0){
            System.out.println();
            System.out.println("* Distance-related maintenance coming soon...");
            printListResult(distanceRelateCars);

        }

        //若存在报废提醒名单
        if(writeOffCars.size()!=0){
            System.out.println();
            System.out.println("* Write-off coming soon...");
            printListResult(writeOffCars);
        }


    }

    public static void main(String args[]) throws ParseException{
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String fristLine = scanner.nextLine();
        String[]str = fristLine.split(":");


        //get SubmitDate
        Date getDate = simpleDateFormat.parse(str[1]);
        String date = simpleDateFormat.format(getDate);
        SubmitDate = simpleDateFormat.parse(date);


        //get car info
        int i =0;
        while(i<9){
            i++;
            totalCars.add(new CarInfo(scanner.nextLine()));
        }

        classifyCars(totalCars);
        mainPrintResult();

    }
}



