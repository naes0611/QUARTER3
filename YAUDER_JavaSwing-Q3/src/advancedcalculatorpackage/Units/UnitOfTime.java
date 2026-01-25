/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package advancedcalculatorpackage.Units;

/**
 *
 * @author seany
 */
public enum UnitOfTime{
    MICROSECONDS {
        @Override
        public double toSeconds(double value) {
            return value / 1_000_000;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds * 1_000_000;
        }

    },
    MILLISECONDS {
        @Override
        public double toSeconds(double value) {
            return value / 1_000;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds * 1_000;
        }

    },
    SECONDS {
        @Override
        public double toSeconds(double value) {
            return value;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds;
        }

    },
    MINUTES {
        @Override
        public double toSeconds(double value) {
            return value * 60;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds / 60;
        }

    },
    HOURS {
        @Override
        public double toSeconds(double value) {
            return value * 3_600;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds / 3_600;
        }

    },
    DAYS {
        @Override
        public double toSeconds(double value) {
            return value * 86_400;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds * 86_400;
        }

    },
    WEEKS {
        @Override
        public double toSeconds(double value) {
            return value * 604_800;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds / 604_800;
        }

    },
    YEARS {
        @Override
        public double toSeconds(double value) {
            return value * 31_557_600;
        }

        @Override
        public double fromSeconds(double seconds) {
            return seconds / 31_557_600;
        }

    };

    public abstract double toSeconds(double value);
    public abstract double fromSeconds(double seconds);
};
