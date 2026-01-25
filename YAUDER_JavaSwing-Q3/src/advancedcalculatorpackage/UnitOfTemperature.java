/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package advancedcalculatorpackage;

/**
 *
 * @author seany
 */
public enum UnitOfTemperature{
    Celsius{
        @Override
        public double toCelsius(double value) {
            return value;
        }

        @Override
        public double fromCelsius(double celsiusValue) {
            return celsiusValue; 
        }
    },
    Fahrenheit{
        @Override
        public double toCelsius(double value) {
            return (value - 32) * 5.0/9.0;
        }

        @Override
        public double fromCelsius(double celsiusValue) {
            return celsiusValue * 9.0/5.0 + 32;
        }
    },
    Kelvin{
        @Override
        public double toCelsius(double value) {
            return value - 273.15;
        }

        @Override
        public double fromCelsius(double celsiusValue) {
            return celsiusValue + 273.15;
        }
    };

    public abstract double toCelsius(double value);
    public abstract double fromCelsius(double celsiusValue);
};
