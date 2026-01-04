/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author seany
 */
public class storingVariable {
    private static int persistentValue = 0;

    public void storeValue(int newValue) {
        persistentValue = newValue;
        System.out.println("Stored value is now: " + persistentValue);
    }

    public int getValue() {
        return persistentValue;
    }
    
    public static void main(String[] args) {
        storingVariable demo1 = new storingVariable();
        storingVariable demo2 = new storingVariable();
        
        demo1.storeValue(42);
        System.out.println("Value accessed by demo2: " + demo2.getValue());
    }
}
