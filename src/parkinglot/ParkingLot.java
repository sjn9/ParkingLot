package parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Suhani
 */
public class ParkingLot {
    static ArrayList<Integer> slot=new ArrayList<Integer>();
    
    public static String createParkingLot(int n){
        for(int i=0;i<n;i++){
             slot.add(0);
        }
        return "Created a parking lot with "+n+" slots";
    }
    
    public static String park(String reg_no, String color) throws Exception{
        int res=0;
        for(int i=0;i<slot.size();i++){
            if(i==0){
                slot.set(i, -1);
                res=i+1;
                break;
            }
        }
        CarDetails car=new CarDetails(res,reg_no,color);
        Car newCar=new Car();
        newCar.insertNewCar(car);
        return "Allocated slot no: "+res+"";
    }
    
    public static String leave(int n) throws Exception{
        int res=0;
        for(int i=0;i<slot.size();i++){
            if((i+1)==n){
                slot.set(i, 0);
                res=i+1;
                break;
            }
        }
        Car newCar=new Car();
        newCar.deleteCar(n);
        return "Slot no "+n+" is free";
    }
    public static void status() throws Exception{
        Car newCar=new Car();
        newCar.carDetails();
    }
    public static void color(String color) throws Exception{
        Car newCar=new Car();
        newCar.carDetailsColor(color);
    }
    public static void color1(String color) throws Exception{
        Car newCar=new Car();
        newCar.carDetailsColor1(color);
    }
    public static void slot(String reg_no) throws Exception{
        Car newCar=new Car();
        newCar.carDetailsRegno(reg_no);
    }
    public static void main(String[] args) throws IOException, Exception {
        ParkingDetails pd=new ParkingDetails();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String []s=br.readLine().split(" ");
            if(s[0].equals(pd.s1)){
                System.out.println(createParkingLot(Integer.parseInt(s[1])));
            }
            if(s[0].equals(pd.s2)){
                System.out.println(park(s[1], s[2]));
            }
            if(s[0].equals(pd.s3)){
                System.out.println(leave(Integer.parseInt(s[1])));
            }
            if(s[0].equals(pd.s4)){
                status();
            }
            if(s[0].equals(pd.s5)){
                color(s[1]);
            }
            if(s[0].equals(pd.s6)){
                color1(s[1]);
            }
            if(s[0].equals(pd.s7)){
                slot(s[1]);
            }
        }
    }
    
}
