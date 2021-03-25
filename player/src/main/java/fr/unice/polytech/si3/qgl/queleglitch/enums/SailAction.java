package fr.unice.polytech.si3.qgl.queleglitch.enums;

public enum SailAction {

    LIFT {
        @Override
        public String toString() {
            return "Lift";
        }
    }
    ,
    LOWER {
        @Override
        public String toString() {
            return "Lower";
        }
    }
    ,
    DO_NOTHING {
        @Override
        public String toString() {
            return "Do nothing";
        }
    }

}
