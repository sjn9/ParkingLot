/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

import java.util.ArrayList;

/**
 *
 * @author Suhani
 */
public class ParkingLot {
    static ArrayList<Integer> slot=new ArrayList<Integer>();
    static ArrayList<String> reg_details=new ArrayList<String>();
    static ArrayList<String> color=new ArrayList<String>();
    
    static String CreateParkingLot(int n){
        for(int i=0;i<n;i++){
             slot.add(0);
        }
        return "Created a parking lot with "+n+" slots";
    }
    
    
    static String park(int arr[], int n){
        int res=0;
        for(int i=0;i<slot.size();i++){
            if(i==0){
                slot.set(i, -1);
                res=i+1;
                break;
            }
        }
        return "Allocated slot no: "+res+"";
    }
    public static void main(String[] args) {
        
    }
    
}
